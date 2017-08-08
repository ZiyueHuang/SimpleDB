package simpledb;

import java.util.*;
/**
 * Knows how to compute some aggregate over a set of StringFields.
 */
public class StringAggregator implements Aggregator {

    private static final long serialVersionUID = 1L;

    private int gfield;
    private Type gfieldtype;
    private int afield;
    private Op op;
    
    private int nogroup;
    private HashMap<Field, Integer> group;
    /**
     * Aggregate constructor
     * @param gbfield the 0-based index of the group-by field in the tuple, or NO_GROUPING if there is no grouping
     * @param gbfieldtype the type of the group by field (e.g., Type.INT_TYPE), or null if there is no grouping
     * @param afield the 0-based index of the aggregate field in the tuple
     * @param what aggregation operator to use -- only supports COUNT
     * @throws IllegalArgumentException if what != COUNT
     */

    public StringAggregator(int gfield, Type gfieldtype, int afield, Op what) {
        // some code goes here
        if (what != Op.COUNT) {
            throw new IllegalArgumentException("Only supports COUNT");
        }
        this.gfield = gfield;
        this.gfieldtype = gfieldtype;
        this.afield = afield;
        this.op = what;
        nogroup = 0;
        if (this.gfield != Aggregator.NO_GROUPING) {
            group = new HashMap<Field, Integer>();
        }
    }

    /**
     * Merge a new tuple into the aggregate, grouping as indicated in the constructor
     * @param tup the Tuple containing an aggregate field and a group-by field
     */
    public void mergeTupleIntoGroup(Tuple tup) {
        // some code goes here
        if (gfield == Aggregator.NO_GROUPING) {
            nogroup++; 
        } else {
            Field f = tup.getField(gfield);
            group.put(f, group.getOrDefault(f, 0) + 1);
        }
    }

    /**
     * Create a DbIterator over group aggregate results.
     *
     * @return a DbIterator whose tuples are the pair (groupVal,
     *   aggregateVal) if using group, or a single (aggregateVal) if no
     *   grouping. The aggregateVal is determined by the type of
     *   aggregate specified in the constructor.
     */
    public DbIterator iterator() {
        // some code goes here

        ArrayList<Tuple> tuples = new ArrayList<Tuple>();
        TupleDesc td;
        
        if (gfield == Aggregator.NO_GROUPING) {
            td = Utility.getTupleDesc(1);
            // if nogroup == 0, let tuples be empty
            // To be consistent with IntegerAggregator
            if (nogroup != 0) {
                tuples.add(Utility.getTuple(new int[] {nogroup}, 1));
            }
        } else {
            td = new TupleDesc(new Type[] {gfieldtype, Type.INT_TYPE});
            for (Map.Entry<Field, Integer> e : group.entrySet()) {
                Tuple t = new Tuple(td);
                t.setField(0, e.getKey());
                t.setField(1, new IntField(e.getValue()));
                tuples.add(t);
            }
        }
        
        return new TupleIterator(td, tuples);
    }

}
