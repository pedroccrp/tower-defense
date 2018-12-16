package domain.geometrics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Quad {
	
	private Point position;
	private int width, height;
	private Color color;
	
	private boolean valid;
		
	public Quad(Point position, int width, int height, Color color) {
		
		this.position = position;
		this.width = width;
		this.height = height;
		this.color = color;
		
		valid = true;
	}
	
	public void draw (Graphics g) {
		
		g.setColor(color);
        g.fillRect((int)position.getX(), (int)position.getY(), width, height);				
	}
	
	// Getters and Setters
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}