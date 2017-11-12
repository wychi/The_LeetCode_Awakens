/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> data = new ArrayList<>();
    private int current=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        decode(nestedList);
    }
    
    private void decode(List<NestedInteger> nestedList) {
        for(NestedInteger n : nestedList) {
            //System.out.println("decode:"+n);
            if(n.isInteger()) {
                data.add(n.getInteger());
            }else{
                decode(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return data.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current<data.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */