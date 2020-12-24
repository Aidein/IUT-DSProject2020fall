package projectAspects.purchaseDistribution;

import java.text.NumberFormat;

public class IngredientInfo implements IngredientInfoInterface{
    // basic stats of the ingredient
    private String id;
    private double weight = 0;

    // constructors
    public IngredientInfo(){}
    public IngredientInfo(double weight, String id){
        this.id = id;
        this.weight = weight;
    }

    // getters and setters for stats
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight += weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // gives an info of a partition of the meal

    @Override
    public String toString() {
        return String.format("%s%s%.2f\n", this.getId(), "\t-->\tWeight: ", this.getWeight());
    }
}
