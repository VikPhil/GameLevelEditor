package objects;

import java.awt.Graphics;

import main.Editor;
import manager.TileManager;

public class CanvasLayer {

	private int[][] canvas;
	private TileManager tileManager;

	public CanvasLayer(int[][] canvas) {
		this.canvas = canvas;
		
		tileManager = new TileManager();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				int id = canvas[i][j];
				g.drawImage(tileManager.getSpritesId(id), j * 64, i * 64, null);
			}
		}
	}
	
	public int[][] getCanvas() {
		return canvas;
	}
}
