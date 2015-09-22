class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
            while(size > 0){
                if(size > 1 ){
                    queue.add(queue.peek());
                }
                queue.remove();
                size--;
            }

    }

    // Get the top element.
    public int top() {
        int size = queue.size();
        int tmp = 0;
        while(size > 0){
            if(size == 1){
                tmp = queue.peek();
            }
            queue.add(queue.peek());
            queue.remove();
            size--;
        }
        return tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue.size() > 0){
            return false;
        }else {
            return true;
        }
        
    }
}
