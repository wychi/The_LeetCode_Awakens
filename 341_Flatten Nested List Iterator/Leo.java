public class NestedIterator implements Iterator<Integer> {
    private LinkedList<LinkedList<NestedInteger>> mStack = new LinkedList<>();
    private Integer mNext;
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0) return;
        LinkedList<NestedInteger> list = new LinkedList<>(nestedList);
        mStack.push(list);
        mNext = getNext();
    }
    
    private Integer getNext() {
        while (mStack.size() > 0) {
            LinkedList<NestedInteger> list = mStack.peek();
            NestedInteger n = list.removeFirst();
            if (list.isEmpty()) mStack.pop();
            if (n.isInteger()) return n.getInteger();
            list = new LinkedList<>(n.getList());
            if (list.size() > 0) mStack.push(list);
        }  
        return null;
    }

    @Override
    public Integer next() {
        Integer ret = mNext;
        mNext = getNext();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return null != mNext;
    }
}
