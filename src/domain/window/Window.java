package domain.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	public Window(int windowWidth, int windowHeight, String title) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		this.setTitle(title);
		int cornerX = (int)screenWidth/2 - windowWidth/2;
		int cornerY = (int)screenHeight/2 - windowHeight/2;
		setBounds(cornerX, cornerY, windowWidth, windowHeight);
		getContentPane(). setBackground( Color .cyan.darker());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.red,3));
		//getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(false);
	}
	public static void main(String args[]) {
		int width = 800;
		int height = 600;
		String title = "Janela";
		new	Window(width, height, title).setVisible(true);
	}
}

