package controller;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.App;

public class InputGUI {

    private MainGUI mainGUI;
    private App app;

   

    @FXML
    private JFXComboBox<String> cbCashier;


    public InputGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;    
    }

    @FXML
    private JFXButton startBtn;

    @FXML
    public void reset(ActionEvent event) {

    }

    @FXML
    public void start(ActionEvent event) throws IOException {
        mainGUI.storeView();
    }


   


    @FXML
    public void addClientButton(ActionEvent event)  {
        try {
            mainGUI.addClientView();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    public void addCashierButton(ActionEvent event) {
        try {
            mainGUI.addCashierView();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
    
   
     

    
}
