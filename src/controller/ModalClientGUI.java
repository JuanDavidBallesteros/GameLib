package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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


    //_________________________________________-

    @FXML
    private TableView<Game> tvGameSelect;

    @FXML
    private TableColumn<Game, Integer> tcGameSelect;

    @FXML
    private TableColumn<Game, Integer> tcCostSelect;
    
    private ArrayList<Game> gamesSelected;

   

    public ModalClientGUI(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;    
        gamesSelected = new ArrayList<>();
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
        

        tvGameList.setRowFactory(tv -> {
            TableRow<Game> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Game temp = row.getItem();
                    gamesSelected.add(temp);
                    System.out.println("Double click on: "+ temp.getRack());
                    initializeTableView();

                }
            });
            return row ;
        });

        ObservableList<Game> observableList2 = FXCollections.observableList(gamesSelected);

        tcGameSelect.setCellValueFactory(new PropertyValueFactory<Game, Integer>("id"));
        tcCostSelect.setCellValueFactory(new PropertyValueFactory<Game, Integer>("Cost"));
        

        tvGameSelect.setItems(observableList2);

        tvGameSelect.setRowFactory(tv -> {
            TableRow<Game> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Game temp = row.getItem();
                    gamesSelected.remove(temp);
                    System.out.println("Double click on: "+ temp.getRack());
                    initializeTableView();

                }
            });
            return row ;
        });

        
        
    }

   

    




    @FXML
    public void informationGameButton(ActionEvent event) {
        try {
            mainGUI.informationGame();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }


}