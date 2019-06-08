package components;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Boat extends Objects {
    TranslateTransition translateTransition;
    ImageView boat;



    public Boat(ImageView boat) {
        this.boat = boat;
    }

    @Override
    public void open() {
    }

    @Override
    public void close() {

    }
}
