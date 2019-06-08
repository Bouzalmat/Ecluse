package components;

import javafx.scene.image.ImageView;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public abstract class Objects {
    private ImageView image;
    private State state = State.CLOSE;

    public Objects(ImageView image, State state) {
        this.image = image;
        this.state = state;
    }

    public Objects(ImageView image) {
        this.image = image;
    }
    public Objects(){};

    abstract public void open();
    abstract public void close();

    public ImageView getImage() {
        return image;
    }

    public State getState() {
        return state;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public void setState(State state) {
        this.state = state;
    }
}
