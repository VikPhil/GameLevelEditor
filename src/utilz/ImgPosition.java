package utilz;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImgPosition {

	// Rotate a sprite
	public static BufferedImage getRotate(BufferedImage img, int angle) {

		int w = img.getWidth();
		int h = img.getHeight();

		BufferedImage result = new BufferedImage(w, h, img.getType());
		Graphics2D g2 = result.createGraphics();

		g2.rotate(Math.toRadians(angle), w / 2, h / 2);
		g2.drawImage(img, 0, 0, null);
		g2.dispose();

		return result;
	}
}
