package LinkedList;

import java.util.ArrayList;

public class LinkedList {
    public class ListNode {
        public int data;
        public ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    protected ListNode head, tail;
    protected int size;

    LinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public ListNode getHead(){
        return head;
    }

    public void insert(int data){
        if(head == null){
            head = new ListNode(data);
            tail = head;
        }
        else{
            tail.next = new ListNode(data);
            tail = tail.next;
        }
        ++size;
    }

    public void remove(int data){
        if(head == null){
            return;
        }
        ListNode pre = null, cur = head;
        while(cur != null && cur.data != data){
            pre = cur;
            cur = cur.next;
        }
        if(cur == null){
            return;
        }
        if(pre == null){
            head = head.next;
            cur.next = null;
            if(head == null){
                tail = null;
            }
        }
        else{
            pre.next = cur.next;
            if(cur.next == null){
                tail = pre;
            }
        }
        --size;
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head == null) {
            tail = null;
        }
        --size;
    }

    public void removeLast(){
        if(head == null){
            return;
        }
        --size;
        if(head.next == null){
            head = null;
            tail = null;
            return;
        }
        tail = head;
        while (tail.next != null && tail.next.next != null) {
            tail = tail.next;
        }
        tail.next = null;
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
