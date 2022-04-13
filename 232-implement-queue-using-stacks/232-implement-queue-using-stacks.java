class MyQueue {
    private Stack<Integer> stack1;
    public MyQueue() {
        stack1 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.add(x);
    }
    
    public int pop() {
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        int popValue = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
        return popValue;
    }
    
    public int peek() {
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        int peekValue = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
        return peekValue;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */