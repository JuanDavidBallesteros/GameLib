package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.App;
import model.Game;

public class InputGUI {

    private MainGUI mainGUI;
    private App app;

    @FXML
    private TableView<Game> tvGameList;

    @FXML
    private TableColumn<Game, Integer> tcGame;

    @FXML
    private TableColumn<Game,Integer> tcAmount;

    @FXML
    private TableColumn<Game, String> tcRack;

    @FXML
    private TableColumn<Game, Integer> tcCost;

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

    public void initializeTableView() {
		
        ObservableList<Game> observableList;

        observableList = FXCollections.observableArrayList(app.getGames());
        tvGameList.setItems(observableList);
		tcGame.setCellValueFactory(new PropertyValueFactory<Game,Integer>("id")); //the tableview search for a method called getName
		tcAmount.setCellValueFactory(new PropertyValueFactory<Game,Integer>("Amount")); //the tableview search for a method called getEmail
        tcRack.setCellValueFactory(new PropertyValueFactory<Game, String>("Rack"));
        tcCost.setCellValueFactory(new PropertyValueFactory<Game,Integer>("Cost"));
    }
    
}
