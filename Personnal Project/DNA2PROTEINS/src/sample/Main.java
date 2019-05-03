package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.scenes.ControllerBase;
import sample.scenes.ControllerNP;
import sample.scenes.ControllerPN;

public class Main extends Application {
    /*
       CREATE STATIC WINDOWS
    */
    public static ControllerBase base = new ControllerBase();
    public static ControllerNP np = new ControllerNP();
    public static ControllerPN pn = new ControllerPN();


    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
            CREATE GRAPHIC INTERFACE
         */
        primaryStage.setTitle("Dna To Proteins - V0.1 - Eddy Ikhlef");
        Image image = new Image("img/ico.png");
        primaryStage.getIcons().add(image);
        /*
            START INTERFACE
         */
        //primaryStage.setScene(new Scene(vBox, 1280, 720));
        Scene scene = new Scene(base.getContent(), 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
