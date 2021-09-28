package ui;

import java.io.IOException;

import controller.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.App;
import routes.Routes;

public class Main extends Application {

    private static App app;

    public static void main(String[] args) {
        try {
            app = new App();

        } catch (IOException e) {
            e.printStackTrace();
        }

/*<<<<<<< HEAD
        Simulation simul = new Simulation(app);
        simul.runSimulation();
        //launch(args);
        
        

       // System.exit(0);
=======*/
        launch(args);

        //Simulation simul = new Simulation(app);

        //simul.runSimulation();

        System.exit(0);
//>>>>>>> 36f000a33f4d08bbe1ed5e0f30f7a80e46b7daee
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.MAIN_VIEW.getRoute()));

        MainGUI gui = new MainGUI(app);

        fxmlLoader.setController(gui);
        Parent root = fxmlLoader.load();

        // Test

        Scene scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource("assets/styles/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("GameLib Store");
        primaryStage.show();

        gui.inputView();
    }

}
