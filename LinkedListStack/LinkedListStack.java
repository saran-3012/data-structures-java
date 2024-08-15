package LinkedListStack;


public class LinkedListStack {

    private class ListNode {
        public int data;
        public ListNode next;
        ListNode(int data){
            this.data = data;
        }
    }

    protected ListNode top;
    protected int size;

    LinkedListStack(){
        this.top = null;
        this.size = 0;
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        ++size;
    }

    public Integer pop(){
        if(top == null){
            return null;
        }
        int data = top.data;
        top = top.next;
        --size;
        return data;
    }

    public Integer top(){
        if(top == null){
            return null;
        }
        return top.data;
    }

    public int size(){
        return size;
    }

    public void print(){
        ListNode node = top;
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
