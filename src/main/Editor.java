package main;

import java.awt.Graphics;

import ui.RightBar;

import static utilz.Constants.WindowConstants.*;

public class Editor implements Runnable{

	private EditorWindow editorWindow;

	private RightBar rightBar;
	
	private Thread myThread;
	private final int FPS = 60;
	

	public Editor() {

		editorWindow = new EditorWindow(this);

		initClasses();
		
		startThread();
	}

	private void startThread() {
		myThread = new Thread(this);
		myThread.start();
	}

	private void initClasses() {
		rightBar = new RightBar(WIDTH_RIGHT_BAR, 0, DEFAULT_TALE * TALE_COUNT, EDITOR_HEIGHT);
	}

	public void draw(Graphics g) {

		rightBar.draw(g);

	}

	public void mouseMoved(int x, int y) {
		if (x >= WIDTH_RIGHT_BAR) {
			rightBar.mouseMoved(x, y);
		}
	}

	public void mousePressed(int x, int y) {
		if(x >= WIDTH_RIGHT_BAR) {
			rightBar.mousePressed(x, y);
		}
	}
	
	@Override
	public void run() {
		double timePerFrame = 1_000_000_000.0 / FPS;
		
		long previousTime = System.nanoTime();

		int frames = 0;
		double delta = 0;
		
		long lastCheck = System.currentTimeMillis();
		
		while(true) {
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
}
