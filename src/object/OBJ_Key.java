package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	public OBJ_Key(GamePanel gp) {	
		super(gp);
		
		type = type_Key;
		name ="Key";	
		down1 = setup("/objects/key");
		description = "[" + name + "]\nIt opens a door.";
		price = 1000;
	
	}
	public void use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You can open the Door !";
		gp.player.hasKey++;
		gp.playSE(1);
	}
}
