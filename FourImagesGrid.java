import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FourImagesGrid extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);  // horizontal gap between cells
        grid.setVgap(10);  // vertical gap between cells
        grid.setAlignment(Pos.CENTER);

        // Load images and create ImageViews
        ImageView img1 = new ImageView(new Image(getClass().getResource("image1.png").toExternalForm()));
        ImageView img2 = new ImageView(new Image(getClass().getResource("image2.png").toExternalForm()));
        ImageView img3 = new ImageView(new Image(getClass().getResource("image3.png").toExternalForm()));
        ImageView img4 = new ImageView(new Image(getClass().getResource("image4.png").toExternalForm()));

        // Set a preferred size for images
        double size = 200;
        for (ImageView iv : new ImageView[]{img1, img2, img3, img4}) {
            iv.setFitWidth(size);
            iv.setFitHeight(size);
            iv.setPreserveRatio(true);
        }

        // Add images to grid (col, row)
        grid.add(img1, 0, 0);
        grid.add(img2, 1, 0);
        grid.add(img3, 0, 1);
        grid.add(img4, 1, 1);

        // Create a scene and display it
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Four Images in a GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
