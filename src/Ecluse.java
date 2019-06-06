import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Ecluse extends Application {
    Pane pane;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();
        scene = new Scene(pane, 1100, 650);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
