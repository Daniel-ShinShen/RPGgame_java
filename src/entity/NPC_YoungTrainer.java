package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import main.GamePanel;
import main.UtilityTool;

public class NPC_YoungTrainer extends Entity{
	
	
	public NPC_YoungTrainer(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;

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
		
		up1 = setup("/npc/youngtrainer_up_1");
		up2 = setup("/npc/youngtrainer_up_2");
		up3 = setup("/npc/youngtrainer_up_3");
		down1 = setup("/npc/youngtrainer_down_1");
		down2 = setup("/npc/youngtrainer_down_2");
		down3 = setup("/npc/youngtrainer_down_3");
		left1 = setup("/npc/youngtrainer_left_1");
		left2 = setup("/npc/youngtrainer_left_2");
		left3 = setup("/npc/youngtrainer_left_3");
		right1 = setup("/npc/youngtrainer_right_1");
		right2 = setup("/npc/youngtrainer_right_2");
		right3 = setup("/npc/youngtrainer_right_3");
		
	}
	public void setDialogue() {
		dialogues[0] = "Hello, kid.";
		dialogues[1] = "So you have come to this area to\nfind the treasures?";
		dialogues[2] = "I used to be a good explorer in the world\nbut now... I'm too lazy to adventure.";
		dialogues[3] = "Well, good luck on you.  ;)";
		dialogues[4] = "Hope for your good news.";
	}
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			
			Random random = new Random();
			int i =random.nextInt(100)+1;
			
			if(i <= 25) {
				direction ="up";
			}
			if(i > 25 && i <= 50 ) {
				direction = "down";
			}
			if(i > 50 && i <= 75 ) {
				direction = "left";
			}
			if(i > 75 && i <= 100 ) {
				direction = "right";
			}
			
			actionLockCounter=0;
		}
				
	}
	
	public void speak() {
		
		//Do this character specific stuff
		super.speak();
		
	}
	
}
