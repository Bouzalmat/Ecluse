package components;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Boat extends Objects {
    TranslateTransition translateTransition;
    public Boat(ImageView image, State state) {
        super(image, state);
    }
    public Boat(ImageView image) {
        super(image);
    }


    @Override
    public void open() {
    }

    @Override
    public void close() {

    }

    public void moveX(int direction, int level){
        if(direction == 1){
            if( level == 1){
                translateTransition = new TranslateTransition();
                translateTransition.setNode(getImage());
                translateTransition.setByX(GlobalVars.BOAT_LEVEL1_MAX_XPOSITION - GlobalVars.BOAT_LEVEL1_MIN_XPOSITION);
                translateTransition.setDuration(GlobalVars.boatDuration);
                translateTransition.play();
            }
            else if(level == 2){
                translateTransition = new TranslateTransition();
                translateTransition.setNode(getImage());
                translateTransition.setByX(GlobalVars.BOAT_AMONT_XPOSITION - GlobalVars.BOAT_LEVEL1_MAX_XPOSITION);
                translateTransition.setDuration(GlobalVars.boatDuration);
                translateTransition.play();
            }

        }
    }

    public void moveY(){
        translateTransition = new TranslateTransition();
        translateTransition.setNode(getImage());
        translateTransition.setByY(GlobalVars.BOAT_MAX_YPOSITION - GlobalVars.BOAT_MIN_YPOSITION);
        translateTransition.setDuration(GlobalVars.duration);
        translateTransition.play();
    }
}
