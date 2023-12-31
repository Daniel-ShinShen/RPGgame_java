package main;

import entity.Entity;

public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
		
			col++;
			if(col == gp.maxWorldCol) {	
				col = 0;
				row++;
				
				if(row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
		
	}
	
	public void checkEvent() {
		//Check if the player character is more than 1 tile away from the last event
		int xDistance =Math.abs(gp.player.worldX - previousEventX);
		int yDistance =Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}
		
		if(canTouchEvent == true) {
			if(hit(0,40,26, "any") == true) {damagePit(0,40,26,gp.dialogueState);}
			else if(hit(0,28,8, "any") == true) {teleport(gp.dialogueState);}
			else if(hit(0,31,10,"up") == true||hit(0,32,10,"up") == true||hit(0,40,10,"up") == true
					||hit(0,41,10,"up") == true||hit(0,42,10,"up") == true||hit(0,43,10,"up") == true) {healingPool(gp.dialogueState);}
			
			else if (hit(0,12,41,"any") == true){teleport(1,10,32);}
			else if (hit(1,10,32,"any") == true){teleport(0,12,41);}
			
			else if (hit(0,57,35,"any") == true){teleport(2,12,20);}
			else if (hit(2,12,20,"any") == true){teleport(0,57,35);}
			
			
			else if (hit(0,62,6,"any") == true){teleport(3,10,10);}
			else if (hit(3,10,10,"any") == true){teleport(0,62,6);}
			
			//else if (hit(0,20,14,"any") == true){teleport(0,62,7);}
			//else if (hit(0,62,7,"any") == true){teleport(0,20,14);}
			
			else if (hit(1,10,23,"up") == true) {speak(gp.npc[1][0]);}
			
		}
	}
	
	public boolean hit(int map, int col, int row, String reqDirection) {
		
		boolean hit = false;
		
		if(map == gp.currentMap) {
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
			
			if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
				if(gp.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")) {
					hit = true;
					previousEventX = gp.player.worldX;
					previousEventY = gp.player.worldY;
				}
			}
			
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
		}
		
		return hit;
	}
	public void teleport(int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Teleport!";
		gp.player.worldX = gp.tileSize*13;
		gp.player.worldY = gp.tileSize*31;
	}
	public void teleport(int map, int col, int row) {
		
		gp.gameState = gp.transitionState;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		//gp.currentMap = map;
		//gp.player.worldX = gp.tileSize * col;
		//gp.player.worldY = gp.tileSize * row;
		//previousEventX = gp.player.worldX;
		//previousEventY = gp.player.worldY;
		canTouchEvent = false;
		gp.playSE(13);
	}
	public void damagePit(int map,int col, int row, int gameState){
		gp.gameState = gameState;
		gp.playSE(6);
		gp.ui.currentDialogue = "You fall into a pit!";
		gp.player.life -= 1;
		eventRect[map][col][row].eventDone = true;
		canTouchEvent = false;
	}
	public void healingPool(int gameState) {
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.attackCanceled = true;
			gp.playSE(2);
			gp.ui.currentDialogue = "You drink the water.\nYour life and mana has been recovered.";
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMonster();
		}
	
	}
	public void speak(Entity entity) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gp.dialogueState;
			gp.player.attackCanceled = true;
			entity.speak();
		}
	}
}
