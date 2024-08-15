package Deque;


public class Main {
    public static void main(String[] args) {
        Deque dq = new Deque();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            dq.pushBack(data);
        }
        System.out.println("Queue size is " + dq.size());
        System.out.println("Back element is " + dq.popBack());
        System.out.println("Front element is " + dq.popFront());
        System.out.println("Back element is " + dq.popBack());
        System.out.println("Front element is " + dq.popFront());
        System.out.println("Front element is " + dq.popFront());
        System.out.println("Queue size is " + dq.size());
        dq.print();
    }
}
