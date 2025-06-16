/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author inval
 */
public class RegularStudent extends Student {
    public RegularStudent(String name, MealType preference) {
        super(name, preference);
    }
    
    @Override
    public String toString() {
        return "ID: " + id +
               "\nNome: " + name +
               "\nTipo de Usuario: Aluno Regular" +
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
