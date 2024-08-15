package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            dll.insert(data);
        }
        for(int i=0; i<10; i++){
            int data = (int)(Math.random() * 1000);
            if(dll.search(data)){
                System.out.println(data + " is found in Linked List");
            }
            else{
                System.out.println(data + " is not found in Linked List");
            }
        }
        dll.print();
    }
}
