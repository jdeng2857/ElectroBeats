import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class VictoryPane extends Pane {

    private Button exit;
    private Label summary;
    private Store store;

    public VictoryPane(Store s){
        Pane innerPane = new Pane();
        store = s;

        exit = new Button("EXIT");
        exit.setPrefSize(100,50);
        exit.setStyle("-fx-font: 24 arial; -fx-base: rgb(127,127,0); " + "-fx-text-fill: rgb(255,255,255);");
        exit.relocate(500,500);

        summary = new Label();

        innerPane.getChildren().addAll(summary, exit);
        getChildren().addAll(innerPane);
    }

    public Button getExit(){return exit;}

    public void update(Store s){
        exit.setText("EXIT");
        exit.setPrefSize(100,50);
        exit.setStyle("-fx-font: 24 arial; -fx-base: rgb(127,127,0); " + "-fx-text-fill: rgb(255,255,255);");
        exit.relocate(500,500);

        summary = new Label();
        String str = Integer.toString(s.getMoney()-1000);
        String str2 = Integer.toString(1000-s.getMoney());
        System.out.println(s.getMoney());
        System.out.println(str);
        if(s.getMoney() >= 1000) {
            summary.setText("Congratulations! \n" + "You have made " + str + " in profit!");
        }else{
            summary.setText("OH NO! \n" +
                    "You have losses of " + str2 +"\n" +
                    "You will do better next time!");
        }
        summary.relocate(50,50);
        summary.setStyle("-fx-font: 24 arial;");

        this.getChildren().add(summary);
    }
}
