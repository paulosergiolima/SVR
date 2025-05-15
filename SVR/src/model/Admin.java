/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;
/**
 *
 * @author inval
 */
public class Admin {
    private final UUID id;
    private String name;
    
    public Admin(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "ID: " + id +
               "\nNome: " + name;
    }
    
    public Meal newMeal(String description, MealType type, double price) {
        Meal meal = new Meal(description, type, price);
        return meal;
    }
}
