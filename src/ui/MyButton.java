package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {

	private int x, y, width, height, id;
	private Rectangle bounds;

	private boolean mouseOver, mousePressed;

	public MyButton(int x, int y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;

		bounds = new Rectangle(x, y, width, height);
	}

	public void draw(Graphics g) {
		// border
		drawBorder(g);

		// body
		drawBody(g);
	}

	private void drawBody(Graphics g) {

		if (mousePressed)
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.GREEN);

		g.fillRect(x, y, width, height);
	}

	private void drawBorder(Graphics g) {

		if (mouseOver)
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLACK);

		g.drawRect(x - 1, y - 1, width + 1, height + 1);
	}

	public void resetBooleans() {
		mousePressed = false;
		mouseOver = false;
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
	
	public int getId() {
		return id;
	}
}
