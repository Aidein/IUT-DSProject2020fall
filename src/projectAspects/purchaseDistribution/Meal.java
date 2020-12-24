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
    public ArrayList<IngredientInfoInterface> ingredientsRatio = new ArrayList<>();

    @Override
    public void attach(IngredientInterface ingredient) {
        boolean notCopy = true;
        for(IngredientInterface i : ingredients){
            if(ingredient == i){
                notCopy = false;
                System.out.println("There is already such an ingredient!");
            }
        }
        if(notCopy){
            System.out.println("Please enter the amount of ingredient needed to cook this meal:");
            double amount = input.nextDouble();
            IngredientInfoInterface temporary = new IngredientInfo(amount, String.format("%s(Ref:%d)",ingredient.getName(),
                    ingredient.getRefAmount()));
            ingredient.attachStat(temporary);
            ingredientsRatio.add(temporary);
            this.ingredients.add(ingredient);
//            Message message = new MessageClass();
//            message.setMessageAmount(amount);
//            notifyUpdate(message, ingredient);
        }
    }

    @Override
    public void detach(IngredientInterface ingredient) {
        IngredientInfoInterface removableRef = new IngredientInfo();
        for (IngredientInterface i : ingredients){
            // Checks if there is such an ingredient in the meal
            if(i == ingredient){
                System.out.println("Detach ingredient found!");
                // Iterates ingredient lists in Ingredients ratio of the meal
                // and Ingredients, then compares and updates
                for (IngredientInfoInterface j : ingredientsRatio){
                    for (IngredientInfoInterface k : i.getIngredientsStats()){
                        if (j.getId().equals(k.getId())){
                            System.out.println("Ingredient removed!");
                            removableRef = j;
                        }
                    }
                }
            }
        }
        this.ingredientsRatio.remove(removableRef);
        this.ingredients.remove(ingredient);
    }

    @Override
    public void notifyUpdate(Message message, IngredientInterface ingredient) {
        boolean found = false;
        for (IngredientInterface i : ingredients){
            // Checks if there is such an ingredient in the meal
            if(i == ingredient){
                // Iterates ingredient lists in Ingredients ratio of the meal
                // and Ingredients, then compares and updates
                for (IngredientInfoInterface j : ingredientsRatio){
                    for (IngredientInfoInterface k : i.getIngredientsStats()){
                        if (j.getId().equals(k.getId())){
                            i.update(message, j);
                        }
                    }
                }
            }
        }
        if (!found){
            System.out.println("There is no such ingredient in this meal!");
        }
    }

    @Override
    public String toString() {
        StringBuilder formattedIngredients = new StringBuilder();
        for(IngredientInfoInterface i : ingredientsRatio){
            formattedIngredients.append(i.toString());
        }
        return String.format("%s%s", "This meal consists of:\n", formattedIngredients.toString());
    }
}
