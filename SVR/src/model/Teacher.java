/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author inval
 */
public class Teacher extends User {
    public Teacher(String name, MealType preference) {
        super(name, preference);
    }
    
    @Override
    public String toString() {
        return "Nome: " + name +
               "\nTipo de Usuario: Professor" +
               "\nPreferencia: " + preference.getDescription() +
               "\n" + account.toString();
    }
    
    @Override
    public boolean buyMeal(Meal meal) {
        if(this.account.getCredit() >= meal.getPrice()) {
            this.account.setCredit(this.account.getCredit() - meal.getPrice());
            this.account.addMeal(meal);
            return true;
        }
        return false;
    }
}
