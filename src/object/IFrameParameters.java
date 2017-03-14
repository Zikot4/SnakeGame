package object;

import java.awt.Color;

public interface IFrameParameters {
	String TITLE_OF_PROGRAM = "Classic Game Snake";
    String GAME_OVER_MSG = "GAME OVER";
    int POINT_RADIUS = 20; // in pix
    int FIELD_WIDTH = 30; // in point
    int FIELD_HEIGHT = 20;
    int FIELD_DX = 6;
    int FIELD_DY = 28;
    int START_LOCATION = 200;
    int START_SNAKE_SIZE = 6;
    int START_SNAKE_X = 10;
    int START_SNAKE_Y = 10;
    int SHOW_DELAY = 100;
    Color DEFAULT_COLOR = Color.black;
    Color FOOD_COLOR = Color.green;
    Color CANVAS_COLOR = new Color(220,220,220);
}
