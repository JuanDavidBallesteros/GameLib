package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.App;
import routes.Routes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

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
        controller.initializeTableView();

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
