import java.awt.Color;
import java.io.File;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GOval;

public class Character extends GCompound{
	
	private int posX;
	private int posY;
	private boolean isPlayer;
	private GImage sprite_still;
	private GImage sprite_hit;
	
	
	public Character(int x, int y, boolean isPlayer){
		posX = x;
		posY = y;
		this.isPlayer = isPlayer;
		
		File file;
		if(isPlayer){
			 file = new File("../bin/oser_sprite.png");
		}else{
			 file = new File("../bin/oser_bad.png");
		}
		
		String fileName = file.getPath();
		sprite_still = new GImage(fileName);
		this.add(sprite_still);
		
		
		
	}
	
	public void move2(int dir){
		switch(dir){
			case 1:this.move(-50,0);posX--;break;//Left
			case 2:this.move(0,-50);posY--;break;	//Up
			case 3:this.move(50,0);posX++;break; //Right
			case 4:this.move(0, 50);posY++;break; //Down
		}
	}
	
	public int getBlockX(){
		return posX;
	}
	
	public int getBlockY(){
		return posY;
	}
	public void setBlockX(int x){
		posX = x;
	}
	public void setBlockY(int y){
		posY = y;
	}
	
	public void updateBlock(int x, int y){
		posX+=x;
		posY+=y;
	}
	
	public void spriteHit(){
		File file = new File("../bin/oser_hit.png");
		String fileName = file.getPath();
		sprite_still = new GImage(fileName);
	}
	
	public boolean isPlayer(){
		return isPlayer;
	}
	
	
}
