package customArrayList.Implementation.ravi;

import customArrayKist.ravi.ArrayListCustom;

import java.util.ArrayList;

public class ArrayListImplementation {
    public static void main(String[] args) {
        ArrayList<Integer> i = new ArrayList<>();
        ArrayListCustom<String> str = new ArrayListCustom<>();
        str.add("Apple");
        str.add("Banana");
        str.add("Guava");
        str.add("Guavaa");
        str.remove(1);
//        System.out.println(str.get(1));
//        str.display();
//        System.out.println(str.isEmpty());
        System.out.println(str.contains("Guavaa"));
        System.out.println(str.get(0));
//        str.clear();
        str.display();
//        Object[] s = str.toArray();
//        System.out.println(s[0]);

    }
}
