package ArrayQueue;

import java.util.Arrays;

public class ArrayQueue {
    protected int queue[];
    protected int capacity;
    final private int threshold = 10000;
    protected int front, rear;

    ArrayQueue(){
        this(20);
    }

    ArrayQueue(int capacity){
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
    }

    private void resize(){
        if(capacity == threshold){
            System.out.println("Queue capacity reached threshold");
            return;
        }
        int copyQueue[] = Arrays.copyOfRange(queue, front, capacity);
        capacity = Math.min(capacity << 1, threshold);
        queue = Arrays.copyOf(copyQueue, capacity);
        rear -= front;
        front = 0;
    }

    public void clear(){
        this.front = 0;
        this.rear = -1;
    }

    public void push(int data){
        if(rear >= capacity - 1){
            resize();
        }
        if(rear >= threshold - 1){
            return;
        }
        queue[++rear] = data;
    }

    public Integer pop(){
        if(front > rear){
            return null;
        }
        return queue[front++];
    }

    public Integer front(){
        if(front > rear){
            return null;
        }
        return queue[front];
    }

    public int size(){
        return rear - front + 1;
    }

    public void print(){
        for(int i=front; i<=rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
