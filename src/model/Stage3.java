package model;

public class Stage3 {

    
    private int time4Rack;

    public Stage3(int time4Rack){
        this.time4Rack = time4Rack;
    }

    public int addTimeToClient(Client client){

        while (client.getSortedRacksList().getSize() > 0) {
            client.getSortedRacksList().dequeue();
            int time = client.getTime();
            client.setTime(time + time4Rack);

            clien
            client.getBasket().push(value);
        }
        return client.getTime();
    }

    // ---------------------------------------------> Getter and Setters

    public int getTime4Rack() {
        return time4Rack;
    }

    public void setTime4Rack(int time4Rack) {
        this.time4Rack = time4Rack;
    }

    

}
