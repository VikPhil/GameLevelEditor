package main;

import javax.swing.JFrame;

public class EditorWindow extends JFrame{
	
	private EditorPanel editorPanel;
	
	public EditorWindow(Editor editor) {
		
		editorPanel = new EditorPanel(editor);
		
		add(editorPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
