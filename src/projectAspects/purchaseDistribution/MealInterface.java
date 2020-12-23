package projectAspects.purchaseDistribution;

public interface MealInterface {
    public void attach(IngredientInterface ingredient);
    public void detach(IngredientInterface ingredient);
    public void notifyUpdate(Message message, IngredientInterface ingredient);
    public String toString();
}
