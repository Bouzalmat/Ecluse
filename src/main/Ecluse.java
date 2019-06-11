package main;

import components.State;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    GridPane buttonsAmontPane;
    public static Resources res;

    //Global vars for the default situation
    public static int sens = 1;
    public static int level = 1;
    public static int sasLevel = GlobalVars.SAS_MAX_YPOSITION;

    //Variable for error messages

    private static Text errors;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        scene = new Scene(root, GlobalVars.WINDOW_WIDTH, GlobalVars.WINDOW_HEIGHT);
        primaryStage.setResizable(false);

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
                level = 3;
                sasLevel = GlobalVars.SAS_MIN_YPOSITION;
                initResourses(sens);
                root.setCenter(initCenterPane());
            }
        };
        EventHandler<ActionEvent> amantToAvalEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                sens = 1;
                level = 1;
                sasLevel = GlobalVars.SAS_MAX_YPOSITION;
                initResourses(sens);
                root.setCenter(initCenterPane());
            }
        };

        // Add menu event
        avalToAmantItem.setOnAction(avalToAmantEvent);
        amantToAvalItem.setOnAction(amantToAvalEvent);

        initResourses(sens);
        root.setTop(menubar);
        root.setCenter(initCenterPane());
        root.setBottom(initConrolPanel());

        primaryStage.setScene(scene);
        primaryStage.show();

    }





    // Initialize ressources
    private void initResourses(int sens) {
        res = new Resources();
        res.loadResourses(sens);
    }


    // Render center pane
    public Pane initCenterPane() {
        center = new Pane();
        center.getChildren().addAll(res.backgroundView, res.boatView, res.firstDoorView, res.sasView, res.secondDoorView, res.firstValveView, res.secondValveView, res.firstLightOnView, res.secondLightOnView);
        return  center;
    }


    // Render control pane
    public BorderPane initConrolPanel(){
        controlPane = new BorderPane();
        controlPane.setLeft(avalButtonsBuilder());
        controlPane.setRight(amontButtonsBuilder());
        controlPane.setCenter(messagesBuilder());
        return controlPane;
    }

    public  Text messagesBuilder(){
        errors = new Text();
        errors.setText("");
        errors.setFill(Color.RED);
        errors.setFont(new Font(25));

        return errors;
    }

    //function for initialize the text;
    public void intitializeText(Text text){
        text.setText("");
    }


    public GridPane avalButtonsBuilder(){
        GridPane buttonsAvalPane = new GridPane();
        buttonsAvalPane.setHgap(10);
        buttonsAvalPane.setVgap(10);

        Label avalLabel = new Label("Aval");
        Label lightLabel = new Label("Feu");
        Label doorLabel = new Label("Porte");
        Label valveLabel = new Label("Vanne");

        Button openFirstValve = new Button("Ouvrir");
        Button closeFirstValve = new Button("Fermer");
        Button openFirstAvalDoor = new Button("Ouvrir");
        Button closeFirstAvalDoor = new Button("Fermer");
        Button firstLightOn = new Button("Allumer");
        Button firstLightOff = new Button("Eteindre");

        openFirstAvalDoor.setOnAction(openFirstDoor());
        closeFirstAvalDoor.setOnAction(closeFirstDoor());
        openFirstValve.setOnAction(openFirstValve());
        closeFirstValve.setOnAction(closeFirstValve());
        firstLightOn.setOnAction(firstLightOn());
        firstLightOff.setOnAction(firstLightOff());



        buttonsAvalPane.add(avalLabel,1,1);
        buttonsAvalPane.add(valveLabel,1,2);
        buttonsAvalPane.add(doorLabel,1,3);
        buttonsAvalPane.add(lightLabel,1,4);
        buttonsAvalPane.add(openFirstValve,2,2);
        buttonsAvalPane.add(closeFirstValve,3,2);
        buttonsAvalPane.add(openFirstAvalDoor,2,3);
        buttonsAvalPane.add(closeFirstAvalDoor,3,3);
        buttonsAvalPane.add(firstLightOn,2,4);
        buttonsAvalPane.add(firstLightOff,3,4);

        return buttonsAvalPane ;
    }

    public EventHandler<ActionEvent> openFirstDoor(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(res.firstDoor.getState() == State.CLOSE && sasLevel == GlobalVars.SAS_MIN_YPOSITION && res.firstValve.getState() == State.CLOSE) {
                    res.firstDoor.open();
                    res.firstDoor.setState(State.OPEN);
                }
                else if(res.firstDoor.getState() == State.OPEN)
                    errors.setText("La porte est déja ouverte");
                else if (res.firstValve.getState() == State.OPEN)
                    errors.setText("La vanne est ouverte");
                else if (sasLevel == GlobalVars.SAS_MAX_YPOSITION )
                    errors.setText("Le niveau de l'eau n'est pas équilibré");
            }
        };
        return  event;
    }

    public EventHandler<ActionEvent> closeFirstDoor(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if( res.firstDoor.getState()  == State.OPEN && res.firstLight.getState() == State.CLOSE){
                        res.firstDoor.close();
                        res.firstDoor.setState(State.CLOSE);
                }
                else if(res.firstDoor.getState() == State.CLOSE)
                    errors.setText("La porte est déja fermée");
                else if(res.firstLight.getState() == State.OPEN)
                    errors.setText("Le feu est allumé");
            }
        };
        return  event;
    }

    public EventHandler<ActionEvent> openFirstValve(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(sasLevel == GlobalVars.SAS_MAX_YPOSITION && res.firstValve.getState() == State.CLOSE && res.secondValve.getState() == State.CLOSE && res.firstDoor.getState() == State.CLOSE && res.secondDoor.getState() == State.CLOSE){
                    res.firstValve.openFirstValve(res);
                    if(level == 2){
                        res.boat.moveBoatY(GlobalVars.BOAT_MAX_YPOSITION, GlobalVars.BOAT_MIN_YPOSITION);
                    }
                    res.sas.close();
                    sasLevel = GlobalVars.SAS_MIN_YPOSITION;
                    res.firstValve.setState(State.OPEN);
                }
                else if (res.firstValve.getState() == State.OPEN)
                    errors.setText("La vanne est déja ouverte");
                else if (sasLevel == GlobalVars.SAS_MIN_YPOSITION)
                    errors.setText("Le niveau d'eau est déja équilibré");
                else if(res.secondValve.getState() == State.OPEN)
                    errors.setText("L'autre vanne est ouverte");
                else if(res.firstDoor.getState() == State.OPEN)
                    errors.setText("La porte niveau aval est ouverte");
                else if (res.secondDoor.getState() == State.OPEN)
                    errors.setText("La porte niveau amaont est ouverte");
                else
                    errors.setText("Action non autorisée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> closeFirstValve(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(res.firstValve.getState() == State.OPEN){
                    res.firstValve.closeFirstValve(res);
                    res.firstValve.setState(State.CLOSE);
                }
                else
                    errors.setText("La vanne est déja fermée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> firstLightOn(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(res.firstLight.getState() == State.CLOSE && res.firstDoor.getState() == State.OPEN){
                    res.firstLight.setState(State.OPEN);
                    res.firstLight.firstLightOn(res);
                    if(sens == 1 && level == 1){
                        res.boat.moveBoatX(GlobalVars.BOAT_LEVEL1_MIN_XPOSITION, GlobalVars.BOAT_LEVEL1_MAX_XPOSITION);
                        level = 2;
                    }
                    else if (sens == -1 && level == 2){
                        res.boat.moveBoatX(GlobalVars.BOAT_LEVEL2_XPOSITION, GlobalVars.BOAT_LEVEL1_MIN_XPOSITION);
                        level = 1;
                    }
                }
                else if (res.firstLight.getState() == State.OPEN)
                    errors.setText("Le feu est déja allumé");
                else if (res.firstDoor.getState() == State.CLOSE)
                    errors.setText("La porte est fermée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> firstLightOff(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if( res.firstLight.getState() == State.OPEN){
                    res.firstLight.setState(State.CLOSE);
                    res.firstLight.firstLightOff(res);
                }
                else
                    errors.setText("Le feu est déja éteint");
            }
        };
        return event;
    }




    public GridPane amontButtonsBuilder(){
        // Initialize AmontPane
        buttonsAmontPane = new GridPane();
        buttonsAmontPane.setHgap(10);
        buttonsAmontPane.setVgap(10);

        //AmontPane labels
        Label amontLabel = new Label("Amont");
        Label amontLightLabel = new Label("Feu");
        Label amontDoorLabel = new Label("Porte");
        Label amontValveLabel = new Label("Vanne");


        // AmontPane buttons
        Button openSecondValve = new Button("Ouvrir");
        Button closeSecondValve = new Button("Fermer");
        Button openSecondDoor = new Button("Ouvrir");
        Button closeSecondDoor = new Button("Fermer");
        Button secondLightOn = new Button("Allumer");
        Button secondLightOff = new Button("Eteindre");


        // Add labels and buttons to AmontPane
        buttonsAmontPane.add(amontLabel,1,1);
        buttonsAmontPane.add(amontValveLabel,1,2);
        buttonsAmontPane.add(amontDoorLabel,1,3);
        buttonsAmontPane.add(amontLightLabel,1,4);
        buttonsAmontPane.add(openSecondValve,2,2);
        buttonsAmontPane.add(closeSecondValve,3,2);
        buttonsAmontPane.add(openSecondDoor,2,3);
        buttonsAmontPane.add(closeSecondDoor,3,3);
        buttonsAmontPane.add(secondLightOn,2,4);
        buttonsAmontPane.add(secondLightOff,3,4);

        //Add events to buttons
        openSecondDoor.setOnAction(openSecondDoor());
        closeSecondDoor.setOnAction(closeSecondDoor());
        openSecondValve.setOnAction(openSecondValve());
        closeSecondValve.setOnAction(closeSecondValve());
        secondLightOn.setOnAction(secondLightOn());
        secondLightOff.setOnAction(secondLightOff());


        return buttonsAmontPane;
    }

    public EventHandler<ActionEvent> openSecondDoor(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(res.secondDoor.getState() == State.CLOSE && sasLevel == GlobalVars.SAS_MAX_YPOSITION && res.secondValve.getState() == State.CLOSE) {
                    res.secondDoor.open();
                    res.secondDoor.setState(State.OPEN);
                }
                else if(res.secondDoor.getState() == State.OPEN)
                    errors.setText("La porte est déja ouverte");
                else if (res.secondValve.getState() == State.OPEN)
                    errors.setText("La vanne est ouverte");
                else if (sasLevel == GlobalVars.SAS_MIN_YPOSITION )
                    errors.setText("Le niveau de l'eau n'est pas équilibré");
            }
        };
        return  event;
    }

    public EventHandler<ActionEvent> closeSecondDoor(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if( res.secondDoor.getState()  == State.OPEN && res.secondLight.getState() == State.CLOSE){
                    res.secondDoor.close();
                    res.secondDoor.setState(State.CLOSE);
                }
                else if(res.secondDoor.getState() == State.CLOSE)
                    errors.setText("La porte est déja fermée");
                else if(res.secondLight.getState() == State.OPEN)
                    errors.setText("Le feu est allumé");
                else
                    errors.setText("Action non autorisée");
            }
        };
        return  event;
    }

    public EventHandler<ActionEvent> openSecondValve(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(sasLevel == GlobalVars.SAS_MIN_YPOSITION && res.secondValve.getState() == State.CLOSE && res.secondDoor.getState() == State.CLOSE && res.firstDoor.getState() == State.CLOSE && res.firstValve.getState() == State.CLOSE){
                    res.firstValve.openSecondValve(res);
                    if(level == 2){
                        res.boat.moveBoatY(GlobalVars.BOAT_MIN_YPOSITION, GlobalVars.BOAT_MAX_YPOSITION);
                    }
                    res.sas.open();
                    sasLevel = GlobalVars.SAS_MAX_YPOSITION;
                    res.secondValve.setState(State.OPEN);
                }
                else if (res.secondValve.getState() == State.OPEN)
                    errors.setText("La vanne est déja ouverte");
                else if (sasLevel == GlobalVars.SAS_MAX_YPOSITION)
                    errors.setText("Le niveau d'eau est déja équilibré");
                else if(res.firstValve.getState() == State.OPEN)
                    errors.setText("L'autre vanne est ouverte");
                else if(res.firstDoor.getState() == State.OPEN)
                    errors.setText("La porte niveau aval est ouverte");
                else if (res.secondDoor.getState() == State.OPEN)
                    errors.setText("La porte niveau amaont est ouverte");
                else
                    errors.setText("Action non autorisée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> closeSecondValve(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(sasLevel == GlobalVars.SAS_MAX_YPOSITION && res.secondValve.getState() == State.OPEN){
                    res.secondValve.closeSecondValve(res);
                    res.secondValve.setState(State.CLOSE);
                }
                else
                    errors.setText("La vanne est déja fermée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> secondLightOn(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if(res.secondLight.getState() == State.CLOSE && res.secondDoor.getState() == State.OPEN){
                    res.secondLight.setState(State.OPEN);
                    res.secondLight.secondLightOn(res);
                    if(sens == -1 && level == 3){
                        res.boat.moveBoatX(GlobalVars.BOAT_AMONT_XPOSITION, GlobalVars.BOAT_LEVEL1_MAX_XPOSITION);
                        level = 2;
                    }
                    else if(sens == 1 && level == 2){
                        res.boat.moveBoatX(GlobalVars.BOAT_LEVEL2_XPOSITION, GlobalVars.BOAT_AMONT_XPOSITION);
                        level = 3;
                    }
                }
                else if (res.secondLight.getState() == State.OPEN)
                    errors.setText("Le feu est déja allumé");
                else if (res.secondDoor.getState() == State.CLOSE)
                    errors.setText("La porte est fermée");
            }
        };
        return event;
    }

    public EventHandler<ActionEvent> secondLightOff(){
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                intitializeText(errors);
                if( res.secondLight.getState() == State.OPEN){
                    res.secondLight.setState(State.CLOSE);
                    res.secondLight.secondLightOff(res);
                }
                else
                    errors.setText("Le feu déja est éteint");
            }
        };
        return event;
    }






    public static void main(String[] args) {
        launch(args);
    }
}
