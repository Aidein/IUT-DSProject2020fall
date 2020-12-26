package projectAspects.purchaseDistribution;

import java.security.PublicKey;
import java.util.ArrayList;

public class Ingredient implements IngredientInterface{
    private String ingredientName;
    private int ingredientRefAmount = 0;
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
        ingredientRefAmount += 1;
        return ingredientRefAmount - 1;
    }

    public Ingredient(){}
    public Ingredient(String name){
        this.ingredientName = name;
    }

    @Override
    public void setPrice(double price) {
        this.ingredientPricePerKilo = price;
    }

    @Override
    public String getName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

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
    public double getTotalPrice() {
        double totalPrice = 0;
        for (IngredientInfoInterface temp : ingredientStats){
            totalPrice += temp.getWeight() * ingredientPricePerKilo;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        double totalAmount = 0;
        for (IngredientInfoInterface temp : ingredientStats){
            totalAmount += temp.getWeight();
        }
        return String.format("-----%s%s%.2f%s%.2f\n", this.getName(), " --> Amount (in kilos): ", totalAmount,
                "\t Price (in sums): ", this.getPrice() * totalAmount);
    }
}
