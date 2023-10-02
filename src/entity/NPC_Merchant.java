package entity;

import main.GamePanel;
import object.OBJ_Axe;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Potion_Super;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Regi;
import object.OBJ_Shield_Super;
import object.OBJ_Sword_Diamond;
import object.OBJ_Sword_Nice;

public class NPC_Merchant extends Entity{	
	
	public NPC_Merchant(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 0;

		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		setDialogue();
		setItems();
	}
	
	
	public void getImage() {
		
		up1 = setup("/npc/merchant_down_1");
		up2 = setup("/npc/merchant_down_2");
		up3 = setup("/npc/merchant_down_1");
		down1 = setup("/npc/merchant_down_1");
		down2 = setup("/npc/merchant_down_2");
		down3 = setup("/npc/merchant_down_1");
		left1 = setup("/npc/merchant_down_1");
		left2 = setup("/npc/merchant_down_2");
		left3 = setup("/npc/merchant_down_1");
		right1 = setup("/npc/merchant_down_1");
		right2 = setup("/npc/merchant_down_2");
		right3 = setup("/npc/merchant_down_1");
		
	}
	public void setDialogue() {
		dialogues[0] = "He he, so you found me.\nI have some good stuff.\nDo you want to trade?";
	}
	public void setItems() {
		inventory.add(new OBJ_Potion_Red(gp));
		inventory.add(new OBJ_Potion_Super(gp));
		inventory.add(new OBJ_Axe(gp));
		inventory.add(new OBJ_Sword_Nice(gp));
		inventory.add(new OBJ_Sword_Diamond(gp));
		inventory.add(new OBJ_Shield_Blue(gp));
		inventory.add(new OBJ_Shield_Super(gp));	
		inventory.add(new OBJ_Shield_Regi(gp));
		inventory.add(new OBJ_Key(gp));

	}
	public void speak() {
		
		super.speak();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}
}
