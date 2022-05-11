/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.*/

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int len;
    public MyStack() {
       this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
        this.len = 0;
    }
    
    public void push(int x) {
        this.queue1.add(x);
        this.len = this.len+1;
    }
    
    public int pop() {
       this.len = this.len-1;
        int i=0;
        while(i<len){
            this.queue2.add(this.queue1.poll());
            i++;
        }
        i = 0;
        int element = this.queue1.poll();
        while(i<len){
            this.queue1.add(this.queue2.poll());
            i++;
        }
        return element;
    }
    
    public int top() {
        int i=0;
        while(i<len-1){
            this.queue2.add(this.queue1.poll());
            i++;
        }
        i = 0;
        int element = this.queue1.poll();
        queue2.add(element);
        i=0;
        while(i<len){
            this.queue1.add(this.queue2.poll());
            i++;
        }
        return element;
    }
    
    public boolean empty() {
        return this.queue1.isEmpty();
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