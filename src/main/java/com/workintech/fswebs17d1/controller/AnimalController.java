package com.workintech.fswebs17d1.controller;


import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    public static Map<Integer, Animal> animals = Animal.animals;

    @PostConstruct
    public  void  loadAll() {
        System.out.println("@PostConstruct, loadAll() called !");
        this.animals = new HashMap<>();
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        System.out.println("getAllAnimals() called!");
        return new ArrayList<>(animals.values());
    }

    //berkintech/animal/{id}
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable ("id") int id) {
        if( id <= 0 ) {
            System.out.println("ID: " + id + " is invalid!");
            return null;
        }

        return this.animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {

        if(animal.getName() == null || animal.getId() == null) {
            System.out.println("Invalid post parameter");
        }
        this.animals.put(animal.getId(), animal);
    }

    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable("id") int id, @RequestBody Animal newAnimal) {
        System.out.println(id <= 0 ? "Invalid id input!": "The animal with " + id + " id has been updated successfully.");
        this.animals.replace(id, newAnimal);
        return this.animals.get(id);
    }

    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable("id") int id) {
        System.out.println(id <= 0 ? "Invalid id input!": "The animal with " + id + " id has been deleted successfully.");
        this.animals.remove(id);
    }
}
