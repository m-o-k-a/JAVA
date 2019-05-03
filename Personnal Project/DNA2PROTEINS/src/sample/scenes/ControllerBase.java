package sample.scenes;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.Controller;

import static sample.Main.cc;
import static sample.Main.np;
import static sample.Main.pn;

public class ControllerBase implements Controller {
    @FXML
    public VBox root;
    public ControllerBase() {
        //CREATE MENU
        Menu menu0 = new Menu("<Help>");
        Menu menu1 = new Menu("<Converter>");
        MenuItem menuItem1 = new MenuItem("N->P");
        MenuItem menuItem2 = new MenuItem("P->[Na-Nk]");
        MenuItem menuItem3 = new MenuItem("N->C");
        //BUILD MENU
        MenuBar menuBar = new MenuBar();
        menu1.getItems().addAll(menuItem1, menuItem2, menuItem3);
        menuBar.getMenus().addAll(menu0, menu1);
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
            menuBar.getScene().setRoot(cc.getContent());
        });
        //END OF MENU
        menuBar.setStyle("-fx-border-color: #0096C9; -fx-border-style: solid; -fx-border-width: 2; -fx-border-height: 2;");
        root = new VBox(menuBar);
        //DRAW INFO TEXT
        Line lineText = new Line(0, 780, 1300, 780);
        lineText.setTranslateY(665);
        lineText.setStroke(Color.web("#0096C9"));
        lineText.setStrokeWidth(2);
        Text text = new Text("INFO: SELECT A TOOL IN THE MENU");
        text.setFill(Color.web("#0096C9"));
        text.setTranslateY(685);
        root.getChildren().add(text);
        root.getChildren().add(lineText);
    }

    @Override
    public Parent getContent() {
        return root;
    }

}
