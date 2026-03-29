package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	// ground----------------------------------------------------------------------
	public static final String SHADOWS = "ground/shadows.png";
	public static final String TILE_FLAT1 = "ground/tilemap_color1.png";
	// ----------------------------------------------------------------------------
	
	// rocks----------------------------------------------------------------------
	public static final String ROCKS_1 = "rocks/rock1.png";
	public static final String ROCKS_2 = "rocks/rock2.png";
	public static final String ROCKS_3 = "rocks/rock3.png";
	public static final String ROCKS_4 = "rocks/rock4.png";
	// ----------------------------------------------------------------------------
	
	// water and rocks in water-------------------------------------------------------------
	public static final String WATER = "water/water.png";
	public static final String FOAM = "water/foam.png";
	public static final String WATER_ROCK_1= "water/water_rocks_01.png";
	public static final String WATER_ROCK_2= "water/water_rocks_02.png";
	public static final String WATER_ROCK_3= "water/water_rocks_03.png";
	public static final String WATER_ROCK_4= "water/water_rocks_03.png";
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
