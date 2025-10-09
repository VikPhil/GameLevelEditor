package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

	// ground----------------------------------------------------------------------
	public static final String SHADOWS = "ground/shadows.png";
	public static final String TILE_ELEVATION = "ground/tilemap_elevation.png";
	public static final String TILE_FLAT = "ground/tilemap_flat.png";
	// ----------------------------------------------------------------------------

	// water-----------------------------------------------------------------------
	public static final String WATER = "water/water.png";
	// ----------------------------------------------------------------------------
	
	public static BufferedImage GetSpriteAtlas(String name) {

		BufferedImage image = null;

		InputStream is = LoadSave.class.getResourceAsStream("/" + name);

		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return image;
	}
}
