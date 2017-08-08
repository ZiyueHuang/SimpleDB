package simpledb;

import java.util.*;

public class RWLock {
    Set<TransactionId> holders;
    Map<TransactionId, Boolean> acquirers;
    boolean exclusive;
    private int readNum;
    private int writeNum;

    public RWLock() {
        holders = new HashSet<TransactionId>();
        acquirers = new HashMap<TransactionId, Boolean>();
        exclusive = false;
        readNum = 0;
        writeNum = 0;
    }

    public void readLock(TransactionId tid) {
        if (holders.contains(tid) && !exclusive) return;
        acquirers.put(tid, false);
        synchronized (this) {
            try {
                while (writeNum != 0) this.wait();
                ++readNum;
                holders.add(tid);
                exclusive = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        acquirers.remove(tid);
    }

    public void writeLock(TransactionId tid) {
        if (holders.contains(tid) && exclusive) return;
        if (acquirers.containsKey(tid) && acquirers.get(tid)) return;
        acquirers.put(tid, true);
        synchronized (this) {
            try {
                if (holders.contains(tid)) {
                    while (holders.size() > 1) {
                        this.wait();
                    }
                    readUnlockWithoutNotifyingAll(tid);
                }
                while (readNum != 0 || writeNum != 0) this.wait();
                ++writeNum;
                holders.add(tid);
                exclusive = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        acquirers.remove(tid);
    }

    private void readUnlockWithoutNotifyingAll(TransactionId tid) {
        if (!holders.contains(tid)) return;
        synchronized (this) {
            --readNum;
            holders.remove(tid);
        }
    }

    public void readUnlock(TransactionId tid) {
        if (!holders.contains(tid)) return;
        synchronized (this) {
            --readNum;
            holders.remove(tid);
            notifyAll();
        }
    }

    public void writeUnlock(TransactionId tid) {
        if (!holders.contains(tid)) return;
        if (!exclusive) return;
        synchronized (this) {
            --writeNum;
            holders.remove(tid);
            notifyAll();
        }
    }

    public void unlock(TransactionId tid) {
        if (!exclusive)
            readUnlock(tid);
        else writeUnlock(tid);
    }

    public Set<TransactionId> holders() {
        return holders;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public Set<TransactionId> acquirers() {
        return acquirers.keySet();
    }

    public boolean heldBy(TransactionId tid) {
        return holders().contains(tid);
    }

}
