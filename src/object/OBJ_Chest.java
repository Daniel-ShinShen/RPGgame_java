package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity{

	public OBJ_Chest(GamePanel gp) {
		super(gp);
		
		name = "Treasure";
		down1 = setup("/objects/chest");
		defenseValue = 2;
		description = "[" + name + "]\nThe symbol of glory.\nSold in high price.";
		price = 6000;
	}
}
