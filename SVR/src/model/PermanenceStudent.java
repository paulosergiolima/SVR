/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author inval
 */
public class PermanenceStudent extends Student {
    private double discount;
    
    public PermanenceStudent(String name, MealType preference, double discount) {
        super(name, preference);
        this.discount = discount;
    }
    
    @Override
    public String toString() {
        return "Nome: " + name +
               "\nTipo de Usuario: Aluno Permanencia" +
               "\nPreferencia: " + preference.getDescription() +
               "\n" + account.toString();
    }
    
    @Override
    public boolean buyMeal(Meal meal) {
        if(this.account.getCredit() >= meal.getPrice() * (1 - this.discount)) {
            this.account.setCredit(this.account.getCredit() - meal.getPrice() * (1 - this.discount));
            this.account.addMeal(meal);
            return true;
        }
        return false;
    }
}
