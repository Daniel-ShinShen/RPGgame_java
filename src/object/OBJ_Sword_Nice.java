package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Nice extends Entity {

	public OBJ_Sword_Nice(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = "Nice Sword";
		down1 = setup("/objects/sword_nice");
		attackValue = 15;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\nA sword with nice look.\nCoated with green color.";
		price = 400;
		
	}
}
