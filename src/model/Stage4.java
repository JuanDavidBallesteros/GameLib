package model;

import java.util.ArrayList;

public class Stage4 {
    
    private ArrayList<Casher> cashers;
    private ArrayList<Client> clientes;

    public Stage4(int cashersNum, int timeXcasher) {
        this.cashers = new ArrayList<>();
        for (int i = 0; i < cashersNum; i++) {
            Casher temp = new Casher(timeXcasher);
            this.cashers.add(temp);
        }
    }

    public ArrayList<Client> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Client> clientes) {
        this.clientes = clientes;
    }

    public QueueTAD<Client> clientsOut(){
        
        return null;
    }

    
}
