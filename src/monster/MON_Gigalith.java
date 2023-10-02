package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Gold;
import object.OBJ_Coin_Platinum;
import object.OBJ_Heart;
import object.OBJ_Rock;

public class MON_Gigalith extends Entity{
	
	public MON_Gigalith(GamePanel gp) {
		super(gp);
		
		isBoss = true;
		type = type_monster;
		name = "Gigalith";
		speed = 1;
		maxLife = 100;
		life = maxLife;
		attack = 10;
		defense = 8;
		exp = 25;
		projectile = new OBJ_Rock(gp);

		solidArea.x = 6;
		solidArea.y = 12;
		solidArea.width = 80;
		solidArea.height = 74;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/gigalith_up_1", gp.tileSize*2, gp.tileSize*2);
		up2 = setup("/monster/gigalith_up_2", gp.tileSize*2, gp.tileSize*2);
		up3 = setup("/monster/gigalith_up_1", gp.tileSize*2, gp.tileSize*2);
		down1 = setup("/monster/gigalith_down_1", gp.tileSize*2, gp.tileSize*2);
		down2 = setup("/monster/gigalith_down_2", gp.tileSize*2, gp.tileSize*2);
		down3 = setup("/monster/gigalith_down_1", gp.tileSize*2, gp.tileSize*2);
		left1 = setup("/monster/gigalith_down_1", gp.tileSize*2, gp.tileSize*2);
		left2 = setup("/monster/gigalith_down_2", gp.tileSize*2, gp.tileSize*2);
		left3 = setup("/monster/gigalith_down_1", gp.tileSize*2, gp.tileSize*2);
		right1 = setup("/monster/gigalith_up_1", gp.tileSize*2, gp.tileSize*2);
		right2 = setup("/monster/gigalith_up_2", gp.tileSize*2, gp.tileSize*2);
		right3 = setup("/monster/gigalith_up_1", gp.tileSize*2, gp.tileSize*2);
		
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
			gp.ui.addMessage("Gigalith looks angry. Be careful!");
		}
		actionLockCounter = 0;
		if(i > 50 && i <= 100) {
			
			switch(gp.player.direction) {
			case "up":
				direction = "down";
				break;

			case "down":
				direction = "up";
				break;

			case "left":
				direction = "right";
				break;

			case "right":
				direction = "left";
				break;
			}
		}
	}
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		if(i < 35) {
			dropItem(new OBJ_Coin_Gold(gp));
		}
		if(i >= 35 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 85 && i < 100) {
			dropItem(new OBJ_Coin_Platinum(gp));
		}
		
	}
}
