package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.*;

public class InputGUI {

    private MainGUI mainGUI;
    private App app;

    private int s2Time;
    private int s3TimeRack;
    private int timeXcasher;
    private int cashersNum;
    private QueueTAD<Client> clients;

    //-------------- Control

    private ArrayList<Client> clientList;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, Integer> posCol;

    @FXML
    private TableColumn<Client, String> idCol;

    public InputGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;

        clients = new QueueTAD<>();
        clientList = new ArrayList<>();
        s2Time = 1;
        s3TimeRack = 1;
        timeXcasher = 1;
    }

    @FXML
    private JFXButton startBtn;

    @FXML
    public void reset(ActionEvent event) {

    }

    @FXML
    public void start(ActionEvent event) throws IOException {
        if (cashersNum != 0 && clientList.size() != 0) {
            for (int i = 0; i < clientList.size(); i++) {
                clients.add(clientList.get(i));
            }
            app.setSimulation(s2Time, s3TimeRack, timeXcasher, cashersNum, clients);
            mainGUI.storeView();
        }

    }

    @FXML
    public void addClientButton(ActionEvent event) {
        try {
            mainGUI.addClientView(this);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void addCashierButton(ActionEvent event) {
        try {
            mainGUI.addCashierView(this);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void initializeTableView() {


        ObservableList<Client> observableList = FXCollections.observableArrayList(clientList);

        clientsTable.setItems(observableList);

		idCol.setCellValueFactory(new PropertyValueFactory<Client,String>("id")); 
		posCol.setCellValueFactory(new PropertyValueFactory<Client,Integer>("arrivalNum"));
        
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }    

}
