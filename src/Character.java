import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GOval;

public class Character extends GCompound {
	
	private boolean isAlive;
	private boolean isPlayer;
	private int health;
	private int posX, posY;
	private int width, height;
	private Item[] inventory;
	private int inventoryCount;
	public static final int MAXINVENTORY = 10;
	private GImage model;
	private Image sprite;
	public GOval tempOval;
	
	
	public Character(boolean isPlayer, int health, int x, int y, int w, int h) throws IOException{
		isAlive = true;
		this.isPlayer = isPlayer;
		this.health = health;
		posX = x;
		posY = y;
		width = w;
		height = h;
		inventoryCount = 0;
		tempOval = new GOval(x,y,w,h);
		
		
		
		
		
	}
	
	public int getHealth(){
		return health;
	}
	
	public void moveDirection(KeyEvent e)
    {
        
        if (e.getKeyCode() == 39) move(4); //RIHT
        if (e.getKeyCode() == 37) move(3); //LEFT
        if (e.getKeyCode() == 38) move(1); //UP
        if (e.getKeyCode() == 40) move(2); //DOWN
    }
	
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
		return (y >= 0) && (y < 1200) && (x >= 0) && (x < 1600);
	}

	public void move(int x){
		switch(x){
		case 1: if(inBounds(posX, posY-1)){posY--;}break;//Move Up
		case 2: if(inBounds(posX, posY+1)){posY++;}break;//Move Down
		case 3: if(inBounds(posX-1, posY)){posX--;}break;//Move Left
		case 4: if(inBounds(posX+1, posY)){posX++;}break;//Move Right
		}
		update();
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
