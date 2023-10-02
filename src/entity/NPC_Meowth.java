package entity;

import main.GamePanel;

public class NPC_Meowth extends Entity{
	
	
	public NPC_Meowth(GamePanel gp) {
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
		
		up1 = setup("/npc/meowth_up_1");
		up2 = setup("/npc/meowth_up_1");
		up3 = setup("/npc/meowth_up_1");
		down1 = setup("/npc/meowth_down_1");
		down2 = setup("/npc/meowth_down_1");
		down3 = setup("/npc/meowth_down_1");
		left1 = setup("/npc/meowth_left_1");
		left2 = setup("/npc/meowth_left_1");
		left3 = setup("/npc/meowth_left_1");
		right1 = setup("/npc/meowth_right_1");
		right2 = setup("/npc/meowth_right_1");
		right3 = setup("/npc/meowth_right_1");
		
	}
	public void setDialogue() {
		dialogues[0] = "meow~ meowth!\n(Congratulations! You completed the game!)\n(Your score is: "+gp.player.coin*2+" )";
		dialogues[1] = "meow~ meow~\n(The treasure is over there.)\n(Don't you go to get it?)";
	}

	public void speak() {

		super.speak();
		
	}
}
