package domain.interactables;

import java.awt.Point;

public class Collision {
	
	public static boolean checkCollision (Point p1, int w1, int h1, Point p2, int w2, int h2) {
		
		boolean collision = !((p1.getX() + w1 < p2.getX()) || (p1.getX() > p2.getX() + w2) || 
				             (p1.getY() + h1 < p2.getY()) || (p1.getY() > p2.getY() + h2));
		
		return collision;		
	}
}
