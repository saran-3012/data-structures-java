package LinkedListQueue;

public class LinkedListQueue {
    public class ListNode {
        public int data;
        public ListNode next;
        ListNode(int data){
            this.data = data;
        }
    }

    protected ListNode front, rear;
    protected int size;

    LinkedListQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void clear(){
        front = null;
        rear = null;
    }

    public void push(int data){
        if(front == null){
            front = rear = new ListNode(data);
        }
        else{
            rear.next = new ListNode(data);
            rear = rear.next;
        }
        ++size;
    }

    public Integer pop(){
        if(front == null){
            return null;
        }
        int data = front.data;
        front = front.next;
        --size;
        return data;
    }

    public Integer front(){
        if(front == null){
            return null;
        }
        return front.data;
    }

    public int size(){
        return size;
    }

    public void print(){
        ListNode node = front;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

}
