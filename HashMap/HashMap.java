package HashMap;

public class HashMap {
    protected EntryLinkedList lists[];
    protected int size;
    protected int capacity;
    final private int lambda = 3;
    final private int threshold = 10000;

    HashMap(){
        this(20);
    }

    HashMap(int capacity){
        this.capacity = capacity;
        this.lists = new EntryLinkedList[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            lists[i] = new EntryLinkedList(); 
        }
    }

    private int hashCode(int key){
        return (int)(((long)key * key * 31 * 61)  % capacity);
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
                set(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    public int size(){
        return size;
    }

    public void set(int key, int value){
        if(size / capacity > lambda){
            rehash();
        }
        if(size >= threshold){
            return;
        }
        int hashKey = hashCode(key);
        lists[hashKey].set(key, value);    
        ++size;    
    }

    public Integer get(int key){
        int hashKey = hashCode(key);
        EntryLinkedList.Entry entry = lists[hashKey].get(key);
        return entry == null ? null : entry.value;
    }

    public Integer getOrDefault(int key, int defaultValue){
        int hashKey = hashCode(key);
        EntryLinkedList.Entry entry = lists[hashKey].get(key);
        return entry == null ? defaultValue : entry.value;
    }

    public void remove(int key){
        int hashKey = hashCode(key);
        lists[hashKey].remove(key);
    }

    public boolean contains(int key){
        int hashKey = hashCode(key);
        return lists[hashKey].contains(key);
    }

    public void print(){
        for(int i=0; i<capacity; i++){
            lists[i].print();
        }
        System.out.println();
    }

}
