package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.EditorPanel;

public class MyMouseInput implements MouseListener, MouseMotionListener {

	private EditorPanel editorPanel;

	public MyMouseInput(EditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		editorPanel.getEditor().mouseDragged(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		editorPanel.getEditor().mouseMoved(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		editorPanel.getEditor().mouseClicked(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			editorPanel.getEditor().mousePressed(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		editorPanel.getEditor().mouseReleased(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
