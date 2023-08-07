import java.util.ArrayList;
import java.util.HashMap;

public class Store {

    private int money;
    private int month;
    private int accuracy;
    private String name;
    private String[] products = {"Wired Earbuds", "Wireless Earbuds", "Bluetooth Headphones",
    "Computer Speakers", "Bluetooth Speakers", "Studio Speakers"};
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    private HashMap<String, Integer> prices = new HashMap<String, Integer>();
    private HashMap<String, Integer> orders = new HashMap<String, Integer>();
    private HashMap<String, Integer> realForecast = new HashMap<String, Integer>();
    private HashMap<String, Integer> forecast = new HashMap<String, Integer>();

    public Store(String n){
        name = n;
        money = 1000;
        month = 0;
        accuracy = 5;
        // Initialize Inventory and Starting Prices
        inventory.put("Wired Earbuds", 20);
        inventory.put("Wireless Earbuds", 10);
        inventory.put("Bluetooth Headphones", 5);
        inventory.put("Computer Speakers", 10);
        inventory.put("Bluetooth Speakers", 5);
        inventory.put("Studio Speakers", 1);

        prices.put("Wired Earbuds", 10);
        prices.put("Wireless Earbuds", 20);
        prices.put("Bluetooth Headphones", 50);
        prices.put("Computer Speakers", 30);
        prices.put("Bluetooth Speakers", 60);
        prices.put("Studio Speakers", 200);

        orders.put("Wired Earbuds", 0);
        orders.put("Wireless Earbuds", 0);
        orders.put("Bluetooth Headphones", 0);
        orders.put("Computer Speakers", 0);
        orders.put("Bluetooth Speakers", 0);
        orders.put("Studio Speakers", 0);
    }

    // Reset orders
    public void resetOrders(){
        orders.clear();
        orders.put("Wired Earbuds", 0);
        orders.put("Wireless Earbuds", 0);
        orders.put("Bluetooth Headphones", 0);
        orders.put("Computer Speakers", 0);
        orders.put("Bluetooth Speakers", 0);
        orders.put("Studio Speakers", 0);
    }

    // Get inventory
    public HashMap<String, Integer> getInventory(){return inventory;}

    // Set inventory
    public void setInventory(HashMap<String, Integer> h){
        inventory.clear();
        String[] arr = h.keySet().toArray(new String[h.size()]);
        Integer[] arr2 = h.values().toArray(new Integer[h.size()]);
        for(int i = 0; i < h.size(); i++){
            inventory.put(arr[i], arr2[i]);
        }
    }

    // Get month
    public int getMonth(){return month;}

    // Set month
    public void setMonth(int n){month = n;}

    // Next month
    public void nextMonth(){month+=1;}

    // Get money
    public int getMoney(){return money;}

    // Set money
    public void setMoney(int a){money = a;}

    // Set orders
    public void setOrders(HashMap<String, Integer> h){
        orders.clear();
        String[] arr = h.keySet().toArray(new String[h.size()]);
        Integer[] arr2 = h.values().toArray(new Integer[h.size()]);
        for(int i = 0; i < h.size(); i++){
            orders.put(arr[i], arr2[i]);
        }
    }

    // Set accuracy
    public void setAccuracy(int n){
        accuracy = n;
    }

    // Get accuracy
    public int getAccuracy(){
        return accuracy;
    }

    // Get products
    public String[] getProducts(){
        return products;
    }

    // Get orders
    public HashMap<String, Integer> getOrders(){
        return orders;
    }

    // Get prices
    public HashMap<String, Integer> getPrices(){
        return prices;
    }

    // Get realForecast
    public HashMap<String, Integer> getRealForecast(){
        return realForecast;
    }

    // Set realForecast
    public void setRealForecast(HashMap<String, Integer> h){
        realForecast = h;
    }

    // Get forecast
    public HashMap<String, Integer> getForecast(){
        return forecast;
    }

    // Set forecast
    public void setForecast(HashMap<String, Integer> h){
        forecast = h;
    }

    // Set prices
    public void setPrices(HashMap<String, Integer> h){
        prices = h;
    }

}
