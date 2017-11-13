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

    Stack< List<NestedInteger> > stackList = new Stack<>();
    Stack<Integer> stackIndex = new Stack<>();
    List<NestedInteger> mCurList;
    int mCurIdx;
    
    Integer nextVal = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        mCurList = nestedList;
        mCurIdx = 0;
    }

    @Override
    public Integer next() {
        Integer ret = nextVal;
        nextVal = null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        Integer result = null;
        
        while(mCurIdx >= mCurList.size()) {
            if(stackList.isEmpty())
                return false;
            
            mCurList = stackList.pop();
            mCurIdx = stackIndex.pop();
        }
        
        NestedInteger item = mCurList.get(mCurIdx);
        mCurIdx++;
        
        if(!item.isInteger()) {
            List<NestedInteger> list = item.getList();
            if(!list.isEmpty()) {
                stackList.push(mCurList);
                stackIndex.push(mCurIdx);
                mCurList = list;
                mCurIdx = 0;
            }
            
            return hasNext();
            
        } else {
            result = item.getInteger();
        }
        
        nextVal = result;
        return nextVal != null;
    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
