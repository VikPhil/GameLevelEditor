package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import manager.ButtonManager;
import manager.TileManager;
import objects.CanvasLayer;
import ui.RightBar;
import utilz.LoadSaveFiles;

import static utilz.Constants.WindowConstants.*;

public class Editor implements Runnable {

	private int mouseX, mouseY;
	private boolean drawSelect = false;

	private EditorWindow editorWindow;

	private RightBar rightBar;
	private TileManager tileManager;
	private ButtonManager buttonManager;

	private Thread myThread;
	private final int FPS = 60;

	private int[][] lvl = new int[EDITOR_HEIGHT / DEFAULT_TALE][WIDTH_RIGHT_BAR / DEFAULT_TALE];

	public ArrayList<CanvasLayer> canvas = new ArrayList<CanvasLayer>();

	private String currentNameTxtFile;
	
	private int idCanvas;
	
	public Editor() {

		initClasses();
		editorWindow = new EditorWindow(this);

		startThread();
	
	}

	private void initCanvasesOfLevel() {
			
		canvas.clear();
		
		for (int i = 0; i < LoadSaveFiles.GetListOfFiles().length; i++) {
			currentNameTxtFile = LoadSaveFiles.GetFileNameId(i);
			canvas.add(new CanvasLayer(LoadSaveFiles.GetLayerData(currentNameTxtFile, lvl)));
		}
	}

	private void startThread() {
		myThread = new Thread(this);
		myThread.start();
	}

	private void initClasses() {
		tileManager = new TileManager();
		buttonManager = new ButtonManager();

		rightBar = new RightBar(WIDTH_RIGHT_BAR, 0, DEFAULT_TALE * TALE_COUNT, EDITOR_HEIGHT, this);

		initCanvasesOfLevel();

	}

	public void draw(Graphics g) {

		rightBar.draw(g);
		for (CanvasLayer cl : canvas)
			cl.draw(g);

		drawSelectedTile(g);
		
	}

	private void drawSelectedTile(Graphics g) {

		if (rightBar.getSelectedTile() != null && drawSelect) {
			g.drawImage(rightBar.getSelectedTile().getSprite(), mouseX, mouseY, 64, 64, null);
		}
	}

	private void insertATile(int x, int y) {

		idCanvas = LoadSaveFiles.GetListOfFiles().length - 1;
		
		if (rightBar.getSelectedTile() != null) {
			int tileX = x / 64;
			int tileY = y / 64;

			canvas.get(idCanvas).getCanvas()[tileY][tileX] = rightBar.getSelectedTile().getId();
		}
	}

	@Override
	public void run() {
		double timePerFrame = 1_000_000_000.0 / FPS;

		long previousTime = System.nanoTime();

		int frames = 0;
		double delta = 0;

		long lastCheck = System.currentTimeMillis();

		while (true) {
			long currentTime = System.nanoTime();

			delta += (currentTime - previousTime) / timePerFrame;

			previousTime = currentTime;

			if (delta >= 1) {
				editorWindow.repaint();
				frames++;
				delta--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}

	}

	public void mouseMoved(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR) {
			rightBar.mouseMoved(x, y);
			drawSelect = false;
		} else {
			drawSelect = true;
			mouseX = (x / 64) * 64;
			mouseY = (y / 64) * 64;
		}
	}

	public void mousePressed(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR) {
			rightBar.mousePressed(x, y);
		}
	}

	public void mouseClicked(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR)
			rightBar.mouseClicked(x, y);
		else
			insertATile(mouseX, mouseY);

	}

	public void mouseReleased(int x, int y) {
		
			rightBar.mouseReleased(x, y);
	}

	public void mouseDragged(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR) {

		} else
			insertATile(x, y);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_R) {
			rightBar.changeSprite();
		}
	}

	// getters and setters
	public TileManager getTileManager() {
		return tileManager;
	}

	public ButtonManager getButtonManager() {
		return buttonManager;
	}

	public void setDrawSelect(boolean drawSelect) {
		this.drawSelect = drawSelect;
	}

	public int[][] getLvl() {
		return lvl;
	}

	public Thread getMyThread() {
		return myThread;
	}
	
	public int getIdCanvas() {
		return idCanvas;
	}

}