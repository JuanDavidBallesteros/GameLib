package model;

import java.util.ArrayList;

public class Client {

    private ArrayList<Game> gamesList;
    private String listCode;
    private String id;

    private QueueTAD<Game> sortedGameList;
    private Bag bag;
    private StackTAD<Game> basket;

    private int purchaseValue;

    private int time;
    private int arrivalNum;

    private boolean sortingAlgorithm;
    
    public Client(String listCode, String id, int arrivalNum, boolean sortingAlgorithm ) {
        this.listCode = listCode;
        this.id = id;
        this.arrivalNum = arrivalNum;
        this.sortingAlgorithm = sortingAlgorithm;

        gamesList = new ArrayList<>();
        sortedGameList = new QueueTAD<>();
        basket = new StackTAD<>();
        bag = new Bag();
    }

    public Client(String id, int arrivalNum) {  // Test Client
        this.listCode = id;
        this.id = id;
        this.arrivalNum = arrivalNum;
        this.sortingAlgorithm = true;

        gamesList = new ArrayList<>();
        sortedGameList = new QueueTAD<>();
        basket = new StackTAD<>();
        bag = new Bag();
    }

    public ArrayList<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(ArrayList<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public String getListCode() {
        return listCode;
    }

    public void setListCode(String listCode) {
        this.listCode = listCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QueueTAD<Game> getSortedGameList() {
        return sortedGameList;
    }

    public void setSortedGameList(QueueTAD<Game> sortedGameList) {
        this.sortedGameList = sortedGameList;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public StackTAD<Game> getBasket() {
        return basket;
    }

    public void setBasket(StackTAD<Game> basket) {
        this.basket = basket;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getArrivalNum() {
        return arrivalNum;
    }

    public void setArrivalNum(int arrivalNum) {
        this.arrivalNum = arrivalNum;
    }

    public boolean isSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public void setSortingAlgorithm(boolean sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }    
    
}
