/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import model.Admin;
import model.Meal;
import model.MealType;
import model.User;
import model.Student;
import model.RegularStudent;
import model.PermanenceStudent;
import model.Teacher;

import java.util.ArrayList;
/**
 *
 * @author inval
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Admin admin = new Admin("Admin01");
        System.out.println("Admin:\n" + admin.toString() + "\n");
        System.out.println("==================================");
        
        ArrayList<Meal> mealList = new ArrayList<>();
        mealList.add(admin.newMeal("Bolo de Carne Moida", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Fricasse de Frango", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Carne de Panela", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("File de Frango Grelhado", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Carne Assada", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Ovos Mexidos com Ervilha", MealType.VEGETARIAN, 2.5));
        mealList.add(admin.newMeal("Strogonoff de Carnes", MealType.OMNIVOROUS, 2.5));
        System.out.println("Lista de Refeicoes no Sistema:\n");
        for(Meal meal : mealList) {
            System.out.println(meal.toString() + "\n");
        }
        System.out.println("==================================");
        
        User user01 = new RegularStudent("User01", MealType.OMNIVOROUS);
        user01.createAccount("user01@email.com", "12345678");
        user01.login("user01@email.com", "12345678");
        user01.addCredit(12.5);
        user01.buyMeal(mealList.get(0));
        user01.buyMeal(mealList.get(1));
        user01.buyMeal(mealList.get(2));
        user01.buyMeal(mealList.get(3));
        user01.buyMeal(mealList.get(4));
        
        User user02 = new PermanenceStudent("User02", MealType.VEGETARIAN, 0.30);
        user02.createAccount("user02@email.com", "87654321");
        user02.login("user02@email.com", "87654321");
        user02.addCredit(5.0);
        user02.buyMeal(mealList.get(5));
        user02.buyMeal(mealList.get(6));
        user02.transferMeal("Ovos Mexidos com Ervilha", user01.getAccount());
        
        System.out.println("User01\n" + user01.toString());
        System.out.println("==================================");
        System.out.println("User02\n" + user02.toString());
    }
    
}
