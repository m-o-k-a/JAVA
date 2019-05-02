package sampleOld;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private NumberAxis xAxis = new NumberAxis();
    @FXML
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    public LineChart<NumberAxis, NumberAxis> sketchLine = new LineChart(xAxis, yAxis);
    /**
    * CONSTRUCTOR
    */
    public Controller() {
        //this.sketchLine = new LineChart(xAxis, yAxis);
        //this.addSeries(getCosineSeries());
    }


    /**
     * METHOD
     */
    @FXML
    public XYChart.Series getCosineSeries() {
        XYChart.Series series = new XYChart.Series();
        series.setName("Cosinus");
        for (double x = -10; x <= 10; x += 0.1) {
            double y = Math.cos(x);
            series.getData().add(new XYChart.Data<>(x, y));
        }
        //ObservableList<XYChart.Series<Double, Double>> observe = series.getData();
        return series;
    }

    @FXML
    public XYChart.Series getSineSeries() {
        XYChart.Series series = new XYChart.Series();
        series.setName("Sinus");
        for (double x = -10; x <= 10; x += 0.1) {
            double y = Math.sin(x);
            series.getData().add(new XYChart.Data<>(x, y));
        }
        //ObservableList<XYChart.Series<Double, Double>> observe = series.getData();
        return series;
    }

    @FXML
    public XYChart.Series getSeries(RealFunction sample, String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for (double x = -10; x <= 10; x += 0.1) {
            double y = sample.apply(x);
            series.getData().add(new XYChart.Data<>(x, y));
        }
        return series;
    }

    @FXML
    public void addSeries(XYChart.Series serie) {
        sketchLine.getData().add(serie);
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addSeries(getSeries(x -> Math.cos(x), "Cosine"));
        this.addSeries(getSeries(x -> Math.sin(x), "Sine" ));
        sketchLine.setCreateSymbols(false);
        sketchLine.setTitle("Fonctions");
        //sketchLine.setScaleX(0.15);
        //sketchLine.setScaleY(0.15);


    }
}