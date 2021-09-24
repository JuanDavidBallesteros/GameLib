package model;

import exception.FullTable;
import exception.NullKeyException;

public class Rack implements Comparable<Rack>{

    private HasTableTAD<Game, Integer> games; // Key => Game Object - Value => Number of games available
    private String letter;

    public Rack(String letter){
        games = new HasTableTAD<>();
        this.letter = letter;
    }

    public HasTableTAD<Game, Integer> getGames() {
        return games;
    }

    public String getLetter() {
        return letter;
    }

    public void addGame(Game game, int cant) throws NullKeyException, FullTable{
        games.insert(game, cant);
    }

    public Game buyGame(Game game){
        if(games.search(game)>0){
            int value = games.search(game)-1;
            games.setValue(game, value);
            return game;
        } else {
            return null;
        } 
    }

    @Override
    public int compareTo(Rack o) {
        return letter.compareTo(((Rack) o).getLetter());

    }

   
   
    
}
