package domain.interactables;

import java.awt.Color;
import java.awt.Point;

import domain.geometrics.Quad;

import static domain.interactables.Collision.*;

public class Button extends Quad implements Interactable {
	
	private Color normalColor, highlightColor;
	private boolean active;
		
	public Button(Point position, int width, int height, Color normalColor, Color highlightColor, boolean active) {
		
		super(position, width, height, normalColor);
		
		this.normalColor = normalColor;
		this.highlightColor = highlightColor;
		this.active = active;
	}

	@Override
	public boolean detectMouse(Point mousePos) {
		
		return checkCollision(getPosition(), getWidth(), getHeight(), mousePos, 0, 0);
	}
	
	@Override
	public void onMouseClick() {
		
	}
	
	@Override
	public void onMouseHover() {
		
	}
	
	// Getters and Setters

	public boolean isActive() {
		return active;
	}

	public Color getNormalColor() {
		return normalColor;
	}

	public void setNormalColor(Color normalColor) {
		this.normalColor = normalColor;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Color getHighlightColor() {
		return highlightColor;
	}

	public void setHighlightColor(Color highlightColor) {
		this.highlightColor = highlightColor;
	}
}
