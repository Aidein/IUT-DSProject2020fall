package projectAspects.purchaseDistribution;

import java.util.ArrayList;
import java.util.Scanner;

public class PDMain {
//    public static void main(String[] args){
//        IngredientInterface meat = new Ingredient("Meat");
//        IngredientInterface tomato = new Ingredient("Tomato");
//        IngredientInterface potato = new Ingredient("Potato");
//        IngredientInterface apple = new Ingredient("Apple");
//        IngredientInterface chicken = new Ingredient("Chicken");
//
//        MealInterface meal1 = new Meal("Meal1");
//
//        meal1.attach(meat);
//        meal1.attach(tomato);
//        meal1.attach(potato);
//
//        System.out.println(meal1.toString());
//
//        MealInterface meal2 = new Meal("Meal2");
//
//        meal2.attach(potato);
//        meal2.attach(tomato);
//        meal2.attach(apple);
//        meal2.attach(chicken);
//
//        System.out.println(meal2.toString());
//
//        System.out.println("Please set the price:");
//        meat.setPrice(57000);
//        potato.setPrice(5000);
//        tomato.setPrice(7000);
//        apple.setPrice(13000);
//        chicken.setPrice(27000);
//        System.out.printf("Prices:\n1) %s\n2) %s\n3) %s\n", meat.toString(), chicken.toString(), apple.toString());
//    }
    // ingredient counter
    Scanner input = new Scanner(System.in);
    private ArrayList<IngredientInterface> totalIngredientsList = new ArrayList<>();
    private ArrayList<MealInterface> totalMealsList = new ArrayList<>();

    // sets a new ingredient
    public void setIngredient(String name){
        IngredientInterface ingredient = new Ingredient(name);
        totalIngredientsList.add(ingredient);
    }

    // sets a new meal
    public void setMeal(String name){
        MealInterface meal = new Meal(name);
        totalMealsList.add(meal);
    }

    // adds an ingredient to a meal
    public void addIngredientToMeal(MealInterface meal, IngredientInterface ingredient){
        meal.attach(ingredient);
    }

    // removes an ingredient from a meal
    public void removeIngredientFromMeal(MealInterface meal, IngredientInterface ingredient){
        meal.detach(ingredient);
    }

    // iterates and returns a meal chosen by user
    public MealInterface iterateAndGetMeal(){
        System.out.println("Here is a list:");
        int count = 1, index;
        for (MealInterface meal : totalMealsList){
            System.out.printf("%d%s%s", count, ") ", meal.getMealName());
            count += 1;
        }
        System.out.print("Please choose the number from above:");
        index = input.nextInt();
        return totalMealsList.get(index - 1);
    }

    // iterates and returns an ingredient chosen by user
    public IngredientInterface iterateAndGetIngredient(){
        System.out.println("Here is a list:");
        int count = 1, index;
        for (IngredientInterface ingredient : totalIngredientsList){
            System.out.printf("%d%s%s", count, ") ", ingredient.getName());
            count += 1;
        }
        System.out.print("Please choose the number from above:");
        index = input.nextInt();
        return totalIngredientsList.get(index - 1);
    }

    // lists all the meals
    public void listAllTheMeals(){
        int count = 1;
        for (MealInterface meal : totalMealsList){
            System.out.printf("\t%d%s%s\n", count, ") ", meal.getMealName());
        }
    }

    // lists all the ingredients
    public void listAllTheIngredients(){
        int count = 1;
        for (IngredientInterface ingredient : totalIngredientsList){
            System.out.printf("\t%d%s%s\n", count, ") ", ingredient.getName());
        }
    }

    // displays prices of the meals and total price
    public void displayBill(){
        for (MealInterface meal : totalMealsList){
            System.out.print(meal.toString());
        }
        double totalPrice = 0;
        for (IngredientInterface ingredient : totalIngredientsList){
            totalPrice += ingredient.getTotalPrice();
        }
        System.out.printf("%s%.2f", "-----> TOTAL -----> ", totalPrice);
    }

    // main PD class user interface
    public void launchPDUserInterface(){
        PDMain basket = new PDMain();
        boolean stop = false;
        do {
            System.out.println("Please choose the operation from the list below:");
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                    "1) Set up an ingredient",
                    "2) Set up a meal",
                    "3) Add an ingredient to a meal",
                    "4) Remove an ingredient from a meal",
                    "5) List all the meals",
                    "6) List all the ingredients",
                    "7) Get bill",
                    "8) Set price for an ingredient",
                    "0) Back");
            switch (input.nextInt()){
                case 1:
                    System.out.print("Please enter the name of the ingredient (without spaces): ");
                    basket.setIngredient(input.nextLine()); break;
                case 2:
                    System.out.print("Please enter the name of the meal (without spaces): ");
                    basket.setMeal(input.nextLine()); break;
                case 3:
                    basket.addIngredientToMeal(basket.iterateAndGetMeal(), basket.iterateAndGetIngredient());
                    break;
                case 4:
                    basket.removeIngredientFromMeal(basket.iterateAndGetMeal(), basket.iterateAndGetIngredient());
                    break;
                case 5:
                    basket.listAllTheMeals(); break;
                case 6:
                    basket.listAllTheIngredients(); break;
                case 7:
                    basket.displayBill(); break;
                case 8:
                    System.out.print("-->Please choose the ingredient and set the price<--");
                    basket.iterateAndGetIngredient().setPrice(input.nextDouble()); break;
                case 0:
                    stop = true; break;
                default:
                    System.out.println("Please choose the numbers from the rage!!!");
            }
        }while (!stop);
    }
}
