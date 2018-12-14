package domain.interactables;

import java.awt.Point;

public interface Interactable {
		
	public boolean detectMouse(Point mousePos);
	public void onMouseClick();
	public void onMouseHover();
	public boolean isActive();
}