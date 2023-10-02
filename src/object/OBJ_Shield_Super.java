package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Super extends Entity{

	public OBJ_Shield_Super (GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Super Shield";
		down1 = setup("/objects/shield_super");
		defenseValue = 14;
		description = "[" + name + "]\nA shield of good defence.\nIsn't it SUPER?.";
		price = 300;
	}
}
