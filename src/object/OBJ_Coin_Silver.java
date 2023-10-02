package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin_Silver extends Entity{

	GamePanel gp;

	public OBJ_Coin_Silver(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Silver Coin";
		value = 30;
		down1 =setup("/objects/coin_silver");
		
	}
	public void use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Coin +" + value);
		gp.player.coin += value;
	}
}
