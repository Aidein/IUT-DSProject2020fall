package projectAspects.purchaseDistribution;

import java.security.PublicKey;

public class Ingredient implements IngredientInterface{
    private String ingredientName;
    private double ingredientAmount = 0;
    private double ingredientPricePerKilo = 0;

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

    @Override
    public double getAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(double ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    @Override
    public double getPrice() {
        return ingredientPricePerKilo;
    }

    public void setIngredientPricePerKilo(double ingredientPricePerKilo) {
        this.ingredientPricePerKilo = ingredientPricePerKilo;
    }

    @Override
    public void update(Message message){
        if(this.ingredientAmount >= 0 && this.ingredientPricePerKilo >= 0) {
            this.ingredientAmount += message.getMessageAmount();
            this.ingredientPricePerKilo += message.getMessagePrice();
        }else{
            System.out.println("You cannot set negative number!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s%s%.2f%s%.2f\n", this.getName(), " --> Amount (in kilos): ", this.getAmount(),
                "\t Price (in sums): ", this.getPrice() * this.getAmount());
    }
}
