package HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        for(int i=0; i<100; i++){
            int data = (int)(Math.random() * 100);
            System.out.println("The element " + data + " is added : " + set.add(data));
        }

        for(int i=0; i<10; i++){
            int data = (int)(Math.random() * 100);
            System.out.println(data + " is found : " + set.contains(data));
        }

        System.out.println(set.size());

        set.print();
    }
}
