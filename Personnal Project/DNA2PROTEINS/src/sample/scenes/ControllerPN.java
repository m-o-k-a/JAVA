package sample.scenes;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.Controller;

import static sample.Main.np;
import static sample.Main.pn;

public class ControllerPN implements Controller {
    /*
        Build Scene
    */
    private VBox root = new VBox();
    public ControllerPN() {
        /*
            ADD MENU
         */
        //ADD CATEGORIES
        Menu menu0 = new Menu("Help");
        Menu menu1 = new Menu("Converter");
        MenuItem menuItem1 = new MenuItem("N->P");
        MenuItem menuItem2 = new MenuItem("P->[Na-Nk]");
        MenuItem menuItem3 = new MenuItem("N->C");
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        //BUILD MENU
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu0);
        //ADD LISTENER
        menuItem1.setOnAction(e -> {
            System.out.println("N->P Selected");
            menuBar.getScene().setRoot(np.getContent());
        });
        menuItem2.setOnAction(e -> {
            System.out.println("P->[Na-Nk] Selected");
            menuBar.getScene().setRoot(pn.getContent());
        });
        menuItem3.setOnAction(e -> {
            System.out.println("N->C Selected");
        });
        menuBar.setStyle("-fx-border-color: #0096C9; -fx-border-style: solid; -fx-border-width: 2; -fx-border-height: 2;");
        root = new VBox(menuBar);
        //DRAW INFO TEXT
        Line lineText = new Line(0, 780, 1300, 780);
        lineText.setTranslateY(665);
        lineText.setStroke(Color.web("#0096C9"));
        lineText.setStrokeWidth(2);
        Text text = new Text("INFO: CONVERT PROTEINS TO ALL THE POSSIBLES NUCLEOTIDES SEQUENCES");
        text.setFill(Color.web("#0096C9"));
        text.setTranslateY(685);
        root.getChildren().add(text);
        root.getChildren().add(lineText);

        //DRAW CONTENT TEXT
        Text info1 = new Text("Enter the Proteins sequence to convert:");
        info1.setScaleX(2);
        info1.setScaleY(2);
        info1.setFill(Color.web("#0096C9"));
        info1.setTranslateY(-10);
        info1.setTranslateX(110);
        Rectangle rect1 = new Rectangle(0,0,1280, 300);
        rect1.setStrokeWidth(2);
        rect1.setStroke(Color.web("#0096C9"));
        rect1.setTranslateX(4);
        rect1.setFill(Color.WHITE);
        //TODO INPUT
        Text info3 = new Text("Result:");
        info3.setScaleX(2);
        info3.setScaleY(2);
        info3.setFill(Color.web("#0096C9"));
        info3.setTranslateY(5);
        info3.setTranslateX(25);
        Rectangle rect2 = new Rectangle(0,0,1280, 300);
        rect2.setStrokeWidth(2);
        rect2.setStroke(Color.web("#0096C9"));
        rect2.setTranslateX(4);
        rect2.setTranslateY(11);
        rect2.setFill(Color.WHITE);
        //TODO OUTPUT
        root.getChildren().add(info1);
        root.getChildren().add(rect1);
        root.getChildren().add(info3);
        root.getChildren().add(rect2);

    }

    @Override
    public Parent getContent() {
        return root;
    }
}
