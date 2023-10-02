package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ball extends Entity{
	
	
	public OBJ_Ball(GamePanel gp) {
		super(gp);
		
		name ="Ball";
		down1 = setup("/objects/ball");
	}
}
