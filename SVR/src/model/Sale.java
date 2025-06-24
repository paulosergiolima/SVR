/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
/**
 *
 * @author Roberto Augusto
 */
public class Sale {
    private ArrayList<Meal> mealList;
    
    public Sale() {
        this.mealList = new ArrayList<>();
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }
    
    public String displayMealList() {
        String string = "Refeicoes disponiveis para compra\n\n";
        for(int i = 0; i < mealList.size(); i++) {
            string += (i + 1) + ":\n" + mealList.get(i).toString();
            string += "\n==================================\n";
        }
        return string;
    }
    
    public void addMeal(Meal meal) {
        mealList.add(meal);
    }
    
    public void removeMeal(Meal meal) {
        mealList.remove(meal);
    }
    
    public boolean isValidSale() {
        int omnivorousMealCount = 0, vegetarianMealCount = 0;
        for(Meal meal : mealList) {
            if(meal.getType().equals(MealType.OMNIVOROUS)) {
                omnivorousMealCount++;
            }
            if(meal.getType().equals(MealType.VEGETARIAN) || meal.getType().equals(MealType.VEGAN)) {
                vegetarianMealCount++;
            }
        }
        return omnivorousMealCount == 5 && vegetarianMealCount == 5;
    }    
}
