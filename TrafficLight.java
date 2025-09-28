import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
    private Circle redLight, yellowLight, greenLight;

    @Override
    public void start(Stage primaryStage) {
        // Traffic light housing (white rectangle with black border)
        Rectangle housing = new Rectangle(80, 200, Color.WHITE);
        housing.setStroke(Color.BLACK);

        // Traffic light circles (start as white with black stroke)
        redLight = new Circle(25, Color.WHITE);
        redLight.setStroke(Color.BLACK);
        yellowLight = new Circle(25, Color.WHITE);
        yellowLight.setStroke(Color.BLACK);
        greenLight = new Circle(25, Color.WHITE);
        greenLight.setStroke(Color.BLACK);

        VBox lightsBox = new VBox(15, redLight, yellowLight, greenLight);
        lightsBox.setAlignment(Pos.CENTER);

        // StackPane so rectangle is behind the lights
        StackPane trafficLight = new StackPane(housing, lightsBox);

        // Radio buttons
        RadioButton redBtn = new RadioButton("Red");
        RadioButton yellowBtn = new RadioButton("Yellow");
        RadioButton greenBtn = new RadioButton("Green");

        ToggleGroup group = new ToggleGroup();
        redBtn.setToggleGroup(group);
        yellowBtn.setToggleGroup(group);
        greenBtn.setToggleGroup(group);

        // Listener for toggle selection
        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == redBtn) {
                setLights(true, false, false);
            } else if (newToggle == yellowBtn) {
                setLights(false, true, false);
            } else if (newToggle == greenBtn) {
                setLights(false, false, true);
            } else { // no selection
                setLights(false, false, false);
            }
        });

        HBox controls = new HBox(15, redBtn, yellowBtn, greenBtn);
        controls.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(trafficLight);
        root.setBottom(controls);

        Scene scene = new Scene(root, 250, 300);
        primaryStage.setTitle("Exercise16_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setLights(boolean r, boolean y, boolean g) {
        redLight.setFill(r ? Color.RED : Color.WHITE);
        yellowLight.setFill(y ? Color.YELLOW : Color.WHITE);
        greenLight.setFill(g ? Color.GREEN : Color.WHITE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
