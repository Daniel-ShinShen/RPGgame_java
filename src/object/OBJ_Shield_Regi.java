package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Regi extends Entity{

	public OBJ_Shield_Regi(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Regi's Shield";
		down1 = setup("/objects/shield_regi");
		defenseValue = 25;
		description = "[" + name + "]\nA legend shield.\nLooks tough.";
		price = 700;
	}
}
