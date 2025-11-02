package manager;

import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class ButtonManager {

	private BufferedImage bRedPressed, bRed, bBluePressed, bBlue;

	public ButtonManager() {
		loadSprites();
	}

	private void loadSprites() {
		bRedPressed = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_RED_PRESSED);
		bRed = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_RED);
		bBluePressed = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_BLUE_PRESSED);
		bBlue = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_BLUE);
	}

	public BufferedImage getBRedPressed() {
		return bRedPressed;
	}

	public BufferedImage getBRed() {
		return bRed;
	}

	public BufferedImage getBBlue() {
		return bBlue;
	}

	public BufferedImage getBBluePressed() {
		return bBluePressed;
	}

}
