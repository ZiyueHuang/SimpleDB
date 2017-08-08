package simpledb;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * HeapFile is an implementation of a DbFile that stores a collection
 * of tuples in no particular order.  Tuples are stored on pages, each of
 * which is a fixed size, and the file is simply a collection of those
 * pages. HeapFile works closely with HeapPage.  The format of HeapPages
 * is described in the HeapPage constructor.
 *
 * @see simpledb.HeapPage#HeapPage
 * @author Sam Madden
 */
public class HeapFile implements DbFile {
    private File file;
    private TupleDesc tupleDesc;

    private int numPages;

    /**
     * Constructs a heap file backed by the specified file.
     *
     * @param f the file that stores the on-disk backing store for this heap file.
     */
    public HeapFile(File f, TupleDesc td) {
        file = f;
        tupleDesc = td;
        numPages = (int) f.length() / BufferPool.PAGE_SIZE;
    }

    /**
     * Returns the File backing this HeapFile on disk.
     *
     * @return the File backing this HeapFile on disk.
     */
    public File getFile() {
        return file;
    }

    /**
    * Returns an ID uniquely identifying this HeapFile. Implementation note:
    * you will need to generate this tableid somewhere ensure that each
    * HeapFile has a "unique id," and that you always return the same value
    * for a particular HeapFile. We suggest hashing the absolute file name of
    * the file underlying the heapfile, i.e. f.getAbsoluteFile().hashCode().
    *
    * @return an ID uniquely identifying this HeapFile.
    */
    public int getId() {
        return file.getAbsoluteFile().hashCode();
    }
    
    /**
     * Returns the TupleDesc of the table stored in this DbFile.
     * @return TupleDesc of this DbFile.
     */
    public TupleDesc getTupleDesc() {
    	return tupleDesc;
    }
    
    // see DbFile.java for javadocs
    public Page readPage(PageId pid) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long pos = pid.pageNumber() * (long) BufferPool.PAGE_SIZE;
            if (pos < 0 || pos >= file.length()) {
                throw new IllegalArgumentException("The page doesn't exist in this file.");
            }
            
            raf.seek(pos);
            byte[] buf = new byte[BufferPool.PAGE_SIZE];
            raf.read(buf);
            return new HeapPage((HeapPageId) pid, buf);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    // see DbFile.java for javadocs
    public void writePage(Page page) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        
        PageId pid = page.getId();
        long pos = pid.pageNumber() * (long) BufferPool.PAGE_SIZE;
        // new pages might need to be appended to the file
        raf.seek(pos);
        raf.write(page.getPageData());
        raf.close();
    }

    /**
     * Returns the number of pages in this HeapFile.
     */
    public int numPages() {
        return numPages;
    }

    // see DbFile.java for javadocs
    public ArrayList<Page> insertTuple(TransactionId tid, Tuple t)
        throws DbException, IOException, TransactionAbortedException {
        if (t == null)
            throw new DbException("the tuple is null");
        ArrayList<Page> dirtyPages = new ArrayList<Page>();
        HeapPage page;
        for (int i = 0; i <= numPages; ++i) {
            HeapPageId pid = new HeapPageId(getId(), i);
            page = ((HeapPage) Database.getBufferPool().getPage(
                       tid, pid, Permissions.READ_WRITE));
            if (page.getNumEmptySlots() > 0) {
                page.insertTuple(t);
                dirtyPages.add(page);
                if (i == numPages)
                    ++numPages;
                break;
            }
        }
        return dirtyPages;
    }

    // see DbFile.java for javadocs
    public Page deleteTuple(TransactionId tid, Tuple t)
        throws DbException, TransactionAbortedException {
        PageId pid = t.getRecordId().getPageId();
        if (pid.getTableId() != getId())
            throw new DbException("the tuple is not on the table");
        HeapPage page = ((HeapPage) Database.getBufferPool().getPage(
                              tid, pid, Permissions.READ_WRITE));
        page.deleteTuple(t);
        return page;
    }

    private class HeapFileIterator implements DbFileIterator {
        
        private static final long serialVersionUID = 1L;
        
        private int curPage = 0;
        private Iterator<Tuple> curItr = null;
        private TransactionId tid;
        private boolean open = false;;
        
        public HeapFileIterator(TransactionId tid) {
            this.tid = tid;
        }
        
        @Override
        public void open() throws DbException, TransactionAbortedException {
            open = true;
            curPage = 0;
            if (curPage >= numPages()) {
                return;
            }
            curItr = ((HeapPage) Database.getBufferPool().getPage(tid,
                    new HeapPageId(getId(), curPage), Permissions.READ_ONLY))
                    .iterator();
            advance();
        }

        private void advance() throws DbException, TransactionAbortedException {
            while (!curItr.hasNext()) {
                curPage++;
                if (curPage < numPages()) {
                    curItr = ((HeapPage) Database.getBufferPool().getPage(tid,
                            new HeapPageId(getId(), curPage),
                            Permissions.READ_ONLY)).iterator();
                } else {
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() throws DbException,
                TransactionAbortedException {
            if (!open) {
                return false;
            }
            return curPage < numPages();
        }

        @Override
        public Tuple next() throws DbException, TransactionAbortedException,
                NoSuchElementException {
            if (!open) {
                throw new NoSuchElementException("iterator not open.");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more tuples.");
            }
            Tuple result = curItr.next();
            advance();
            return result;
        }

        @Override
        public void rewind() throws DbException, TransactionAbortedException {
            if (!open) {
                throw new DbException("iterator not open yet.");
            }
            close();
            open();          
        }

        @Override
        public void close() {
            curItr = null;
            curPage = 0;
            open = false;
        }

    }
    
    // see DbFile.java for javadocs
    public DbFileIterator iterator(TransactionId tid) {
        return new HeapFileIterator(tid);
    }
    
}

