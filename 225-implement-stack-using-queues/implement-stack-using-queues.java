class MyStack {

   private Deque<Integer> mainQueue = new ArrayDeque<>();
    private Deque<Integer> auxQueue = new ArrayDeque<>();

    public MyStack() {
    }

    public void push(int x) {
        auxQueue.offer(x);
      
        while (!mainQueue.isEmpty()) {
            auxQueue.offer(mainQueue.poll());
        }
      
        Deque<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
    }

    public int pop() {
        return mainQueue.poll();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */