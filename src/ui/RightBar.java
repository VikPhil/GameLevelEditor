package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import static utilz.Constants.WindowConstants.WIDTH_RIGHT_BAR;
import static utilz.Constants.WindowConstants.DEFAULT_TALE;

public class RightBar {

	private int x, y, width, height;
	private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();

	public RightBar(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initButtons();
	}

	private void initButtons() {

		int bWidth = 50;
		int bHeight = 50;
		int xPos = WIDTH_RIGHT_BAR + 32;
		int yPos = 10;
		int xOffset = bWidth + 5;

		int tileCounter = 0;

		for (int i = 0; i < 8; i++) {
			tileButtons.add(new MyButton(xPos + xOffset * tileCounter, yPos, bWidth, bHeight));
			tileCounter++;

			if (tileCounter == 6) {
				tileCounter = 0;
				yPos += DEFAULT_TALE;
			}
		}
	}

	public void draw(Graphics g) {
		// background
		g.setColor(new Color(244, 164, 95));
		g.fillRect(x, y, width, height);

		drawButtons(g);
	}

	private void drawButtons(Graphics g) {
		for (MyButton b : tileButtons) {
			b.draw(g);
		}
	}

	public void mouseMoved(int x, int y) {

		for (MyButton b : tileButtons) {
			b.setMouseOver(false);		
			if (b.getBounds().contains(x, y)) {
				b.setMouseOver(true);
				return;
			}
		}
	}

	public void mousePressed(int x, int y) {

		for (MyButton b : tileButtons) 
			b.setMousePressed(false);
			for (MyButton b : tileButtons)
			if (b.getBounds().contains(x, y)) {
				b.setMousePressed(true);
				return;
			}
		
	}
}
