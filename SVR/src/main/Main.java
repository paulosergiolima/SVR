/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import model.Admin;
import model.Meal;
import model.MealType;

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
        ArrayList<Meal> mealList = new ArrayList<>();
        mealList.add(admin.newMeal("Bolo de Carne Moida", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Fricasse de Frango", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Carne de Panela", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("File de Frango Grelhado", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Carne Assada", MealType.OMNIVOROUS, 2.5));
        mealList.add(admin.newMeal("Ovos Mexidos com Ervilha", MealType.VEGETARIAN, 2.5));
        mealList.add(admin.newMeal("Strogonoff de Carnes", MealType.OMNIVOROUS, 2.5));
        
        System.out.println("Dados do Admin:\n" + admin.toString() + "\n");
        
        System.out.println("Lista de Refeicoes:\n");
        for(Meal meal : mealList) {
            System.out.println(meal.toString() + "\n");
        }
    }
    
}
