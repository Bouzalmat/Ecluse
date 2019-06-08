package utils;

import javafx.util.Duration;

/**
 * Created by BouzalmatAbderrahman on 6/6/2019
 */
public class GlobalVars {
    //window size
    public static final int WINDOW_WIDTH = 892;
    public static final int WINDOW_HEIGHT = 611;

    //boat positions
    public static final int BOAT_LEVEL1_MIN_XPOSITION = 0;
    public static final int BOAT_LEVEL1_MAX_XPOSITION = 290;
    public static final int BOAT_LEVEL2_XPOSITION = 287;
    public static final int BOAT_LEVEL3_MIN_XPOSITION = 0;
    public static final int BOAT_LEVEL3_MAX_XPOSITION = 240;
    public static final int BOAT_AMONT_XPOSITION = 720;
    public static final int BOAT_MIN_YPOSITION = 290;
    public static final int BOAT_MAX_YPOSITION = 210;

    // doors position
    public static final int FIRST_DOOR_XPOSITION = 275;
    public static final int SECOND_DOOR_XPOSITION = 472;
    public static final int DOOR_MIN_YPOSITION = 153;
    public static final int DOOR_MAX_YPOSITION = 23;


    //first vanne position
    public static final int FIRST_VANNE_XPOSTION = 276;
    public static final int FIRST_VANNE_YPOSTION = 342;

    //second vanne position
    public static final int SECOND_VANNE_XPOSTION = 473;
    public static final int SECOND_VANNE_YPOSTION = 342;

    //sas position
    public static final int SAS_XPOSITION = 288;
    public static final int SAS_MIN_YPOSITION = 342;
    public static final int SAS_MAX_YPOSITION = 263;


    // sens de parcours de l'écluse
    public static final short AVAL_TO_AMONT_DIRECTION = 1;
    public static final short AMONT_TO_AVAL_DIRECTION = -1;

    // movement duration
    public static final Duration duration = Duration.millis(1700);

    //boat speed
    public static final Duration boatDuration = Duration.millis(2200);







}
