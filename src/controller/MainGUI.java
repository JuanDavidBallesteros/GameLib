package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.App;
import routes.Routes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainGUI extends Stage {

    private App app;


    @FXML
    private Pane mainPane;

    
    public MainGUI(App app) {
        this.app = app;
        

    }

    // ----------------------------- Navigation

    public void inputView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.INPUT_VIEW.getRoute()));
        InputGUI controller = new InputGUI(this, app);
        fxmlLoader.setController(controller);

        Parent view = fxmlLoader.load();
        mainPane.getChildren().setAll(view);

    }

    public void storeView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.STORE_VIEW.getRoute()));
        StoreGUI controller = new StoreGUI(this, app);
        fxmlLoader.setController(controller);
        Parent view = fxmlLoader.load();
        mainPane.getChildren().setAll(view);
        controller.testing();

    }

    public void resultView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.RESULT_VIEW.getRoute()));
        ResultGUI controller = new ResultGUI(this, app);
        fxmlLoader.setController(controller);
        Parent view = fxmlLoader.load();
        mainPane.getChildren().setAll(view);
        controller.initializeTableView();
    }

    public Stage addClientView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.ADD_CLIENT_VIEW.getRoute()));
        ModalClientGUI controller = new ModalClientGUI(this, app);
        fxmlLoader.setController(controller);
        Parent modal = fxmlLoader.load();

        

        Scene  scene = new Scene(modal);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        controller.setStage(stage);
        controller.initializeTableView();

        stage.show();
        
        return stage;

    }

    public Stage addCashierView() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.ADD_CASHIER_VIEW.getRoute()));
        ModalCashierGUI controller = new ModalCashierGUI(this, app);
        fxmlLoader.setController(controller);
        Parent modal = fxmlLoader.load();


        

        Scene  scene = new Scene(modal);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        controller.setStage(stage);
        //controller.initializeTableView();
        controller.comboBoxValue();


        stage.show();
        
        return stage;
    }


   
    public Stage informationGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.GAME_INFORMATION_VIEW.getRoute()));
        ModalGameInformation controller = new ModalGameInformation(this, app);
        fxmlLoader.setController(controller);
        Parent modal = fxmlLoader.load();


        

        Scene  scene = new Scene(modal);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        controller.setStage(stage);
        controller.cbCodeGames();
    
        stage.show();
        
        return stage;
    }

    // ----------------------------- Alerts

    public void alert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    

    
}
