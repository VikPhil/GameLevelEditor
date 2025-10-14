package manager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.Tile;
import utilz.LoadSave;

public class TileManager {

	private Tile water;
	private Tile[] grassTiles = new Tile[14];
	
	private BufferedImage atlasWater, atlasFlat;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public TileManager() {
		loadAtlas();
		createTiles();
	}


	private void createTiles() {
		
		int id = 0, counter = 0;
		
		tiles.add(water = new Tile(getSpriteOfAtlas(atlasWater, 0, 0), id++));
		
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 3), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 2), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 2), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 0), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 0), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 1), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 1), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 0), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 2), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 1), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 3), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 3), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 3), id++));
		tiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 4, 0), id++));
		
		counter = 0;
		
	}


	private void loadAtlas() {
		atlasWater = LoadSave.GetSpriteAtlas(LoadSave.WATER);
		atlasFlat = LoadSave.GetSpriteAtlas(LoadSave.TILE_FLAT);
	}
	
	//get subimage
	private BufferedImage getSpriteOfAtlas(BufferedImage atlas, int xCor, int yCor) {
		return atlas.getSubimage(xCor * 64, yCor * 64, 64, 64);
	}
	
	//get image of tile
	public BufferedImage getSpritesId(int id) {
		return tiles.get(id).getSprite();
	}

	public Tile getTilesId(int id) {
		return tiles.get(id);
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
}
