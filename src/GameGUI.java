import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GameGUI extends GraphicsProgram{
	
	private Dimension fullScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	private double backWidth = fullScreenDimension.getWidth();
	private double backHeight = fullScreenDimension.getHeight();
	
	public void run(){
		//full screen
		this.setSize(1200, 1600);
		this.setBackground(Color.BLACK);
		//asdf
		//ground
		GRect ground = new GRect(25,25, 1100, 100);
		ground.setFillColor(new Color(204,102,0)); //brownish
		ground.setFilled(true);
		this.add(ground);
		
		Character player_1 = null;
		try {
			player_1 = new Character(true, 100, 400, 300, 10, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(player_1.tempOval);
		
	}
	
	public void draw(GObject object){
		this.add(object);
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
