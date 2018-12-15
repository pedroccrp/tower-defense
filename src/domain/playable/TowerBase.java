package domain.playable;

import java.awt.Color;
import java.awt.Point;

import domain.interactables.Button;
import domain.managers.TowerManager;
import domain.map.ColorPalette;

public class TowerBase extends Button {
	
	private Tower tower;

	public TowerBase(Point position, int width, int height, Color normalColor, Color highlightColor, boolean active,
			Tower tower) {
	
		super(position, width, height, normalColor, highlightColor, active);
		
		this.tower = tower;
	}
	
	@Override
	public void onMouseClick(int mouseButton) {
		
		if (mouseButton == 0) {
			
			if (tower == null) {
				
				int tWidth = (int)(getWidth() * 0.8f);
				int tHeight = (int)(getHeight() * 0.8f);
				
				int tX = (int)getPosition().getX() + (getWidth() - tWidth) / 2;
				int tY = (int)getPosition().getY() + (getHeight() - tHeight) / 2;
				
				tower = new Tower(new Point(tX, tY), tWidth, tHeight, ColorPalette.TOWER, 0, 0, 0, 0, 0);
				
				TowerManager.addTower(tower);
			}
			
		} else if (mouseButton == 1) {
			
			if (tower != null) {
				
				TowerManager.removeTower(tower);
				tower = null;
			}
		}
	}
	
	// Getters and Setters

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}
}
