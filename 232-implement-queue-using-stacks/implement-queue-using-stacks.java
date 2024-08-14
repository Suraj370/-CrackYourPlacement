class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front, bottom;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(s1.empty() && s2.empty()){
            front = x;
        }
        if(s1.empty()){
            bottom = x;
        }
        s1.push(x);
    }
    
    public int pop() {
        int ans;
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.peek());
                s1.pop();
            }
        }
        ans = s2.peek();
        s2.pop();
        if(!s2.empty())front = s2.peek();
        else if(!s1.empty()) front = bottom;
        return ans;
    }

    public int peek(){
        return front;
    }
    
 
    public boolean empty() {
        return s1.empty() && s2.empty();       
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