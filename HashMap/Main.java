package HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap mp = new HashMap();

        mp.set(1000, 56);
        mp.set(2340, 647);
        mp.set(25, 436);
        mp.set(426, 463);
        mp.set(346, 436);
        mp.set(6547, 436);
        mp.set(6874, 46);
        mp.set(4856, 436);
        mp.set(658, 235);
        mp.set(674, 57);
        mp.set(4554, 34);
        mp.set(457, 324);
        
        System.out.println(mp.contains(2534));
        System.out.println(mp.contains(25));
        System.out.println(mp.contains(6874));

        System.out.println();

        System.out.println(mp.get(674));
        System.out.println(mp.get(34));
        System.out.println(mp.get(1000));

        System.out.println();

        mp.print();
    }
}
