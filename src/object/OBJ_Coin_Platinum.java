package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin_Platinum extends Entity{

	GamePanel gp;

	public OBJ_Coin_Platinum(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Platinum Coin";
		value = 500;
		down1 =setup("/objects/coin_platinum");
		
	}
	public void use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Coin +" + value);
		gp.player.coin += value;
	}
}
