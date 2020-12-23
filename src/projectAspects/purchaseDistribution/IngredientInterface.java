package projectAspects.purchaseDistribution;

import java.util.ArrayList;

public interface IngredientInterface {
    void update(Message message, IngredientInfoInterface info);
//    double getAmount();
    double getPrice();
    void attachStat(IngredientInfoInterface stat);
    String getName();
    String toString();
    int getRefAmount();
    ArrayList<IngredientInfoInterface> getIngredientsStats();
}
