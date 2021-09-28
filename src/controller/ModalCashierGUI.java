package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.App;

public class ModalCashierGUI {

    @FXML
    private JFXComboBox<String> cbCashier;

    @FXML
    private JFXTextField timeCasher;

    @FXML
    private JFXTextField timeRack;

    @FXML
    private JFXTextField timeTable;

    private MainGUI mainGUI;
    private App app;

    private Stage stage;

    private InputGUI inputGUI;


    public ModalCashierGUI(InputGUI inputGUI) {
        this.inputGUI = inputGUI;
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

    @FXML
    void save(ActionEvent event) {

        stage.close();
    }
}