package main;

import components.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import res.Res;
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
    Image firstLightOnImage;
    Image secondLightOnImage;

   public ImageView backgroundView;
    public ImageView boatView;
    public ImageView firstDoorView;
    public ImageView secondDoorView;
    public ImageView firstValveView;
    public ImageView secondValveView;
    public ImageView sasView;
    public ImageView controlBackgroundView;
    public ImageView firstLightOnView;
    public ImageView secondLightOnView;

    Boat boat;
    Sas sas;
    Door firstDoor;
    Door secondDoor;
    Valve firstValve;
    Valve secondValve;
    Light firstLight;
    Light secondLight;


    public void loadResourses(int sens) {
        try {


            backgroundImage = new Image(Res.class.getResourceAsStream("background.png"));

            controlBackgroundImage = new Image(Res.class.getResourceAsStream("controlBackground.png"));

            if (sens == GlobalVars.AVAL_TO_AMONT_DIRECTION)
                boatImage = new Image(Res.class.getResourceAsStream("boat_aval.gif"));

            if(sens == GlobalVars.AMONT_TO_AVAL_DIRECTION)
                boatImage = new Image(Res.class.getResourceAsStream("boat_amant.gif"));

            firstDoorImage = new Image(Res.class.getResourceAsStream("door.png"));
            secondDoorImage = new Image(Res.class.getResourceAsStream("door.png"));

            firstValveImage = new Image(Res.class.getResourceAsStream("open_valve.png"));
            firstValveImage = new Image(Res.class.getResourceAsStream("open_valve.png"));

            secondValveImage = new Image(Res.class.getResourceAsStream("open_valve.png"));
            secondValveImage = new Image(Res.class.getResourceAsStream("open_valve.png"));

            sasImage = new Image(Res.class.getResourceAsStream("sas.png"));

            firstLightOnImage = new Image(Res.class.getResourceAsStream(""));
            secondLightOnImage = new Image(Res.class.getResourceAsStream(""));

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
                boatView.setTranslateX(GlobalVars.BOAT_LEVEL1_MIN_XPOSITION);
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

            firstLightOnView = new ImageView(firstLightOnImage);
            firstLightOnView.setTranslateX(GlobalVars.FIRST_LIGHT_ON_XPOSITION);
            firstLightOnView.setTranslateY(GlobalVars.FIRST_LIGHT_ON_YPOSITION);

            secondLightOnView = new ImageView(secondLightOnImage);
            secondLightOnView.setTranslateX(GlobalVars.SECOND_LIGHT_ON_XPOSITION);
            secondLightOnView.setTranslateY(GlobalVars.SECOND_LIGHT_ON_YPOSITION);


            firstLight = new Light();
            secondLight = new Light();

        } catch (Exception e) {
            System.out.println("error attaching imgs");
        }
    }

}
