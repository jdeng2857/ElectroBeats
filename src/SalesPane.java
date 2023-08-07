import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.HashMap;

public class SalesPane extends Pane {
    private Button add1, add2, add3, add4, add5, add6;
    private Button delete1, delete2, delete3, delete4, delete5, delete6;
    private Label l1, l2, l3, l4, l5, l6;
    private Label changePricing;
    private Store store;
    private Integer[] prices;
    private String[] products;
    private HashMap<String, Integer> newPrices;

    public SalesPane(Store s) {
        Pane innerPane = new Pane();
        store = s;
        products = store.getPrices().keySet().toArray(new String[store.getPrices().size()]);
        prices = store.getPrices().values().toArray(new Integer[store.getPrices().size()]);
        newPrices = store.getPrices();

        // Create label
        changePricing = new Label("CHANGE PRICING");
        changePricing.relocate(25,75);
        changePricing.setStyle("-fx-font: 24 arial;");

        // Create labels
        l1 = new Label(products[0]+": " + Integer.toString(prices[0]) + " dollars");
        l1.relocate(25,125);
        l1.setStyle("-fx-font: 12 arial;");

        l2 = new Label(products[1]+": " + Integer.toString(prices[1]) + " dollars");
        l2.relocate(25,150);
        l2.setStyle("-fx-font: 12 arial;");

        l3 = new Label(products[2]+": " + Integer.toString(prices[2]) + " dollars");
        l3.relocate(25,175);
        l3.setStyle("-fx-font: 12 arial;");

        l4 = new Label(products[3]+": " + Integer.toString(prices[3]) + " dollars");
        l4.relocate(25,200);
        l4.setStyle("-fx-font: 12 arial;");

        l5 = new Label(products[4]+": " + Integer.toString(prices[4]) + " dollars");
        l5.relocate(25,225);
        l5.setStyle("-fx-font: 12 arial;");

        l6 = new Label(products[5]+": " + Integer.toString(prices[5]) + " dollars");
        l6.relocate(25,250);
        l6.setStyle("-fx-font: 12 arial;");

        // Create buttons
        add1 = new Button("+");
        add1.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add1.relocate(300, 125);
        add1.setPrefSize(24,24);

        add2 = new Button("+");
        add2.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add2.relocate(300, 150);
        add2.setPrefSize(24,24);

        add3 = new Button("+");
        add3.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add3.relocate(300, 175);
        add3.setPrefSize(24,24);

        add4 = new Button("+");
        add4.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add4.relocate(300, 200);
        add4.setPrefSize(24,24);

        add5 = new Button("+");
        add5.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add5.relocate(300, 225);
        add5.setPrefSize(24,24);

        add6 = new Button("+");
        add6.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add6.relocate(300, 250);
        add6.setPrefSize(24,24);

        delete1 = new Button("-");
        delete1.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete1.relocate(350, 125);
        delete1.setPrefSize(24,24);

        delete2 = new Button("-");
        delete2.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete2.relocate(350, 150);
        delete2.setPrefSize(24,24);

        delete3 = new Button("-");
        delete3.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete3.relocate(350, 175);
        delete3.setPrefSize(24,24);

        delete4 = new Button("-");
        delete4.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete4.relocate(350, 200);
        delete4.setPrefSize(24,24);

        delete5 = new Button("-");
        delete5.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete5.relocate(350, 225);
        delete5.setPrefSize(24,24);

        delete6 = new Button("-");
        delete6.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete6.relocate(350, 250);
        delete6.setPrefSize(24,24);
/*
        // Add button listeners
        add1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[0] += 1;
                l1.setText(products[0] + ": " + Integer.toString(prices[0]) + " dollars");
                newPrices.put(products[0], prices[0]);
            }
        });

        add2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[1] += 1;
                l2.setText(products[1] + ": " + Integer.toString(prices[1]) + " dollars");
                newPrices.put(products[1], prices[1]);
            }
        });

        add3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[2] += 1;
                l3.setText(products[2] + ": " + Integer.toString(prices[2]) + " dollars");
                newPrices.put(products[2], prices[2]);
            }
        });

        add4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[3] += 1;
                l4.setText(products[3] + ": " + Integer.toString(prices[3]) + " dollars");
            }
        });

        add5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[4] += 1;
                l5.setText(products[4] + ": " + Integer.toString(prices[4]) + " dollars");
            }
        });

        add6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                prices[5] += 1;
                l6.setText(products[5] + ": " + Integer.toString(prices[5]) + " dollars");
            }
        });

        delete1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[0] - 1>=0) {
                    prices[0] -= 1;
                    l1.setText(products[0] + ": " + Integer.toString(prices[0]) + " dollars");
                }
            }
        });

        delete2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[1] - 1>=0) {
                    prices[1] -= 1;
                    l2.setText(products[1] + ": " + Integer.toString(prices[1]) + " dollars");
                }
            }
        });

        delete3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[2] - 1>=0) {
                    prices[2] -= 1;
                    l3.setText(products[2] + ": " + Integer.toString(prices[2]) + " dollars");
                }
            }
        });

        delete4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[3] - 1>=0) {
                    prices[3] -= 1;
                    l4.setText(products[3] + ": " + Integer.toString(prices[3]) + " dollars");
                }
            }
        });

        delete5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[4] - 1>=0) {
                    prices[4] -= 1;
                    l5.setText(products[4] + ": " + Integer.toString(prices[4]) + " dollars");
                }
            }
        });

        delete6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(prices[5] - 1>=0) {
                    prices[5] -= 1;
                    l6.setText(products[5] + ": " + Integer.toString(prices[5]) + " dollars");
                }
            }
        });
*/
        innerPane.getChildren().addAll(changePricing, l1, l2, l3, l4, l5, l6,
                add1, add2, add3, add4, add5, add6,
                delete1, delete2, delete3, delete4, delete5, delete6);
        getChildren().addAll(innerPane);
    }

    public HashMap<String, Integer> getNewPrices(){
        return newPrices;
    }

    //Get methods
    public String[] getProducts(){return products;}

    public Integer[] getPrices(){return prices;}

    public Label getL1(){return l1;}

    public Label getL2(){return l2;}

    public Label getL3(){return l3;}

    public Label getL4(){return l4;}

    public Label getL5(){return l5;}

    public Label getL6(){return l6;}

    public Button getAdd1(){return add1;}

    public Button getAdd2(){return add2;}

    public Button getAdd3(){return add3;}

    public Button getAdd4(){return add4;}

    public Button getAdd5(){return add5;}

    public Button getAdd6(){return add6;}

    public Button getDelete1(){return delete1;}

    public Button getDelete2(){return delete2;}

    public Button getDelete3(){return delete3;}

    public Button getDelete4(){return delete4;}

    public Button getDelete5(){return delete5;}

    public Button getDelete6(){return delete6;}

}