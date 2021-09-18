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

public class Main extends Application{

    private static App app;

    public static void main(String[] args) {
        try {
            app = new App();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < app.getGames().size(); i++) {
            System.out.println(app.getGames().get(i).getName());
        }
        //launch(args);

        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainGUI gui = new MainGUI(app);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Routes.MAIN_VIEW.getRoute()));
        fxmlLoader.setController(gui);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("assets/styles/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        gui.inputView(); 
    }


}
