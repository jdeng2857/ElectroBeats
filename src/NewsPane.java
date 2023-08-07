import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.HashMap;

public class NewsPane extends Pane implements RandomGenerator{
    private Label trend;
    private Label l1, l2, l3, l4, l5, l6;
    private HashMap<String, Integer> forecast = new HashMap<String, Integer>();
    private HashMap<String, Integer> realForecast = new HashMap<String, Integer>();
    private String[] products;
    private int accuracy;
    private Store store;

    public NewsPane(Store s) {
        Pane innerPane = new Pane();

        store = s;
        products = store.getProducts();
        accuracy = store.getAccuracy();

        generateRealForecast(store);
        generateForecast(store, accuracy);

        // CREATE LABEL
        trend = new Label("TRENDS FOR THE NEXT MONTH");
        trend.relocate(25,75);
        trend.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,255,255); " + "-fx-text-fill: rgb(0,0,0);");

        l1 = new Label(products[0] + ": " + Integer.toString(forecast.get(products[0])) + " sales");
        l1.relocate(25,125);
        l1.setStyle("-fx-font: 12 arial;");

        l2 = new Label(products[1] + ": " + Integer.toString(forecast.get(products[1])) + " sales");
        l2.relocate(25,150);
        l2.setStyle("-fx-font: 12 arial;");

        l3 = new Label(products[2] + ": " + Integer.toString(forecast.get(products[2])) + " sales");
        l3.relocate(25,175);
        l3.setStyle("-fx-font: 12 arial;");

        l4 = new Label(products[3] + ": " + Integer.toString(forecast.get(products[3])) + " sales");
        l4.relocate(25,200);
        l4.setStyle("-fx-font: 12 arial;");

        l5 = new Label(products[4] + ": " + Integer.toString(forecast.get(products[4])) + " sales");
        l5.relocate(25,225);
        l5.setStyle("-fx-font: 12 arial;");

        l6 = new Label(products[5] + ": " + Integer.toString(forecast.get(products[5])) + " sales");
        l6.relocate(25,250);
        l6.setStyle("-fx-font: 12 arial;");


        innerPane.getChildren().addAll(trend, l1, l2, l3, l4, l5, l6);
        getChildren().addAll(innerPane);
    }

    public Store generateRealForecast(Store s){
        realForecast.put(products[0], getRandomNumber(40,0));
        realForecast.put(products[1], getRandomNumber(20,0));
        realForecast.put(products[2], getRandomNumber(10,0));
        realForecast.put(products[3], getRandomNumber(15,0));
        realForecast.put(products[4], getRandomNumber(8,0));
        realForecast.put(products[5], getRandomNumber(3,0));
        s.setRealForecast(realForecast);
        return s;
    }

    public Store generateForecast(Store s, int a){
        for(int i = 0; i < 6; i++) {
            if(realForecast.get(products[i]) - a >= 0) {
                forecast.put(products[i], getRandomNumber(realForecast.get(products[i]) + a, realForecast.get(products[i]) - a));
            }else{
                forecast.put(products[i], getRandomNumber(realForecast.get(products[i]) + a, 0));
            }
        }
        s.setForecast(forecast);
        return s;
    }

    public int getRandomNumber(int max, int min){
        return (int)((Math.random()*(max-min))+min+1);
    }

}