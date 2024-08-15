package ArrayHeap;

public class Main {
    public static void main(String[] args) {
        ArrayHeap pq = new ArrayHeap();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            pq.push(data);
        }
        System.out.println("Queue size is " + pq.size());
        System.out.println("Max element is " + pq.pop());
        System.out.println("Max element is " + pq.pop());
        System.out.println("Max element is " + pq.pop());
        System.out.println("Queue size is " + pq.size());
        pq.print();
        while (!pq.isEmpty()) {
            System.out.print(pq.pop() + " ");
        }
    }
}
