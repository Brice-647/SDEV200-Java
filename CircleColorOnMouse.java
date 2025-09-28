import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColorOnMouse extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a circle
        Circle circle = new Circle(100, Color.WHITE);

        // Handle mouse press → black
        circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));

        // Handle mouse release → white
        circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        // Layout
        StackPane root = new StackPane(circle);

        // Scene
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Circle Color Change with Mouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
