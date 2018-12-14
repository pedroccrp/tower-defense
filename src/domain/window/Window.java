package domain.window;

import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JPanel panel;
	
	public Window (String title, int windowWidth, int windowHeight, Color windowColor) {
		
		this.setTitle(title);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		int cornerX = (int)screenWidth/2 - windowWidth/2;
		int cornerY = (int)screenHeight/2 - windowHeight/2;
		
		setBounds(cornerX, cornerY, windowWidth, windowHeight);
		
		getContentPane().setBackground(windowColor);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
	}
	
	public void init () {
	
		setVisible(true);
	}
	
	// Getters and Setters
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
