package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Fireball;
import object.OBJ_Key;
import object.OBJ_Rock;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

public class Player extends Entity{
	

	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	int standCounter = 0;
	boolean moving = false;
	public boolean attackCanceled = false;

	
	public Player(GamePanel gp,KeyHandler keyH) {
		
		super(gp);

		this.keyH =keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		//SOLID AREA
		solidArea = new Rectangle();
		solidArea.x = 10;
		solidArea.y = 10;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 36;
		solidArea.height = 36;
		//ATTACK AREA
		attackArea.width = 36;
		attackArea.height = 36;
		
		
		setDefaultvalues();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
	}
	
	public void setDefaultvalues() {
		
		worldX = gp.tileSize * 20;
		worldY = gp.tileSize * 13;
		//worldX = gp.tileSize * 11;
		//worldY = gp.tileSize * 15;
		speed = 4;
		direction = "down";
		
		//PLAYER STATUS
		level = 1;
		maxLife = 6;
		life = maxLife;
		maxMana = 4;
		mana = maxMana;
		ammo = 10;
		strength = 2;
		dexterity = 1;
		exp = 0;
		nextLevelExp = 10;
		coin = 500;
		currentWeapon = new OBJ_Sword_Normal(gp);
		currentShield = new OBJ_Shield_Wood(gp);
		projectile = new OBJ_Fireball(gp);
		attack = getAttack();// The total attack value is decided by strength and weapon
		defense = getDefense();// The total defense is decided by dexterity and shield
	}
	public void setDefaultPositions() {
		
		worldX = gp.tileSize * 20;
		worldY = gp.tileSize * 13;
		direction = "down";
		
	}
	public void restoreLifeAndMana() {
		life = maxLife;
		mana = maxMana;
		invincible = false;
	}
	public void setItems() {
		inventory.clear();
		inventory.add(currentWeapon);
		inventory.add(currentShield);
	}
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return attack = strength * currentWeapon.attackValue;
	}
	public int getDefense() {
		return defense = dexterity * currentShield.defenseValue;
	}
	public void getPlayerImage() {
		
		up1 = setup("/player/red_up_1");
		up2 = setup("/player/red_up_2");
		up3 = setup("/player/red_up_3");
		down1 = setup("/player/red_down_1");
		down2 = setup("/player/red_down_2");
		down3 = setup("/player/red_down_3");
		left1 = setup("/player/red_left_1");
		left2 = setup("/player/red_left_2");
		left3 = setup("/player/red_left_3");
		right1 = setup("/player/red_right_1");
		right2 = setup("/player/red_right_2");
		right3 = setup("/player/red_right_3");
		
	}
	public void getPlayerAttackImage() {
		
		if(currentWeapon.type == type_sword) {
			attackUp1 = setup("/player/red_attack_up_1", gp.tileSize, gp.tileSize*2);
			attackUp2 = setup("/player/red_attack_up_2", gp.tileSize, gp.tileSize*2);
			attackUp3 = setup("/player/red_attack_up_1", gp.tileSize, gp.tileSize*2);
			attackDown1 = setup("/player/red_attack_down_1", gp.tileSize, gp.tileSize*2);
			attackDown2 = setup("/player/red_attack_down_2", gp.tileSize, gp.tileSize*2);
			attackDown3 = setup("/player/red_attack_down_1", gp.tileSize, gp.tileSize*2);
			attackLeft1 = setup("/player/red_attack_left_1", gp.tileSize*2, gp.tileSize);
			attackLeft2 = setup("/player/red_attack_left_2", gp.tileSize*2, gp.tileSize);
			attackLeft3 = setup("/player/red_attack_left_1", gp.tileSize*2, gp.tileSize);
			attackRight1 = setup("/player/red_attack_right_1", gp.tileSize*2, gp.tileSize);
			attackRight2 = setup("/player/red_attack_right_2", gp.tileSize*2, gp.tileSize);
			attackRight3 = setup("/player/red_attack_right_1", gp.tileSize*2, gp.tileSize);
		}

		if(currentWeapon.type == type_axe) {
			attackUp1 = setup("/player/red_axe_up_1", gp.tileSize, gp.tileSize*2);
			attackUp2 = setup("/player/red_axe_up_2", gp.tileSize, gp.tileSize*2);
			attackUp3 = setup("/player/red_axe_up_1", gp.tileSize, gp.tileSize*2);
			attackDown1 = setup("/player/red_axe_down_1", gp.tileSize, gp.tileSize*2);
			attackDown2 = setup("/player/red_axe_down_2", gp.tileSize, gp.tileSize*2);
			attackDown3 = setup("/player/red_axe_down_1", gp.tileSize, gp.tileSize*2);
			attackLeft1 = setup("/player/red_axe_left_1", gp.tileSize*2, gp.tileSize);
			attackLeft2 = setup("/player/red_axe_left_2", gp.tileSize*2, gp.tileSize);
			attackLeft3 = setup("/player/red_axe_left_1", gp.tileSize*2, gp.tileSize);
			attackRight1 = setup("/player/red_axe_right_1", gp.tileSize*2, gp.tileSize);
			attackRight2 = setup("/player/red_axe_right_2", gp.tileSize*2, gp.tileSize);
			attackRight3 = setup("/player/red_axe_right_1", gp.tileSize*2, gp.tileSize);
		}
		
	}
		
	public void update() {
		
		if(moving == false) {
			

			if(attacking == true) {
				attacking();
			}
			
			else if(keyH.upPressed == true||keyH.downPressed == true||
					keyH.leftPressed == true||keyH.rightPressed == true||keyH.enterPressed == true) {
				
				if(keyH.upPressed==true) {
					direction = "up";
				}
				else if(keyH.downPressed==true) {
					direction = "down";
				}
				else if(keyH.leftPressed==true) {
					direction = "left";
				}
				else if(keyH.rightPressed==true) {
					direction = "right";
				}
				
				moving = true;
				
				//CHECK TILE COLLISION
				collisionOn = false;
				gp.cChecker.checkTile(this);
				
				//CHECK OBJECT COLLISION
				int objIndex = gp.cChecker.checkObject(this,true);
				pickUpObject(objIndex);	
				
				//CHECK NPC COLLISION
				int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
				interactNPC(npcIndex);
				
				//CHECK MONSTER COLLISION
				int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
				contactMonster(monsterIndex);
				
				//CHECK INTERACTIVE TILE COLLISION
				int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
				
				//CHECK EVENT
				gp.eHandler.checkEvent();
				
				
			}
			
			else {					
				standCounter++;			
				if(standCounter == 20) {
					spriteNum = 1;
					standCounter = 0;		
				}		
			}		
			
		}
		
		
		if(moving == true) {
			
			//if collision is false, player can move
			if(collisionOn == false && keyH.enterPressed == false) {
				
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;					
				}
			}
			
			if(keyH.enterPressed == true && attackCanceled == false) {
				gp.playSE(7);
				attacking = true;
				spriteCounter = 0;
			}
			
			attackCanceled = false;
			gp.keyH.enterPressed = false;
			
			spriteCounter++;
			if(spriteCounter>9) {
				
				if(spriteNum == 1) {
					spriteNum++;
				}
				else if(spriteNum == 2) {
					spriteNum++;
				}
				else if(spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			moving = false;	
		}
		
		//spell attack
		if(gp.keyH.shotKeyPressed == true && projectile.alive == false 
				&& shotAvailableCounter == 30 && projectile.haveResource(this) == true) {
			//SET DEFAULT COORDINATES, DIRECTION AND USER
			projectile.set(worldX, worldY, direction, true, this);
			
			//SUBTRACT THE COST
			projectile.subtractResource(this);
			
			//ADD IT TO THE LIST
			gp.projectileList.add(projectile);
			
			shotAvailableCounter = 0;
			
			gp.playSE(10);
		}
		//This needs to be outside of key if statement
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		if(shotAvailableCounter < 30){
			shotAvailableCounter++;
		}
		if(life > maxLife) {
			life = maxLife;
		}
		if(mana > maxMana) {
			mana = maxMana;
		}
		if(life <= 0) {
			gp.gameState = gp.gameOverState;
			gp.ui.commandNum = -1;
			gp.stopMusic();
			gp.playSE(12);
		}
	}
	public void attacking() {
		
		spriteCounter++;
		if(spriteCounter <= 5) {
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
			
			// Save the current worldX, worldY, solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			//Adjust player's worldX/Y for the attack area
			switch(direction) {
			case "up": worldY -= attackArea.height; break;
			case "down": worldY += attackArea.height; break;
			case "left": worldX -= attackArea.width; break;
			case "right": worldX += attackArea.width; break;
			}
			//attackArea becomes solidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			// Check monster collision with the updated worldX, worldY,and solidArea
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			damageMonster(monsterIndex, attack);
			
			int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
			damageInteractiveTile(iTileIndex);
			
			//After checking collision, restore the original data
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
			
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
	}
	
	public void pickUpObject(int i) {
		
		if(i!= 999) {
			// PICK ONLY ITEMS
			if(gp.obj[gp.currentMap][i].type == type_pickupOnly) { // FIXED
				
				gp.obj[gp.currentMap][i].use(this);
				gp.obj[gp.currentMap][i] = null;
			}
			
			//INVENTORY ITEMS
			else {
				String text = "";
				
				if(inventory.size() != maxInventorySize && gp.obj[gp.currentMap][i].type != type_Door) { // FIXED
					inventory.add(gp.obj[gp.currentMap][i]);
					gp.playSE(1);
					text = "You got a " + gp.obj[gp.currentMap][i].name + "!";
					gp.obj[gp.currentMap][i] = null;
				}
				else {
					if(gp.obj[gp.currentMap][i].type != type_Door) { // FIXED
						text = "You cannot carry any more!";
					}
					if(gp.obj[gp.currentMap][i].type == type_Door && hasKey >= 1) { // FIXED
						hasKey--;
						text = "You opened a " + gp.obj[gp.currentMap][i].name + "!";
						gp.obj[gp.currentMap][i] = null; // FIXED
					}			
				}
				gp.ui.addMessage(text);
				
			}
		}
	}
	public void interactNPC(int i) {
		
		if(gp.keyH.enterPressed == true) {
			
			if(i != 999) {
					attackCanceled = true;
					gp.gameState = gp.dialogueState;
					gp.npc[gp.currentMap][i].speak();
			}
		}
		
		
	}
	public void contactMonster(int i) {
		if(i != 999) {
			if(invincible == false && gp.monster[gp.currentMap][i].dying == false) { // FIXED
				
				gp.playSE(6);
				
				int damage = gp.monster[gp.currentMap][i].attack - defense; // FIXED
				if(damage < 0) {
					damage = 0;
				}
				
				life -= damage;
				invincible = true;
			}
			
		}
	}
	public void damageMonster(int i, int attack) {
		if(i != 999) {
			if(gp.monster[gp.currentMap][i].invincible == false) { // FIXED
				
				gp.playSE(5);
				
				Random random = new Random();
				int chance =random.nextInt(100)+1;
				int damage = attack - gp.monster[gp.currentMap][i].defense; // FIXED
				if(damage < 0) {
					damage = 0;
				}
				if(chance < 20) {
					damage = damage*2 + 1;
					gp.ui.addMessage("\n[Critical hit]\n");
				}
				gp.monster[gp.currentMap][i].life -= damage; // FIXED
				gp.ui.addMessage(damage + " damage!");
				
				gp.monster[gp.currentMap][i].invincible = true; // FIXED
				gp.monster[gp.currentMap][i].damageReaction(); // FIXED
		
				if(gp.monster[gp.currentMap][i].life <= 0 ) { // FIXED
					gp.monster[gp.currentMap][i].dying = true; // FIXED
					gp.ui.addMessage("Killed the " + gp.monster[gp.currentMap][i].name + "!"); // FIXED
					gp.ui.addMessage("Exp +" + gp.monster[gp.currentMap][i].exp + "!"); // FIXED
					exp += gp.monster[gp.currentMap][i].exp; // FIXED
					checkLevelUp();
				}
			}
		}
	}
	public void damageInteractiveTile(int i) {
		
		if(i != 999 && gp.iTile[gp.currentMap][i].destructible == true  // FIXED
				&& gp.iTile[gp.currentMap][i].isCorrectItem(this) == true && gp.iTile[gp.currentMap][i].invincible == false) { // FIXED
			
			gp.iTile[gp.currentMap][i].playSE(); // FIXED
			gp.iTile[gp.currentMap][i].life--; // FIXED
			gp.iTile[gp.currentMap][i].invincible = true; // FIXED
			
			// Generate particle
			generateParticle(gp.iTile[gp.currentMap][i],gp.iTile[gp.currentMap][i]); // FIXED
			
			if(gp.iTile[gp.currentMap][i].life == 0) { // FIXED
				gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyForm(); // FIXED
			}
			
		}
	}
	public void checkLevelUp() {        
		if(exp >= nextLevelExp) {
			level++;
			nextLevelExp = nextLevelExp*2;
			maxLife += 2;
			life+=2;
			if(level%2 ==0) {
				strength++;
				maxMana++;
				mana++;
			}
			if(level%5 ==0) {
				strength++;
			}
			
			dexterity++;
			attack = getAttack();
			defense = getDefense();
			
			gp.playSE(8);
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "Level up! \nYou are level "+ level +" now!\n"
					+ "You feel stronger!";
		}
	}
	public void selectItem() {
		
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol,gp.ui.playerSlotRow);
		
		if(itemIndex < inventory.size()) {
			
			Entity selectedItem = inventory.get(itemIndex);
			
			if(selectedItem.type == type_sword||selectedItem.type == type_axe) {
				currentWeapon =selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			if(selectedItem.type == type_shield) {
				currentShield = selectedItem;
				defense = getDefense();
			}
			if(selectedItem.type == type_consumable||selectedItem.type == type_Key) {
				selectedItem.use(this);
				inventory.remove(itemIndex);
			}
		}
	}
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int tempScreenX = 0;
		int tempScreenY = 0;
		
		switch(direction) {
		case "up":
			if(attacking == false) {
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				if(spriteNum == 3) {image = up3;}
			}
			if(attacking == true) {
				tempScreenY = - gp.tileSize;
				if(spriteNum == 1) {image = attackUp1;}
				if(spriteNum == 2) {image = attackUp2;}
			}
			break;
		case "down":
			if(attacking == false) {
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
				if(spriteNum == 3) {image = down3;}
			}
			if(attacking == true) {
				if(spriteNum == 1) {image = attackDown1;}
				if(spriteNum == 2) {image = attackDown2;}
			}
			break;
		case "left":
			if(attacking == false) {
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				if(spriteNum == 3) {image = left3;}
			}
			if(attacking == true) {
				tempScreenX = - gp.tileSize;
				if(spriteNum == 1) {image = attackLeft1;}
				if(spriteNum == 2) {image = attackLeft2;}
			}
			break;
		case "right":
			if(attacking == false) {
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				if(spriteNum == 3) {image = right3;}
			}
			if(attacking == true) {
				if(spriteNum == 1) {image = attackRight1;}
				if(spriteNum == 2) {image = attackRight2;}
			}
			break;
		
		}	
		
		int x = screenX;
		int y = screenY;
		
		if(screenX > worldX) {
			x = worldX;
		}
		if(screenY > worldY) {
			y = worldY;
		}
		int rightOffset = gp.screenWidth - screenX;
		if( rightOffset > gp.worldWidth - worldX ) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.screenHeight - screenY;
		if( bottomOffset > gp.worldHeight - worldY ) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		
		g2.drawImage(image, x+tempScreenX, y+tempScreenY, null);
		
		//Reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		/*
		//DEBUG
		g2.setFont(new Font("Arial", Font.PLAIN, 26));
		g2.setColor(Color.white);
		g2.drawString("Invincible:"+invincibleCounter,10,400);
		*/
	}
}
