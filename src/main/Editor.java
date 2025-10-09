package main;

import java.awt.Graphics;

import manager.TileManager;
import ui.RightBar;

import static utilz.Constants.WindowConstants.*;

public class Editor implements Runnable {

	private int mouseX, mouseY;
	private boolean drawSelect = false;

	private EditorWindow editorWindow;

	private RightBar rightBar;
	private TileManager tileManager;

	private Thread myThread;
	private final int FPS = 60;

	private int[][] lvl = new int[EDITOR_HEIGHT / DEFAULT_TALE][WIDTH_RIGHT_BAR / DEFAULT_TALE];

	public Editor() {

		initClasses();
		editorWindow = new EditorWindow(this);

		startThread();
	}

	private void startThread() {
		myThread = new Thread(this);
		myThread.start();
	}

	private void initClasses() {
		tileManager = new TileManager();

		rightBar = new RightBar(WIDTH_RIGHT_BAR, 0, DEFAULT_TALE * TALE_COUNT, EDITOR_HEIGHT, this);
	}

	public void draw(Graphics g) {

		for (int i = 0; i < lvl.length; i++) {
			for (int j = 0; j < lvl[i].length; j++) {
				int id = lvl[i][j];
				g.drawImage(tileManager.getSpritesId(id), j * 64, i * 64, null);
			}
		}

		rightBar.draw(g);

		drawSelectedTile(g);
	}

	private void drawSelectedTile(Graphics g) {

		if (rightBar.getSelectedTile() != null && drawSelect) {
			g.drawImage(rightBar.getSelectedTile().getSprite(), mouseX, mouseY, 64, 64, null);
		}
	}

	private void insertATile(int x, int y) {

		if (rightBar.getSelectedTile() != null) {
			int tileX = x / 64;
			int tileY = y / 64;

			lvl[tileY][tileX] = rightBar.getSelectedTile().getId();
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

		if (x >= WIDTH_RIGHT_BAR)
			rightBar.mouseReleased(x, y);
	}

	public void mouseDragged(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR) {

		} else
			insertATile(x, y);
	}

	// getters and setters
	public TileManager getTileManager() {
		return tileManager;
	}

	public void setDrawSelect(boolean drawSelect) {
		this.drawSelect = drawSelect;
	}
}
