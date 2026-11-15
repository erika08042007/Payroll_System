package model;

public class Allowance {
    private String description;
    private double amount;

    public Allowance(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() { return description; }
    public double getAmount() { return amount; }
}
