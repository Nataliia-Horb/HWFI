package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

    public class Main {
        public static void main(String[] args) {

//        First level: 1. Создать Supplier, который генерирует случайные значения типа Integer

            Supplier<Integer> sup = () -> new Random().nextInt();
            System.out.println(sup.get());
            System.out.println("-------------------------------");

//        Создать BiFunction, которая возводит первый аргумент типа int в степень второго аргумента типа int

            BiFunction<Integer, Integer, Double> func = Math::pow;
            System.out.println(func.apply(5, 3));
            System.out.println("-------------------------------");


//        Отсортировать с помощью стримов список из строк
//        по алфавиту
//        в обратном порядке

            List<String> list = Arrays.asList("Hello, my friend", "How are you", "red car drives far", "the weather was cold");
            System.out.println(list.stream().sorted().collect(Collectors.toList()));
            System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
            System.out.println("-------------------------------");

//        Из списка чисел типа Integer с помощью стримов создать список их строковых представлений

            List<Integer> listInt = Arrays.asList(3, 55, 47, 12, 100, 3, 12, 45, 78);
            List<String> listStr = listInt.stream().map(el -> el.toString()).collect(Collectors.toList());
            System.out.println(listStr);
            System.out.println("-------------------------------");


//        Second level: 5. Создать класс Cat с полями
//        String name
//        int age
//        String colour
//        boolean isHungry
//        Создать список из экземплянов класса Cat. С помощью стримов:

            Cat cat1 = new Cat("Myrka", 2, "black-white", true);
            Cat cat2 = new Cat("Lysia", 1, "white", true);
            Cat cat3 = new Cat("Timur", 1, "black", true);
            Cat cat4 = new Cat("Tom", 2, "black", true);
            Cat cat5 = new Cat("Vasia", 3, "grey", false);
            Cat cat6 = new Cat("Tom", 2, "black", false);
            Cat cat7 = new Cat("Markis", 4, "blue", true);
            Cat cat8 = new Cat("Rudolf", 1, "white", false);
            Cat cat9 = new Cat("Umka", 1, "red", true);
            Cat cat10 = new Cat("Alisa", 2, "blue", false);
            Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10};

//        вывести список голодных кошек старше 2 лет

            List<Cat> myList1 = Arrays.stream(cats).filter(el -> el.getAge() > 2).collect(Collectors.toList());
            myList1.forEach(System.out::println);
            System.out.println("-------------------------------");

//        вывести список черных кошек с именем, начинающимся на T

            List<Cat> myList2 = Arrays.stream(cats).filter(e -> (e.getColour() == "black" && e.getName().substring(0, 1)
                    .contains("T"))).collect(Collectors.toList());
            myList2.forEach(System.out::println);
            System.out.println("-------------------------------");

//        вывести список имен кошек возраста 1 год

            List<String> myList3 = Arrays.stream(cats).filter(e -> (e.getAge() == 1)).map(a -> a.getName()).collect(Collectors.toList());
            myList3.forEach(System.out::println);
        }
    }

