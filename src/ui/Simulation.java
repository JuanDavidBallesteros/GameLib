package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

import exception.FullTable;
import exception.NullKeyException;
import javafx.application.Platform;
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
                            int key = g.getId();
                            gamesList.insert(key, g);
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
                            if(fGame != null){
                                temp.getGamesList().add(fGame);
                            }
                        }
                        clientsList.add(temp);
                    }

                    app.setSimulation(1, 1, 1, cashersNum, clientsList, gamesL);

                    /* System.out.println(gamesL.toString());
                    while (!clientsList.isEmpty()) {
                        System.out.println(clientsList.dequeue().getGamesList().toString());
                    } */
                    app.passStage2();
                    app.passStage3();
                    app.passStage4();

                    cases--;
                }
                
                Platform.runLater(()->{
                    System.exit(0);
                });
                br.close();

                app.responseStage();

            } catch (NumberFormatException | IOException | NullKeyException | FullTable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }).start();
    }
}

/* 
1
3
3
A 4
331 17000 3
465 60000 6
612 80000 2
971 70000 6
B 5
441 30000 3
112 22000 6
229 28000 6
281 38000 2
333 43000 6
C 2
767 40000 2
287 65000 6
5
1627 287 612
3456 612 333 287 465
3219 287
3311 767 287 229 971
2100 331
 */
