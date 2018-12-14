package domain.geometrics;

import java.awt.Color;
import java.awt.Point;

public class Quad {
	
	private Point position;
	private int width, height;
	private Color color;
		
	public Quad(Point position, int width, int height, Color color) {
		
		this.position = position;
		this.width = width;
		this.height = height;
		this.color = color;
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
}
