package model;

import java.util.ArrayList;

public class Stage4 {
    
    private ArrayList<Casher> cashers;
    private QueueTAD<Client> clients;

    public Stage4(int cashersNum, int timeXcasher) {
        clients = new QueueTAD<>();

        this.cashers = new ArrayList<>();
        for (int i = 0; i < cashersNum; i++) {
            Casher temp = new Casher(timeXcasher);
            this.cashers.add(temp);
        }
    }

    public QueueTAD<Client> getClientes() {
        return clients;
    }

    public void setClientes(QueueTAD<Client> clients) {
        this.clients = clients;
    }

    public QueueTAD<Client> clientsOut(){
        QueueTAD<Client> out = new QueueTAD<>();

        while (!clients.isEmpty()) {
            for (int i = 0; i < cashers.size() && !clients.isEmpty(); i++) {  // Poner limite
                if (cashers.get(i).getClient() == null) {
                    cashers.get(i).setClient(clients.front());
                    cashers.get(i).passClient();
                    out.add(clients.dequeue());
                }
            }
        }
        return out;
    }

    
}
