/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
/**
 *
 * @author inval
 */
public class Account {
    private String login;
    private String password;
    private boolean isLoggedIn;
    private double credit;
    private ArrayList<Meal> mealList;
    
    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.isLoggedIn = false;
        this.credit = 0;
        this.mealList = new ArrayList<>();
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
    
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }
    
    public void addMeal(Meal meal) {
        this.mealList.add(meal);
    }
    
    public void removeMeal(Meal meal) {
        this.mealList.remove(meal);
    }
    
    public Meal getMealByDescription(String description){
        for(Meal meal : mealList) {
            if(meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }
    
    public String toString() {
        String mealListString = "";
        for(Meal meal : mealList) {
            mealListString += meal.toString() + "\n\n";
        }
        return "Login: " + login +
               "\nCredito: R$" + String.format("%.2f", credit) +
               "\nLista de Refeicoes do Usuario:\n" + 
               "\n" + mealListString;
               
    }
}
