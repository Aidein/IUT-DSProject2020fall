package projectAspects.purchaseDistribution;

public interface Message {
    double getMessagePrice();
    double getMessageAmount();
    void setMessagePrice(double price);
    void setMessageAmount(double amount);
}
