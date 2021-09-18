package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import routes.Routes;

public class App {

    private QueueTAD<Client> clients;
    private Stage1 s1;
    private Stage2 s2;
    private Stage3 s3;
    private Stage4 s4;

    public App() throws IOException {
        games = new ArrayList<>();
        loadGames();
    }

    // -----------------------------------------------> Start Simulation
    
    private ArrayList<Game> games;
    public ArrayList<Game> getGames() {
        return games;
    }

    private void loadGames() throws IOException {

        /* String currentPath = new java.io.File(".").getCanonicalPath(); // Get actual path
        System.out.println(currentPath); */
        BufferedReader br = new BufferedReader(new FileReader(Routes.GAMES_DATA.getRoute()));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(","); 

            Game temp = new Game(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);
            games.add(temp);
            line = br.readLine();
        }

        br.close();
    }

    // ---------------------------------------------> Getter and Setters

    public QueueTAD<Client> getClients() {
        return clients;
    }

    public void setClients(QueueTAD<Client> clients) {
        this.clients = clients;
    }

    public Stage1 getS1() {
        return s1;
    }

    public void setS1(Stage1 s1) {
        this.s1 = s1;
    }

    public Stage2 getS2() {
        return s2;
    }

    public void setS2(Stage2 s2) {
        this.s2 = s2;
    }

    public Stage3 getS3() {
        return s3;
    }

    public void setS3(Stage3 s3) {
        this.s3 = s3;
    }

    public Stage4 getS4() {
        return s4;
    }

    public void setS4(Stage4 s4) {
        this.s4 = s4;
    }

        
}
