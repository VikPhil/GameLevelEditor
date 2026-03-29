package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DropdownList {

	private String[] items;
	private String selectedItem;
	private boolean isOpen = false, isUp = true;
	private int x, y, width, height;

	private MyButton bDropdown;
	private Font font = new Font("Arial", Font.PLAIN, 14);

	public DropdownList(String[] items, int x, int y, int width, int height) {
		this.items = items;
		this.selectedItem = items[0];
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bDropdown = new MyButton(x + (width - 20), y, 20, height, width);

	}

	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString(selectedItem, x + 5, y + height - 5);

		
		bDropdown.draw(g);
		drawArrow(g, !isUp);

		// Выпадающие элементы, если открыто
		if (isOpen) {
			
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height * items.length);
			g.setColor(Color.GRAY);
			g.drawRect(x, y, width, height * items.length);

			// Рисуем каждый элемент
			for (int i = 0; i < items.length; i++) {
				String item = items[i];

				// Подсветка при наведении
//                if (getMousePosition() != null &&
//                    getMousePosition().y >= height + i * height &&
//                    getMousePosition().y < height + (i + 1) * height) {
//                    g2d.setColor(Color.LIGHT_GRAY);
//                    g2d.fillRect(0, height + i * height, width, height);
//                }

				g.setColor(Color.BLACK);
				g.drawString(item, x + 10, (y + height - 5) + height * i);
				g.drawRect(x, y, width, height * i);
			}
			
			bDropdown.draw(g);
			drawArrow(g, isUp);
		}

	}

	// Рисуем стрелку
	private void drawArrow(Graphics g, boolean dir) {
		// down
		int[] xPoints = { x + (width - 15), x + (width - 5), x + (width - 10) };
		int[] yPoints = { y + (height / 2 - 2), y + (height / 2 - 2), y + (height / 2 + 3) };

		if (dir) {
			// up
			xPoints[0] = x + (width - 15);
			xPoints[1] = x + (width - 5);
			xPoints[2] = x + (width - 10);

			yPoints[0] = y + (height / 2 + 2);
			yPoints[1] = y + (height / 2 + 2);
			yPoints[2] = y + (height / 2 - 3);

		}
		g.setColor(Color.BLACK);

		g.fillPolygon(xPoints, yPoints, 3);

	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public MyButton getBDropdown() {
		return bDropdown;
	}
		
}