package domain.managers;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.playable.Bullet;

public class BulletManager {

	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		
	public static void draw (Graphics g) {
		
		for (Bullet b : new ArrayList<>(bullets)) {
			
			if (b.isValid()) {
				
				b.draw(g);
				
			} else {
				try {
					bullets.remove(b);
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Bullet not found", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public static void update () {
		
		for (Bullet b : bullets) {
			
			b.move();
		}
	}
	
	public static void addBullet(Bullet b) {
		
		bullets.add(b);
	}
	
	public static void removeBullet(Bullet b) {
		
		b.setValid(false);		
	}
}
