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
    
    public String getPassword() {
        return password;
    }
        
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }
    
    public double getCredit() {
        return credit;
    }
    
    public ArrayList<Meal> getMealList() {
        return mealList;
    }
    
    public Meal getMealByDescription(String description){
        for(Meal meal : mealList) {
            if(meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }
    
    public Meal getMealByIndex(int index) {
        return mealList.get(index);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setCredit(double credit) {
        this.credit = credit;
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
    
    public String toString() {
        String mealListString = "";
        for(Meal meal : mealList) {
            mealListString += meal.toString() + "\n==================================\n";
        }
        return "Login: " + login +
               "\nCredito: R$" + String.format("%.2f", credit) +
               "\n\nLista de Refeicoes do Usuario:\n" + 
               "\n" + mealListString;
               
    }
    
    public String displayMealList() {
        String string = "Lista de Refeicoes do Usuario\n\n";
        for(int i = 0; i < mealList.size(); i++) {
            string += (i + 1) + ":\n" + mealList.get(i).toString();
            string += "\n==================================\n";
        }
        return string;
    }
}
