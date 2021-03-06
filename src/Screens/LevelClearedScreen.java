package Screens;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Screen;
import Engine.ScreenManager;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
    protected SpriteFont winMessage;

    public LevelClearedScreen() {
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("Level Cleared", 320, 270, "Comic Sans", 30, Color.white);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        // paint entire screen black and dislpay level cleared text
        graphicsHandler.drawFilledRectangle(0, 0, Config.WIDTH, Config.HEIGHT, Color.black);
        winMessage.draw(graphicsHandler);
    }

	@Override
	public void muteVolume() { }
}
