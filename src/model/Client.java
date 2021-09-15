package model;

import java.util.ArrayList;

public class Client {

    private ArrayList<Game> gamesList;
    private String listCode;
    private String id;

    private QueueTAD<Game> bagT;
    private Bag bag;
    private StackTAD<Game> shoppingBag;

    private int time;
    private int arrivalNum;

    private boolean sortingAlgorithm;
    
    public Client(String listCode, String id, int arrivalNum, boolean sortingAlgorithm ) {
        this.listCode = listCode;
        this.id = id;
        this.arrivalNum = arrivalNum;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    
}
