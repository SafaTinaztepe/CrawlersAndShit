
public class Obstacle {
	
	
	private boolean passable;
	private int posX, posY;
	private int width, height;
	private Item[] inventory;
	private int inventoryCount;
	
	public Obstacle(boolean passable, int x, int y, int w, int h, Item[] inventory){
		this.passable = passable;
		posX = x;
		posY = y;
		width = w;
		height = h;
		inventoryCount = inventory.length;
		for(int i=0;i<inventory.length;i++){
			this.inventory[i] = inventory[i];
		}
		
	}
	
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
	}
	
	
	
	
	public boolean inBounds(int x, int y){
		return (y >= 0) && (y < 600) && (x >= 0) && (x < 800);
	}

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
