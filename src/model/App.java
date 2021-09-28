package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import routes.Routes;

public class App {

    private QueueTAD<Client> clients;
    private ArrayList<Game> games;

    private Stage2 s2;
    private Stage3 s3;
    private Stage4 s4;

    public App() throws IOException {
        clients = new QueueTAD<>();
        games = new ArrayList<>();
        loadGames();
    }

    // -----------------------------------------------> Start Simulation
    // --------------- Import games

    public ArrayList<Game> getGames() {
        return games;
    }

    private void loadGames() throws IOException {

        /*
         * String currentPath = new java.io.File(".").getCanonicalPath(); // Get actual
         * path System.out.println(currentPath);
         */

        BufferedReader br = new BufferedReader(new FileReader(Routes.GAMES_DATA.getRoute()));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");

            Game temp = new Game(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2],
                    Integer.parseInt(parts[3]));
            games.add(temp);
            line = br.readLine();
        }

        br.close();
    }

    // --------------- Set Objects

    public void setSimulation(int s2Time, int s3TimeRack, int timeXcasher, int cashersNum, QueueTAD<Client> clients) {
        s2 = new Stage2(s2Time);
        s3 = new Stage3(s3TimeRack);
        s4 = new Stage4(cashersNum, timeXcasher);

        this.clients = clients;
    }

    public void setSimulation(int s2Time, int s3TimeRack, int timeXcasher, int cashersNum, QueueTAD<Client> clients,
            ArrayList<Game> games) {
        s2 = new Stage2(s2Time);
        s3 = new Stage3(s3TimeRack);
        s4 = new Stage4(cashersNum, timeXcasher);

        this.clients = clients;
        this.games = games;
    }

    // ---------------------------------------------> Flow

    public void passStage2() {

        QueueTAD<Client> temp = new QueueTAD<>();

        while (!clients.isEmpty()) {
            s2.addTimeToClient(clients.front());
            s2.getSortedRackList(clients.front());
            temp.add(clients.dequeue());
        }

        clients = temp;

    }

    public void passStage3() {
        ArrayList<Client> list = new ArrayList<>();

        while (!clients.isEmpty()) {
            s3.addTimeToClient(clients.front());
            list.add(clients.dequeue());
        }

        QueueTAD<Client> temp = new QueueTAD<>();

        // Sorting clientes por su tiempo y añadirlos a la cola de clientes para la fase
        // 4

        Comparator<Client> timeComparator = new Comparator<Client>() {

            @Override
            public int compare(Client in1, Client in2) {
                if (in1.getTime() - (in2.getTime()) > 0) {
                    return -1;
                } else if (in1.getTime() - (in2.getTime()) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        list.sort(timeComparator);

        for (Client client : list) {
            temp.add(client);
        }

        clients = temp;
    }

    public void passStage4() {
        s4.setClientes(clients);
        clients = s4.clientsOut();
        if(clients.isEmpty()){

        }
    }

    // ---------------------------------------------> Response
    public void responseStage() throws IOException {

        System.out.println("");

        StackTAD<Client> outList = new StackTAD<>();

        for (; !clients.isEmpty(); ) {
           outList.push(clients.dequeue());
        }

        for (; !outList.isEmpty(); ) {
            String line1 = "";
            String line2 = "";

            line1 += outList.top().getId() + " ";
            line1 += outList.top().getPurchaseValue();

            int size = outList.top().getBag().getGames().getSize();
            for (int j = 0; j < size; j++) {
                line2 += outList.top().getBag().getGames().pop().getId();
                line2 += " ";
            }

            System.out.println(line1);
            System.out.println(line2);
            //System.out.println("time:" + outList.top().getTime()); // Tiempo

            outList.pop();
        }
    }

    // ---------------------------------------------> Getter and Setters

    public QueueTAD<Client> getClients() {
        return clients;
    }

    public void setClients(QueueTAD<Client> clients) {
        this.clients = clients;
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

    public void restart() {

    }

}
