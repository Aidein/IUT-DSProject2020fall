package projectAspects.purchaseDistribution;

public interface MealInterface {
    void attach(IngredientInterface ingredient);
    void detach(IngredientInterface ingredient);
    void notifyUpdate(Message message, IngredientInterface ingredient);
    String toString();
}
