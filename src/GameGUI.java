import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class GameGUI extends GraphicsProgram{
	public void run(){
		
		this.setSize(1200, 1600);
		this.setBackground(Color.BLACK);
		this.getGCanvas().requestFocus();
		Character player = new Character(true,100,399,399,10,10);
		this.add(player);
		
		// keys
		this.addKeyListeners(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case 37: System.out.println("Left");player.move(-10,0);break;
					case 38: System.out.println("Up");player.move(0,-10);break;
					case 39: System.out.println("Right");player.move(10,0);break;
					case 40: System.out.println("Down");player.move(0, 10);break;
				}}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		
	}

}
