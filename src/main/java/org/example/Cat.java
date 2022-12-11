package org.example;

import lombok.Getter;

@Getter
public class Cat {
    private String name;
    private int age;
    private String colour;
    private boolean isHungry;

    public Cat(String name, int age, String colour, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return ("Name:" + name + " Age:" + age + " Colour:" + colour + " isHungry:" + isHungry);
    }
}
