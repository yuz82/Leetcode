/*
Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/

class MyQueue {
    Stack<Integer> stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(stack.size() > 1){
            tmpStack.push(stack.pop());
        }
        stack.pop();
        while(!tmpStack.empty()){
            stack.push(tmpStack.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(stack.size() > 1){
            tmpStack.push(stack.pop());
        }
        int peek = stack.peek();
        while(!tmpStack.empty()){
            stack.push(tmpStack.pop());
        }
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
