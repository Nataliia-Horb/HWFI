package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;
    private String colour;
    private boolean isHungry;

    private String catOwner;


    @Override
    public String toString() {
        return ("Name:" + name + " Age:" + age + " Colour:" + colour + " isHungry:" + isHungry);
    }
}
