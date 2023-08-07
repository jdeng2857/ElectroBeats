import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MenuPane extends Pane {
    private Button main, purchases, sales, news, q;
    private Label title;

    public MenuPane() {
        Pane innerPane = new Pane();

        // CREATE STORE Title
        title = new Label("ELECTROBEATS");
        title.relocate(25,0);
        title.setPrefSize(250,50);
        title.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,255,255); " + "-fx-text-fill: rgb(0,0,0);");

        // CREATE MENU Buttons
        main = new Button("MAIN");
        main.relocate(850, 0);
        main.setPrefSize(100, 50);
        main.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,127,0); " + "-fx-text-fill: rgb(255,255,255);");

        purchases = new Button("PURCHASES");
        purchases.relocate(350, 0);
        purchases.setPrefSize(200, 50);
        purchases.setStyle("-fx-font: 24 arial; -fx-base: rgb(127,0,0); " + "-fx-text-fill: rgb(255,255,255);");

        sales = new Button("SALES");
        sales.relocate(550, 0);
        sales.setPrefSize(150, 50);
        sales.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,0,127); " + "-fx-text-fill: rgb(255,255,255);");

        news = new Button("NEWS");
        news.relocate(700, 0);
        news.setPrefSize(150, 50);
        news.setStyle("-fx-font: 24 arial; -fx-base: rgb(0,127,127); " + "-fx-text-fill: rgb(255,255,255);");

        q = new Button("?");
        q.relocate(950, 0);
        q.setPrefSize(50, 50);
        q.setStyle("-fx-font: 24 arial; -fx-base: rgb(127,127,0); " + "-fx-text-fill: rgb(255,255,255);");

        innerPane.getChildren().addAll(main, purchases, sales, news, title, q);
        getChildren().addAll(innerPane);
    }

    public Button getMain(){return main;}
    public Button getPurchases(){return purchases;}
    public Button getSales(){return sales;}
    public Button getNews(){return news;}
    public Button getQ(){return q;}
}