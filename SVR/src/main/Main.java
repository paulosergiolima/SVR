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
import main.Menu;

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
        //Admin e refeições adicionadas na main temporariamente até a implementação do login do admin
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
        
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
