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
    public void buyMeal(Meal meal) {
        if(this.account.getIsLoggedIn() == true) {
            if(this.account.getCredit() >= meal.getPrice()) {
                this.account.setCredit(this.account.getCredit() - meal.getPrice());
                this.account.addMeal(meal);
            } else {
                System.out.println("Credito insuficiente para a transacao.");
            }
        } else {
            System.out.println("O usuario nao esta logado.");
        }
    }
}
