import java.util.Random;

public class Room {
	Random random = new Random();
	private boolean exists = false;
	
	public static void main(String[] args){
		System.out.print(1+1);
	}
	
	public Room(boolean exists){
		this.exists = exists;
	}
	
	public String toString(){
		return "" + this.exists;
	}
}
