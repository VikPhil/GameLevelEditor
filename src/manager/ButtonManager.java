package manager;

import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class ButtonManager {

	private BufferedImage bRedPressed, bRed;
	
	public ButtonManager() {
		loadSprites();
	}

	private void loadSprites() {
		bRedPressed = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_RED_PRESSED);
		bRed = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_RED);
	}

	public BufferedImage getBRedPressed() {
		return bRedPressed;
	}

	public BufferedImage getBRed() {
		return bRed;
	}
	
	
}
