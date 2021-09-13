package controller;

import java.io.IOException;

import javafx.application.Platform;
import model.App;

public class StoreGUI {

    private MainGUI mainGUI;
    private App app;

    public StoreGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;
    }
    
    public void testing(){
       new Thread(()->{
            try {
                Thread.sleep(2500);
                Platform.runLater(()->{
                    try {
                        mainGUI.resultView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
