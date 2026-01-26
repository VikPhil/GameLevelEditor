package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.MyKeyboardInput;
import inputs.MyMouseInput;

import static utilz.Constants.WindowConstants.EDITOR_WIDTH;
import static utilz.Constants.WindowConstants.EDITOR_HEIGHT;

public class EditorPanel extends JPanel{

	private Editor editor;
	
	private MyMouseInput mouseInput;
	
	public EditorPanel(Editor editor) {
		this.editor = editor;
		mouseInput = new MyMouseInput(this);
		
		setPanelSize();
		
		addKeyListener(new MyKeyboardInput(this));
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);	
		
	}

	private void setPanelSize() {		
		setBackground(Color.GRAY);
		Dimension size = new Dimension(EDITOR_WIDTH, EDITOR_HEIGHT);
		setPreferredSize(size);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		editor.draw(g);
	}

	public Editor getEditor() {
		return editor;
	}
	
}
