package model;

public class Casher {
    private int payTime;
    private Client client;
    
    public Casher(int payTime) {
        this.payTime = payTime;
    }

    public synchronized void passClient(){
        int purchase = 0;

        while (!client.getBasket().isEmpty()) {
            int cTime = client.getTime();
            client.setTime(cTime + payTime);
            purchase += client.getBasket().top().getCost();
            client.getBag().getGames().push(client.getBasket().pop());
        }

        client.setPurchaseValue(purchase);
        client = null;
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

    public synchronized void setClient(Client client) {
        this.client = client;
    }

    
}
