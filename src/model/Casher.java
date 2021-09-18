package model;

public class Casher {
    private int payTime;
    private Client client;
    
    public Casher(int payTime) {
        this.payTime = payTime;
    }

    public int getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = payTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
}
