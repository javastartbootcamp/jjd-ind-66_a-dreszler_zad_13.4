package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        // tutaj możesz przeprowadzać manualne testy listy
        CustomList<Integer> list = new CustomList<>();
        System.out.println(list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
        list.add(2, 3);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());

        // lista powinna być parametryzowana (analogicznie jak java.util.ArrayList czy java.util.LinkedList)
        CustomList<String> customListOfStrings = new CustomList();
        CustomList<Integer> customListOfIntegers = new CustomList();
    }
}
