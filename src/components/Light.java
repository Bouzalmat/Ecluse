package components;

import javafx.scene.image.ImageView;

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

    @Override
    public void close() {

    }
}
