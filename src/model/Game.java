package model;

public class Game {
    private int id;
    private int amount;
    private String rack;
    private int cost;
    
    public Game(int id, int amount, String rack,int cost) {
        this.id = id;
        this.amount = amount;
        this.amount = amount;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    

    
}
