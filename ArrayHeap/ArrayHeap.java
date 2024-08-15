package ArrayHeap;

import java.util.Arrays;

public class ArrayHeap {
    protected int heap[];
    protected int capacity;
    protected int size;
    final private int threshold = 10000;

    ArrayHeap(){
        this(20);
    }

    ArrayHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private void resize(){
        if(capacity >= threshold){
            System.out.println("Heap reached the threshold");
            return;
        }
        capacity = Math.min(capacity << 1, threshold);
        heap = Arrays.copyOf(heap, capacity);
    }

    private int parent(int index){
        return (index - 1)/2;
    }

    private int left(int index){
        return (index << 1) + 1;
    }

    private int right(int index){
        return (index << 1) + 2;
    }

    protected void heapify(int index){
        int left = left(index);
        int right = right(index);
        int maxIndex = index;

        if(left < size && heap[maxIndex] < heap[left]){
            maxIndex = left;
        }
        if(right < size && heap[maxIndex] < heap[right]){
            maxIndex = right;
        }
        
        if(maxIndex != index){
            int temp = heap[index];
            heap[index] = heap[maxIndex];
            heap[maxIndex] = temp;
            heapify(maxIndex);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public void push(int data){
        if(size >= capacity){
            resize();
        }
        if(size >= threshold){
            return;
        }

        heap[size++] = data;
        int index = size - 1;
        while (index > 0 && heap[parent(index)] < heap[index]) {
            int temp = heap[parent(index)];
            heap[parent(index)] = heap[index];
            heap[index] = temp;
            index = parent(index);
        }
    }

    public Integer pop(){
        if(size <= 0){
            return null;
        }

        int data = heap[0];
        heap[0] = heap[--size];

        heapify(0);

        return data;
    }

    public Integer top(){
        if(size <= 0){
            return null;
        }

        return heap[0];
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
