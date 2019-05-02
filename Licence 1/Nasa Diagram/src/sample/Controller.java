package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import nasa.DataFetcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

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
    public Controller() throws IOException, URISyntaxException {
    }


    /**
     * METHOD
     */
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
    public TreeMap<Integer, Integer> getData(int pages) throws IOException, URISyntaxException {
        //create data
        final ObjectMapper mapper = new ObjectMapper();
        DataFetcher dataFetcher = new DataFetcher();
        TreeMap<Integer, Integer> data = dataFetcher.getData(pages);
        System.out.println(data);
        return data;
    }
    @FXML
    public XYChart.Series throwData(String name, List<Integer> keys, List<Integer> values) throws IOException, URISyntaxException {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for(int i = 0; i < keys.size(); i++) {
            series.getData().add(new XYChart.Data<>(keys.get(i), values.get(i)));
        }
        System.out.println(series);
        return series;
    }

    @FXML
    public void addSeries(XYChart.Series serie) {
        sketchLine.getData().add(serie);
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Get Datas
        try {
            TreeMap<Integer, Integer> data = getData(12);
            List<Integer> keys = new ArrayList<>(data.keySet());
            List<Integer> values = new ArrayList<>(data.values());
            xAxis.setLowerBound(keys.get(0));
            xAxis.setUpperBound(keys.get(keys.size()-1));
            xAxis.setTickUnit(Math.abs(keys.get(keys.size()-1)/keys.get(0))*5);
            this.addSeries(throwData("number of asteroids approach per year", keys, values));
            sketchLine.setTitle("Asteroid Approaching the Earth");
            sketchLine.setPrefWidth(800);
            sketchLine.setPrefHeight(800);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}