/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author inval
 */
public enum MealType {
    OMNIVOROUS("Onivoro"),
    VEGETARIAN("Vegetariano"),
    VEGAN("Vegano");
    
    private final String description;
    
    MealType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
