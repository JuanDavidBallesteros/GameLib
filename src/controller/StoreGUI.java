package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import model.*;

public class StoreGUI {

    private MainGUI mainGUI;
    private App app;

    private final static int WAITING_TIME = 2250;

    @FXML
    private JFXTextArea Stage2TA;

    @FXML
    private JFXTextArea Stage3TA;

    @FXML
    private JFXButton btnContinue;

    @FXML
    private JFXTextArea Stage4TA;

    public StoreGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;
    }
    
    public void testing(){
        simulateStage2();
        simulateStage3();
        simulateStage4();
    }

    private void simulateStage2(){
        app.passStage2();
        callInfoS2(Stage2TA);
    }

    private void simulateStage3(){
        new Thread(()->{
            try {
                Thread.sleep(WAITING_TIME);
                Platform.runLater(()->{
                    app.passStage3();
                    callInfoS3(Stage3TA);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void simulateStage4(){
        new Thread(()->{
            try {
                Thread.sleep(WAITING_TIME*2);
                Platform.runLater(()->{
                    app.passStage4();
                    callInfoS4(Stage4TA);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void continueResults(ActionEvent event) {
        try {
            mainGUI.resultView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void callInfoS2(JFXTextArea stageTA){

        ArrayList<Client> list = new ArrayList<>();
        QueueTAD<Client> clients = new QueueTAD<>();

        while (!app.getClients().isEmpty()) {
            list.add(app.getClients().front());
            clients.add(app.getClients().dequeue());
        }

        app.setClients(clients);

        for (int i = 0; i < list.size(); i++) {
            String line1 = "";
            String line2 = "";

            line1 += list.get(i).getId() + " ";
            line1 += list.get(i).getPurchaseValue();

            QueueTAD<Game> games = new QueueTAD<>();

            while (!list.get(i).getSortedGameList().isEmpty()) {
                line2 += list.get(i).getSortedGameList().front().getId() + " ";
                games.add(list.get(i).getSortedGameList().dequeue());
            }

            list.get(i).setSortedGameList(games);
            stageTA.appendText(line1 + "\n");
            stageTA.appendText(line2 + "\n");
        }   
    }

    private void callInfoS3(JFXTextArea stageTA){

        ArrayList<Client> list = new ArrayList<>();
        QueueTAD<Client> clients = new QueueTAD<>();

        while (!app.getClients().isEmpty()) {
            list.add(app.getClients().front());
            clients.add(app.getClients().dequeue());
        }

        app.setClients(clients);

        for (int i = 0; i < list.size(); i++) {
            String line1 = "";
            String line2 = "";

            line1 += list.get(i).getId() + " ";
            line1 += list.get(i).getPurchaseValue();

            StackTAD<Game> games = new StackTAD<>();

            while (!list.get(i).getBasket().isEmpty()) {
                line2 += list.get(i).getBasket().top().getId() + " ";
                games.push(list.get(i).getBasket().pop());
            }

            while (!games.isEmpty()) {
                list.get(i).getBasket().push(games.pop());
            }

            
            stageTA.appendText(line1 + "\n");
            stageTA.appendText(line2 + "\n");
        }
    }

    private void callInfoS4(JFXTextArea stageTA){

        ArrayList<Client> list = new ArrayList<>();
        QueueTAD<Client> clients = new QueueTAD<>();

        while (!app.getClients().isEmpty()) {
            list.add(app.getClients().front());
            clients.add(app.getClients().dequeue());
        }

        app.setClients(clients);

        for (int i = list.size()-1; i >= 0; i--) {
            String line1 = "";
            String line2 = "";

            line1 += list.get(i).getId() + " ";
            line1 += list.get(i).getPurchaseValue();

            StackTAD<Game> games = new StackTAD<>();

            while (!list.get(i).getBag().getGames().isEmpty()) {
                line2 += list.get(i).getBag().getGames().top().getId() + " ";
                games.push(list.get(i).getBag().getGames().pop());
            }

            while (!games.isEmpty()) {
                list.get(i).getBag().getGames().push(games.pop());
            }

            //list.get(i).getBag().setGames(games);
            stageTA.appendText(line1 + "\n");
            stageTA.appendText(line2 + "\n");
        }
    }
}
