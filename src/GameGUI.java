import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GameGUI extends GraphicsProgram{
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	public static GRect ground;
	Character player;
	
	public void run(){
		
		this.setSize(WIDTH,HEIGHT);
		this.setBackground(Color.BLACK);
		this.getGCanvas().requestFocus();
		setStage();
		player = new Character(true,100,50,50,10,10);
		this.add(player);
		
		// keys
		this.addKeyListeners(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case 37: System.out.println("Left");if(player.inBounds())player.move(-10,0);break;
					case 38: System.out.println("Up");if(player.inBounds())player.move(0,-10);break;
					case 39: System.out.println("Right");if(player.inBounds())player.move(10,0);break;
					case 40: System.out.println("Down");if(player.inBounds())player.move(0,10);break;
				}}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});	
	}
	
	
	private void setStage(){
		this.setBackground(Color.BLACK);
		ground = new GRect(50,50,750,550);
		ground.setFillColor(new Color(188,143,143));
		ground.setFilled(true);
		this.add(ground);
	}

}
