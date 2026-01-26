package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	// private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();
	private Map<MyButton, ArrayList<Tile>> map = new HashMap<MyButton, ArrayList<Tile>>();

	private MyButton bLayer, bSave;
	private MyButton bSingle, bGCorner, bGSide, bGIsland;

	private Editor editor;
	private Tile selectedTile;

	private String currentFileName;
	private int countFile;

	private MyButton currentButton;

	private int indexButton = 0;
	int yPos = 10;

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

		int tileCounter = 0;
		int id = 0;

//		for (Tile tile : editor.getTileManager().getTiles()) {
//			tileButtons.add(new MyButton(xPos + xOffset * tileCounter, yPos, bWidth, bHeight, id));
//
//			id++;
//			tileCounter++;
//
//			if (tileCounter == 6) {
//				tileCounter = 0;
//				yPos += DEFAULT_TALE;
//			}
//		}

		initMapButtons(bSingle, editor.getTileManager().getSingleTiles(), xPos, yPos, xOffset * tileCounter++, bWidth,
				bHeight, id++);
		initMapButtons(bGCorner, editor.getTileManager().getGrassCorners(), xPos, yPos, xOffset * tileCounter++, bWidth,
				bHeight, id++);
		initMapButtons(bGSide, editor.getTileManager().getGrassSides(), xPos, yPos, xOffset * tileCounter++, bWidth,
				bHeight, id++);
		initMapButtons(bGIsland, editor.getTileManager().getGrassIslands(), xPos, yPos, xOffset * tileCounter++, bWidth,
				bHeight, id++);

	}

	private void initMapButtons(MyButton b, ArrayList<Tile> list, int x, int y, int xOffset, int w, int h, int id) {

		b = new MyButton(x + xOffset, y, w, h, id);
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
		// background
		g.setColor(new Color(244, 164, 95));
		g.fillRect(x, y, width, height);

		drawUiButtons(g);
		drawSelectedTile(g);
		drawMapButtons(g);
	}

	private void drawMapButtons(Graphics g) {
		// TODO Auto-generated method stub
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

		if (bSave.isMousePressed()) {
			g.drawImage(editor.getButtonManager().getBBluePressed(), bSave.getX(), bSave.getY(), bSave.getWidth(),
					bSave.getHeight(), null);
		} else {
			g.drawImage(editor.getButtonManager().getBBlue(), bSave.getX(), bSave.getY(), bSave.getWidth(),
					bSave.getHeight(), null);
		}

		if (bLayer.isMousePressed()) {
			g.drawImage(editor.getButtonManager().getBRedPressed(), bLayer.getX(), bLayer.getY(), bLayer.getWidth(),
					bLayer.getHeight(), null);

		} else {
			g.drawImage(editor.getButtonManager().getBRed(), bLayer.getX(), bLayer.getY(), bLayer.getWidth(),
					bLayer.getHeight(), null);
		}

		drawTextOfButton(g);
	}

	private void drawTextOfButton(Graphics g) {
		bLayer.drawText(g);
		bSave.drawText(g);
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

	private BufferedImage getButtonImage(int id) {
		return editor.getTileManager().getSpritesId(id);
	}

	public void mouseMoved(int x, int y) {

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

//		for (MyButton b : tileButtons) {
//			if (b.getBounds().contains(x, y)) {
//				selectedTile = editor.getTileManager().getTilesId(b.getId());
//				return;
//			}
//		}
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
