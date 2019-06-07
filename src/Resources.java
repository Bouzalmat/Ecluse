import components.Boat;
import components.Door;
import components.Sas;
import components.Valve;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Resources {
    Image backgroundImage;
    Image boatImage;
    Image firstDoorImage;
    Image secondDoorImage;
    Image firstValveImage;
    Image secondValveImage;
    Image sasImage;
    Image controlBackgroundImage;

    ImageView backgroundView;
    ImageView boatView;
    ImageView firstDoorView;
    ImageView secondDoorView;
    ImageView firstValveView;
    ImageView secondValveView;
    ImageView sasView;
    ImageView controlBackgroundView;

    Boat boat;
    Sas sas;
    Door firstDoor;
    Door secondDoor;
    Valve firstValve;
    Valve secondValve;

    Button b;


    public void loadResourses(int sens) {
        try {


            backgroundImage = new Image(Resources.class.getResourceAsStream("res/background.png"));

            controlBackgroundImage = new Image(Resources.class.getResourceAsStream("res/controlBackground.png"));

            if (sens == GlobalVars.AVAL_TO_AMONT_DIRECTION)
                boatImage = new Image(Resources.class.getResourceAsStream("res/boat_aval.gif"));

            if(sens == GlobalVars.AMONT_TO_AVAL_DIRECTION)
                boatImage = new Image(Resources.class.getResourceAsStream("res/boat_amant.gif"));

            firstDoorImage = new Image(Resources.class.getResourceAsStream("res/door.png"));
            secondDoorImage = new Image(Resources.class.getResourceAsStream("res/door.png"));

            firstValveImage = new Image(Resources.class.getResourceAsStream("res/open_valve.png"));
            firstValveImage = new Image(Resources.class.getResourceAsStream("res/open_valve.png"));

            secondValveImage = new Image(Resources.class.getResourceAsStream("res/open_valve.png"));
            secondValveImage = new Image(Resources.class.getResourceAsStream("res/open_valve.png"));

            sasImage = new Image(Resources.class.getResourceAsStream("res/sas.png"));

            // attaching
            attachDefaultImages(sens);

        } catch (Exception e) {
            System.out.println("error loading one of the resourses");
        }

    }

    private void attachDefaultImages(int sens) {
        try {
            //
            backgroundView = new ImageView(backgroundImage);

            controlBackgroundView = new ImageView(controlBackgroundImage);
            //controlBackgroundView.setTranslateY(458);

            //
            if(sens == GlobalVars.AVAL_TO_AMONT_DIRECTION){
                boatView = new ImageView(boatImage);
                boatView.setTranslateX(GlobalVars.BOAT_LEVEL2_XPOSITION);
                boatView.setTranslateY(GlobalVars.BOAT_MIN_YPOSITION);
                boat = new Boat(boatView);

                sasView = new ImageView(sasImage);
                sasView.setTranslateX(GlobalVars.SAS_XPOSITION);
                sasView.setTranslateY(GlobalVars.SAS_MAX_YPOSITION);
                sas = new Sas(sasView);
            }
            else if(sens == GlobalVars.AMONT_TO_AVAL_DIRECTION){
                boatView = new ImageView(boatImage);
                boatView.setTranslateX(GlobalVars.BOAT_AMONT_XPOSITION);
                boatView.setTranslateY(GlobalVars.BOAT_MAX_YPOSITION);
                boat = new Boat(boatView);

                sasView = new ImageView(sasImage);
                sasView.setTranslateX(GlobalVars.SAS_XPOSITION);
                sasView.setTranslateY(GlobalVars.SAS_MIN_YPOSITION);
                sas = new Sas(sasView);
            }



            //
            firstDoorView = new ImageView(firstDoorImage);
            firstDoorView.setTranslateX(GlobalVars.FIRST_DOOR_XPOSITION);
            firstDoorView.setTranslateY(GlobalVars.DOOR_MIN_YPOSITION);
            firstDoor = new Door(firstDoorView);

            //
            secondDoorView = new ImageView(secondDoorImage);
            secondDoorView.setTranslateX(GlobalVars.SECOND_DOOR_XPOSITION);
            secondDoorView.setTranslateY(GlobalVars.DOOR_MIN_YPOSITION);
            secondDoor = new Door(secondDoorView);

            //
            firstValveView = new ImageView(firstValveImage);
            firstValveView.setTranslateX(GlobalVars.FIRST_VANNE_XPOSTION);
            firstValveView.setTranslateY(GlobalVars.FIRST_VANNE_YPOSTION);
            firstValve = new Valve(firstValveView);

            //
            secondValveView = new ImageView(secondValveImage);
            secondValveView.setTranslateX(GlobalVars.SECOND_VANNE_XPOSTION);
            secondValveView.setTranslateY(GlobalVars.SECOND_VANNE_YPOSTION);
            secondValve = new Valve(secondValveView);

            //


            b = new Button("button");

        } catch (Exception e) {
            System.out.println("error attaching imgs");
        }
    }

}
