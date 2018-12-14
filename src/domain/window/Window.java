package domain.window;

import javax.swing.*;

import domain.geometrics.Quad;

import java.awt.*;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
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
		
		//getRootPane().setBorder(BorderFactory.createLineBorder(Color.red,3));
		//getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		//setUndecorated(false);
	}
	
	public void init () {
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		int width = 800;
		int height = 600;
		String title = "Janela";
		Window window = new	Window(title, width, height, new Color(0, 0, 0, 255));
        
		JPanel j1 = new JPanel() {
        	
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
	            super.paintComponent(g);

	            Quad q = new Quad(new Point(0, 0), 50, 50, Color.red);
	            
	            q.draw(g);
	            
	            g.setColor(Color.BLACK);
	            g.drawRect(0, 0, 50, 50);

	            g.drawLine(20, 10, 20, 20);
	            g.drawLine(30, 10, 30, 20);

	            g.drawArc(15, 15, 20, 20, 180, 180);


	            g.drawString("î Pedro", 5, 65);
            }
       };
		
       j1.setBackground(new Color(0, 0, 0, 255));
       
	   window.add(j1);
       window.setVisible(true);
		
	}
}
