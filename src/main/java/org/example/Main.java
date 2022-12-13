package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//            1) Дан список слов. С помощью стримов вывести его аббревиатуру в виде S.M.A.R.T.
        List<String> list = Arrays.asList("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");

        //Вариант 1
        System.out.println(list.stream().map(e -> e.substring(0, 1)).collect(Collectors.joining(".")));

        //Вариант 2
        System.out.println(list.stream().map(e -> e.substring(0, 1).concat(".")).reduce(String::concat).get());

        System.out.println("-----------------------------");


//            2) В класс Cat добавить поле String catOwner

        Cat cat1 = new Cat("Myrka", 2, "black-white", true, "Tim Tailor");
        Cat cat2 = new Cat("Lysia", 1, "white", true, "Maria Rei");
        Cat cat3 = new Cat("Timur", 1, "black", true, "Simon Door");
        Cat cat4 = new Cat("Tom", 2, "black", true, "Tim Tailor");
        Cat cat5 = new Cat("Vasia", 3, "grey", false, "Vita Kama");
        Cat cat6 = new Cat("Tom", 2, "black", false, "Maria Rei");
        Cat cat7 = new Cat("Markis", 4, "blue", true, "Tim Tailor");
        Cat cat8 = new Cat("Rudolf", 1, "white", false, "Mr.Ben");
        Cat cat9 = new Cat("Umka", 1, "red", true, "Mr.Ben");
        Cat cat10 = new Cat("Alisa", 2, "blue", false, "Mr.Ben");
        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10};

        //  сформировать и вывести Map из списка имен хозяев с числом их коше

        // 1 вариант
        Map<String, Integer> map = Arrays.stream(cats).collect(Collectors.toMap(Cat::getCatOwner, v -> 1, (t1, t2) -> t1 + t2));
        System.out.println(map);

        // 2вариант
        Map<String, Long> map1 = Arrays.stream(cats).collect(Collectors.groupingBy(Cat::getCatOwner, Collectors.counting()));
        System.out.println(map1);
        System.out.println("-----------------------------");

//            сформировать и вывести Map из списка имен хозяев со списком имен их кошек

        Map<String, List<String>> map2 = Arrays.stream(cats).collect(Collectors.groupingBy(Cat::getCatOwner, Collectors.mapping(Cat::getName, Collectors.toList())));
        System.out.println(map2);
        System.out.println("-----------------------------");

//            3)StringBuilder: напишите метод, который принимает две строки в аргументах, соединяет их и определяет реверсивный порядок, выведите результат на консоль.

        System.out.println(twoStringReverse("Cat", "Dog"));
        System.out.println("-----------------------------");

//            4)StringBuilder: дан массив символов, объедините его и замените символ '?' на правильный символ, выведите результат на консоль.

        char[] arr = new char[]{'S', 't', 'r', 'i', '?', 'g', ' ', 'i', 's', ' ', 'i', 'm', 'm', 'u', 't', 'a', 'b', 'l', 'e'};

        StringBuilder build = new StringBuilder();
        build.append(arr);
        int position = build.indexOf("?");
        build.replace(position, position + 1, "n");
        System.out.println(build);
    }

    public static String twoStringReverse(String cat, String dog) {
        StringBuilder resStr = new StringBuilder(cat);
        resStr.append(dog);
        return resStr.reverse().toString();
    }
}

