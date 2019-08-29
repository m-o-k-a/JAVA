package com.moka.colorfulcircles.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;
import static javafx.scene.paint.Color.BLACK;

public class ColorfulCircles extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //variables
        int width = 800;
        int height = 600;
        int circlesAmount = 30;
        int circlesWidth = 4;
        int circlesBlur = 10;
        int animDuration = 40000;
        int maxTranslateX = 800;
        int maxTranslateY = 600;

        //create Scene
        Group root = new Group();
        Scene scene = new Scene(root, width, height, Color.web("black", 1));
        primaryStage.setTitle("0w0");
        primaryStage.setScene(scene);

        //create circles
        Group circles = new Group();
        //initialize
        for (int i = 0; i < circlesAmount; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.5));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.05));
            circle.setStrokeWidth(circlesWidth);
            circle.setEffect(new BoxBlur(10, 10, circlesBlur));
            circles.getChildren().add(circle);
        }

        //create background to colorize circles
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0.14, Color.web("yellow")),
                new Stop(0.16, Color.web("yellow")),
                new Stop(0.32, Color.web("green")),
                new Stop(0.48, Color.web("blue")),
                new Stop(0.64, Color.web("fuchsia")),
                new Stop(0.80, Color.web("red")),
                new Stop(1, Color.web("yellow")),}));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());


        //add child in blend mode
        Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(), Color.web("black")), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);

        //animate the whole
        Timeline timeline = new Timeline();
        for (Node circle: circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                    //position to 0
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), random()*maxTranslateX),
                            new KeyValue(circle.translateYProperty(), random()*maxTranslateY)),
                    new KeyFrame(new Duration(animDuration),
                            new KeyValue(circle.translateXProperty(), random()*maxTranslateX),
                            new KeyValue(circle.translateYProperty(), random()*maxTranslateY))
            );
        }
        //play infinite animation
        timeline.play();

        //show Scene
        primaryStage.show();
    }
}
