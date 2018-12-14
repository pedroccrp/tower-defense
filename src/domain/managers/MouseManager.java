package domain.managers;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.window.Window;

public class MouseManager {
	
	private static Point mousePosition = new Point(100, 0);
	
	public static Point getMousePosition (Window window) {
				
		ActionListener al = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            Point p = MouseInfo.getPointerInfo().getLocation();
	           
	            mousePosition = new Point(p.x - window.getLocation().x, p.y - window.getLocation().y);
	        }
	    };
	    
	    al.actionPerformed(null);
	    return mousePosition;
	}
}
