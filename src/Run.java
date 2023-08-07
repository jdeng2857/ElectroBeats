import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;

public class Run extends Application{

    Store s = new Store("ELECTROBEATS");
    private HashMap<String, Integer> realForecast;
    private Dialog<String> d;

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        d = new Dialog<String>();
        d.setTitle("How to Play");
        d.setContentText("The goal is to make as much money as possible during the 12 months you'll be selling products. \n" +
                "Purchase products that you need and sell them off to make a profit \n" +
                "You can only place up to one order every month, so choose wisely \n" +
                "The news section shows the potential sales forecast for the next month, although they might be off a bit! \n" +
                "NOTE: This the first version of the game, where the prices are capped at 250, so if you charge more than 250 for any product, you will get no sales for that product!");
        ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(type);
        d.setResizable(true);

        // Create main pane and add it to application
        MainPane main = new MainPane(s);
        main.relocate(0,0);
        main.setVisible(true);
        aPane.getChildren().add(main);
        System.out.println("Main Pane Added");

        // Create purchases pane and add it to application
        PurchasesPane purchases = new PurchasesPane(s);
        purchases.relocate(0,0);
        purchases.setVisible(false);
        aPane.getChildren().add(purchases);
        purchases.reload();
        System.out.println("Purchases Pane Added");

        // Create menu pane and add it to application
        MenuPane menu = new MenuPane();
        menu.relocate(0,0);
        menu.setVisible(true);
        aPane.getChildren().add(menu);
        System.out.println("Menu Pane Added");

        // Create sales pane and add it to application
        SalesPane sales = new SalesPane(s);
        sales.relocate(0,0);
        sales.setVisible(false);
        aPane.getChildren().add(sales);
        System.out.println("Sales Pane Added");

        // Create news pane and add it to application
        NewsPane news = new NewsPane(s);
        news.relocate(0,0);
        news.setVisible(false);
        aPane.getChildren().add(news);
        System.out.println("News Pane Added");

        // Create month pane and add it to application
        MonthPane month = new MonthPane(s);
        month.relocate(0,0);
        month.setVisible(false);
        aPane.getChildren().add(month);
        System.out.println("Month Pane Added");

        // Create victory pane
        VictoryPane victory = new VictoryPane(s);
        victory.relocate(0,0);
        victory.setVisible(false);
        aPane.getChildren().add(victory);
        System.out.println("Victory Pane Added");


        // Create Button Listeners to Main Pane
        main.getQuit().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                Platform.exit();
                System.exit(0);
            }
        });

        // Create Button Listeners to Menu Pane
        menu.getMain().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                menu.setVisible(false);
                main.setVisible(false);
                sales.setVisible(false);
                news.setVisible(false);
                purchases.setVisible(false);
                month.setVisible(false);
                main.setVisible(true);
                menu.setVisible(true);
            }
        });

        menu.getPurchases().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                purchases.setVisible(false);
                menu.setVisible(false);
                sales.setVisible(false);
                news.setVisible(false);
                main.setVisible(false);
                month.setVisible(false);
                purchases.setVisible(true);
                menu.setVisible(true);
            }
        });

        menu.getSales().setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                sales.setVisible(false);
                menu.setVisible(false);
                news.setVisible(false);
                main.setVisible(false);
                month.setVisible(false);
                purchases.setVisible(false);
                sales.setVisible(true);
                menu.setVisible(true);
            }
        }));

        menu.getNews().setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                news.setVisible(false);
                menu.setVisible(false);
                main.setVisible(false);
                month.setVisible(false);
                purchases.setVisible(false);
                sales.setVisible(false);
                news.setVisible(true);
                menu.setVisible(true);
            }
        }));

        menu.getQ().setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                d.showAndWait();
            }
        }));


        // Create Button Listeners to Purchases Pane
        purchases.getPlaceOrder().setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if(purchases.getNTotal() <= s.getMoney()) {
                    s.setOrders(purchases.getCart());
                    s.setMoney(s.getMoney() - purchases.getNTotal());
                    main.updateMoney(s);
                    purchases.updateMoney(s);
                    String[] o = s.getOrders().keySet().toArray(new String[s.getOrders().size()]);
                    Integer[] q = s.getOrders().values().toArray(new Integer[s.getOrders().size()]);
                    String[] ord = new String[s.getOrders().size()];
                    for (int i = 0; i < s.getOrders().size(); i++) {
                        ord[i] = "";
                        ord[i] += o[i];
                        ord[i] += ": ";
                        ord[i] += Integer.toString(q[i]);
                    }
                    main.orders.setItems(FXCollections.observableArrayList(ord));
                    purchases.disable();
                    purchases.reset();
                }else{
                    System.out.println("You don't have enough moeny");
                }
            }
        });

        // Create Button Listeners to Sales Pane
        sales.getAdd1().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[0] += 1;
                sales.getL1().setText(sales.getProducts()[0] + ": " + Integer.toString(sales.getPrices()[0]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[0], sales.getPrices()[0]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getAdd2().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[1] += 1;
                sales.getL2().setText(sales.getProducts()[1] + ": " + Integer.toString(sales.getPrices()[1]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[1], sales.getPrices()[1]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getAdd3().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[2] += 1;
                sales.getL3().setText(sales.getProducts()[2] + ": " + Integer.toString(sales.getPrices()[2]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[2], sales.getPrices()[2]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getAdd4().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[3] += 1;
                sales.getL4().setText(sales.getProducts()[3] + ": " + Integer.toString(sales.getPrices()[3]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[3], sales.getPrices()[3]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getAdd5().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[4] += 1;
                sales.getL5().setText(sales.getProducts()[4] + ": " + Integer.toString(sales.getPrices()[4]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[4], sales.getPrices()[4]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getAdd6().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                sales.getPrices()[5] += 1;
                sales.getL6().setText(sales.getProducts()[5] + ": " + Integer.toString(sales.getPrices()[5]) + " dollars");
                sales.getNewPrices().put(sales.getProducts()[5], sales.getPrices()[5]);
                main.updatePrices(s, sales.getNewPrices());
            }
        });

        sales.getDelete1().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[0] - 1>=0) {
                    sales.getPrices()[0] -= 1;
                    sales.getL1().setText(sales.getProducts()[0] + ": " + Integer.toString(sales.getPrices()[0]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[0], sales.getPrices()[0]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        sales.getDelete2().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[1] - 1>=0) {
                    sales.getPrices()[1] -= 1;
                    sales.getL2().setText(sales.getProducts()[1] + ": " + Integer.toString(sales.getPrices()[1]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[1], sales.getPrices()[1]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        sales.getDelete3().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[2] - 1>=0) {
                    sales.getPrices()[2] -= 1;
                    sales.getL3().setText(sales.getProducts()[2] + ": " + Integer.toString(sales.getPrices()[2]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[2], sales.getPrices()[2]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        sales.getDelete4().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[3] - 1>=0) {
                    sales.getPrices()[3] -= 1;
                    sales.getL4().setText(sales.getProducts()[3] + ": " + Integer.toString(sales.getPrices()[3]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[3], sales.getPrices()[3]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        sales.getDelete5().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[4] - 1>=0) {
                    sales.getPrices()[4] -= 1;
                    sales.getL5().setText(sales.getProducts()[4] + ": " + Integer.toString(sales.getPrices()[4]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[4], sales.getPrices()[4]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        sales.getDelete6().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(sales.getPrices()[5] - 1>=0) {
                    sales.getPrices()[5] -= 1;
                    sales.getL6().setText(sales.getProducts()[5] + ": " + Integer.toString(sales.getPrices()[5]) + " dollars");
                    sales.getNewPrices().put(sales.getProducts()[5], sales.getPrices()[5]);
                    main.updatePrices(s, sales.getNewPrices());
                }
            }
        });

        // Create button listener for Start Month
        main.getStartMonth().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                month.updateMonth(s);
                s = month.update(s);
                news.setVisible(false);
                menu.setVisible(false);
                main.setVisible(false);
                month.setVisible(false);
                purchases.setVisible(false);
                sales.setVisible(false);
                month.setVisible(true);
            }
        });

        // Create button listener for Month Pane
        month.getNext().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                System.out.println(s.getMoney());
                s.setMonth(s.getMonth()+1);
                main.updateMonth(s,s.getMonth()+1);
                s = main.updateMoney(s);
                s = main.updateInventory(s);
                s = main.updateOrders(s);
                s = news.generateRealForecast(s);
                s = news.generateForecast(s,5);
                s = purchases.updateMoney(s);
                purchases.enable();
                if(s.getMonth() >= 12) {
                    news.setVisible(false);
                    menu.setVisible(false);
                    main.setVisible(false);
                    month.setVisible(false);
                    purchases.setVisible(false);
                    sales.setVisible(false);
                    victory.update(s);
                    victory.setVisible(true);
                }else {
                    news.setVisible(false);
                    menu.setVisible(false);
                    main.setVisible(false);
                    month.setVisible(false);
                    purchases.setVisible(false);
                    sales.setVisible(false);
                    main.setVisible(true);
                    menu.setVisible(true);
                }
            }
        });

        // Create button listener to victory pane
        victory.getExit().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                Platform.exit();
                System.exit(0);
            }
        });

        Scene scene = new Scene(aPane, 1025,650);
        primaryStage.setTitle("ELECTROBEATS");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}