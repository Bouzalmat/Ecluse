package components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.management.resource.ResourceId;
import main.Resources;
import res.Res;

/**
 * Created by BouzalmatAbderrahman on 6/8/2019
 */
public class Light extends Objects {
    public Light(ImageView image, State state) {
        super(image, state);
    }

    public Light(ImageView image) {
        super(image);
    }

    public Light(){}

    @Override
    public void open() {

    }

    public void firstLightOn(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("lightOn.png"));
        res.firstLightOnView.setImage(image);
    }

    public void firstLightOff(Resources res){
        Image image = new Image(Res.class.getResourceAsStream(""));
        res.firstLightOnView.setImage(image);
    }

    public void secondLightOn(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("secondLightOn.png"));
        res.secondLightOnView.setImage(image);
    }

    public void secondLightOff(Resources res){
        Image image = new Image(Res.class.getResourceAsStream(""));
        res.secondLightOnView.setImage(image);
    }

    @Override
    public void close() {

    }
}
