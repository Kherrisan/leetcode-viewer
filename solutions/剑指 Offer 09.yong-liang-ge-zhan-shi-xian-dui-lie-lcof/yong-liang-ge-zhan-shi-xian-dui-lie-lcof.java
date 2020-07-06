class CQueue {

    Stack<Integer> m=new Stack();
    Stack<Integer> n=new Stack();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        m.push(value);
    }
    
    public int deleteHead() {
        if(n.isEmpty()){
            while(!m.isEmpty()){
                n.push(m.pop());
            }
            if(n.isEmpty()){
                return -1;
            }
        }
        return n.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */