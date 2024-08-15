package BST;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            bst.insert(data);
        }
        for(int i=0; i<10; i++){
            int data = (int)(Math.random() * 1000);
            if(bst.search(data)){
                System.out.println(data + " is found in BST");
            }
            else{
                System.out.println(data + " is not found in BST");
            }
        }
        bst.print();
    }   
}