package model;

public class Stage3 {

    
    private int time4Rack;

    public Stage3(int time4Rack){
        this.time4Rack = time4Rack;
    }

    public int addTimeToClient(Client client){

        while (client.getSortedGameList().getSize() > 0) {
            Game temp = client.getSortedGameList().dequeue();
            int time = client.getTime();
            client.setTime(time + time4Rack);

            client.getBasket().push(temp);
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
