package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

import main.Editor;
import objects.CanvasLayer;
import objects.Tile;
import utilz.Constants.OtherConstants;
import utilz.LoadSaveFiles;

import static utilz.Constants.WindowConstants.WIDTH_RIGHT_BAR;
import static utilz.Constants.WindowConstants.EDITOR_HEIGHT;
import static utilz.Constants.WindowConstants.EDITOR_WIDTH;
import static utilz.Constants.WindowConstants.DEFAULT_TALE;

public class RightBar {

	private int x, y, width, height;

	private Map<MyButton, ArrayList<Tile>> map = new HashMap<MyButton, ArrayList<Tile>>();

	private MyButton bLayer, bSave;
	private MyButton bSingle, bGCorner, bGSide, bGIsland, bESide, bETop, bEBottom, bEGrassCor, bEGrassSide, bEAngle,
			bRocks;

	private Editor editor;
	private Tile selectedTile;

	private String currentFileName;
	private int countFile;

	private MyButton currentButton;

	private int indexButton = 0;

	// ----------------------------
	//public String[] elements = { "One", "Two", "Three" };
	private DropdownList dropdownList;
	private String[] elements;
	// ----------------------------

	public RightBar(int x, int y, int width, int height, Editor editor) {

		this.editor = editor;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initButtons();

	}

	private void initButtons() {

		bLayer = new MyButton("New layer", EDITOR_WIDTH - DEFAULT_TALE * 2, EDITOR_HEIGHT - 40, 100, 30);
		bSave = new MyButton("Save layer", EDITOR_WIDTH - DEFAULT_TALE * 2, EDITOR_HEIGHT - 100, 100, 30);

		int bWidth = 50;
		int bHeight = 50;
		int xPos = WIDTH_RIGHT_BAR + 32;
		int yPos = 10;
		int xOffset = bWidth + 5;
		int yOffset = bHeight + 5;

		int tileCounter = 0;
		int id = 0;

		initMapButtons(bSingle, editor.getTileManager().getSingleTiles(), xPos, yPos, xOffset * tileCounter++, 0,
				bWidth, bHeight, id++);
		initMapButtons(bGCorner, editor.getTileManager().getGrassCorners(), xPos, yPos, xOffset * tileCounter++, 0,
				bWidth, bHeight, id++);
		initMapButtons(bGSide, editor.getTileManager().getGrassSides(), xPos, yPos, xOffset * tileCounter++, 0, bWidth,
				bHeight, id++);
		initMapButtons(bGIsland, editor.getTileManager().getGrassIsland(), xPos, yPos, xOffset * tileCounter++, 0,
				bWidth, bHeight, id++);
		initMapButtons(bESide, editor.getTileManager().getElevationSides(), xPos, yPos, xOffset * tileCounter++, 0,
				bWidth, bHeight, id++);
		initMapButtons(bEBottom, editor.getTileManager().getElevationBottom(), xPos, yPos, xOffset * tileCounter++, 0,
				bWidth, bHeight, id++);

		tileCounter = 0;

		initMapButtons(bEGrassCor, editor.getTileManager().getElevGrassCorners(), xPos, yPos, xOffset * tileCounter++,
				yOffset, bWidth, bHeight, id++);
		initMapButtons(bEGrassSide, editor.getTileManager().getElevGrassSides(), xPos, yPos, xOffset * tileCounter++,
				yOffset, bWidth, bHeight, id++);
		initMapButtons(bETop, editor.getTileManager().getElevationTop(), xPos, yPos, xOffset * tileCounter++, yOffset,
				bWidth, bHeight, id++);
		initMapButtons(bEAngle, editor.getTileManager().getElevationAngle(), xPos, yPos, xOffset * tileCounter++,
				yOffset, bWidth, bHeight, id++);
		initMapButtons(bRocks, editor.getTileManager().getRocks(), xPos, yPos, xOffset * tileCounter++, yOffset, bWidth,
				bHeight, id++);

		// ---------------------
		elements = new String[LoadSaveFiles.GetListOfFiles().length];
		
		for(int i = 0; i < elements.length;i++)
			elements[i] = LoadSaveFiles.GetFileNameId(i);
		
		// ---------------------
		dropdownList = new DropdownList(elements, xPos, yPos + xOffset * 3, 100, 30);
		// ---------------------
	}

	private void initMapButtons(MyButton b, ArrayList<Tile> list, int x, int y, int xOffset, int yOffset, int w, int h,
			int id) {

		b = new MyButton(x + xOffset, y + yOffset, w, h, id);
		map.put(b, list);

	}

	// rotate sprites
	public void changeSprite() {

		indexButton++;

		if (indexButton >= map.get(currentButton).size())
			indexButton = 0;

		selectedTile = map.get(currentButton).get(indexButton);

	}

	public void draw(Graphics g) {
		drawUiButtons(g);
		drawSelectedTile(g);
		drawMapButtons(g);
	}

	private void drawMapButtons(Graphics g) {
		for (Map.Entry<MyButton, ArrayList<Tile>> entry : map.entrySet()) {
			MyButton b = entry.getKey();
			BufferedImage img = entry.getValue().get(0).getSprite();

			// draw an image on a tile
			g.drawImage(img, b.getX(), b.getY(), b.getWidth(), b.getHeight(), null);

			drawButtonFrames(g, b);

		}
	}

	private void drawButtonFrames(Graphics g, MyButton b) {
		// tiles mouse moved
		if (b.isMouseOver())
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLACK);

		g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());

		// tiles mouse pressed
		if (b.isMousePressed()) {
			g.setColor(Color.WHITE);
			g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}

	private void drawUiButtons(Graphics g) {

		dropdownList.draw(g);

		if (bSave.isMousePressed()) {
			createUiButtons(g, bSave.getX() + 3, bSave.getY() + 3, bSave.getWidth() - 6, bSave.getHeight() - 6);
			bSave.setFont(new Font("Arial", Font.BOLD, 16));
		} else {
			createUiButtons(g, bSave.getX(), bSave.getY(), bSave.getWidth(), bSave.getHeight());

		}

		if (bLayer.isMousePressed()) {
			createUiButtons(g, bLayer.getX() + 3, bLayer.getY() + 3, bLayer.getWidth() - 6, bLayer.getHeight() - 6);
			bLayer.setFont(new Font("Arial", Font.BOLD, 16));
		} else {
			createUiButtons(g, bLayer.getX(), bLayer.getY(), bLayer.getWidth(), bLayer.getHeight());
		}

		bSave.writeText(g);
		bLayer.writeText(g);
	}

	private void createUiButtons(Graphics g, int x, int y, int width, int height) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}


	private void addCanvasLayer() {

		int id = LoadSaveFiles.GetListOfFiles().length;

		id++;

		LoadSaveFiles.CreateLayerFile(OtherConstants.EmptyLayer, id, editor.getLvl());

		currentFileName = LoadSaveFiles.GetFileNameId(id - 1);

		editor.canvas.add(new CanvasLayer(LoadSaveFiles.GetLayerData(currentFileName, editor.getLvl())));

	}

	private void drawSelectedTile(Graphics g) {
		if (selectedTile != null) {
			g.drawImage(selectedTile.getSprite(), WIDTH_RIGHT_BAR + 5, EDITOR_HEIGHT - DEFAULT_TALE, 50, 50, null);
			g.setColor(Color.BLACK);
			g.drawRect(WIDTH_RIGHT_BAR + 5, EDITOR_HEIGHT - DEFAULT_TALE, 50, 50);
		}
	}

	public void mouseMoved(int x, int y) {

		dropdownList.getBDropdown().setMouseOver(false);

		if (dropdownList.getBDropdown().getBounds().contains(x, y)) {
			dropdownList.getBDropdown().setMouseOver(true);
		}

		for (MyButton b : map.keySet()) {
			b.setMouseOver(false);

			if (b.getBounds().contains(x, y)) {
				b.setMouseOver(true);
				return;
			}
		}

	}

	public void mousePressed(int x, int y) {

		bLayer.setMousePressed(false);
		bSave.setMousePressed(false);

		// -----------------------------------------------------
		if (dropdownList.getBDropdown().getBounds().contains(x, y)) {
			dropdownList.setUp(true);
			dropdownList.setOpen(true);
		}
		// -----------------------------------------------------

		if (bLayer.getBounds().contains(x, y)) {
			bLayer.setMousePressed(true);
		}

		if (bSave.getBounds().contains(x, y)) {
			bSave.setMousePressed(true);
		}

		for (MyButton b : map.keySet()) {
			b.setMousePressed(false);

			if (b.getBounds().contains(x, y)) {
				b.setMousePressed(true);
				return;
			}
		}

	}

	public void mouseClicked(int x, int y) {

		if (bLayer.getBounds().contains(x, y)) {
			addCanvasLayer();
			return;
		}

		if (bSave.getBounds().contains(x, y)) {
			currentFileName = LoadSaveFiles.GetFileNameId(countFile);
			LoadSaveFiles.SaveLayer(currentFileName, editor.canvas.get(countFile).getCanvas());
			return;
		}

		for (MyButton b : map.keySet()) {
			if (b.getBounds().contains(x, y)) {
				selectedTile = map.get(b).get(0);
				currentButton = b;
				indexButton = 0;
				return;
			}
		}
	}

	public void mouseReleased(int x, int y) {

		bLayer.resetBooleans();
		bSave.resetBooleans();

		countFile = LoadSaveFiles.GetListOfFiles().length - 1;

		for (MyButton b : map.keySet()) {
			b.resetBooleans();
		}
	}

	// getters and setters
	public Tile getSelectedTile() {
		return selectedTile;
	}

	public int getCountFile() {
		return countFile;
	}

}
