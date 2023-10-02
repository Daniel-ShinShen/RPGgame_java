package monster;

import java.util.Random;
import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Gold;
import object.OBJ_Coin_Platinum;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;
import object.OBJ_Shield_Regi;
import object.OBJ_Sword_Diamond;

public class MON_Regigigas extends Entity {
	public MON_Regigigas(GamePanel gp) {
		super(gp);
		
		isBoss = true;
		type = type_monster;
		name = " [BOSS] Regigigas";
		speed = 1;
		maxLife = 450;
		life = maxLife;
		attack = 15;
		defense = 40;
		exp = 200;
		projectile = new OBJ_Rock(gp);
		projectile.speed = 4;
		
		solidArea.x = 6;
		solidArea.y = 11;
		solidArea.width = 80;
		solidArea.height = 75;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/regigigas_up_1", gp.tileSize*2, gp.tileSize*2);
		up2 = setup("/monster/regigigas_up_2", gp.tileSize*2, gp.tileSize*2);
		up3 = setup("/monster/regigigas_up_3", gp.tileSize*2, gp.tileSize*2);
		down1 = setup("/monster/regigigas_down_1", gp.tileSize*2, gp.tileSize*2);
		down2 = setup("/monster/regigigas_down_2", gp.tileSize*2, gp.tileSize*2);
		down3 = setup("/monster/regigigas_down_3", gp.tileSize*2, gp.tileSize*2);
		left1 = setup("/monster/regigigas_down_1", gp.tileSize*2, gp.tileSize*2);
		left2 = setup("/monster/regigigas_down_2", gp.tileSize*2, gp.tileSize*2);
		left3 = setup("/monster/regigigas_down_3", gp.tileSize*2, gp.tileSize*2);
		right1 = setup("/monster/regigigas_up_1", gp.tileSize*2, gp.tileSize*2);
		right2 = setup("/monster/regigigas_up_2", gp.tileSize*2, gp.tileSize*2);
		right3 = setup("/monster/regigigas_up_3", gp.tileSize*2, gp.tileSize*2);
		
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 30) {
			
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
		if(i > 90 && projectile.alive == false && shotAvailableCounter == 30) {
			projectile.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(projectile);
			shotAvailableCounter = 0;
		}
	}
	public void damageReaction() {
		
		int i = new Random().nextInt(100)+1;
		
		if(speed <= 10) {
			speed++;
		}
		if(i < 50 && attack <= 20) {
			attack += 10;
			speed += 2;
			projectile.speed += 4;
			gp.ui.addMessage("Regigigas looks angry. Be careful!");
		}
		if(life <= maxLife/2 && attack <= 30) {
			attack += 20;
			gp.ui.addMessage("Regigigas champes with rage. Almost there!");
		}
		actionLockCounter = 0;
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
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		if(i < 25) {
			dropItem(new OBJ_Coin_Platinum(gp));
		}
		if(i >= 25 && i < 75) {
			dropItem(new OBJ_Coin_Gold(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_Shield_Regi(gp));
		}
		
	}
}
