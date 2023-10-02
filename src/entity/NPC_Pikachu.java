package entity;

import main.GamePanel;

public class NPC_Pikachu extends Entity{
	
	public NPC_Pikachu(GamePanel gp) {
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
	}
	
	
	public void getImage() {
		
		up1 = setup("/npc/pikachu_up_1");
		up2 = setup("/npc/pikachu_up_1");
		up3 = setup("/npc/pikachu_up_1");
		down1 = setup("/npc/pikachu_down_1");
		down2 = setup("/npc/pikachu_down_1");
		down3 = setup("/npc/pikachu_down_1");
		left1 = setup("/npc/pikachu_left_1");
		left2 = setup("/npc/pikachu_left_1");
		left3 = setup("/npc/pikachu_left_1");
		right1 = setup("/npc/pikachu_right_1");
		right2 = setup("/npc/pikachu_right_1");
		right3 = setup("/npc/pikachu_right_1");
		
	}
	public void setDialogue() {
		dialogues[0] = "Pika-pikachu! Pika?\n(The game has come to the end.\nDo you want to end the game?)";
	}
	public void speak() {
		
		super.speak();
		gp.gameState = gp.endState;
	}
}
