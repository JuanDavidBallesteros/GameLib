package model;

import java.util.ArrayList;

public class Stage2 {
    
    private int clientCount;
    private int waitingTime;

    public Stage2(int waitingTime){
        clientCount = 0;
        this.waitingTime = waitingTime;
    }

    public int addTimeToClient(Client client){
        clientCount++;
        client.setTime(waitingTime*clientCount);
        return client.getTime();
    }

    

    // ---------------------------------------------> Return sorted racks list by selected algorithm

    public QueueTAD<Game> getSortedRackList(Client client){
        ArrayList<Game> list = (client.getGamesList());
        if(client.isSortingAlgorithm()){
            client.setSortedGameList(selectionSort(list)); // change to insertion sort
            return insertionSort(list);
        }else{
            client.setSortedGameList(selectionSort(list));
            return selectionSort(list);
        }
    }

    // ---------------------------------------------> Sorting algorithms

    private QueueTAD<Game> insertionSort(ArrayList<Game> list){
    	
    	        QueueTAD<Game> queue = new QueueTAD<>();
    	        
    	        for (int i = 0; i < list.size(); i++) {
    	            Game minor = list.get(i);

    	            for (int j = i + 1; (j < list.size()); j++) {
    	                if (minor.compareTo(list.get(j)) > 0) {
    	                    Game temp = list.get(j);
    	                    list.set(j, minor);
    	                    list.set(i, temp);
    	                }
    	            }
    	        }

    	        for (Game game : list) {
    	            queue.add(game);
    	        }
    	    
    	        return queue;
    	    }   


    private QueueTAD<Game> selectionSort(ArrayList<Game> list){
        QueueTAD<Game> queue = new QueueTAD<>();
        
        for (int i = 0; i < list.size(); i++) {
            Game minor = list.get(i);
            int pos = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (minor.compareTo(list.get(j)) < 0) { // > Cambio de dirección
                    minor = list.get(j);
                    pos = j;
                }
            }
            Game temp = list.get(i);
            list.set(i, minor);
            list.set(pos, temp);
        }

        for (Game game : list) {
            queue.add(game);
        }
    
        return queue;
    }    
    

    
}
