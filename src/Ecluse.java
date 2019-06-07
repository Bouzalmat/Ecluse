import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    BorderPane controlPane;
    GridPane buttonsAvalPane;
    GridPane buttonsAmontPane;
    Resources res;
    int sens = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        center = new Pane();
        controlPane = new BorderPane();
        scene = new Scene(root, GlobalVars.WINDOW_WIDTH, GlobalVars.WINDOW_HEIGHT);

        //creating MenuBar
        MenuBar menubar = new MenuBar();
        //creating Menus
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

        // Add menu event
        avalToAmantItem.setOnAction(avalToAmantEvent);
        amantToAvalItem.setOnAction(amantToAvalEvent);


        // Initialize AvalPane
        buttonsAvalPane = new GridPane();
        buttonsAvalPane.setHgap(10);
        buttonsAvalPane.setVgap(10);

        // Initialize AmontPane
        buttonsAmontPane = new GridPane();
        buttonsAmontPane.setHgap(10);
        buttonsAmontPane.setVgap(10);

        //AvalPane labels
        Label avalLabel = new Label("Aval");
        Label lightLabel = new Label("Feu");
        Label doorLabel = new Label("Porte");
        Label valveLabel = new Label("Vanne");

        //AmontPane labels
        Label amontLabel = new Label("Amont");
        Label amontLightLabel = new Label("Feu");
        Label amontDoorLabel = new Label("Porte");
        Label amontValveLabel = new Label("Vanne");

        // AvalPane buttons
        Button openFirstAvalValve = new Button("Ouvrir");
        Button closeFirstAvalValve = new Button("Fermer");
        Button openFirstAvalDoor = new Button("Ouvrir");
        Button closeFirstAvalDoor = new Button("Fermer");
        Button lightAvalOn = new Button("Allumer");
        Button lightAvalOff = new Button("Eteindre");

        // AmontPane buttons
        Button openFirstAmontValve = new Button("Ouvrir");
        Button closeFirstAmontValve = new Button("Fermer");
        Button openFirstAmontDoor = new Button("Ouvrir");
        Button closeFirstAmontDoor = new Button("Fermer");
        Button lightAmontOn = new Button("Allumer");
        Button lightAmontOff = new Button("Eteindre");

        // Add labels and buttons to AvalPane
        buttonsAvalPane.add(avalLabel,1,1);
        buttonsAvalPane.add(valveLabel,1,2);
        buttonsAvalPane.add(doorLabel,1,3);
        buttonsAvalPane.add(lightLabel,1,4);
        buttonsAvalPane.add(openFirstAvalValve,2,2);
        buttonsAvalPane.add(closeFirstAvalValve,3,2);
        buttonsAvalPane.add(openFirstAvalDoor,2,3);
        buttonsAvalPane.add(closeFirstAvalDoor,3,3);
        buttonsAvalPane.add(lightAvalOn,2,4);
        buttonsAvalPane.add(lightAvalOff,3,4);

        // Add labels and buttons to AmontPane
        buttonsAmontPane.add(amontLabel,1,1);
        buttonsAmontPane.add(amontLightLabel,1,2);
        buttonsAmontPane.add(amontDoorLabel,1,3);
        buttonsAmontPane.add(amontValveLabel,1,4);
        buttonsAmontPane.add(openFirstAmontValve,2,2);
        buttonsAmontPane.add(closeFirstAmontValve,3,2);
        buttonsAmontPane.add(openFirstAmontDoor,2,3);
        buttonsAmontPane.add(closeFirstAmontDoor,3,3);
        buttonsAmontPane.add(lightAmontOn,2,4);
        buttonsAmontPane.add(lightAmontOff,3,4);


        root.setTop(menubar);
        root.setCenter(center);
        root.setBottom(controlPane);

        primaryStage.setScene(scene);
        primaryStage.show();

        initResourses(sens);
        initConrolPanel();
        initWorld();
    }





    // Initialize ressources
    private void initResourses(int sens) {
        res = new Resources();
        res.loadResourses(sens);
    }
    // Render center pane
    public void initWorld() {
        addObjects(res.backgroundView, res.boatView, res.firstDoorView, res.secondDoorView, res.sasView, res.firstValveView, res.secondValveView);
    }
    // Render control pane
    public void initConrolPanel(){
       // controlPane.setCenter(res.controlBackgroundView);
        controlPane.setLeft(buttonsAvalPane);
        controlPane.setRight(buttonsAmontPane);
    }

    //Center pane methods
    private void addObjects(Node... n) {
        center.getChildren().addAll(n);
    }
    private void addObjects(Node n) {
        center.getChildren().add(0, n);
    }

    //Control pane methods
    private void addControls(Node... n) {
        controlPane.getChildren().addAll(n);
    }
    private void addControls(Node n) {
        controlPane.getChildren().add(0, n);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
