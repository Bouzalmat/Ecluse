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

    public void moveBoatY(int start, int finish){
        translateTransition = new TranslateTransition();
        translateTransition.setNode(getImage());
        translateTransition.setByY(finish - start);
        translateTransition.setDuration(GlobalVars.duration);
        translateTransition.play();
    }

    public void moveBoatX(int start, int finish){
        translateTransition = new TranslateTransition();
        translateTransition.setNode(getImage());
        translateTransition.setByX(finish - start);
        translateTransition.setDuration(GlobalVars.boatDuration);
        translateTransition.play();
    }
}
