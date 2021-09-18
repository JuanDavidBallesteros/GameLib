package model;

public class Bag {
    private StackTAD<Game> games;

    public Bag() {
        games = new StackTAD<>();
    }

    public StackTAD<Game> getGames() {
        return games;
    }
    
}
