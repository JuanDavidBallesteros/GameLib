package controller;

import model.App;
import model.Client;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ResultGUI {
    
    private MainGUI mainGUI;
    private App app;

    @FXML
    private TableView<Client> outList;

    @FXML
    private TableColumn<Client, String> clientId;

    @FXML
    private TableColumn<Client, Integer> purchaseAmount;

    @FXML
    private TableColumn<Client, String> bagCol;
    
    public ResultGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;
    }

    @FXML
    public void newSimulation(ActionEvent event) throws IOException {
        mainGUI.inputView();
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    public void initializeTableView() {

        ArrayList<Client> list = new ArrayList<>();
        
        while (!app.getClients().isEmpty()) {
            list.add(app.getClients().dequeue());
        }

        ObservableList<Client> observableList = FXCollections.observableArrayList(list);

        outList.setItems(observableList);

		clientId.setCellValueFactory(new PropertyValueFactory<Client,String>("id")); 
		purchaseAmount.setCellValueFactory(new PropertyValueFactory<Client,Integer>("Amount"));
        bagCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Rack"));
        
    }
}
