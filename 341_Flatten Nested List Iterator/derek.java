public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;    
            } else {
                stack.pop();
                for (int i = curr.getList().size() -1 ; i>= 0 ;i--) {
                    stack.push(curr.getList().get(i));
                }
            }
        }
        return false;
    }
}
