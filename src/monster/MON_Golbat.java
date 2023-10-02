package monster;
import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Coin_Gold;
import object.OBJ_Coin_Silver;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;


public class MON_Golbat extends Entity{
	
	public MON_Golbat(GamePanel gp) {
		super(gp);
		
		type = type_monster;
		name = "Golbat";
		speed = 1;
		maxLife = 32;
		life = maxLife;
		attack = 6;
		defense = 1;
		exp = 8;
		projectile = new OBJ_Rock(gp);
		
		solidArea.x = 3;
		solidArea.y = 10;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/golbat_up_1");
		up2 = setup("/monster/golbat_up_2");
		up3 = setup("/monster/golbat_up_3");
		down1 = setup("/monster/golbat_down_1");
		down2 = setup("/monster/golbat_down_2");
		down3 = setup("/monster/golbat_down_3");
		left1 = setup("/monster/golbat_down_1");
		left2 = setup("/monster/golbat_down_2");
		left3 = setup("/monster/golbat_down_3");
		right1 = setup("/monster/golbat_up_1");
		right2 = setup("/monster/golbat_up_2");
		right3 = setup("/monster/golbat_up_3");
		
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 60) {
			
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
		
		int i = new Random().nextInt(100)+1;
		if(i > 98 && projectile.alive == false && shotAvailableCounter == 30) {
			projectile.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(projectile);
			shotAvailableCounter = 0;
		}
	}
	public void damageReaction() {

		if(speed < 5) {
			speed++;
		}
		int i = new Random().nextInt(100)+1;
		if(i < 50 && attack <= 10) {
			attack += 3;
			gp.ui.addMessage("Golbat looks angry. Be careful!");
		}
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		if(i < 50) {
			dropItem(new OBJ_Coin_Silver(gp));
		}
		if(i >= 50 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
		
	}
}
