package HashSet;

public class HashSet {
    protected EntryLinkedList lists[];
    protected int size;
    protected int capacity;
    final private int lambda = 3;
    final private int threshold = 10000;

    HashSet(){
        this(20);
    }

    HashSet(int capacity){
        this.capacity = capacity;
        this.lists = new EntryLinkedList[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            lists[i] = new EntryLinkedList(); 
        }
    }

    private int hashCode(int data){
        return (int)(((long)data * data * 31 * 61)  % capacity);
    }

    private void rehash(){
        if(capacity >= threshold){
            System.out.println("Hash Map size reached threshold");
            return;
        }

        EntryLinkedList copyLists[] = lists.clone();

        capacity = Math.min(capacity << 1, threshold);
        lists = new EntryLinkedList[capacity];
        size = 0;

        for (int i = 0; i < capacity; i++) {
            lists[i] = new EntryLinkedList(); 
        }

        for(EntryLinkedList ell : copyLists){
            EntryLinkedList.Entry entry = ell.getHead();
            while (entry != null) {
                add(entry.data);
                entry = entry.next;
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean add(int data){
        if(size / capacity > lambda){
            rehash();
        }
        if(size >= threshold){
            return false;
        }
        int hashKey = hashCode(data);
        ++size;    
        return lists[hashKey].add(data);    
    }

    public void remove(int data){
        int hashKey = hashCode(data);
        lists[hashKey].remove(data);
    }

    public boolean contains(int data){
        int hashKey = hashCode(data);
        return lists[hashKey].contains(data);
    }

    public void print(){
        for(int i=0; i<capacity; i++){
            lists[i].print();
        }
        System.out.println();
    }

}
