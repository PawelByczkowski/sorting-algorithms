package com.company;

public class MyStack {
    private int MAX_STACK_SIZE;
    private int stackTop;
    private int[] stack;

    MyStack(int size) {
        this.stackTop = -1;
        this.MAX_STACK_SIZE = size;
        this.stack = new int[MAX_STACK_SIZE];
    }

    public int pop() {
        if (stackTop < 0) {
            return 0;
        } else {
            return stack[stackTop--];
        }
    }

    public boolean push(int num) {
        if (stackTop >= (MAX_STACK_SIZE - 1)) {
            return false;
        } else {
            stack[++stackTop] = num;
            return true;
        }
    }


}
