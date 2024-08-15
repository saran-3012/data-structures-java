package LinkedListQueue;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue que = new LinkedListQueue();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            que.push(data);
        }
        System.out.println("Queue size is " + que.size());
        System.out.println("Front element is " + que.pop());
        System.out.println("Front element is " + que.pop());
        System.out.println("Front element is " + que.pop());
        System.out.println("Queue size is " + que.size());
        que.print();
    }
}
