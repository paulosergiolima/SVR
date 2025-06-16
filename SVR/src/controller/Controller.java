/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Admin;
import model.Meal;
import model.MealType;
import model.User;
import model.Student;
import model.RegularStudent;
import model.PermanenceStudent;
import model.Teacher;

import java.util.ArrayList;
import model.Account;
/**
 *
 * @author Roberto Augusto
 */
public class Controller {
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Meal> mealList = new ArrayList<>();
    
    public void addRegularStudent(String name, MealType preference, String login, String password) {
        User user = new RegularStudent(name, preference);
        user.createAccount(login, password);
        userList.add(user);
    }
    
    public void addPermanenceStudent(String name, MealType preference, Double discount, String login, String password) {
        User user = new PermanenceStudent(name, preference, discount);
        user.createAccount(login, password);
        userList.add(user);
    }
    
    public void addTeacher(String name, MealType preference, String login, String password) {
        User user = new Teacher(name, preference);
        user.createAccount(login, password);
        userList.add(user);
    }
    
    public User getUserByLoginAndPassword(String login, String password) {
        for(User user : userList) {
            if(user.getAccount().getLogin().equals(login) && user.getAccount().getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
    public User userLogin(String login, String password) {
        User user = getUserByLoginAndPassword(login, password);
        if(user != null) {
            user.login(login, password);
            return user;
        }
        return null;
    }
    
    public void addCredit(User user, Double credit) {
        user.addCredit(credit);
    }
    
    public void addMeal(String description, MealType type, double price) {
        Meal meal = new Meal(description, type, price);
        mealList.add(meal);
    }
    
    public Meal getMealByDescription(String description) {
        for(Meal meal : mealList) {
            if(meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }
    
    public void buyMeal(User user, String description) {
        Meal meal = getMealByDescription(description);
        if(meal != null) {
            user.buyMeal(meal);
        }
    }
    
    public Account getAccountByLogin(String login) {
        for(User user : userList) {
            Account account = user.getAccount();
            if(account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }
    
    public void transferMeal(User user, String targetLogin, String description) {
        Account targetAccount = getAccountByLogin(targetLogin);
        if(targetAccount != null) {
            user.transferMeal(description, targetAccount);
        }
    }
    
    public void displayUser(User user) {
        user.toString();
    }
    
    public void displayUserList() {
        System.out.println("Lista de Usuarios no Sistema:\n");
        for(User user : userList) {
            user.toString();
            System.out.println("==================================\n");
        }
    }
    
    public void displayMeal(Meal meal) {
        meal.toString();
    }
    
    public void displayMealList() {
        System.out.println("Lista de Refeicoes no Sistema:\n");
        for(Meal meal : mealList) {
            meal.toString();
            System.out.println("==================================\n");
        }
    }
}