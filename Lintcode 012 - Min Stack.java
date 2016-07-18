Lintcode 12 - Min Stack.java

public class MinStack {
    //keep 一个和stack同样大小的 minStack，但每次push如的数据都是stack中的最小值
    //e.g.
    //stack:      3,2,2,4,1,5,8
    //minStack:   1,1,1,1,1,5,8
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() { //这里的pop是pop的整个stack的
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
