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
        return "ID: " + id +
               "\nNome: " + name +
               "\nTipo de Usuario: Aluno Permanencia" +
               "\nPreferencia: " + preference.getDescription() +
               "\n" + account.toString();
    }
    
    @Override
    public void buyMeal(Meal meal) {
        if(this.account.getIsLoggedIn() == true) {
            if(this.account.getCredit() >= meal.getPrice() * this.discount) {
                this.account.setCredit(this.account.getCredit() - meal.getPrice() * this.discount);
                this.account.addMeal(meal);
            } else {
                System.out.println("Credito insuficiente para a transacao.");
            }
        } else {
            System.out.println("O usuario nao esta logado.");
        }
    }
}
