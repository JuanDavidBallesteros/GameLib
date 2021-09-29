package model;

public class Bag {
    private StackTAD<Game> games;

    public Bag() {
        games = new StackTAD<>();
    }

    public StackTAD<Game> getGames() {
        return games;
    }

    public void setGames(StackTAD<Game> games) {
        this.games = games;
    }

    public String toString(){
        String text = "";

        StackTAD<Game> gamesTemp = new StackTAD<>();

            while (!games.isEmpty()) {
                text += games.top().getId() + " ";
                gamesTemp.push(games.pop());
            }
        
        games = gamesTemp;

        return text;
    }
    
    
}
