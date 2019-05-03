package sample.scenes;

import javafx.event.ActionEvent;
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

import static sample.Main.*;

public class ControllerNP implements Controller {
    /*
        Build Scene
    */
    private VBox root = new VBox();
    public ControllerNP() {
        /*
            ADD MENU
         */
        //ADD CATEGORIES
        Menu menu0 = new Menu("<Help>");
        Menu menu1 = new Menu("<Converter>");
        Menu menu2 = new Menu("Tools");
        MenuItem menuItem1 = new MenuItem("N->P");
        MenuItem menuItem2 = new MenuItem("P->[Na-Nk]");
        MenuItem menuItem3 = new MenuItem("N->C");
        MenuItem menu2Item1 = new MenuItem("Clear Values");
        MenuItem menu2Item2 = new MenuItem("Generate Output");
        //BUILD MENU
        MenuBar menuBar = new MenuBar();
        menu1.getItems().addAll(menuItem1, menuItem2, menuItem3);
        menu2.getItems().addAll(menu2Item1, menu2Item2);
        menuBar.getMenus().addAll(menu0, menu1, menu2);
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
        Text text = new Text("INFO: CONVERT NUCLEOTIDES SEQUENCES TO PROTEINS");
        text.setFill(Color.web("#0096C9"));
        text.setTranslateY(685);
        root.getChildren().add(text);
        root.getChildren().add(lineText);

        //DRAW CONTENT TEXT
        Text info1 = new Text("Enter the Nucleotides sequence to convert:");
        info1.setScaleX(2);
        info1.setScaleY(2);
        info1.setFill(Color.web("#0096C9"));
        info1.setTranslateY(-10);
        info1.setTranslateX(120);
        Rectangle rect1 = new Rectangle(0,0,1280, 300);
        rect1.setStrokeWidth(2);
        rect1.setStroke(Color.web("#0096C9"));
        rect1.setTranslateX(4);
        rect1.setFill(Color.WHITE);

        TextArea input = new TextArea();
        input.setWrapText(true);
        input.setMinHeight(298);
        input.setMinWidth(1279);
        HBox inputHBox = new HBox(input);
        inputHBox.setTranslateY(-618);
        inputHBox.setTranslateX(5);
        input.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent; -fx-text-fill: #0096C9;");

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

        TextArea output = new TextArea("OUPUT");
        output.setWrapText(true);
        HBox outputHBox = new HBox(output);
        output.setMinHeight(298);
        output.setMinWidth(1275);
        outputHBox.setTranslateY(-588);
        outputHBox.setTranslateX(10);
        output.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent; -fx-text-fill: #0096C9;");

        root.getChildren().add(info1);
        root.getChildren().add(rect1);
        root.getChildren().add(info3);
        root.getChildren().add(rect2);
        root.getChildren().add(inputHBox);
        root.getChildren().add(outputHBox);

        //UPDATE LISTENER
        menu2Item1.setOnAction(e -> {
            System.out.println("Clear Values");
            input.setText("");
            output.setText("");
        });
        menu2Item2.setOnAction(e -> {
            System.out.println("Generate");
            output.setText(converter.drawSequences(converter.sequencesToProteins(input.getText(), reference)));
        });
    }

    @Override
    public Parent getContent() {
        return root;
    }
}
