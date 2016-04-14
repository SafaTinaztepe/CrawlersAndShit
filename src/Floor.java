import java.util.Random;


public class Floor {
	private Random random = new Random();
	private Room[][] floor = new Room[1200][1800];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	
	public void generateFloor(){
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				floor[row][col] = Room(random.nextBoolean());
			}//create_room
		}
	}
}

/* public onTimerTick()
	 arrayList everything_to_be_drawn
	 for i in everything
		this.add(i)
*/