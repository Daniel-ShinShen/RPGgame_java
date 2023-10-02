package monster;

import java.util.Random;
import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Coin_Gold;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

public class MON_Zubat extends Entity {
	public MON_Zubat(GamePanel gp) {
		super(gp);
		
		type = type_monster;
		name = "Golbat";
		speed = 1;
		maxLife = 22;
		life = maxLife;
		attack = 3;
		defense = 0;
		exp = 3;
		
		solidArea.x = 5;
		solidArea.y = 10;
		solidArea.width = 40;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/zubat_up_1");
		up2 = setup("/monster/zubat_up_2");
		up3 = setup("/monster/zubat_up_1");
		down1 = setup("/monster/zubat_down_1");
		down2 = setup("/monster/zubat_down_2");
		down3 = setup("/monster/zubat_down_1");
		left1 = setup("/monster/zubat_down_1");
		left2 = setup("/monster/zubat_down_2");
		left3 = setup("/monster/zubat_down_1");
		right1 = setup("/monster/zubat_up_1");
		right2 = setup("/monster/zubat_up_2");
		right3 = setup("/monster/zubat_up_1");
		
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 80) {
			
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
	public void damageReaction() {
		
		if(speed < 3) {
			speed++;
		}
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(200)+1;
		
		if(i < 100) {
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		if(i >= 100 && i < 150) {
			dropItem(new OBJ_Heart(gp));
		}
		
	}
}
