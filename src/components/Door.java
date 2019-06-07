package components;


import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Door extends Objects {
    public Door(ImageView image, State state) {
        super(image, state);
    }

    public Door(ImageView image) {
        super(image);
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
