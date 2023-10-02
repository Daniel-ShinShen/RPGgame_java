package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Diamond extends Entity {
	
	public OBJ_Sword_Diamond(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = "Diamond Sword";
		down1 = setup("/objects/sword_diamond");
		attackValue = 20;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\nMade of rare ores.\nSparkling with blue light.";
		price = 800;
		
	}

}
