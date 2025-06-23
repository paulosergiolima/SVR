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
public abstract class User {
    protected final UUID id;
    protected String name;
    protected MealType preference;
    protected Account account;
    
    public User(String name, MealType preference) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.preference = preference;
        this.account = null;
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

    public MealType getPreference() {
        return preference;
    }

    public void setPreference(MealType preference) {
        this.preference = preference;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    public abstract String toString();
    
    public boolean createAccount(String login, String password) {
        if(this.account == null) {
            this.account = new Account(login, password);
            return true;
        } else {
            return false;
        }
    }

    public boolean login(String login, String password) {
        if(this.account.getLogin().equals(login) && this.account.getPassword().equals(password)) {
            this.account.setIsLoggedIn(true);
            return true;
        }
        return false;
    }
    
    public boolean logout() {
        if(this.account.getIsLoggedIn()) {
            this.account.setIsLoggedIn(false);
            return true;
        }
        return false;
    }
    
    public boolean addCredit(double credit) {
        if(credit >= 0) {
            this.account.setCredit(credit);
            return true;
        }
        return false;
    }
    
    public abstract boolean buyMeal(Meal meal);
    
    public int transferMeal(int index, Account targetAccount) {
        if(targetAccount != this.account) {
            Meal meal = this.account.getMealByIndex(index);
            if(meal != null) {
                targetAccount.addMeal(meal);
                this.account.removeMeal(meal);
                return 1;
            }
            return -1; //Refeição não encontrada na lista de refeições do usuário
        }
        return -2; //Tentativa de transferir a refeição para si mesmo
    }
    //Nota: Interessante trocar os retornos de inteiros para exceções
}
