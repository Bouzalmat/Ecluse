package components;


import javafx.scene.image.ImageView;

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

    }

    @Override
    public void close() {

    }
}
