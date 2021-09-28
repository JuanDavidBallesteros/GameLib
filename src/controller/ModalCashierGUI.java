package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
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


    public ModalCashierGUI(MainGUI mainGUI,InputGUI inputGUI) {
        this.mainGUI = mainGUI;
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
    public void save(ActionEvent event) {
        String s2Time = timeTable.getText();
        String s3TimeRack = timeRack.getText();
        String timeXcasher = timeCasher.getText();

        

        if(!s2Time.equals("") && !s3TimeRack.equals("") && !timeXcasher.equals("") && cbCashier.getValue() != null){
            
           // System.out.println("melo");
           inputGUI.setCashersNum(Integer.parseInt(cbCashier.getValue()));
           inputGUI.setS2Time(Integer.parseInt(s2Time));
           inputGUI.setS3TimeRack(Integer.parseInt(s3TimeRack));
           inputGUI.setTimeXcasher(Integer.parseInt(timeXcasher)); 
           
           
           stage.close();
        }else{
           /* Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message for you!");

            alert.showAndWait();*/
            mainGUI.alert(AlertType.INFORMATION, "Empty field", "Please complete the client information");

        }



        
    }
}