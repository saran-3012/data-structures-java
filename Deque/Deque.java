package Deque;

public class Deque {
    public class ListNode {
        public int data;
        public ListNode next, prev;
        ListNode(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }

    protected ListNode front, rear;
    protected int size;

    Deque(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void pushBack(int data){
        if(front == null){
            front = rear = new ListNode(data);
        }
        else{
            rear.next = new ListNode(data);
            rear.next.prev = rear;
            rear = rear.next;
        }
        ++size;
    }

    public void pushFront(int data){
        if(front == null){
            front = rear = new ListNode(data);
        }
        else{
            front.prev = new ListNode(data);
            front.prev.next = front;
            front = front.prev;
        }
        ++size;
    }

    public Integer popBack(){
        if(front == null){
            return null;
        }
        int data = rear.data;
        rear = rear.prev;
        if(rear == null){
            front = null;
        }
        else{
            rear.next = null;
        }
        --size;
        return data;
    }

    public Integer popFront(){
        if(front == null){
            return null;
        }
        int data = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        else{
            front.prev = null;
        }
        --size;
        return data;
    }

    public Integer front(){
        if(front == null){
            return null;
        }
        return front.data;
    }

    public Integer back(){
        if(front == null){
            return null;
        }
        return rear.data;
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
