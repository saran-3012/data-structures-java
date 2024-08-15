package HashMap;

public class EntryLinkedList {
    public class Entry {
        public int key;
        public int value;
        public Entry next;

        Entry(int key, int value){
            this.key = key;
            this.value = value;
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

    private void insert(int key, int value){
        if(head == null){
            head = tail = new Entry(key, value);
        }
        else{
            tail.next = new Entry(key, value);
            tail = tail.next;
        }
    }

    public void remove(int key){
        if(head == null){
            return;
        }

        if(head.key == key){
            head = head.next;
            return;
        }

        Entry node = head;
        while(node.next != null && node.next.key != key){
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

    public boolean contains(int key){
        Entry node = head;
        while(node != null){
            if(node.key == key){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Entry get(int key){
        Entry node = head;
        while(node != null){
            if(node.key == key){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void set(int key, int value){
        Entry node = head;
        while(node != null){
            if(node.key == key){
                node.value = value;
                return;
            }
            node = node.next;
        }
        insert(key, value);
    }

    public void print(){
        if(head == null){ 
            return;
        }
        Entry node = head;
        while (node != null) {
            System.out.println("Key : " + node.key + ", Value : " + node.value);
            node = node.next;
        }
    }
}
