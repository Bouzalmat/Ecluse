package components;


import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Sas extends Objects {
    TranslateTransition translateTransition;
    public Sas(ImageView image, State state) {
        super(image, state);
    }

    public Sas(ImageView image) {
        super(image);
    }

    @Override
    public void open() {
        translateTransition = new TranslateTransition();
        translateTransition.setNode(getImage());
        translateTransition.setByY(GlobalVars.SAS_MAX_YPOSITION - GlobalVars.SAS_MIN_YPOSITION);
        translateTransition.setDuration(GlobalVars.duration);
        translateTransition.play();
        this.setState(State.OPEN);
    }

    @Override
    public void close() {
            translateTransition = new TranslateTransition();
            translateTransition.setNode(getImage());
            translateTransition.setByY(GlobalVars.SAS_MIN_YPOSITION - GlobalVars.SAS_MAX_YPOSITION);
            translateTransition.setDuration(GlobalVars.duration);
            translateTransition.play();
            this.setState(State.CLOSE);
    }
}
