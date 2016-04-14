import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

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
		
		//ground
		GRect ground = new GRect(25,25, 775, 575);
		ground.setFillColor(new Color(204,102,0)); //brownish
		ground.setFilled(true);
		this.add(ground);
		
		
		
		
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
