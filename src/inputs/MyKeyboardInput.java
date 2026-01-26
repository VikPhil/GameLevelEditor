package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.EditorPanel;

public class MyKeyboardInput implements KeyListener{

	private EditorPanel editorPanel;
	
	public MyKeyboardInput(EditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		editorPanel.getEditor().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
