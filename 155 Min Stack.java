/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.*/

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(min.empty() || x<= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        if(!stack.empty()){
            if(stack.peek().equals(min.peek())){
                min.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public int getMin() {
        if(!min.empty()){
            return min.peek();
        }else {
            return Integer.MAX_VALUE;
        }
    }
}
