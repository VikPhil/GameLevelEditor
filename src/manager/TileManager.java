package manager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.Tile;
import utilz.LoadSave;

public class TileManager {

	private Tile  empty, water, grassMoss, grassMiddle;
	
	private Tile[] flatTiles = new Tile[7];

	private BufferedImage atlasWater, atlasFlat;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	private ArrayList<Tile> singleTiles = new ArrayList<Tile>();
	private ArrayList<Tile> grassCorners = new ArrayList<Tile>();
	private ArrayList<Tile> grassSides = new ArrayList<Tile>();
	private ArrayList<Tile> grassIsland = new ArrayList<Tile>();
	
	private ArrayList<Tile> elevationSides = new ArrayList<Tile>();
	private ArrayList<Tile> elevationTop = new ArrayList<Tile>();
	private ArrayList<Tile> elevationBottom = new ArrayList<Tile>();
	
	private ArrayList<Tile> elevGrassCorners = new ArrayList<Tile>();
	private ArrayList<Tile> elevGrassSides = new ArrayList<Tile>();
	
	private ArrayList<Tile> elevationAngle = new ArrayList<Tile>();
	private ArrayList<Tile> rocks = new ArrayList<Tile>();
	
	public TileManager() {
		loadAtlas();
		createTiles();
	}

	private void createTiles() {

		int id = 0, counter = 0;

//		tiles.add(empty = new Tile(getSpriteOfAtlas(atlasFlat, 4, 1), id++));
//		tiles.add(water = new Tile(getSpriteOfAtlas(atlasWater, 0, 0), id++));
//		tiles.add(grassMoss = new Tile(getSpriteOfAtlas(atlasFlat, 4, 0), id++));
		
		
		//single tiles
		singleTiles.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasWater, 0, 0), id++));
		singleTiles.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 1), id++));
		singleTiles.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 4, 1), id++));
		
		
		//corner
		counter = 0;
		grassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 2), id++));
		grassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 0), id++));
		grassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 0), id++));
		grassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 2), id++));
		
		//side
		counter = 0;
		grassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 1), id++));
		grassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 0), id++));
		grassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 1), id++));
		grassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 2), id++));
		//island
		counter = 0;
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 3), id++));
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 0, 3), id++));	
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 0), id++));
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 2, 3), id++));
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 2), id++));		
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 1, 3), id++));
		grassIsland.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 3, 1)  , id++));
	
		//elevation 
		counter = 0;
		elevationSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,5 ,5), id++));
		elevationSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,6 ,5), id++));
		elevationSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,7 ,5), id++));
		elevationSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,5), id++));
		counter = 0;
		elevationBottom.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,5 ,4), id++));
		elevationBottom.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,6 ,4), id++));
		elevationBottom.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,7 ,4), id++));
		elevationBottom.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,4), id++));
		counter = 0;

		elevGrassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 5, 2), id++));
		elevGrassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 5, 0), id++));
		elevGrassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 7, 0), id++));
		elevGrassCorners.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 7, 2), id++));
		counter = 0;
		elevGrassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 5, 1), id++));
		elevGrassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 6, 0), id++));
		elevGrassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 7, 1), id++));
		elevGrassSides.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat, 6, 2), id++));
		counter = 0;
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,3), id++));
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,5 ,3), id++));	
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,0), id++));
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,7 ,3), id++));	
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,2), id++));		
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,6 ,3), id++));
		elevationTop.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,8 ,1), id++));
		counter = 0;
		elevationAngle.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,0 ,4), id++));
		elevationAngle.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,0 ,5), id++));
		elevationAngle.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,3 ,4), id++));
		elevationAngle.add(flatTiles[counter++] = new Tile(getSpriteOfAtlas(atlasFlat,3 ,5), id++));
		
		rocks.add(new Tile(LoadSave.GetSpriteAtlas(LoadSave.ROCKS_1), id++));
		rocks.add(new Tile(LoadSave.GetSpriteAtlas(LoadSave.ROCKS_2), id++));
		rocks.add(new Tile(LoadSave.GetSpriteAtlas(LoadSave.ROCKS_3), id++));
		rocks.add(new Tile(LoadSave.GetSpriteAtlas(LoadSave.ROCKS_4), id++));
		
		tiles.addAll(singleTiles);
		tiles.addAll(grassCorners);
		tiles.addAll(grassSides);
		tiles.addAll(grassIsland);
		tiles.addAll(elevationSides);
		tiles.addAll(elevationBottom);
		tiles.addAll(elevGrassCorners);
		tiles.addAll(elevGrassSides);
		tiles.addAll(elevationTop);
		tiles.addAll(elevationAngle);
		tiles.addAll(rocks);
	}

	private void loadAtlas() {
		atlasWater = LoadSave.GetSpriteAtlas(LoadSave.WATER);
		atlasFlat = LoadSave.GetSpriteAtlas(LoadSave.TILE_FLAT1);
		
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

	public ArrayList<Tile> getGrassIsland() {
		return grassIsland;
	}

	public ArrayList<Tile> getSingleTiles() {
		return singleTiles;
	}
	
	public ArrayList<Tile> getElevationSides() {
		return elevationSides;
	}
	
	public ArrayList<Tile> getElevationTop() {
		return elevationTop;
	}
	
	public ArrayList<Tile> getElevationBottom() {
		return elevationBottom;
	}

	public ArrayList<Tile> getElevGrassCorners() {
		return elevGrassCorners;
	}

	public ArrayList<Tile> getElevGrassSides() {
		return elevGrassSides;
	}

	public ArrayList<Tile> getElevationAngle() {
		return elevationAngle;
	}

	public ArrayList<Tile> getRocks() {
		return rocks;
	}
}
