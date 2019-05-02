package nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
        final ObjectMapper mapper = new ObjectMapper();
        DataFetcher dataFetcher = new DataFetcher();

        TreeMap<Integer, Integer> data = dataFetcher.getData(2);
        List<Integer> keys = new ArrayList<>(data.keySet());
        List<Integer> values = new ArrayList<>(data.values());
        System.out.println(keys +"\n"+ values);
        System.out.println(data);
    }
}
