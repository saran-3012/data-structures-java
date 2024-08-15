package DoublyLinkedList;

import java.util.ArrayList;

public class DoublyLinkedList {
    public class ListNode {
        public int data;
        public ListNode next, prev;
        ListNode(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }

    protected ListNode head, tail;
    protected int size = 0;

    DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public ListNode getHead(){
        return head;
    }

    public ListNode getTail(){
        return tail;
    }

    public void insert(int data){
        if(head == null){
            head = tail = new ListNode(data);
        }
        else{
            tail.next = new ListNode(data);
            tail.next.prev = tail;
            tail = tail.next;
        }
        ++size;
    }

    public void remove(int data){
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur != null && cur.data != data){
            cur = cur.next;
        }
        if(cur == null){
            return;
        }

        if(cur.prev == null){
            head = head.next;
            if(head == null){
                tail = null;
            }
            else{
                head.prev = null;
            }
        }
        else{
            cur.prev.next = cur.next;
            if(cur.next == null){
                tail = cur.prev;
            }
            else{
                cur.next.prev = cur.prev;
            }
        }
        --size;
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
        else{
            head.prev = null;
        }
        --size;
    }

    public void removeLast(){
        if(tail == null){
            return;
        }
        tail = tail.prev;
        if(tail == null){
            head = null;
        }
        else{
            tail.next = null;
        }
        --size;
    }

    public boolean search(int data){
        ListNode node = head;
        while(node != null){
            if(node.data == data){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Integer getFirst(){
        if(head == null){
            return null;
        }
        return head.data;
    }

    public Integer getLast(){
        if(head == null){
            return null;
        }
        return tail.data;
    }

    public void print(){
        ListNode node = head;
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ArrayList<Integer> getArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }
        return list;
    }
}
