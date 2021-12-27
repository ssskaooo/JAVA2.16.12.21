package lesson3;

import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        setExample();
        System.out.println("===+++++++++++===");
        phoneBook();
    }

    private static void setExample() {
        List<String> list = new ArrayList<>();

        list.add("Виталий");
        list.add("Катя");
        list.add("Катя");
        list.add("Геннадий");
        list.add("Виталий");
        list.add("Антон");
        list.add("Антон");
        list.add("Лариса");
        list.add("Василий");
        list.add("Василий");
        list.add("Иван");
        list.add("Иван");
        list.add("Виталий");
        list.add("Лиза");
        list.add("Егор");

        HashSet<String> printed = new HashSet<>();
        for (String s : list) {
            if (printed.add(s))
                System.out.println("Имя: " + s + ", использовалось: " + Collections.frequency(list, s));
        }

    }

    private static void phoneBook() {
        Directory directory = new Directory();

        directory.add("Бирюков", "89857689922");
        directory.add("Бирюков", "89857485912");
        directory.add("Рогов", "89528899621");
        directory.add("Иванов", "89774772677");
        directory.add("Бирюков", "89857689922");
        directory.add("Седов", "898577788832");
        directory.add("Лобов", "89996542132");

        System.out.println("Бирюков : " + directory.get("Бирюков"));
        System.out.println("Седов : " + directory.get("Седов"));
        System.out.println("Лобов : "  + directory.get("Лобов"));


    }
}
