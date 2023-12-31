package main;

import entity.NPC_Meowth;
import entity.NPC_Merchant;
import entity.NPC_Pikachu;
import entity.NPC_YoungTrainer;
import monster.MON_Gigalith;
import monster.MON_Golbat;
import monster.MON_Lairon;
import monster.MON_Regigigas;
import monster.MON_Zubat;
import object.OBJ_Axe;
import object.OBJ_Ball;
import object.OBJ_Chest;
import object.OBJ_Coin_Gold;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Regi;
import object.OBJ_Shield_Super;
import object.OBJ_Sword_Diamond;
import tile_interactive.IT_DryTree;

public class AssetSetter {
	 
	GamePanel gp;
	 
	 public AssetSetter(GamePanel gp) {
		 this.gp = gp;
	 }
	 
	 public void setObject() {
		 
		 int mapNum = 0;
		 int i = 0;
		 
		 gp.obj[mapNum][i] = new OBJ_Shield_Super(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*12;
		 gp.obj[mapNum][i].worldY = gp.tileSize*15;
		 i++;
		 
		 gp.obj[mapNum][i] = new OBJ_Door(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*51;
		 gp.obj[mapNum][i].worldY = gp.tileSize*8;
		 i++;
		 
		 gp.obj[mapNum][i] = new OBJ_Door(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*51;
		 gp.obj[mapNum][i].worldY = gp.tileSize*2;
		 i++;
		 
		 gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*37;
		 gp.obj[mapNum][i].worldY = gp.tileSize*14;
		 i++;
		 
		 gp.obj[mapNum][i] = new OBJ_Heart(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*17;
		 gp.obj[mapNum][i].worldY = gp.tileSize*14;
		 i++;
		 
		 gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*20;
		 gp.obj[mapNum][i].worldY = gp.tileSize*15;
		 i++;
		// MAP 1
		 mapNum = 1;
		 i = 0;
		 gp.obj[mapNum][i] = new OBJ_Key(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*7;
		 gp.obj[mapNum][i].worldY = gp.tileSize*14;
		 
		// MAP 2
		 mapNum = 2;
		 i = 0;
		 gp.obj[mapNum][i] = new OBJ_Axe(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*9;
		 gp.obj[mapNum][i].worldY = gp.tileSize*4;
		 i++;
		 
		// MAP 3
		mapNum = 3;
		i = 0;
		 gp.obj[mapNum][i] = new OBJ_Chest(gp);
		 gp.obj[mapNum][i].worldX = gp.tileSize*10;
		 gp.obj[mapNum][i].worldY = gp.tileSize*5;
		 
	 }
	 
	 public void setNPC() {
		 
		 int mapNum = 0;
		 int i = 0;
		 
		 // MAP 0
		 gp.npc[mapNum][i] = new NPC_YoungTrainer(gp);
		 gp.npc[mapNum][i].worldX = gp.tileSize*37;
		 gp.npc[mapNum][i].worldY = gp.tileSize*30;
		 i++;
		 
		 gp.npc[mapNum][i] = new NPC_YoungTrainer(gp);
		 gp.npc[mapNum][i].worldX = gp.tileSize*42;
		 gp.npc[mapNum][i].worldY = gp.tileSize*28;
		 i++;
		 
		 // MAP 1
		 mapNum = 1;
		 i = 0;
		 gp.npc[mapNum][i] = new NPC_Merchant(gp);
		 gp.npc[mapNum][i].worldX = gp.tileSize*10;
		 gp.npc[mapNum][i].worldY = gp.tileSize*21;
		 i++;
		 // MAP 3
		 mapNum = 3;
		 i = 0;
		 gp.npc[mapNum][i] = new NPC_Pikachu(gp);
		 gp.npc[mapNum][i].worldX = gp.tileSize*9;
		 gp.npc[mapNum][i].worldY = gp.tileSize*2;
		 i++;
		 
		 gp.npc[mapNum][i] = new NPC_Meowth(gp);
		 gp.npc[mapNum][i].worldX = gp.tileSize*11;
		 gp.npc[mapNum][i].worldY = gp.tileSize*2;
		 i++;
		 
	 }
	 
	 public void setMonster() {
		 
		 int mapNum =0;
		 int i = 0;
		 gp.monster[mapNum][i] = new MON_Zubat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*19;
		 gp.monster[mapNum][i].worldY =gp.tileSize*30;
		 i++;

		 gp.monster[mapNum][i] = new MON_Zubat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*24;
		 gp.monster[mapNum][i].worldY =gp.tileSize*29;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Zubat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*17;
		 gp.monster[mapNum][i].worldY =gp.tileSize*28;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Zubat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*16;
		 gp.monster[mapNum][i].worldY =gp.tileSize*30;
		 i++;
		 

		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*18;
		 gp.monster[mapNum][i].worldY =gp.tileSize*31;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*16;
		 gp.monster[mapNum][i].worldY =gp.tileSize*25;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*15;
		 gp.monster[mapNum][i].worldY =gp.tileSize*24;
		 i++;

		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*44;
		 gp.monster[mapNum][i].worldY =gp.tileSize*25;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*43;
		 gp.monster[mapNum][i].worldY =gp.tileSize*25;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*42;
		 gp.monster[mapNum][i].worldY =gp.tileSize*29;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Regigigas(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*48;
		 gp.monster[mapNum][i].worldY =gp.tileSize*6;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*52;
		 gp.monster[mapNum][i].worldY =gp.tileSize*5;
		 i++;

		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*50;
		 gp.monster[mapNum][i].worldY =gp.tileSize*5;
		 i++;

		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*51;
		 gp.monster[mapNum][i].worldY =gp.tileSize*7;
		 i++;

		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*48;
		 gp.monster[mapNum][i].worldY =gp.tileSize*5;
		 i++;
		// MAP 2
		 mapNum = 2;
		 i = 0;
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*10;
		 gp.monster[mapNum][i].worldY =gp.tileSize*15;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Golbat(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*15;
		 gp.monster[mapNum][i].worldY =gp.tileSize*5;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Gigalith(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*13;
		 gp.monster[mapNum][i].worldY =gp.tileSize*5;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Gigalith(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*11;
		 gp.monster[mapNum][i].worldY =gp.tileSize*6;
		 i++;

		 gp.monster[mapNum][i] = new MON_Gigalith(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*16;
		 gp.monster[mapNum][i].worldY =gp.tileSize*2;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Lairon(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*10;
		 gp.monster[mapNum][i].worldY =gp.tileSize*4;
		 i++;
		 
		 gp.monster[mapNum][i] = new MON_Lairon(gp);
		 gp.monster[mapNum][i].worldX =gp.tileSize*10;
		 gp.monster[mapNum][i].worldY =gp.tileSize*6;
		 i++;
		 
	 }
	 public void setInteractiveTile() {
		 
		 int mapNum = 0;
		 int i = 0;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,51,10); i++;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,14,33); i++;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,14,34); i++;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,13,15); i++;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,14,15); i++;
		 gp.iTile[mapNum][i] = new IT_DryTree(gp,15,15); i++;
	 }
}
