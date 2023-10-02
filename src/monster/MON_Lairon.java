package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Gold;
import object.OBJ_Coin_Silver;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_Lairon extends Entity{

	public MON_Lairon(GamePanel gp) {
		super(gp);
		
		type = type_monster;
		name = "Lairon";
		speed = 1;
		maxLife = 75;
		life = maxLife;
		attack = 8;
		defense = 5;
		exp = 14;
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
		
		up1 = setup("/monster/lairon_up_1");
		up2 = setup("/monster/lairon_up_2");
		up3 = setup("/monster/lairon_up_1");
		down1 = setup("/monster/lairon_down_1");
		down2 = setup("/monster/lairon_down_2");
		down3 = setup("/monster/lairon_down_1");
		left1 = setup("/monster/lairon_down_1");
		left2 = setup("/monster/lairon_down_2");
		left3 = setup("/monster/lairon_down_1");
		right1 = setup("/monster/lairon_up_1");
		right2 = setup("/monster/lairon_up_2");
		right3 = setup("/monster/lairon_up_1");
		
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 70) {
			
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

		if(speed < 3) {
			speed++;
		}
		int i = new Random().nextInt(100)+1;
		if(i < 50 && attack <= 10) {
			attack += 4;
			gp.ui.addMessage("Lairon looks angry. Be careful!");
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
		if(i >= 50 && i < 65) {
			dropItem(new OBJ_Coin_Gold(gp));
		}

		if(i >= 65 && i < 75) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_Heart(gp));
		}
		
	}
}
