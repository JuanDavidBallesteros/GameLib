package controller;

import model.App;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ResultGUI {
    
    private MainGUI mainGUI;
    private App app;
    
    public ResultGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;
    }
    
    @FXML
    private JFXButton startBtn;

    @FXML
    public void newSimulation(ActionEvent event) throws IOException {
        mainGUI.inputView();
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
}
