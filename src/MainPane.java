import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.HashMap;

public class MainPane extends Pane implements Money{
    private Store store;
    public ListView<String> i, orders, prices;
    private Button startMonth, quit;
    private Label money;
    private String[] products = {"Wired Earbuds", "Wireless Earbuds",
            "Bluetooth Headphones", "Computer Speakers", "Bluetooth Speakers", "Studio Speakers"};
    private Label l1, l2, l3, month;
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();

    public MainPane(Store s) {
        Pane innerPane = new Pane();
        store = s;

        // CREATE Labels
        l1 = new Label("INVENTORY");
        l1.setStyle("-fx-font: 24 arial");
        l1.relocate(25,75);

        l2 = new Label("ORDERS");
        l2.setStyle("-fx-font: 24 arial");
        l2.relocate(275,75);

        l3 = new Label("PRICES");
        l3.setStyle("-fx-font: 24 arial");
        l3.relocate(525,75);

        month = new Label("MONTH: " + Integer.toString(store.getMonth()));
        month.setStyle("-fx-font: 24 arial");
        month.relocate(25,550);

        // CREATE Start Month Button
        startMonth = new Button("START MONTH");
        startMonth.setPrefSize(300,50);
        startMonth.relocate(600, 550);
        startMonth.setStyle("-fx-font: 24 arial; -fx-base: rgb(127,127,0); -fx-text-fill: rgb(0,0,0);");

        quit = new Button("QUIT");
        quit.setPrefSize(200,50);
        quit.relocate(600, 475);
        quit.setStyle("-fx-font: 24 arial; -fx-base: rgb(255,0,0); -fx-text-fill: rgb(0,0,0);");

        money = new Label("MONEY: " + Integer.toString(store.getMoney()));
        money.setStyle("-fx-font: 24 arial");
        money.relocate(25,500);

        // CREATE Inventory Listview
        inventory = store.getInventory();
        String[] products = inventory.keySet().toArray(new String[6]);
        Integer[] quantities = inventory.values().toArray(new Integer[products.length]);

        String[] items = new String[products.length];
        for(int i = 0; i< products.length; i++){
            items[i] = "";
            items[i] += products[i];
            items[i] += ": ";
            items[i] += quantities[i];
        }

        i = new ListView<String>();
        i.setItems(FXCollections.observableArrayList(items));
        i.relocate(25,125);
        i.setPrefSize(200,300);

        System.out.println("Creating orders listview");
        // CREATE Orders Listview
        String[] o = store.getOrders().keySet().toArray(new String[store.getOrders().size()]);
        Integer[] q = store.getOrders().values().toArray(new Integer[store.getOrders().size()]);
        String[] ord = new String[store.getOrders().size()];
        for(int i = 0; i < store.getOrders().size(); i++){
            ord[i] = "";
            ord[i] += o[i];
            ord[i] += ": ";
            ord[i] += Integer.toString(q[i]);
        }
        orders = new ListView<String>();
        orders.setItems(FXCollections.observableArrayList(ord));
        orders.relocate(275,125);
        orders.setPrefSize(200,300);

        // CREATE Prices Listview
        Integer[] price = store.getPrices().values().toArray(new Integer[store.getPrices().size()]);
        String[] p = new String[products.length];
        for(int i = 0; i<products.length; i++){
            p[i] = "";
            p[i] += products[i];
            p[i] += ": ";
            p[i] += Integer.toString(price[i]);
            p[i] += " dollars";
        }

        prices = new ListView<String>();
        prices.setItems(FXCollections.observableArrayList(p));
        prices.relocate(525,125);
        prices.setPrefSize(200,300);


        innerPane.getChildren().addAll(i, prices, orders, l1, l2, l3, month, startMonth, money, quit);
        getChildren().addAll(innerPane);
    }

    public Store updateOrders(Store s){
        String[] o = s.getOrders().keySet().toArray(new String[s.getOrders().size()]);
        Integer[] q = s.getOrders().values().toArray(new Integer[s.getOrders().size()]);
        String[] ord = new String[s.getOrders().size()];
        for(int i = 0; i < s.getOrders().size(); i++){
            ord[i] = "";
            ord[i] += o[i];
            ord[i] += ": ";
            ord[i] += Integer.toString(q[i]);
        }
        orders.setItems(FXCollections.observableArrayList(ord));
        return s;
    }

    public void updateMonth(Store s, int n){
        month.setText("MONTH: " + Integer.toString(s.getMonth()));
    }

    public void updatePrices(Store s, HashMap<String, Integer> h){
        s.setPrices(h);
        Integer[] price = s.getPrices().values().toArray(new Integer[store.getPrices().size()]);
        String[] p = new String[6];
        for(int i = 0; i<6; i++){
            p[i] = "";
            p[i] += products[i];
            p[i] += ": ";
            p[i] += Integer.toString(price[i]);
            p[i] += " dollars";
        }
        prices.setItems(FXCollections.observableArrayList(p));
    }

    public Store updateMoney(Store s){

        money.setText("MONEY: " + Integer.toString(s.getMoney()));
        return s;
    }

    public Button getStartMonth(){
        return startMonth;
    }

    public Store updateInventory(Store s){
        inventory = s.getInventory();
        String[] products = inventory.keySet().toArray(new String[6]);
        Integer[] quantities = inventory.values().toArray(new Integer[products.length]);

        String[] items = new String[products.length];
        for(int i = 0; i< products.length; i++){
            items[i] = "";
            items[i] += products[i];
            items[i] += ": ";
            items[i] += quantities[i];
        }
        i.setItems(FXCollections.observableArrayList(items));
        return s;
    }

    public Button getQuit(){
        return quit;
    }
}