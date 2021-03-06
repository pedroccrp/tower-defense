package domain.playable;

import java.awt.Color;
import java.awt.Point;

import domain.interactables.Button;
import domain.managers.MapManager;
import domain.managers.PlayerManager;
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
			
			int tWidth = (int)(getWidth() * 0.6f);
			int tHeight = (int)(getHeight() * 0.6f);
			
			int tX = (int)getPosition().getX() + (getWidth() - tWidth) / 2;
			int tY = (int)getPosition().getY() + (getHeight() - tHeight) / 2;
			
			Tower towerToAdd =  new Tower(new Point(tX, tY), tWidth, tHeight, ColorPalette.TOWER, 5, 1, 50, 25, 2 * MapManager.activeMap.getTileWidth());
			
			if (tower == null && PlayerManager.gold >= towerToAdd.getBuyPrice()) {
				
				PlayerManager.gold -= towerToAdd.getBuyPrice();
				
				tower = towerToAdd;
				
				TowerManager.addTower(tower);
			}
			
		} else if (mouseButton == 1) {
			
			if (tower != null) {
				
				PlayerManager.gold += tower.getSellPrice();
				
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
