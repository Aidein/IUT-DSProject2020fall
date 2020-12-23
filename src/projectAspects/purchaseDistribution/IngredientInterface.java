package projectAspects.purchaseDistribution;

public interface IngredientInterface {
    public void update(Message message);
    public double getAmount();
    public double getPrice();
    public String getName();
    public String toString();
}
