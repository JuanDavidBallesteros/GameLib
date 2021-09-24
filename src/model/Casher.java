package model;

public class Casher {
    private int payTime;
    private Client client;
    
    public Casher(int payTime) {
        this.payTime = payTime;
    }

    public synchronized void passClient(){
        
        while (client.getBasket().getSize() > 0) {
            int cTime = client.getTime();
            client.setTime(cTime + payTime);
            client.getBag().getGames().push(client.getBasket().pop());
        }

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
