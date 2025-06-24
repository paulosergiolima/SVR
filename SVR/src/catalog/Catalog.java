/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalog;

import java.util.ArrayList;
import model.Admin;
import model.Meal;
import model.Sale;
import model.User;

/**
 *
 * @author Roberto Augusto
 */
public class Catalog {
    private ArrayList<User> userList = new ArrayList<>();
    private Admin admin = null;
    private ArrayList<Meal> mealList = new ArrayList<>();
    private Sale currentSale = null;
    private double permanenceDiscount = 0.30;
    
    public Catalog() {}

    public ArrayList<User> getUserList() {
        return userList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public Sale getCurrentSale() {
        return currentSale;
    }

    public double getPermanenceDiscount() {
        return permanenceDiscount;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean setAdmin(Admin admin) {
        if(this.admin != null) {
            return false; // Já existe um admin
        }
        this.admin = admin;
        return true;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public void setCurrentSale(Sale currentSale) {
        this.currentSale = currentSale;
    }

    public boolean setPermanenceDiscount(double permanenceDiscount) {
        if(permanenceDiscount > 0 && permanenceDiscount < 1) {
            this.permanenceDiscount = permanenceDiscount;
            return true;
        }
        return false;
    }
}
