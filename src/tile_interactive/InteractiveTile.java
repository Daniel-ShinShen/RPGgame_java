package tile_interactive;

import entity.Entity;
import main.GamePanel;

public class InteractiveTile extends Entity{
	
	GamePanel gp;
	public boolean destructible = false;
	
	public InteractiveTile(GamePanel gp, int col, int row) {	
		
		super(gp);
		this.gp = gp;
		
	}
	public boolean isCorrectItem(Entity entity) {	
		boolean isCorrectItem = false;
		return isCorrectItem;
	}
	public void playSE() {}
	public InteractiveTile getDestroyForm() {
		InteractiveTile tile = null;
		return tile;
	}
	public void update() {

		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 20) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}

}
