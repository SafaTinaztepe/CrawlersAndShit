import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GameGUI extends GraphicsProgram{
	
	private Dimension fullScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	private double backWidth = fullScreenDimension.getWidth();
	private double backHeight = fullScreenDimension.getHeight();
	Character player_1 = null;
	
	public void init(){
		this.addKeyListeners(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				switch(arg0.getKeyCode()){
				case 37: player_1.move(3); 
				System.out.println(player_1.tempOval.getX()); break;//LEFT
				case 38: player_1.move(1); break;//UP
				case 39: player_1.move(4); break;//RIGHT
				case 40: player_1.move(2); break;//DOWN
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void keyTyped(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
			}
			
		});

		
	}
	public void run(){
		//full screen
		this.setSize(1200, 1600);
		this.setBackground(Color.BLACK);
		
		
		GRect ground = new GRect(25,25, 1100, 1400);
		
		ground.setFillColor(new Color(204,102,0)); //brownish
		ground.setFilled(true);
		this.add(ground);
		
		
		try {
			player_1 = new Character(true, 100, 400, 300, 10, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(player_1.tempOval);
		
		
		
	}
	
	
	public void redraw(){
		//player_1.tempOval.setLocation(50, 50);
	}
	public void draw(GObject object){
		
	}
	
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) System.out.println("asdf");
	}
	
	public void keyReleased(KeyEvent arg0){
			
		}
	public void keyTyped(KeyEvent arg0){
		
	}
	
	
	private void debug(String str){
		System.out.println(str);
	}
	private void debug(double str){
		System.out.println(str);
	}
	private void debug(int str){
		System.out.println(str);
	}
	private void debug(boolean str){
		System.out.println(str);
	}
}
