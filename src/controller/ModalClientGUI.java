package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.App;
import model.Game;

public class ModalClientGUI{

    private MainGUI mainGUI;
    private App app;

    private Stage stage;

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
    

    public ModalClientGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;    
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void cancelButton(ActionEvent event) {
        stage.close();
    }

    @FXML
    public void saveButton(ActionEvent event) {

    }

    public void initializeTableView() {
		
        ObservableList<Game> observableList;

        observableList = FXCollections.observableArrayList(app.getGames());
        tvGameList.setItems(observableList);
		tcGame.setCellValueFactory(new PropertyValueFactory<Game,Integer>("id")); //the tableview search for a method called getName
		tcAmount.setCellValueFactory(new PropertyValueFactory<Game,Integer>("Amount")); //the tableview search for a method called getEmail
        tcRack.setCellValueFactory(new PropertyValueFactory<Game, String>("Rack"));
        tcCost.setCellValueFactory(new PropertyValueFactory<Game,Integer>("Cost"));
        
        /*ObservableList<String> elements = FXCollections.observableArrayList();

        elements.addAll("1","2","3","4","5");

        cbCashier.setItems(elements);

        cbCashier.setValue("1");
       */ 
   
    }


}