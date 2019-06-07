import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.GlobalVars;
import utils.Strings;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Ecluse extends Application {
    BorderPane root;
    Scene scene;
    Pane center;
    Resources res;
    int sens = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        center = new Pane();
        scene = new Scene(root, GlobalVars.WINDOW_WIDTH, GlobalVars.WINDOW_HEIGHT);


        MenuBar menubar = new MenuBar(); //creating MenuBar
        //creating Menu
        Menu direction = new Menu(Strings.DIRECTION_MENU);
        Menu mode = new Menu(Strings.MODE_MENU);
        //creating Menus Items
        MenuItem avalToAmantItem = new MenuItem(Strings.DIRECTION_ITEM1);
        MenuItem amantToAvalItem = new MenuItem(Strings.DIRECTION_ITEM2);
        MenuItem manualMode = new MenuItem(Strings.MODE_ITEM2);
        MenuItem autoMode = new MenuItem(Strings.MODE_ITEM1);

        //adding Menu Items to the Menu
        direction.getItems().addAll(avalToAmantItem, amantToAvalItem);
        mode.getItems().addAll(manualMode, autoMode);

        //adding Menu to the MenuBar
        menubar.getMenus().addAll(direction, mode);

        // actions events
        EventHandler<ActionEvent> avalToAmantEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                sens = -1;
                initResourses(sens);
                initWorld();
            }
        };

        EventHandler<ActionEvent> amantToAvalEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                sens = 1;
                initResourses(sens);
                initWorld();
            }
        };


        // add event
        avalToAmantItem.setOnAction(avalToAmantEvent);
        amantToAvalItem.setOnAction(amantToAvalEvent);

        root.setTop(menubar);
        root.setCenter(center);

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
        center.getChildren().addAll(n);
    }

    private void addObjects(Node n) {
        center.getChildren().add(0, n);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
