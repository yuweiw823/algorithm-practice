Leetcode 155 - Min Stack - 设计.java

在ArrayList的基础上，使用get(), remove(), add() 实现栈

push:   add 入 stack
        如果 push 的值比minstack的最小值小，同时 add 入 minstack
pop:    如果 pop 的值比目前最小值大，仅 remove 出 stack 中的值
        如果 pop 的值即为目前的最小值，同时 remove 出 stack 和 minstack
top:    返回 stack 顶部的值
getMin: 返回 minStack 顶部的值

class MinStack {
    //注意：做任何操作前，都思考一下 stack / minStack 为空的状况
    List<Integer> stack = new ArrayList<Integer>();
    List<Integer> minStack = new ArrayList<Integer>();    
    
    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty() || x <= minStack.get(minStack.size()-1)){
            minStack.add(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int elem = stack.remove(stack.size()-1);
        if(!minStack.isEmpty() && minStack.get(minStack.size()-1) == elem){
            minStack.remove(minStack.size()-1);
        }
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        if(minStack.isEmpty()) return 0;
        return minStack.get(minStack.size()-1);
    }
}