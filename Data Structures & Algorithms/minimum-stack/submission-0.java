class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack= new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.minStack.isEmpty()) {
            this.minStack.push(val);
            return;
        }

        if (this.minStack.peek() > val) {
            this.minStack.push(val);
        } else {
            this.minStack.push(this.minStack.peek());
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
