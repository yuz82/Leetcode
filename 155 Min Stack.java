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

//use ArrayList
class MinStack {
    ArrayList<Integer> stack = new ArrayList<Integer>();
    //every node contains min value at the moment it was pushed
    ArrayList<Integer> min = new ArrayList<Integer>();
    //int l = stack.size()-1;
    int topv = 0;
    public void push(int x) {
        stack.add(x);
        if(min.size()==0) min.add(x);
        else if(x<min.get(min.size()-1)) min.add(x);
        else min.add(min.get(min.size()-1));
    }

    public void pop() {
        min.remove(min.size()-1);
        stack.remove(stack.size()-1);
    }

    public int top() {
        topv = stack.get(stack.size()-1);
        return topv;
    }

    public int getMin() {
        return min.get(min.size()-1);
    }
}
