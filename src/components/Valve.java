package components;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Resources;
import res.Res;
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
        ImageView image = new ImageView(new Image(Res.class.getResourceAsStream("closed_valve.png")));
        image.setTranslateX(GlobalVars.FIRST_VANNE_XPOSTION);
        image.setTranslateY(GlobalVars.FIRST_VANNE_YPOSTION);
        this.setImage(image);
    }

    public void openFirstValve(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("closed_valve.png"));
        res.firstValveView.setImage(image);
    }
    public void closeFirstValve(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("open_valve.png"));
        res.firstValveView.setImage(image);
    }

    public void openSecondValve(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("closed_valve.png"));
        res.secondValveView.setImage(image);
    }

    public void closeSecondValve(Resources res){
        Image image = new Image(Res.class.getResourceAsStream("open_valve.png"));
        res.secondValveView.setImage(image);
    }

    @Override
    public void close() {
    }
}
