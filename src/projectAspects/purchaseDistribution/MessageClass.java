package projectAspects.purchaseDistribution;

public class MessageClass implements Message{
    private double price = 0;
    private double amount;

    @Override
    public double getMessagePrice() {
        return price;
    }

    @Override
    public double getMessageAmount() {
        return amount;
    }

    @Override
    public void setMessagePrice(double price) {
        this.price = price;
    }

    @Override
    public void setMessageAmount(double amount) {
        this.amount = amount;
    }
}
