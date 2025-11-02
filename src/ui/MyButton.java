package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {

	private int x, y, width, height, id;
	private Rectangle bounds;
	private String text;
	
	private boolean mouseOver, mousePressed;

	public MyButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(x, y, width, height);
	}

	public MyButton(int x, int y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;

		bounds = new Rectangle(x, y, width, height);
	}
	
	public void resetBooleans() {
		mousePressed = false;
		mouseOver = false;
	}
	
	public void drawText(Graphics g) {

		g.setFont(g.getFont().deriveFont(18f));
		g.setColor(Color.BLUE);

		g.drawString(text, x + 5, y - 3);
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
