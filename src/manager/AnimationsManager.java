package manager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import animations.Foam;
import utilz.LoadSave;


// На скалы формат 128 а не 192
public class AnimationsManager {

	private BufferedImage[] aniImg;
	private Foam test;

	private int aniSpeed = 9;
	private int aniTick, aniIndex = 0;

	public AnimationsManager() {
		aniImg = new BufferedImage[8];
		test = new Foam(64, 0);
		loadFoamImage();
	}

	private void loadFoamImage() {
		BufferedImage atlas = LoadSave.GetSpriteAtlas(LoadSave.FOAM);
		//BufferedImage atlas = LoadSave.GetSpriteAtlas(LoadSave.ROCKS_1);
		//BufferedImage atlas = LoadSave.GetSpriteAtlas(LoadSave.ROCKS_2);
		//BufferedImage atlas = LoadSave.GetSpriteAtlas(LoadSave.ROCKS_3);
		//BufferedImage atlas = LoadSave.GetSpriteAtlas(LoadSave.ROCKS_4);

		for (int i = 0; i < aniImg.length; i++) {
			aniImg[i] = atlas.getSubimage(i * 192, 0, 192, 192);
		}
	}

	public void update() {
		loadAnimation();
	}

	private void loadAnimation() {
		aniTick++;

		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= aniImg.length)
				aniIndex = 0;
			
		}
	}

	public void draw(Graphics g) {
		drawFoam(test, g);
	}

	private void drawFoam(Foam t, Graphics g) {
		g.drawImage(aniImg[aniIndex], t.getX(), t.getY(), null);
	}
}
