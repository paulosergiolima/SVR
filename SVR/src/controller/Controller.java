/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import catalog.Catalog;
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
import model.Sale;
/**
 *
 * @author Roberto Augusto
 */
public class Controller {
    private Catalog catalog;
    
    public Controller(Catalog catalog) {
        this.catalog = catalog;
    }
    
    //User e UserList
    
    public ArrayList<User> getUserList() {
        return catalog.getUserList();
    }
    
    public User getUserByLogin(String login) {
        for(User user : catalog.getUserList()) {
            if(user.getAccount().getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
    public User getUserByLoginAndPassword(String login, String password) {
        for(User user : catalog.getUserList()) {
            if(user.getAccount().getLogin().equals(login) && user.getAccount().getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
    public Account getAccountByLogin(String login) {
        for(User user : catalog.getUserList()) {
            Account account = user.getAccount();
            if(account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }
    
    public String displayUser(User user) {
        return user.toString();
    }
    
    public String displayUserList() {
        String string = "Lista de Usuarios no Sistema\n\n";
        for(User user : catalog.getUserList()) {
            string += user.toString();
            string += "\n==================================\n";
        }
        return string;
    }
    
    public String displayUserMealList(User user) {
        return user.getAccount().displayMealList();
    }
    
    public boolean addRegularStudent(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new RegularStudent(name, preference);
            if(user.createAccount(login, password)) {
                catalog.getUserList().add(user);
                return true;
            }
        }
        return false;
    }
    
    public boolean addPermanenceStudent(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new PermanenceStudent(name, preference, catalog.getPermanenceDiscount());
            if(user.createAccount(login, password)) {
                catalog.getUserList().add(user);
                return true;
            }
        }
        return false;
    }
    
    public boolean addTeacher(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new Teacher(name, preference);
            if(user.createAccount(login, password)) {
                catalog.getUserList().add(user);
                return true;
            }
        }
        return false;
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
        return user.logout();
    }
    
    public boolean addCredit(User user, Double credit) {
        return user.addCredit(credit);
    }
    
    public boolean buyMeal(User user, int index) {
        Meal meal = catalog.getCurrentSale().getMealList().get(index);
        if(meal != null) {
            user.buyMeal(meal);
            return true;
        }
        return false;
    }
    
    public int transferMeal(User user, String targetLogin, int index) {
        Account targetAccount = getAccountByLogin(targetLogin);
        if(targetAccount != null) {
            return user.transferMeal(index, targetAccount);
        }
        return -3; //Conta com esse login não encontrada
    }
    
    //Admin
    
    public Admin getAdmin() {
        return catalog.getAdmin();
    }
    
    public boolean setAdmin(Admin admin) {
        return catalog.setAdmin(admin);
    }
    
    public String displayAdmin() {
        return catalog.getAdmin().toString();
    }
    
    public Admin adminLogin(String login, String password) {
        if(catalog.getAdmin().login(login, password)) {
            return catalog.getAdmin();
        }
        return null;
    }
    
    public boolean adminLogout() {
        return catalog.getAdmin().logout();
    }
    
    //MealList (Cardápio)
    
    public ArrayList<Meal> getMealList() {
        return catalog.getMealList();
    } 
    
    public Meal getMealByDescription(String description) {
        for(Meal meal : catalog.getMealList()) {
            if(meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }
    
    public boolean addMeal(String description, MealType type, double price) {
        Meal meal = new Meal(description, type, price);
        if(meal != null) {
            catalog.getMealList().add(meal);
            return true;
        }
        return false;
    }

    public boolean removeMealByIndex(int index) {
        if(index > 0 && index < catalog.getMealList().size()) {
            catalog.getMealList().remove(catalog.getMealList().get(index));
            return true;
        }
        return false;
    }
    
    public String displayMeal(Meal meal) {
        return meal.toString();
    }
    
    public String displayMealList() {
        String string = "Lista de Refeicoes no Sistema\n\n";
        for(int i = 0; i < catalog.getMealList().size(); i++) {
            string += (i + 1) + ":\n" + catalog.getMealList().get(i).toString();
            string += "\n==================================\n";
        }
        return string;
    }
    
    //CurrentSale
    
    public Sale getCurrentSale() {
        return catalog.getCurrentSale();
    }
        
    public void setCurrentSale(Sale currentSale) {
        catalog.setCurrentSale(currentSale);
    }
    
    public String displayCurrentSale() {
        return catalog.getCurrentSale().toString();
    }
    
    public boolean isValidSale(Sale sale) {
        return sale.isValidSale();
    }
    
    public boolean addMealToSaleByIndex(int index, Sale sale) {
        if(index > 0 && index < catalog.getMealList().size()) {
            sale.addMeal(catalog.getMealList().get(index));
            return true;
        }
        return false;
    }
    
    //PermanenceDiscount
    
    public double getPermanenceDiscount() {
        return catalog.getPermanenceDiscount();
    }
    
    public boolean setPermanenceDiscount(double permanenceDiscount) {
        return catalog.setPermanenceDiscount(permanenceDiscount);
    }
}