package projectAspects.purchaseDistribution;

import java.security.PublicKey;
import java.util.ArrayList;

public class Ingredient implements IngredientInterface{
    private String ingredientName;
//    private double ingredientAmount = 0;
    private double ingredientPricePerKilo = 0;

    // List of all components of a particular ingredient
    public ArrayList<IngredientInfoInterface> ingredientStats = new ArrayList<>();

    // returns a list of stats
    public ArrayList<IngredientInfoInterface> getIngredientsStats(){
        return ingredientStats;
    }

    // sets up a new stat for the ingredient
    public void attachStat(IngredientInfoInterface stat){
        ingredientStats.add(stat);
    }

    // counts the references
    public int getRefAmount(){
        return ingredientStats.size();
    }

    public Ingredient(){}
    public Ingredient(String name){
        this.ingredientName = name;
    }

    @Override
    public String getName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

//    @Override
//    public double getAmount() {
//        return ingredientAmount;
//    }
//
//    public void setIngredientAmount(double ingredientAmount) {
//        this.ingredientAmount = ingredientAmount;
//    }

    @Override
    public double getPrice() {
        return ingredientPricePerKilo;
    }

    public void setIngredientPricePerKilo(double ingredientPricePerKilo) {
        this.ingredientPricePerKilo = ingredientPricePerKilo;
    }

    @Override
    public void update(Message message, IngredientInfoInterface info){
        for (IngredientInfoInterface temp : ingredientStats){
            if (temp == info){
                temp.setWeight(message.getMessageAmount());
            }
        }
    }

    @Override
    public String toString() {
        double totalAmount = 0;
        for (IngredientInfoInterface temp : ingredientStats){
            totalAmount += temp.getWeight();
        }
        return String.format("%s%s%.2f%s%.2f\n", this.getName(), " --> Amount (in kilos): ", totalAmount,
                "\t Price (in sums): ", this.getPrice() * totalAmount);
    }
}
