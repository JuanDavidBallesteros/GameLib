package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.UUID;

import exception.FullTable;
import exception.NullKeyException;
import model.*;

public class Simulation {
    private App app;

    public Simulation(App app) {
        this.app = app;
    }

    public void runSimulation(){

        
        
        new Thread(()->{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            ArrayList<Game> gamesL = new ArrayList<>();
            HasTableTAD<Integer, Game> gamesList = new HasTableTAD<>();
            QueueTAD<Client> clientsList = new QueueTAD<>();
            

            try {
                int cases = Integer.parseInt(br.readLine());
                while (cases > 0) {
                    int cashersNum = Integer.parseInt(br.readLine());
                    
                    int racks = Integer.parseInt(br.readLine());
                    for (int i = 0; i < racks; i++) {
                        String[] rack = br.readLine().split(" ");
                        Rack temp = new Rack(rack[0]);
                        for (int j = 0; j < Integer.parseInt(rack[1]); j++) {
                            String[] game = br.readLine().split(" ");
                            Game g = new Game(Integer.parseInt(game[0]), Integer.parseInt(game[2]), temp.getLetter(), Integer.parseInt(game[1]));
                            temp.addGame(g, Integer.parseInt(game[1]));
                            gamesList.insert(g.getId(), g);
                            gamesL.add(g);
                        }
                    }
                    int clients = Integer.parseInt(br.readLine());
                    for (int i = 0; i < clients; i++) {
                        String[] client = (br.readLine()).split(" ");
                        boolean sortingAlgorithm = ((int) (Math.random()*3) == 2) ? true : false;
                        String listCode = UUID.randomUUID().toString();
                        Client temp = new Client(listCode, client[0], i+1, sortingAlgorithm);
                        for (int j = 1; j < client.length; j++) {
                            Game fGame= gamesList.search(Integer.parseInt(client[j]));
                            temp.getGamesList().add(fGame);
                        }
                        clientsList.add(temp);
                    }

                    app.setSimulation(1, 1, 1, cashersNum, clientsList, gamesL);
                    app.passStage2();
                    app.passStage3();
                    app.passStage4();
                }

                
                
                br.close();


            } catch (NumberFormatException | IOException | NullKeyException | FullTable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }).start();
    }
}
