package projectAspects.purchaseDistribution;

import java.util.ArrayList;
import java.util.Scanner;

public class Meal implements MealInterface{
    Scanner input = new Scanner(System.in);

    String mealName;

    public Meal(){}
    public Meal(String mealName){
        this.mealName = mealName;
    }

    public ArrayList<IngredientInterface> ingredients = new ArrayList<>();
    public ArrayList<Double> ingredientsRatio = new ArrayList<>();

    @Override
    public void attach(IngredientInterface ingredient) {
        boolean notCopy = true;
        for(IngredientInterface i: ingredients){
            if(ingredient == i){
                notCopy = false;
                System.out.println("There is already such an ingredient!");
            }
        }
        if(notCopy){
            this.ingredients.add(ingredient);
            System.out.println("Please enter the amount of ingredient needed to cook this meal:");
            double amount = input.nextDouble();
            Message message = new MessageClass();
            message.setMessageAmount(amount);
            notifyUpdate(message, ingredient);
        }
    }

    @Override
    public void detach(IngredientInterface ingredient) {
        this.ingredients.remove(ingredient);
    }

    @Override
    public void notifyUpdate(Message message, IngredientInterface ingredient) {
        boolean found = false;
        for (IngredientInterface i : ingredients){
            if(i == ingredient){
                i.update(message);
                found = true;
            }
        }
        if (!found){
            System.out.println("There is no such ingredient in this meal!");
        }
    }

    @Override
    public String toString() {
        StringBuilder formattedIngredients = new StringBuilder();
        for(IngredientInterface i : ingredients){
            formattedIngredients.append(i.toString());
        }
        return String.format("%s%s", "This meal consists of: ", formattedIngredients.toString());
    }
}
