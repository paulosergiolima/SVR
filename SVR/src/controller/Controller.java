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
import model.Sale;
/**
 *
 * @author Roberto Augusto
 */
public class Controller {
    private Admin admin = null;
    private Sale currentSale = null;
    private double permanenceDiscount = 0.30;
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Meal> mealList = new ArrayList<>();
    
    public ArrayList<Meal> getMealList() {
        return mealList;
    } 
    
    public boolean setAdmin(Admin admin) {
        if(this.admin != null) {
            return false; // Já existe um admin
        }
        this.admin = admin;
        return true;
    }

    public Admin getAdmin() {
        return admin;
    }
    
    public void setCurrentSale(Sale currentSale) {
        this.currentSale = currentSale;
    }
    
    public Sale getCurrentSale() {
        return currentSale;
    }
    
    public boolean setPermanenceDiscount(double permanenceDiscount) {
        if(permanenceDiscount > 0 && permanenceDiscount < 1) {
            this.permanenceDiscount = permanenceDiscount;
            return true;
        }
        return false;
    }
    
    public double getPermanenceDiscount() {
        return permanenceDiscount;
    }
    
    public String displayAdmin() {
        return admin.toString();
    }
    
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
    
    public boolean addPermanenceStudent(String name, MealType preference, String login, String password) {
        if(getUserByLogin(login) == null) {
            User user = new PermanenceStudent(name, preference, permanenceDiscount);
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
    
    public Admin adminLogin(String login, String password) {
        if(this.admin.login(login, password)) {
            return admin;
        }
        return null;
    }
    
    public boolean adminLogout() {
        return this.admin.logout();
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
        if(user.addCredit(credit)) {
            return true;
        }
        return false;
    }
    
    public void addMeal(String description, MealType type, double price) {
        Meal meal = new Meal(description, type, price);
        mealList.add(meal);
    }
    
    public boolean addMealToSaleByIndex(int index, Sale sale) {
        if(index > 0 && index < mealList.size()) {
            sale.addMeal(mealList.get(index));
            return true;
        }
        return false;
    }
    
    public boolean isValidSale(Sale sale) {
        return sale.isValidSale();
    }
    
    public boolean removeMealByIndex(int index) {
        if(index > 0 && index < mealList.size()) {
            mealList.remove(mealList.get(index));
            return true;
        }
        return false;
    }
    
    public Meal getMealByDescription(String description) {
        for(Meal meal : mealList) {
            if(meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }
    
    public boolean buyMeal(User user, int index) {
        Meal meal = currentSale.getMealList().get(index);
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
    
    public int transferMeal(User user, String targetLogin, int index) {
        Account targetAccount = getAccountByLogin(targetLogin);
        if(targetAccount != null) {
            return user.transferMeal(index, targetAccount);
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
    
    public String displayUserMealList(User user) {
        return user.getAccount().displayMealList();
    }
    
    public String displayMeal(Meal meal) {
        return meal.toString();
    }
    
    public String displayMealList() {
        String string = "Lista de Refeicoes no Sistema\n\n";
        for(int i = 0; i < mealList.size(); i++) {
            string += (i + 1) + ":\n" + mealList.get(i).toString();
            string += "\n==================================\n";
        }
        return string;
    }
    
    public String displayCurrentSale() {
        return currentSale.toString();
    }
}