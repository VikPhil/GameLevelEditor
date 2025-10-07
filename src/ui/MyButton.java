package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {

	private int x, y, width, height;
	private Rectangle bounds;

	private boolean mouseOver, mousePressed;

	public MyButton(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(x, y, width, height);
	}

	public void draw(Graphics g) {
		// border
		drawBorder(g);

		// body
		drawBody(g);
	}

	private void drawBody(Graphics g) {

		if (mousePressed) {
			g.setColor(Color.GRAY);
		} else
			g.setColor(Color.WHITE);

		g.fillRect(x, y, width, height);
	}

	private void drawBorder(Graphics g) {
		if (mouseOver) {
			g.setColor(Color.RED);
			g.drawRect(x + 2, y + 2, width - 3, height - 3);
			g.drawRect(x + 3, y + 3, width - 5, height - 5);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}
	}

	// --getters and setters----------------------------------------

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
