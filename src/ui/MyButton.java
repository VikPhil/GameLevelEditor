package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {

	private int x, y, width, height, id;
	private Rectangle bounds;
	private String text;

	private Font font;

	private boolean mouseOver, mousePressed;

	public MyButton(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initBounds();
	}

	public MyButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		font = new Font("Arial", Font.BOLD, 18);
		initBounds();
	}

	public MyButton(int x, int y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;

		initBounds();
	}

	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}

	public void resetBooleans() {
		mousePressed = false;
		mouseOver = false;

		font = new Font("Arial", Font.BOLD, 18);
	}

	public void writeText(Graphics g) {

		g.setFont(font);
		g.setColor(Color.BLUE);

		int w = g.getFontMetrics().stringWidth(text);

		g.drawString(text, x - w / 2 + width / 2, y + 20);
	}

	public void draw(Graphics g) {	
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
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

	public void setFont(Font font) {
		this.font = font;
	}

}
