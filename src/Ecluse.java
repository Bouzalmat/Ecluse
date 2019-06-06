import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Ecluse extends Application {
    Pane pane;
    Scene scene;
    Resources res;
    int sens = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();
        scene = new Scene(pane, GlobalVars.WINDOW_WIDTH, GlobalVars.WINDOW_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        initResourses(sens);
        initWorld();
    }

    private void initResourses(int sens) {
        res = new Resources();
        res.loadResourses(sens);
    }

    public void initWorld() {
        addObjects(res.backgroundView, res.boatView, res.firstDoorView, res.secondDoorView, res.sasView, res.firstValveView, res.secondValveView);
    }

    private void addObjects(Node... n) {
        pane.getChildren().addAll(n);
    }

    private void addObjects(Node n) {
        pane.getChildren().add(0, n);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
