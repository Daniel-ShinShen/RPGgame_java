package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Super extends Entity{

	public OBJ_Potion_Super(GamePanel gp) {
		super(gp);

		type = type_consumable;
		name = "Super Potion";
		value = 20;
		down1 = setup("/objects/potion_super");
		description = "[" + name + "]\nThe best potion ever.\nHeals your life by "+value+".";
		price = 200;
	}
	public void use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You drink the " + name + "!\n"
				+"Your life has been recovered by " + value + ".";
		entity.life += value;
		gp.playSE(2);
	}
}
