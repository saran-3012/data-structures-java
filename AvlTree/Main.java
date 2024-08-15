package AvlTree;

public class Main {
    public static void main(String[] args) {
        AvlTree avl = new AvlTree();
        for(int i=0; i<1000; i++){
            int data = (int)(Math.random() * 1000);
            avl.insert(data);
        }

        System.out.println("Height of the tree is " + avl.height());

        for(int i=0; i<10; i++){
            int data = (int)(Math.random() * 1000);
            if(avl.search(data)){
                System.out.println(data + " is found in BST");
            }
            else{
                System.out.println(data + " is not found in BST");
            }
        }
        avl.print();
    }   
}
