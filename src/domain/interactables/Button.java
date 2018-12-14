package domain.interactables;

import java.awt.Color;
import java.awt.Point;

import static domain.interactables.Collision.*;

public class Button implements Interactable {
	
	private Point position;
	private int width, height;
	private Color color;
	private boolean active;
		
	public Button(Point position, int width, int height, Color color, boolean active) {
	
		this.position = position;
		this.width = width;
		this.height = height;
		this.color = color;
		this.active = active;
	}
	
	@Override
	public boolean detectMouse(Point mousePos) {
		
		return checkCollision(position, width, height, mousePos, 0, 0);
	}
	
	@Override
	public void onMouseClick() {
		
	}
	
	@Override
	public void onMouseHover() {
		
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	
}
