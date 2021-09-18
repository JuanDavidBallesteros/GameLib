package ui;

import controller.MainGUI;
import exception.NullKeyException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.App;
import model.HasTableTAD;
import routes.Routes;

public class Main extends Application{

    private static App app;

    public static void main(String[] args) {
        //app = new App();

        /* HasTableTAD<String, Integer> hash = new HasTableTAD<>();

        try {
            hash.insert("A", 1);
            hash.insert("B", 2);
            hash.insert("C", 3);
            hash.insert("D", 4);
            hash.insert("E", 5);
            hash.insert("F", 6);
        } catch (NullKeyException e) {
            e.printStackTrace();
        }

        System.out.println(hash.search("B"));
        System.out.println(hash.search("D"));
        System.out.println(hash.search("G"));

        System.out.println(hash.toString()); */
        
        launch(args);
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
