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
    
    public boolean addRegularStudent(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new RegularStudent(name, preference);
            if(user.createAccount(login, password)) {
                userList.add(user);
                return true;
            }
        }
        return false;
    }
    
    public boolean addPermanenceStudent(String name, MealType preference, Double discount, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new PermanenceStudent(name, preference, discount);
            if(user.createAccount(login, password)) {
                userList.add(user);
                return true;
            }
        }
        return false;
    }
    
    public boolean addTeacher(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new Teacher(name, preference);
            if(user.createAccount(login, password)) {
                userList.add(user);
                return true;
            }
        }
        return false;
    }
    
    public User getUserByLogin(String login) {
        for(User user : userList) {
            if(user.getAccount().getLogin().equals(login)) {
                return user;
            }
        }
        return null;
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
            if(user.login(login, password)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean userLogout(User user) {
        if(user.logout()) {
            return true;
        }
        return false;
    }
    
    public boolean addCredit(User user, Double credit) {
        if(user.addCredit(credit)) {
            return true;
        }
        return false;
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
    
    public boolean buyMeal(User user, String description) {
        Meal meal = getMealByDescription(description);
        if(meal != null) {
            user.buyMeal(meal);
            return true;
        }
        return false;
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
    
    public int transferMeal(User user, String targetLogin, String description) {
        Account targetAccount = getAccountByLogin(targetLogin);
        if(targetAccount != null) {
            return user.transferMeal(description, targetAccount);
        }
        return -3; //Conta com esse login não encontrada
    }
    
    public String displayUser(User user) {
        return user.toString();
    }
    
    public String displayUserList() {
        String string = "Lista de Usuarios no Sistema\n\n";
        for(User user : userList) {
            string += user.toString();
            string += "\n==================================\n";
        }
        return string;
    }
    
    public String displayMeal(Meal meal) {
        return meal.toString();
    }
    
    public String displayMealList() {
        String string = "Lista de Refeicoes no Sistema\n\n";
        for(Meal meal : mealList) {
            string += meal.toString();
            string += "\n==================================\n";
        }
        return string;
    }
}