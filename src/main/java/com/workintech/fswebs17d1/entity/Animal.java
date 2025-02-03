package com.workintech.fswebs17d1.entity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Animal {

    public static  Map<Integer, Animal> animals = new HashMap<>(); // ID -> Animal

    private Integer id;
    private String name;

    public Animal(Integer id, String name) {
//        if (animals.containsKey(id)) {
//            throw new IllegalArgumentException("An animal with id '" + id + "' has been added before, it belongs to another animal!");
//        }

//        if (animals.values().stream().anyMatch(animal -> animal.getName().equalsIgnoreCase(name))) {
//            throw new IllegalArgumentException(name + " has been added before!");
//        }

        this.id = id;
        this.name = name;

        animals.put(id, this);
        System.out.println(name + " with id "+ id +", has been added to animals HashMap field in Animal(C) !");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
