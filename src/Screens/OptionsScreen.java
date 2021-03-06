package Screens;

import Engine.Config;
import Engine.GamePanel;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Maps.LevelSelectMap;
import Screens.PlayLevelScreen.PlayLevelScreenState;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This class is for the level cleared screen
public class OptionsScreen extends Screen 
{
	protected PlayLevelScreen playLevelScreen;
	
	protected GameWindow gameWindow;
	protected ScreenCoordinator screenCoordinator;
	
	protected SpriteFont volumeControl;
	protected SpriteFont volumeMute;
	protected SpriteFont volumeLow;
	protected SpriteFont volumeMed;
	protected SpriteFont volumeHigh;
	protected SpriteFont playerControl;
	protected SpriteFont playerGreen;
	protected SpriteFont playerBlue;
	protected SpriteFont playerOrange;
	protected SpriteFont returnInstructionLabel;
	protected Sprite soundSprite;
	
	protected Map background;
	protected Stopwatch keyTimer = new Stopwatch();
	protected KeyLocker keyLocker = new KeyLocker();
	
	protected int pointerLocationX, pointerLocationY;
	protected int currentItemHovered = 0;
	protected int itemSelected = -1;

	public OptionsScreen(PlayLevelScreen screen) 
	{
		this.playLevelScreen = screen;
	}

	@Override
	public void initialize() 
	{
		gameWindow = GamePanel.getGameWindow();
		screenCoordinator = GamePanel.getScreenCoordinator();

		volumeControl = new SpriteFont("Volume Control", 100, 150, "Comic Sans", 30, Color.white);
		volumeControl.setOutlineColor(Color.black);
		volumeControl.setOutlineThickness(2.0f);
		
		volumeMute = new SpriteFont("Mute", 340, 150, "Comic Sans", 24, Color.white);
		volumeMute.setOutlineColor(Color.black);
		volumeMute.setOutlineThickness(2.0f);
		
		volumeLow = new SpriteFont("Low", 420, 150, "Comic Sans", 24, Color.white);
		volumeLow.setOutlineColor(Color.black);
		volumeLow.setOutlineThickness(2.0f);
		
		volumeMed = new SpriteFont("Medium", 500, 150, "Comic Sans", 24, Color.white);
		volumeMed.setOutlineColor(Color.black);
		volumeMed.setOutlineThickness(2.0f);
		
		volumeHigh = new SpriteFont("High", 615, 150, "Comic Sans", 24, Color.white);
		volumeHigh.setOutlineColor(Color.black);
		volumeHigh.setOutlineThickness(2.0f);

		playerControl = new SpriteFont("Player", 100, 300, "Comic Sans", 30, Color.white);
		playerControl.setOutlineColor(Color.black);
		playerControl.setOutlineThickness(2.0f);
		
		playerGreen = new SpriteFont("Green", 630, 300, "Comic Sans", 24, Color.white);
		playerGreen.setOutlineColor(Color.black);
		playerGreen.setOutlineThickness(2.0f);
		
		playerBlue = new SpriteFont("Blue", 500, 300, "Comic Sans", 24, Color.white);
		playerBlue.setOutlineColor(Color.black);
		playerBlue.setOutlineThickness(2.0f);
		
		playerOrange = new SpriteFont("Orange", 350, 300, "Comic Sans", 24, Color.white);
		playerOrange.setOutlineColor(Color.black);
		playerOrange.setOutlineThickness(2.0f);
		
		returnInstructionLabel = new SpriteFont("Press X to return to the menu", 5, 560, "Times New Roman", 30, Color.white);
		returnInstructionLabel.setOutlineColor(Color.white);
		returnInstructionLabel.setOutlineThickness(2.0f);
		
		background = new LevelSelectMap();
		background.setAdjustCamera(false);
		
		keyTimer.setWaitTime(200);
		keyLocker.lockKey(Key.SPACE);
	}

	@Override
	public void update() 
	{
		background.update(null);

		if (Keyboard.isKeyDown(Key.RIGHT) && keyTimer.isTimeUp()) 
		{
			keyTimer.reset();
			currentItemHovered++;
		} 
		else if (Keyboard.isKeyDown(Key.LEFT) && keyTimer.isTimeUp()) 
		{
			keyTimer.reset();
			currentItemHovered--;
		}
		
		/*
		if down is pressed on last menu item or up is pressed on first menu item,
		"loop" the selection back around to the beginning/end
		*/
		if (currentItemHovered > 8) 
		{
			currentItemHovered = 0;
		} 
		else if (currentItemHovered < 0) 
		{
			currentItemHovered = 8;
		}

		if (currentItemHovered == 0) 
		{
			volumeControl.setColor(new Color(255, 215, 0));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 1) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(255, 215, 0));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 2) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(255, 215, 0));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 3) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(255, 215, 0));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 4) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(255, 215, 0));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 5) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(255, 215, 0));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 6) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(255, 215, 0));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(49, 207, 240));
		} 
		else if (currentItemHovered == 7) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(255, 215, 0));
			playerOrange.setColor(new Color(49, 207, 240));
		}
		else if (currentItemHovered == 8) 
		{
			volumeControl.setColor(new Color(49, 207, 240));
			volumeMute.setColor(new Color(49, 207, 240));
			volumeLow.setColor(new Color(49, 207, 240));
			volumeMed.setColor(new Color(49, 207, 240));
			volumeHigh.setColor(new Color(49, 207, 240));
			playerControl.setColor(new Color(49, 207, 240));
			playerGreen.setColor(new Color(49, 207, 240));
			playerBlue.setColor(new Color(49, 207, 240));
			playerOrange.setColor(new Color(255, 215, 0));
		}

		/*
		if space is pressed on menu item, change to appropriate screen based on which
		menu item was chosen
		*/
		if (Keyboard.isKeyUp(Key.SPACE)) 
		{
			keyLocker.unlockKey(Key.SPACE);
		}

		if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) 
		{
			itemSelected = currentItemHovered;
			
			if (itemSelected == 0) 
			{
				//Empty selection for Volume Control label
			} 
			else if (itemSelected == 1) 
			{
				setVolumeMute();
			} 
			else if (itemSelected == 2) 
			{
				setVolumeLow();
			} 
			else if (itemSelected == 3) 
			{
				setVolumeMed();
			} 
			else if (itemSelected == 4) 
			{
				setVolumeHigh();
			} 
			else if (itemSelected == 5) 
			{
				//Empty selection for PLayer Control label
			} 
			else if (itemSelected == 6) 
			{
				playLevelScreen.setCatNum(0);
				playLevelScreen.setLevelNum(0);
				playLevelScreen.setPlayLevelScreenState(PlayLevelScreenState.RUNNING);
				playLevelScreen.initialize();
			} 
			else if (itemSelected == 7) 
			{
				playLevelScreen.setCatNum(1);
				playLevelScreen.setLevelNum(0);
				playLevelScreen.setPlayLevelScreenState(PlayLevelScreenState.RUNNING);
				playLevelScreen.initialize();
			}
			else if (itemSelected == 8) 
			{
				playLevelScreen.setCatNum(2);
				playLevelScreen.setLevelNum(0);
				playLevelScreen.setPlayLevelScreenState(PlayLevelScreenState.RUNNING);
				playLevelScreen.initialize();
			}
		}
		
		if (!keyLocker.isKeyLocked(Key.X) && Keyboard.isKeyDown(Key.X)) 
		{
			screenCoordinator.setGameState(GameState.MENU);
	    }
	}

	public void setVolumeMute() 
	{
		GamePanel.setVolumeMute();
		Config.VOLUME_SPRITE = "Mute.png";
	}
	
	public void setVolumeLow() 
	{
		GamePanel.setVolumeLow();
		Config.VOLUME_SPRITE = "Unmute.png";
	}

	public void setVolumeMed() 
	{
		GamePanel.setVolumeMed();
		Config.VOLUME_SPRITE = "Unmute.png";
	}

	public void setVolumeHigh() 
	{
		GamePanel.setVolumeHigh();
		Config.VOLUME_SPRITE = "Unmute.png";
	}

	public int getItemSelected() 
	{
		return itemSelected;
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) 
	{
		background.draw(graphicsHandler);
		volumeControl.draw(graphicsHandler);
		volumeMute.draw(graphicsHandler);
		volumeLow.draw(graphicsHandler);
		volumeMed.draw(graphicsHandler);
		volumeHigh.draw(graphicsHandler);
		playerControl.draw(graphicsHandler);
		playerGreen.draw(graphicsHandler);
		playerBlue.draw(graphicsHandler);
		playerOrange.draw(graphicsHandler);
		returnInstructionLabel.draw(graphicsHandler);
		// graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX,
		// pointerLocationY, 20, 20,
		// new Color(49, 207, 240), Color.black, 2);
	}

	@Override
	public void muteVolume() { }
}
