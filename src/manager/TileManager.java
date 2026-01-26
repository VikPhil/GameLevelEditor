package manager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.Tile;
import utilz.ImgPosition;
import utilz.LoadSave;

public class TileManager {

	private Tile  empty, water, grassMoss, grassMiddle;
	
	private Tile[] grassTiles = new Tile[7];

	private BufferedImage atlasWater, atlasFlat;

	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	private ArrayList<Tile> singleTiles = new ArrayList<Tile>();
	private ArrayList<Tile> grassCorners = new ArrayList<Tile>();
	private ArrayList<Tile> grassSides = new ArrayList<Tile>();
	private ArrayList<Tile> grassIslands = new ArrayList<Tile>();
	

	public TileManager() {
		loadAtlas();
		createTiles();
	}

	private void createTiles() {

		int id = 0, counter = 0;

//		tiles.add(empty = new Tile(getSpriteOfAtlas(atlasFlat, 4, 1), id++));
//		tiles.add(water = new Tile(getSpriteOfAtlas(atlasWater, 0, 0), id++));
//		tiles.add(grassMoss = new Tile(getSpriteOfAtlas(atlasFlat, 4, 0), id++));
//		tiles.add(grassMiddle = new Tile(getSpriteOfAtlas(atlasFlat, 1, 1), id++));
		
		//single tiles
		singleTiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 4, 1), id++));
		singleTiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasWater, 0, 0), id++));
		singleTiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 4, 0), id++));
		singleTiles.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 1), id++));
		
		//corner
		counter = 0;
		grassCorners.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 2), id++));
		grassCorners.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 0), id++));
		grassCorners.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 0), id++));
		grassCorners.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 2), id++));
		
		//side
		counter = 0;
		grassSides.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 1), id++));
		grassSides.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 0), id++));
		grassSides.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 1), id++));
		grassSides.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 2), id++));
		//island
		counter = 0;
		grassIslands.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 3), id++));
		grassIslands.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 3), id++));	
		grassIslands.add(grassTiles[counter++] = new Tile(ImgPosition.getRotate(getSpriteOfAtlas(atlasFlat, 0, 3), 90)  , id++));
		grassIslands.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 3), id++));
		grassIslands.add(grassTiles[counter++] = new Tile(ImgPosition.getRotate(getSpriteOfAtlas(atlasFlat, 2, 3), 90)  , id++));		
		grassIslands.add(grassTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 3), id++));
		grassIslands.add(grassTiles[counter++] = new Tile(ImgPosition.getRotate(getSpriteOfAtlas(atlasFlat, 1, 3), 90)  , id++));
	
		
		tiles.addAll(singleTiles);
		tiles.addAll(grassCorners);
		tiles.addAll(grassSides);
		tiles.addAll(grassIslands);

	}

	private void loadAtlas() {
		atlasWater = LoadSave.GetSpriteAtlas(LoadSave.WATER);
		atlasFlat = LoadSave.GetSpriteAtlas(LoadSave.TILE_FLAT);
	}

	// get subimage
	private BufferedImage getSpriteOfAtlas(BufferedImage atlas, int xCor, int yCor) {
		return atlas.getSubimage(xCor * 64, yCor * 64, 64, 64);
	}

	// get image of tile
	public BufferedImage getSpritesId(int id) {
		return tiles.get(id).getSprite();
	}

	public Tile getTilesId(int id) {
		return tiles.get(id);
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	//getters and setters
	public ArrayList<Tile> getGrassCorners() {
		return grassCorners;
	}

	public ArrayList<Tile> getGrassSides() {
		return grassSides;
	}

	public ArrayList<Tile> getGrassIslands() {
		return grassIslands;
	}

	public ArrayList<Tile> getSingleTiles() {
		return singleTiles;
	}
	
}
