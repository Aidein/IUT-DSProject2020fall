package projectAspects.purchaseDistribution;

public interface Message {
    public double getMessagePrice();
    public double getMessageAmount();
    public void setMessagePrice(double price);
    public void setMessageAmount(double amount);
}
