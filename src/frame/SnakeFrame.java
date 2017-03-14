package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanelSnake panel = new JPanelSnake();
	
	public void run(){
		setTitle("Snake Game");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel,BorderLayout.CENTER);
		panel.addCanvas(this);
		
	}
}
