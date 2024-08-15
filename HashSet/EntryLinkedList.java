package HashSet;

public class EntryLinkedList {
    public class Entry {
        public int data;
        public Entry next;

        Entry(int data){
            this.data = data;
        }
    }

    protected Entry head, tail;

    EntryLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public Entry getHead(){
        return head;
    }

    private void insert(int data){
        if(head == null){
            head = tail = new Entry(data);
        }
        else{
            tail.next = new Entry(data);
            tail = tail.next;
        }
    }

    public void remove(int data){
        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Entry node = head;
        while(node.next != null && node.next.data != data){
            node = node.next;
        }

        if(node.next == null){
            return;
        }

        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
    }

    public boolean contains(int data){
        Entry node = head;
        while(node != null){
            if(node.data == data){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Entry get(int data){
        Entry node = head;
        while(node != null){
            if(node.data == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean add(int data){
        Entry node = head;
        while(node != null){
            if(node.data == data){
                return false;
            }
            node = node.next;
        }
        insert(data);
        return true;
    }

    public void print(){
        if(head == null){ 
            return;
        }
        Entry node = head;
        while (node != null) {
            System.out.println("Data : " + node.data);
            node = node.next;
        }
    }
}
