package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin_Gold extends Entity{
	
	GamePanel gp;

	public OBJ_Coin_Gold(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Gold Coin";
		value = 100;
		down1 =setup("/objects/coin_gold");
		
	}
	public void use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Coin +" + value);
		gp.player.coin += value;
	}

}
