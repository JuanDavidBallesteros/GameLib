package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Stage2 {
    
    private int clientCount;
    private int waitingTime;
    private ArrayList<Rack> racks;

    public Stage2(int waitingTime){
        clientCount = 0;
        this.waitingTime = waitingTime;
    }

    public int addTimeToClient(Client client){
        clientCount++;
        client.setTime(waitingTime*clientCount);
        return client.getTime();
    }

    // ---------------------------------------------> Search game in racks
    private Rack searchGameInRacks(Game game){

        for (int i = 0; i < racks.size() ; i++) {
            if(racks.get(i).buyGame(game) != null ){
                return racks.get(i);
            }
        }
        return null;
    }

    // ---------------------------------------------> Return racks list

    private ArrayList<Rack> getRacksList(ArrayList<Game> gamesList){

        ArrayList<Rack> list = new ArrayList<>();
        for (int i = 0; i < gamesList.size(); i++) {
            Game gm = gamesList.get(i);
            list.add(searchGameInRacks(gm));
        }
        return list;
    }

    // ---------------------------------------------> Return sorted racks list by selected algorithm

    public QueueTAD<String> getSortedRackList(Client client){
        ArrayList<Rack> list = getRacksList(client.getGamesList());
        if(client.isSortingAlgorithm()){
            client.setSortedRacksList(insertionSort(list));
            return insertionSort(list);
        }else{
            client.setSortedRacksList(selectionSort(list));
            return selectionSort(list);
        }
    }

    // ---------------------------------------------> Sorting algorithms

    private QueueTAD<String> insertionSort(ArrayList<Rack> list){
        return null;
    }


    private <E extends Comparable<E>> QueueTAD<String> selectionSort(ArrayList<Rack> list){
      QueueTAD queue=null;
        int i, x =0;
        Rack key;
        for (i=1; i<list.size(); i++){
            key= list.get(i);
            x = i - 1; 
            while (x >= 0 && list.get(x).compareTo(key) > 0){
                list.set(x+1, list.get(x)); 
                x--;
            }
            list.set(x+1,key);
           
        }
        for(int y=0;x<list.size();x++){
           // QueueTAD.add(list.get(x))
        }
        return queue;
    }    
    
}
