import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.HashMap;

public class PurchasesPane extends Pane implements RandomGenerator{

    // Declare various GUI objects
    private final Button add1, add2, add3, add4, add5, add6;
    private final Button delete1, delete2, delete3, delete4, delete5, delete6;
    private final Label manufacturerA, manufacturerB, qtyA, qtyB;
    private Label totalA, totalB, total, description, money;
    private final Label t1, t2, t3, t4, t5, t6;
    private int nt1, nt2, nt3, nt4, nt5, nt6;
    private final Label q1, q2, q3, q4, q5, q6;
    private int nq1, nq2, nq3, nq4, nq5, nq6;
    private Button placeOrder;

    private Label costA, costB;
    private int nCostA, nCostB, nTotal;
    private HashMap<String, Integer> cart;
    private ListView<String> mA, mB;

    private String[] itemsA, itemsB;
    private Integer[] pricesA, pricesB;
    private String[] choicesA, choicesB;
    private Store store;
    private String[] productNames;

    public PurchasesPane(Store s) {

        Pane innerPane = new Pane();
        // Initialize variables
        store = s;
        productNames = new String[]{"Wired Earbuds", "Wireless Earbuds","Bluetooth Headphones"
                ,"Computer Speakers","Bluetooth Speakers","Studio Speakers"};
        cart = new HashMap<String, Integer>();
        cart.put("Wired Earbuds",0);
        cart.put("Wireless Earbuds",0);
        cart.put("Bluetooth Headphones",0);
        cart.put("Computer Speakers",0);
        cart.put("Bluetooth Speakers",0);
        cart.put("Studio Speakers",0);

        itemsA = new String[3];
        itemsB = new String[3];
        pricesA = new Integer[3];
        pricesB = new Integer[3];
        choicesA = new String[3];
        choicesB = new String[3];

        nt1 = 0;
        nt2 = 0;
        nt3 = 0;
        nt4 = 0;
        nt5 = 0;
        nt6 = 0;

        t1 = new Label(Integer.toString(nt1));
        t1.setStyle("-fx-font: 12 arial");
        t1.relocate(450,125);

        t2 = new Label(Integer.toString(nt2));
        t2.setStyle("-fx-font: 12 arial");
        t2.relocate(450,150);

        t3 = new Label(Integer.toString(nt3));
        t3.setStyle("-fx-font: 12 arial");
        t3.relocate(450,175);

        t4 = new Label(Integer.toString(nt4));
        t4.setStyle("-fx-font: 12 arial");
        t4.relocate(950,125);

        t5 = new Label(Integer.toString(nt5));
        t5.setStyle("-fx-font: 12 arial");
        t5.relocate(950,150);

        t6 = new Label(Integer.toString(nt6));
        t6.setStyle("-fx-font: 12 arial");
        t6.relocate(950,175);

        nq1 = 0;
        nq2 = 0;
        nq3 = 0;
        nq4 = 0;
        nq5 = 0;
        nq6 = 0;

        q1 = new Label(Integer.toString(nq1));
        q1.setStyle("-fx-font: 12 arial");
        q1.relocate(375,125);

        q2 = new Label(Integer.toString(nq2));
        q2.setStyle("-fx-font: 12 arial");
        q2.relocate(375,150);

        q3 = new Label(Integer.toString(nq3));
        q3.setStyle("-fx-font: 12 arial");
        q3.relocate(375,175);

        q4 = new Label(Integer.toString(nq4));
        q4.setStyle("-fx-font: 12 arial");
        q4.relocate(875,125);

        q5 = new Label(Integer.toString(nq5));
        q5.setStyle("-fx-font: 12 arial");
        q5.relocate(875,150);

        q6 = new Label(Integer.toString(nq6));
        q6.setStyle("-fx-font: 12 arial");
        q6.relocate(875,175);

        nCostA = 0;
        nCostB = 0;
        nTotal = 0;

        costA = new Label("Total A: " + Integer.toString(nCostA));
        costA.setStyle("-fx-font: 24 arial");
        costA.relocate(25,300);

        costB = new Label("Total B: " + Integer.toString(nCostB));
        costB.setStyle("-fx-font: 24 arial");
        costB.relocate(550,300);

        total = new Label("Total: " + Integer.toString(nTotal));
        total.setStyle("-fx-font: 24 arial");
        total.relocate(25,400);

        // Create labels
        manufacturerA = new Label("MANUFACTURER A");
        manufacturerA.setStyle("-fx-font: 24 arial");
        manufacturerA.relocate(25,75);

        qtyA = new Label("QTY");
        qtyA.setStyle("-fx-font: 24 arial");
        qtyA.relocate(350,75);

        totalA = new Label("TOTAL");
        totalA.setStyle("-fx-font: 24 arial");
        totalA.relocate(425,75);

        manufacturerB = new Label("MANUFACTURER B");
        manufacturerB.setStyle("-fx-font: 24 arial");
        manufacturerB.relocate(525,75);

        qtyB = new Label("QTY");
        qtyB.setStyle("-fx-font: 24 arial");
        qtyB.relocate(850,75);

        totalB = new Label("TOTAL");
        totalB.setStyle("-fx-font: 24 arial");
        totalB.relocate(925,75);

        description = new Label("Orders will only appear in inventory in the next month");
        description.setStyle("-fx-font: 18 arial");
        description.relocate(25, 500);

        money = new Label("MONEY: " + Integer.toString(store.getMoney()));
        money.setStyle("-fx-font: 24 arial");
        money.relocate(600,600);

        // Create Buttons
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


        delete1 = new Button("-");
        delete1.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete1.relocate(325, 125);
        delete1.setPrefSize(24,24);

        delete2 = new Button("-");
        delete2.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete2.relocate(325, 150);
        delete2.setPrefSize(24,24);

        delete3 = new Button("-");
        delete3.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete3.relocate(325, 175);
        delete3.setPrefSize(24,24);

        add4 = new Button("+");
        add4.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add4.relocate(800, 125);
        add4.setPrefSize(24,24);

        add5 = new Button("+");
        add5.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add5.relocate(800, 150);
        add5.setPrefSize(24,24);

        add6 = new Button("+");
        add6.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        add6.relocate(800, 175);
        add6.setPrefSize(24,24);

        delete4 = new Button("-");
        delete4.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete4.relocate(825, 125);
        delete4.setPrefSize(24,24);

        delete5 = new Button("-");
        delete5.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete5.relocate(825, 150);
        delete5.setPrefSize(24,24);

        delete6 = new Button("-");
        delete6.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); -fx-text-fill: rgb(0,0,0);");
        delete6.relocate(825, 175);
        delete6.setPrefSize(24,24);

        placeOrder = new Button("PLACE ORDER");
        placeOrder.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,255,0); -fx-text-fill: rgb(255,255,255);");
        placeOrder.relocate(600, 500);
        placeOrder.setPrefSize(300,50);

        // CREATE Button Listeners
        add1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq1 += 1;
                q1.setText(Integer.toString(nq1));
                nt1 += pricesA[0];
                t1.setText(Integer.toString(nt1));
                cart.put(itemsA[0], cart.get(itemsA[0])+1);
                updateTotals();
            }
        });

        add2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq2 += 1;
                q2.setText(Integer.toString(nq2));
                nt2 += pricesA[1];
                t2.setText(Integer.toString(nt2));
                cart.put(itemsA[1], cart.get(itemsA[1])+1);
                updateTotals();
            }
        });

        add3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq3 += 1;
                q3.setText(Integer.toString(nq3));
                nt3 += pricesA[2];
                t3.setText(Integer.toString(nt3));
                cart.put(itemsA[2], cart.get(itemsA[2])+1);
                updateTotals();
            }
        });

        add4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq4 += 1;
                q4.setText(Integer.toString(nq4));
                nt4 += pricesB[0];
                t4.setText(Integer.toString(nt4));
                cart.put(itemsB[0], cart.get(itemsB[0])+1);
                updateTotals();
            }
        });

        add5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq5 += 1;
                q5.setText(Integer.toString(nq5));
                nt5 += pricesB[1];
                t5.setText(Integer.toString(nt5));
                cart.put(itemsB[1], cart.get(itemsB[1])+1);
                updateTotals();
            }
        });

        add6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                nq6 += 1;
                q6.setText(Integer.toString(nq6));
                nt6 += pricesB[2];
                t6.setText(Integer.toString(nt6));
                cart.put(itemsB[2], cart.get(itemsB[2])+1);
                updateTotals();
            }
        });

        delete1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq1 - 1 >= 0) {
                    nq1 -= 1;
                    q1.setText(Integer.toString(nq1));
                    nt1 -= pricesA[0];
                    t1.setText(Integer.toString(nt1));
                    cart.put(itemsA[0], cart.get(itemsA[0])-1);
                    updateTotals();
                }
            }
        });

        delete2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq2 - 1 >= 0) {
                    nq2 -= 1;
                    q2.setText(Integer.toString(nq2));
                    nt2 -= pricesA[1];
                    t2.setText(Integer.toString(nt2));
                    cart.put(itemsA[1], cart.get(itemsA[1])-1);
                    updateTotals();
                }
            }
        });

        delete3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq3 - 1 >= 0) {
                    nq3 -= 1;
                    q3.setText(Integer.toString(nq3));
                    nt3 -= pricesA[2];
                    t3.setText(Integer.toString(nt3));
                    cart.put(itemsA[2], cart.get(itemsA[2])-1);
                    updateTotals();
                }
            }
        });

        delete4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq4 - 1 >= 0) {
                    nq4 -= 1;
                    q4.setText(Integer.toString(nq4));
                    nt4 -= pricesB[0];
                    t4.setText(Integer.toString(nt4));
                    cart.put(itemsB[0], cart.get(itemsB[0])-1);
                    updateTotals();
                }
            }
        });

        delete5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq5 - 1 >= 0) {
                    nq5 -= 1;
                    q5.setText(Integer.toString(nq5));
                    nt5 -= pricesB[1];
                    t5.setText(Integer.toString(nt5));
                    cart.put(itemsB[1], cart.get(itemsB[1])-1);
                    updateTotals();
                }
            }
        });

        delete6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent){
                if(nq6 - 1 >= 0) {
                    nq6 -= 1;
                    q6.setText(Integer.toString(nq6));
                    nt6 -= pricesB[2];
                    t6.setText(Integer.toString(nt6));
                    cart.put(itemsB[2], cart.get(itemsB[2])-1);
                    updateTotals();
                }
            }
        });

        // CREATE Listviews
        mA = new ListView<String>();
        mA.setItems(FXCollections.observableArrayList(choicesA));
        mA.setPrefSize(250,100);
        mA.relocate(25,125);

        mB = new ListView<String>();
        mB.setItems(FXCollections.observableArrayList(choicesB));
        mB.setPrefSize(250,100);
        mB.relocate(525,125);

        innerPane.getChildren().addAll(manufacturerA, manufacturerB,
                mA, mB, qtyA, qtyB, totalA, totalB,
                add1, add2, add3, add4, add5, add6,
                delete1, delete2, delete3, delete4, delete5, delete6,
                t1, t2, t3, t4, t5, t6,
                q1, q2, q3, q4, q5, q6,
                total, costA, costB,
                description, money, placeOrder);
        getChildren().addAll(innerPane);

    }

    public int getNTotal(){
        return nTotal;
    }

    public Store updateMoney(Store s){
        money.setText("MONEY: " + Integer.toString(store.getMoney()));
        return s;
    }

    public void updateTotals(){
        nCostA = nt1 + nt2 + nt3;
        nCostB = nt4 + nt5 + nt6;
        costA.setText("Total A: " + Integer.toString(nCostA));
        costB.setText("Total B: " + Integer.toString(nCostB));
        nTotal = nCostA + nCostB;
        total.setText("Total: " +Integer.toString(nTotal));
    }

    // Reset cart method
    public void reset(){
        cart.clear();
        cart.put("Wired Earbuds",0);
        cart.put("Wireless Earbuds",0);
        cart.put("Bluetooth Headphones",0);
        cart.put("Computer Speakers",0);
        cart.put("Bluetooth Speakers",0);
        cart.put("Studio Speakers",0);

        nt1 = 0;
        nt2 = 0;
        nt3 = 0;
        nt4 = 0;
        nt5 = 0;
        nt6 = 0;

        t1.setText(Integer.toString(nt1));
        t1.setStyle("-fx-font: 12 arial");
        t1.relocate(450,125);

        t2.setText(Integer.toString(nt2));
        t2.setStyle("-fx-font: 12 arial");
        t2.relocate(450,150);

        t3.setText(Integer.toString(nt3));
        t3.setStyle("-fx-font: 12 arial");
        t3.relocate(450,175);

        t4.setText(Integer.toString(nt4));
        t4.setStyle("-fx-font: 12 arial");
        t4.relocate(950,125);

        t5.setText(Integer.toString(nt5));
        t5.setStyle("-fx-font: 12 arial");
        t5.relocate(950,150);

        t6.setText(Integer.toString(nt6));
        t6.setStyle("-fx-font: 12 arial");
        t6.relocate(950,175);

        nq1 = 0;
        nq2 = 0;
        nq3 = 0;
        nq4 = 0;
        nq5 = 0;
        nq6 = 0;

        q1.setText(Integer.toString(nq1));
        q1.setStyle("-fx-font: 12 arial");
        q1.relocate(375,125);

        q2.setText(Integer.toString(nq2));
        q2.setStyle("-fx-font: 12 arial");
        q2.relocate(375,150);

        q3.setText(Integer.toString(nq3));
        q3.setStyle("-fx-font: 12 arial");
        q3.relocate(375,175);

        q4.setText(Integer.toString(nq4));
        q4.setStyle("-fx-font: 12 arial");
        q4.relocate(875,125);

        q5.setText(Integer.toString(nq5));
        q5.setStyle("-fx-font: 12 arial");
        q5.relocate(875,150);

        q6.setText(Integer.toString(nq6));
        q6.setStyle("-fx-font: 12 arial");
        q6.relocate(875,175);

        nCostA = 0;
        nCostB = 0;
        nTotal = 0;

        costA.setText("Total A: " + Integer.toString(nCostA));
        costA.setStyle("-fx-font: 24 arial");
        costA.relocate(25,300);

        costB.setText("Total B: " + Integer.toString(nCostB));
        costB.setStyle("-fx-font: 24 arial");
        costB.relocate(550,300);

        total.setText("Total: " + Integer.toString(nTotal));
        total.setStyle("-fx-font: 24 arial");
        total.relocate(25,400);
    }

    // Get Order list
    public HashMap<String, Integer> getCart(){
        return cart;
    }

    // Get Place Order Button
    public Button getPlaceOrder(){
        return placeOrder;
    }

    // Disables Place Order Button
    public void disable(){
        placeOrder.setDisable(true);
    }

    // Enable Place Order Button
    public void enable(){
        placeOrder.setDisable(false);
    }
    // Resets and randomizes manufacturer prices
    public void reload(){
        int n = 0;
        for(int i = 0; i<3; i++) {
            System.out.println(1);
            n = randomItem();
            setA(n, i);
            System.out.println(2);
            n = randomItem();
            setB(n, i);
        }

        // Update Listviews mA and mB
        for(int i = 0; i<3; i++){
            choicesA[i] = itemsA[i] + ": " + Integer.toString(pricesA[i]) + " each";
            choicesB[i] = itemsB[i] + ": " + Integer.toString(pricesB[i]) + " each";
        }
        mA.setItems(FXCollections.observableArrayList(choicesA));
        mB.setItems(FXCollections.observableArrayList(choicesB));

    }

    public void setA(int n, int i){
        switch(n){
            case 1:
                itemsA[i] = productNames[0];
                pricesA[i] = randomPrice1();
                break;
            case 2:
                itemsA[i] = productNames[1];
                pricesA[i] = randomPrice2();
                break;
            case 3:
                itemsA[i] = productNames[2];
                pricesA[i] = randomPrice3();
                break;
            case 4:
                itemsA[i] = productNames[3];
                pricesA[i] = randomPrice4();
                break;
            case 5:
                itemsA[i] = productNames[4];
                pricesA[i] = randomPrice5();
                break;
            case 6:
                itemsA[i] = productNames[5];
                pricesA[i] = randomPrice6();
                break;
        }
    }

    public void setB(int n, int i){
        switch(n){
            case 1:
                itemsB[i] = productNames[0];
                pricesB[i] = randomPrice1();
                break;
            case 2:
                itemsB[i] = productNames[1];
                pricesB[i] = randomPrice2();
                break;
            case 3:
                itemsB[i] = productNames[2];
                pricesB[i] = randomPrice3();
                break;
            case 4:
                itemsB[i] = productNames[3];
                pricesB[i] = randomPrice4();
                break;
            case 5:
                itemsB[i] = productNames[4];
                pricesB[i] = randomPrice5();
                break;
            case 6:
                itemsB[i] = productNames[5];
                pricesB[i] = randomPrice6();
                break;
        }
    }

    // Random number generators for item selection and prices
    public int randomItem(){
        return getRandomNumber(0,6);
    }

    public int randomPrice1(){
        return getRandomNumber(1,5);
    }

    public int randomPrice2(){
        return getRandomNumber(2,10);
    }

    public int randomPrice3(){
        return getRandomNumber(5,20);
    }

    public int randomPrice4(){
        return getRandomNumber(3,12);
    }

    public int randomPrice5(){
        return getRandomNumber(8,25);
    }

    public int randomPrice6(){
        return getRandomNumber(15,50);
    }

    public int getRandomNumber(int min, int max){
        return (int)((Math.random()*(max-min))+min+1);
    }

}