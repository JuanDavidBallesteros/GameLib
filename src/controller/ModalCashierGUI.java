package controller;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.App;

public class ModalCashierGUI {

    @FXML
    private JFXComboBox<String> cbCashier;

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

    public void comboBoxValue(){
        ObservableList<String> elements = FXCollections.observableArrayList();

        elements.addAll("1","2","3","4","5");

        cbCashier.setItems(elements);
        
    }



}