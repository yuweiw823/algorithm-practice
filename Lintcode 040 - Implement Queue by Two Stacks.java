Lintcode 040 - Implement Queue by Two Stacks.java

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    //算法关键：
    //push()时，推入stack2中
    //top()或pop()时，从stack1取。如果stack1为空，stack2清空，全部推入stack1中(倒序)
    public Queue() {
       // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    //stack2清空，全部推入stack1中
    public void stack2ToStack1() {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    
    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if(stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if(stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}