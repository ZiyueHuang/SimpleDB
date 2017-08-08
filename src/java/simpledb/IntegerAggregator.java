package simpledb;

import java.util.*;
/**
 * Knows how to compute some aggregate over a set of IntFields.
 */
public class IntegerAggregator implements Aggregator {
    
    private static final long serialVersionUID = 1L;

    private int gfield;
    private Type gfieldtype;
    private int afield;
    private Op op;
    
    private int[] nogroup;
    private HashMap<Field, int[]> group;
    /**
     * Aggregate constructor
     * @param gbfield the 0-based index of the group-by field in the tuple, or NO_GROUPING if there is no grouping
     * @param gbfieldtype the type of the group by field (e.g., Type.INT_TYPE), or null if there is no grouping
     * @param afield the 0-based index of the aggregate field in the tuple
     * @param what the aggregation operator
     */

    public IntegerAggregator(int gfield, Type gfieldtype, int afield, Op what) {
        // some code goes here
        this.gfield = gfield;
        this.gfieldtype = gfieldtype;
        this.afield = afield;
        this.op = what;
        nogroup = null;
        if (this.gfield != Aggregator.NO_GROUPING) {
            group = new HashMap<Field, int[]>();
        }
    }

    /**
     * Merge a new tuple into the aggregate, grouping as indicated in the constructor
     * @param tup the Tuple containing an aggregate field and a group-by field
     */
    public void mergeTupleIntoGroup(Tuple tup) {
        // some code goes here
        IntField v = (IntField) tup.getField(afield);
            
        if (op == Op.AVG) {
            if (gfield == Aggregator.NO_GROUPING) {
                if (nogroup == null) {
                    nogroup = new int[] { 0, 0 };
                }
                nogroup[0] += 1;
                nogroup[1] += v.getValue();
            } else {
                Field f = tup.getField(gfield);
                group.putIfAbsent(f, new int[] { 0, 0 });
                int[] avg = group.get(f);
                avg[0]++;
                avg[1] += v.getValue();
            }
        } else if (op == Op.COUNT) {
            if (gfield == Aggregator.NO_GROUPING) {
                if (nogroup == null) {
                    nogroup = new int[] { 0 };
                }
                nogroup[0] += 1;
            } else {
                Field f = tup.getField(gfield);
                group.putIfAbsent(f, new int[] {0});
                int[] count = group.get(f);
                count[0]++;
            }
        } else if (op == Op.MAX) {
            if (gfield == Aggregator.NO_GROUPING) {
                if (nogroup == null) {
                    nogroup = new int[] { Integer.MIN_VALUE };
                }
                nogroup[0] = Math.max(nogroup[0], v.getValue());
            } else {
                Field f = tup.getField(gfield);
                group.putIfAbsent(f, new int[] {Integer.MIN_VALUE});
                int[] max = group.get(f);
                max[0] = Math.max(max[0], v.getValue());
            }
        } else if (op == Op.MIN) {
            if (gfield == Aggregator.NO_GROUPING) {
                if (nogroup == null) {
                    nogroup = new int[] { Integer.MAX_VALUE };
                }
                nogroup[0] = Math.min(nogroup[0], v.getValue());
            } else {
                Field f = tup.getField(gfield);
                group.putIfAbsent(f, new int[] {Integer.MAX_VALUE});
                int[] min = group.get(f);
                min[0] = Math.min(min[0], v.getValue());
            }
        } else if (op == Op.SUM) {
            if (gfield == Aggregator.NO_GROUPING) {
                if (nogroup == null) {
                    nogroup = new int[] { 0 };
                }
                nogroup[0] += v.getValue();
            } else {
                Field f = tup.getField(gfield);
                group.putIfAbsent(f, new int[] {0});
                int[] sum = group.get(f);
                sum[0] += v.getValue();
            }
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
            if (nogroup != null) {
                int finalValue;
                if (op == Op.AVG) {
                    // Assume avg is still Type.INT_TYPE
                    finalValue = nogroup[1] / nogroup[0];
                } else {
                    finalValue = nogroup[0];
                }
                tuples.add(Utility.getTuple(new int[] {finalValue}, 1));
            }
        } else {
            td = new TupleDesc(new Type[] {gfieldtype, Type.INT_TYPE});
            for (Map.Entry<Field, int[]> e : group.entrySet()) {
                Tuple t = new Tuple(td);
                t.setField(0, e.getKey());
                int[] tarr = e.getValue();
                int finalValue;
                if (op == Op.AVG) {
                    finalValue = tarr[1] / tarr[0];
                } else {
                    finalValue = tarr[0];
                }
                t.setField(1, new IntField(finalValue));
                tuples.add(t);
            }
        }
        
        return new TupleIterator(td, tuples);
    }

}
