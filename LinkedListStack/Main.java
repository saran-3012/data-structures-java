package LinkedListStack;

public class Main {
     public static void main(String[] args) {
        LinkedListStack stk = new LinkedListStack();
        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 1000);
            stk.push(data);
        }
        stk.print();
    }
}
