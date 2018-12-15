package domain.managers;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import domain.window.Window;

public class MouseManager implements MouseListener {
	
	private static Point mousePosition = new Point(100, 0);
	
	public static Point getMousePosition (Window window) {
				
		ActionListener al = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            Point p = MouseInfo.getPointerInfo().getLocation();
	           
	            mousePosition = new Point(p.x - window.getLocation().x, p.y - window.getLocation().y - window.getInsets().top);
	        }
	    };
	    
	    al.actionPerformed(null);
	    return mousePosition;
	}
	

	@Override
    public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			System.out.println("click");
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			System.out.println("r-click");
		}
		else if(SwingUtilities.isMiddleMouseButton(e)) {
			System.out.println("Coé");
		}
    }



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

