
public class Item {
	
	private String itemName;
	private String itemDesc;
	private int itemNum;
	private boolean isCollectible;
	public static Item[] itemsInGame;
	public static int numOfItems = 0;
	
	public Item(String name,String desc, boolean c){
		itemName = name;
		isCollectible = c;
		itemDesc = desc;
		itemNum = numOfItems;
		itemsInGame[numOfItems] = this;
		numOfItems++;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public int getItemNum(){
		return itemNum;
	}
	
	public boolean isCollectible(){
		return isCollectible;
	}

}
