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
    private String login;
    private String password;
    private boolean isLoggedIn;
    
    public Admin(String name, String login, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.login = login;
        this.password = password;
        this.isLoggedIn = false;
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
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean login(String login, String password) {
        if(this.login.equals(login) && this.password.equals(password)) {
            this.setIsLoggedIn(true);
            return true;
        }
        return false;
    }
    
    public boolean logout() {
        if(this.isLoggedIn) {
            this.setIsLoggedIn(false);
            return true;
        }
        return false;
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
    
    public boolean addMealToSale(Meal meal, Sale sale) {
        if(meal != null && sale != null) {
            sale.addMeal(meal);
            return true;
        }
        return false;
    }
    
    public boolean removeMealFromSale(Meal meal, Sale sale) {
        if(meal != null && sale != null) {
            sale.removeMeal(meal);
            return true;
        }
        return false;
    }
}
