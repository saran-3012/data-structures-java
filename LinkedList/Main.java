package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            ll.insert(data);
        }
        for(int i=0; i<10; i++){
            int data = (int)(Math.random() * 1000);
            if(ll.search(data)){
                System.out.println(data + " is found in Linked List");
            }
            else{
                System.out.println(data + " is not found in Linked List");
            }
        }
        ll.print();
    }
}
