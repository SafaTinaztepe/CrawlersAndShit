import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acm.graphics.*;
public class Character extends GCompound {
	
	private boolean isAlive;
	private boolean isPlayer;
	private int health;
	private int posX, posY;
	private int width, height;
	private Item[] inventory;
	private int inventoryCount;
	public static final int MAXINVENTORY = 10;
	public GImage model;
	private Image sprite;
	private int dx;
	private int dy;
	public GOval tempOval;
	private final int MAPWIDTH = 1400;
	private final int MAPHEIGHT = 1600;
	
	
	public Character(boolean isPlayer, int health, int x, int y, int w, int h) throws IOException{
		isAlive = true;
		this.isPlayer = isPlayer;
		this.health = health;
		posX = x;
		posY = y;
		width = w;
		height = h;
		inventoryCount = 0;
		
		//sprite = ImageIO.read(new File(".//resources//p1_front.png"));
		//model = new GImage(ImageIO.read(new File(".//resources//p1_front.png")));
		tempOval = new GOval(x,y,w,h);
		tempOval.setFilled(true);
		tempOval.setFillColor(Color.BLACK);
		this.add(tempOval);
	}
	
	public int getHealth(){
		return health;
	}
	/*
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}*/
	
	public int getInventoryCount(){
		return inventoryCount;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public void dead(){
		isAlive = false;
	}
	
	public boolean inBounds(int x, int y){
		return (y >= 0) && (y < MAPHEIGHT) && (x >= 0) && (x < MAPWIDTH);
	}

	
	public void move(int x){
		switch(x){
		case 1: if(inBounds(posX, posY-1)){posY--;update();tempOval.setLocation(posX,posY);}break;//Move Up
		case 2: if(inBounds(posX, posY+1)){posY++;update();tempOval.setLocation(posX,posY);}break;//Move Down
		case 3: if(inBounds(posX-1, posY)){posX--;update();tempOval.setLocation(posX,posY);}break;//Move Left
		case 4: if(inBounds(posX+1, posY)){posX++;update();tempOval.setLocation(posX,posY);}break;//Move Right
		}
		
	}
	
	public void update(){
		tempOval.setLocation(posX, posY);
	}
	
	//create door class
	public void interactWithDoor(Object x){
		
	}
	
	//possible redundant method
	public void interactWithItem(Item x){
		addToInventory(x);
	}
	
	public void addToInventory(Item x){
		if(inventory.length != MAXINVENTORY && x.isCollectible()){
			inventory[inventoryCount] = x;
			inventoryCount++;
		}else if(inventory.length == MAXINVENTORY){
			//inventory is full
			System.out.println("Your inventory is full");
		}else{
			//item is not collectible
			System.out.println("You cannot add this item to your inventory");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
