package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][][];
	
	public TileManager(GamePanel gp) {
		
		this.gp =gp;
		
		tile = new Tile[40];
		mapTileNum =new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world02.txt",0);
		loadMap("/maps/interior01.txt",1);
		loadMap("/maps/interior02.txt",2);
		loadMap("/maps/interior03.txt",3);
	}
	public void getTileImage() {

			System.out.println("Image loading started");
			
			//PLACEHOLDER
			setup(0,"grass", false);
			setup(1,"wall", true);
			setup(2,"water00", true);
			setup(3,"earth", false);
			setup(4,"tree", true);
			setup(5,"sand", false);
			setup(6,"grass01", false);

			setup(10,"grass00", false);
			setup(11,"grass01", false);
			setup(12,"water00", true);
			setup(13,"water01", true);
			setup(14,"water02", true);
			setup(15,"water03", true);
			setup(16,"water04", true);
			setup(17,"water05", true);
			setup(18,"water06", true);
			setup(19,"water07", true);
			setup(20,"water08", true);
			setup(21,"water09", true);
			setup(22,"tree", true);
			setup(23,"hut", false);
			setup(24,"floor01", false);
			setup(25,"table01", true);
			setup(26,"wall", true);
			setup(27,"wall01", true);
			setup(28,"cave00", false);
			setup(29,"cave01", true);
			setup(30,"cave02", true);
			setup(31,"cave03", true);
			setup(32,"earth01", false);
			setup(33,"box", true);
			setup(34,"shelf01", true);
			setup(35,"shelf02", true);
			setup(36,"shelf03", true);
			setup(37,"shelf04", true);
			
			
			System.out.println("Image loading finished");	
				
	}	
	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		try {
			
			tile[index]= new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision =collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}	
	public void loadMap(String filePath, int map) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			int col = 0;
			int row = 0;
			while( col < gp.maxWorldCol && row < gp.maxWorldRow) {

				String line = br.readLine();
				
				while(col < gp.maxWorldCol ){
					String[] numbers = line.split(" ");
					int num =Integer.parseInt(numbers[col]);
					mapTileNum[map][col][row] = num;
					col++;	
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			br.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while( worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			//Stop moving the camera at the edge
			if(gp.player.screenX > gp.player.worldX) {
				screenX = worldX;
			}
			if(gp.player.screenY > gp.player.worldY) {
				screenY = worldY;
			}
			int rightOffset = gp.screenWidth - gp.player.screenX;
			if( rightOffset > gp.worldWidth - gp.player.worldX ) {
				screenX = gp.screenWidth - (gp.worldWidth - worldX);
			}
			int bottomOffset = gp.screenHeight - gp.player.screenY;
			if( bottomOffset > gp.worldHeight - gp.player.worldY ) {
				screenY = gp.screenHeight - (gp.worldHeight - worldY);
			}
			
			
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);	
			}
			else if(gp.player.screenX > gp.player.worldX||
					gp.player.screenY > gp.player.worldY||
					rightOffset > gp.worldWidth - gp.player.worldX||
					bottomOffset > gp.worldHeight - gp.player.worldY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			
			worldCol++;

			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;

			}
		} 
		

	} 

}
