package simpledb;

import java.io.Serializable;
import java.util.*;

/**
 * TupleDesc describes the schema of a tuple.
 */
public class TupleDesc implements Serializable {

    /**
     * A help class to facilitate organizing the information of each field
     * */
    public static class TDItem implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * The type of the field
         * */
        public final Type fieldType;
        
        /**
         * The name of the field
         * */
        public final String fieldName;

        public TDItem(Type t, String n) {
            this.fieldName = n;
            this.fieldType = t;
        }

        public String toString() {
            return fieldName + "(" + fieldType + ")";
        }
    }

    /**
     * @return
     *        An iterator which iterates over all the field TDItems
     *        that are included in this TupleDesc
     * */
    public Iterator<TDItem> iterator() {
        // some code goes here
        return tdItemList.iterator();
    }

    private static final long serialVersionUID = 1L;

    private List<TDItem> tdItemList;
    private int sizeInBytes;

    /**
     * Create a new TupleDesc with typeAr.length fields with fields of the
     * specified types, with associated named fields.
     * 
     * @param typeAr
     *            array specifying the number of and types of fields in this
     *            TupleDesc. It must contain at least one entry.
     * @param fieldAr
     *            array specifying the names of the fields. Note that names may
     *            be null.
     */
    public TupleDesc(Type[] typeAr, String[] fieldAr) {
        // some code goes here
        tdItemList = new ArrayList<TDItem>();
        sizeInBytes = 0;
        for (int i = 0; i < typeAr.length; i++) {
            Type fieldType = typeAr[i];
            String fieldName = fieldAr[i];
            tdItemList.add(new TDItem(fieldType, fieldName));
            sizeInBytes += fieldType.getLen();
        }
    }

    /**
     * Constructor. Create a new tuple desc with typeAr.length fields with
     * fields of the specified types, with anonymous (unnamed) fields.
     * 
     * @param typeAr
     *            array specifying the number of and types of fields in this
     *            TupleDesc. It must contain at least one entry.
     */
    public TupleDesc(Type[] typeAr) {
        // some code goes here
        this(typeAr, new String[typeAr.length]);
    }

    /**
     * @return the number of fields in this TupleDesc
     */
    public int numFields() {
        // some code goes here
        return tdItemList.size();
    }

    /**
     * Gets the (possibly null) field name of the ith field of this TupleDesc.
     * 
     * @param i
     *            index of the field name to return. It must be a valid index.
     * @return the name of the ith field
     * @throws NoSuchElementException
     *             if i is not a valid field reference.
     */
    public String getFieldName(int i) throws NoSuchElementException {
        // some code goes here
        if (i >=  0 && i < tdItemList.size()) {
            return tdItemList.get(i).fieldName;
        } else {
            throw new NoSuchElementException("i is not a valid field reference.");
        }
    }

    /**
     * Gets the type of the ith field of this TupleDesc.
     * 
     * @param i
     *            The index of the field to get the type of. It must be a valid
     *            index.
     * @return the type of the ith field
     * @throws NoSuchElementException
     *             if i is not a valid field reference.
     */
    public Type getFieldType(int i) throws NoSuchElementException {
        // some code goes here
        if (i >=  0 && i < tdItemList.size()) {
            return tdItemList.get(i).fieldType;
        } else {
            throw new NoSuchElementException("i is not a valid field reference.");
        }
    }

    /**
     * Find the index of the field with a given name.
     * 
     * @param name
     *            name of the field.
     * @return the index of the field that is first to have the given name.
     * @throws NoSuchElementException
     *             if no field with a matching name is found.
     */
    public int fieldNameToIndex(String name) throws NoSuchElementException {
        // some code goes here
        for (int i = 0; i < tdItemList.size(); i++) {
            String fieldName = tdItemList.get(i).fieldName;
            if ((fieldName == null && name == null) || 
                    (fieldName != null && fieldName.equals(name))) {
                return i;
            }
        }
        throw new NoSuchElementException("no field with a matching name is found.");
    }

    /**
     * @return The size (in bytes) of tuples corresponding to this TupleDesc.
     *         Note that tuples from a given TupleDesc are of a fixed size.
     */
    public int getSize() {
        // some code goes here
        return sizeInBytes;
    }

    /**
     * Merge two TupleDescs into one, with td1.numFields + td2.numFields fields,
     * with the first td1.numFields coming from td1 and the remaining from td2.
     * 
     * @param td1
     *            The TupleDesc with the first fields of the new TupleDesc
     * @param td2
     *            The TupleDesc with the last fields of the TupleDesc
     * @return the new TupleDesc
     */
    public static TupleDesc merge(TupleDesc td1, TupleDesc td2) {
        // some code goes here
        Type[] typeArray = new Type[td1.numFields() + td2.numFields()];
        String[] nameArray = new String[td1.numFields() + td2.numFields()];
        
        int i = 0;
        for (TDItem item : td1.tdItemList) {
            typeArray[i] = item.fieldType;
            nameArray[i] = item.fieldName;
            i++;
        }
        for (TDItem item : td2.tdItemList) {
            typeArray[i] = item.fieldType;
            nameArray[i] = item.fieldName;
            i++;
        }
        
        return new TupleDesc(typeArray, nameArray);
    }

    /**
     * Compares the specified object with this TupleDesc for equality. Two
     * TupleDescs are considered equal if they are the same size and if the n-th
     * type in this TupleDesc is equal to the n-th type in td.
     * 
     * @param o
     *            the Object to be compared for equality with this TupleDesc.
     * @return true if the object is equal to this TupleDesc.
     */
    public boolean equals(Object o) {
        // some code goes here
        if (o == this) {
            return true;
        }
        if (! (o instanceof TupleDesc)) {
            return false;
        }
        if (((TupleDesc) o).numFields() != numFields()) {
            return false;
        }
        for (int i = 0; i < numFields(); i++) {
            if (getFieldType(i) != ((TupleDesc) o).getFieldType(i)) {
                return false;
            }
        }
        return true;    
    }

    public int hashCode() {
        // If you want to use TupleDesc as keys for HashMap, implement this so
        // that equal objects have equals hashCode() results
        throw new UnsupportedOperationException("unimplemented");
    }


    /**
     * Returns a String describing this descriptor. It should be of the form
     * "fieldType[0](fieldName[0]), ..., fieldType[M](fieldName[M])", although
     * the exact format does not matter.
     * 
     * @return String describing this descriptor.
     */
    public String toString() {
        // some code goes here
        List<String> strings = new ArrayList<String>();
        for (TDItem item : tdItemList) {
            Type type = item.fieldType;
            String name = item.fieldName;
            strings.add(String.format("%s(%s)", type, name));
        }
        return String.join(", ", strings);
    }
}
