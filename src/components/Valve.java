package components;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public  class Valve extends Objects {
    public Valve(ImageView image, State state) {
        super(image, state);
    }

    public Valve(ImageView image) {
        super(image);
    }

    @Override
    public void open() {
        ImageView image = new ImageView(new Image(Valve.class.getResourceAsStream("res/closed_valve.png")));
        image.setTranslateX(GlobalVars.FIRST_VANNE_XPOSTION);
        image.setTranslateY(GlobalVars.FIRST_VANNE_YPOSTION);
        this.setImage(image);
    }

    @Override
    public void close() {
    }
}
