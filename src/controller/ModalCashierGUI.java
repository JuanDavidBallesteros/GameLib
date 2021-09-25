package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.App;

public class ModalCashierGUI {

    private MainGUI mainGUI;
    private App app;

    private Stage stage;


    public ModalCashierGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;    
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void returnButton(ActionEvent event) {
        stage.close();
    }



}