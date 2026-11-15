package model;

public class Deduction {
    private String description;
    private double amount;

    public Deduction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() { return description; }
    public double getAmount() { return amount; }
}
