package projectAspects.purchaseDistribution;

public class PDMain {
    public static void main(String[] args){
        IngredientInterface meat = new Ingredient("Meat");
        IngredientInterface tomato = new Ingredient("Tomato");
        IngredientInterface potato = new Ingredient("Potato");

        MealInterface meal1 = new Meal("Meal1");

        meal1.attach(meat);
        meal1.attach(tomato);
        meal1.attach(potato);

        System.out.println(meal1.toString());
    }
}
