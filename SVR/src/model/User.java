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
    
    public void createAccount(String login, String password) {
        if(this.account == null) {
            this.account = new Account(login, password);
        } else {
            System.out.println("O usuario ja possui uma conta.");
        }
    }
    
    public void login(String login, String password) {
        if(this.account == null) {
            System.out.println("O usuario nao possui uma conta.");
        } else if(this.account.getIsLoggedIn() == true) {
            System.out.println("O usuario ja esta logado.");
        } else if (this.account.getLogin().equals(login) && this.account.getPassword().equals(password)){
            this.account.setIsLoggedIn(true);
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }
    
    public void addCredit(double credit) {
        if(this.account.getIsLoggedIn() == true) {
            if(credit >= 0) {
                this.account.setCredit(credit);
            } else {
                System.out.println("Impossivel adicionar credito negativo.");
            }
        } else {
            System.out.println("O usuario nao esta logado.");
        }
    }
    
    public abstract void buyMeal(Meal meal);
    
    public void transferMeal(String description, Account targetAccount) {
        if(this.account.getIsLoggedIn() == true) {
            Meal meal = this.account.getMealByDescription(description);
            if(meal != null) {
                targetAccount.addMeal(meal);
                this.account.removeMeal(meal);
            } else {
                System.out.println("A refeicao nao existe na lista de refeicoes do usuario.");
            }
        } else {
            System.out.println("O usuario nao esta logado.");
        }
    }
}
