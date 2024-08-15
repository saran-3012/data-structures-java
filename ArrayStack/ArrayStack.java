package ArrayStack;

import java.util.Arrays;

public class ArrayStack {
    protected int stack[];
    protected int capacity;
    protected int top;
    final protected int threshold = 10000;

    ArrayStack(){
        this(20);
    }

    ArrayStack(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    private void resize(){
        if(capacity == threshold){
            System.out.println("Stack capacity reached threshold");
            return;
        }
        capacity = Math.min(capacity << 1, threshold);
        stack = Arrays.copyOf(stack, capacity);
    }

    public void push(int data){
        if(top >= capacity-1){
            resize();
        }
        if(top >= threshold - 1){
            return;
        }
        stack[++top] = data;
    }

    public Integer pop(){
        if(top < 0){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top--];
    }

    public Integer top(){
        if(top < 0){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public void print(){
        for(int i = top; i>=0; i--){
            System.err.print(stack[i] + " ");
        }
        System.err.println();
    }
}
