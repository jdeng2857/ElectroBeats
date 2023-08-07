import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class MonthPane extends Pane {

    private Button next;
    private Label summary;
    private ListView<String> sales, pSales;
    private String[] products, arr, potentialSales;
    private Integer[] qty, prices, inventory, orders, potential;
    private Store store;
    private int total = 0;
    private Label t;
    private HashMap<String, Integer> newInventory = new HashMap<String, Integer>();
    private HashMap<String, Integer> newOrders = new HashMap<String, Integer>();
    private int maxPrice = 250;

    public MonthPane(Store s){
        Pane innerPane = new Pane();

        store = s;
        sales = new ListView<String>();
        t = new Label("Total: ");
        potential = new Integer[6];
        potentialSales = new String[6];
        summary = new Label("MONTH SUMMARY");
        summary.relocate(25,25);
        summary.setStyle("-fx-font: 30 arial;");

        next = new Button("CONTINUE");
        next.relocate(0, 500);
        next.setPrefSize(300, 50);
        next.setStyle("-fx-font: 24 arial; -fx-base: rgb(255,0,255); " + "-fx-text-fill: rgb(255,255,255);");

        innerPane.getChildren().addAll(next, summary);
        getChildren().addAll(innerPane);
    }

    public void updateMonth(Store s){
        summary = new Label("MONTH " + Integer.toString(s.getMonth()) + " SUMMARY");
    }

    public Button getNext(){
        return next;
    }

    public Store update(Store s){
        newInventory.clear();
        newOrders.clear();
        potentialSales = new String[6];
        potential = new Integer[6];
        potential = s.getRealForecast().values().toArray(new Integer[6]);

        arr = new String[6];
        products = s.getRealForecast().keySet().toArray(new String[6]);
        qty = s.getRealForecast().values().toArray(new Integer[6]);
        prices = s.getPrices().values().toArray(new Integer[6]);
        inventory = s.getInventory().values().toArray(new Integer[6]);
        orders = s.getOrders().values().toArray(new Integer[6]);
        System.out.println("Store Inventory"+Integer.toString(s.getInventory().size()));
        System.out.println("Inventory: "+Integer.toString(inventory.length));
        for(int i = 0; i<products.length; i++) {

            if(prices[i]>maxPrice){
                arr[i] = "Prices are too high!";
            }else if(inventory[i]-qty[i] >= 0) {
                inventory[i] -= qty[i];
                s.setMoney(s.getMoney() + prices[i] * qty[i]);
                arr[i] = products[i] + ": " + Integer.toString(qty[i]) + " sold for a total of " + Integer.toString(prices[i] * qty[i]);

                total += prices[i] * qty[i];
            }else{

                s.setMoney(s.getMoney() + prices[i]*inventory[i]);
                arr[i] = products[i] + ": " + Integer.toString(inventory[i]) + " sold for a total of " + Integer.toString(prices[i] * inventory[i]);

                total += prices[i] * inventory[i];
                inventory[i] =0;
            }
            inventory[i] += orders[i];
            newInventory.put(products[i], inventory[i]);
            newOrders.put(products[i], 0);
        }
        System.out.println("New Inventory: "+Integer.toString(newInventory.size()));
        s.setOrders(newOrders);
        s.setInventory(newInventory);

        sales = new ListView<String>();
        sales.setItems(FXCollections.observableArrayList(arr));
        sales.setPrefSize(300,300);
        sales.relocate(25,125);
        this.getChildren().add(sales);

        for(int i = 0; i<6; i++){
            potentialSales[i] = "Potential: " + Integer.toString(potential[i]) + " sold";
        }

        pSales = new ListView<String>();
        pSales.setItems(FXCollections.observableArrayList(potentialSales));
        pSales.setPrefSize(300,300);
        pSales.relocate(425,125);
        this.getChildren().add(pSales);
        return s;
    }
}
