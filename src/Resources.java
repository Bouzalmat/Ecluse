import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.GlobalVars;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class Resources {
    Image backgroundImage;
    Image doorAvalImage;
    Image doorAmontImage;
    ImageView backgroundView;
    ImageView doorAvalView;
    ImageView doorAmontView;


    public void loadResourses() {
        try {


            backgroundImage = new Image(Resources.class.getResourceAsStream("res/background.png"));
            doorAvalImage = new Image(Resources.class.getResourceAsStream("res/door.png"));
            doorAmontImage = new Image(Resources.class.getResourceAsStream("res/door.png"));
            // attaching
            attachDefaultImages();

        } catch (Exception e) {
            System.out.println("error loading one of the resourses");
        }

    }

    private void attachDefaultImages() {
        try {
            //
            backgroundView = new ImageView(backgroundImage);


            doorAmontView = new ImageView(doorAmontImage);
            doorAmontView.setTranslateX(GlobalVars.DOOR_AMONT_XPOSITION);
            doorAmontView.setTranslateY(GlobalVars.DOOR_AMONT_YPOSITION);


            doorAvalView = new ImageView(doorAvalImage);
            doorAvalView.setTranslateX(GlobalVars.DOOR_AVAL_XPOSITION);
            doorAvalView.setTranslateY(GlobalVars.DOOR_AVAL_YPOSITION);


            //

        } catch (Exception e) {
            System.out.println("error attaching imgs");
        }
    }

}
