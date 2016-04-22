import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import javax.script.ScriptException;
import javax.swing.Timer;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import mathProblems.EasyProblem;
import mathProblems.HardProblem;
import mathProblems.MathProblem;
import mathProblems.MediumProblem;

public class Maze extends GraphicsProgram {
	
	private double seed;
	private GRect bound;
	Random random;
	private int[][] mazeArr;
	private GRect[][]grect;
	private ArrayList<Character> mapObjects;
	private Character player;
	private ArrayList<Integer> possibleX;
	private ArrayList<Integer> possibleY;
	private Color[] tileColors;
	private final int ARRSIZE = 12;
	int tempCount = 0;
	private HealthBar[] healthArr;
	private int health;
	private boolean inQuestion;
	Timer timer;
	int possibleCoordLeft;
	
	/*
	 * grect: blue = true, red = false;
	 * mazeArr: 0: pass, 1: wall, 2: pass with obstacle.
	 * we take all the 0s randomly place enemies in them. random difficulty
	 */

	public void run(){
		health = 3;
		possibleCoordLeft = 0;
		inQuestion = false;
		mapObjects = new ArrayList<Character>();
		possibleX = new ArrayList<Integer>();
		possibleY = new ArrayList<Integer>();
		tileColors = new Color[]{Color.BLUE,
				 Color.ORANGE, Color.YELLOW, Color.PINK};
		this.setSize(50 *ARRSIZE,(50 *ARRSIZE) + 50);
		this.setBackground(Color.BLACK);
		this.requestFocus();
		mazeArr = new int[ARRSIZE][ARRSIZE+1];
		healthArr = new HealthBar[health];
		grect = new GRect[ARRSIZE][ARRSIZE];
		random = new Random();
		
		
			
		//variables to setup grects on screen
		int x =0;
		int y = 0;
		for(int c=0; c<ARRSIZE; c++){
		    for (int r=0; r<ARRSIZE; r++){
		    	
		    	grect[r][c] = new GRect(x, y , 50, 50);
		    	x+=50;
	
		    	grect[r][c].setFilled(true);
		    	grect[r][c].setFillColor(Color.BLUE);
		    	this.add(grect[r][c]);
		    }
		    x = 0;
		    y+=50;
		}
		
		x = (ARRSIZE * 50) /3;
		for(int i=0;i<health;i++){
			
		    	HealthBar bar = new HealthBar();
		    	healthArr[i] = bar;
		    	bar.setLocation(x,(50 * ARRSIZE));
		    	this.add(bar);
	    	x+=50;
		}
		
		
		//Adding player and monsters
		
		for(int i=0;i<ARRSIZE * ARRSIZE;i++){
			int ranX = random.nextInt(ARRSIZE);
			int ranY = random.nextInt(ARRSIZE);
			System.out.println(ranX + " , " + ranY);
			possibleX.add(ranX);
			possibleY.add(ranY);
		}
		
		//storing the randomly generated values to resuse locally
		int objX = getRanX();
		int objY = getRanY();
		player = new Character(objX,objY, true);
		player.setLocation(50 * objX, 50* objY);
		mapObjects.add(player);
		this.add(player);
		
		for(int i=0;i<5;i++){
			objX = getRanX();
			objY = getRanY();
			Character monster = new Character(objX, objY, false);
			monster.setLocation(50*objX, 50*objY);
			mapObjects.add(monster);
			this.add(monster);
		}
		
		
		
		
		
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				ArrayList<Character> temp = mapObjects;
				
				for(int i=0;i<temp.size();i++){
				Object tempObstacle = temp.get(i);
				if(tempObstacle instanceof Character){
						Character tempChar = (Character) tempObstacle;
						int ranDir = random.nextInt(4);
						if(!tempChar.isPlayer()){
							switch(ranDir){
							case 0://left
									if(inBounds(tempChar.getX()-50,tempChar.getY()) && !(inQuestion)){
										tempChar.move2(1);
									}
									break;
							case 1: //up
									if(inBounds(tempChar.getX(),tempChar.getY()-50)&& !(inQuestion)){
										tempChar.move2(2);
									}
									break;
							case 2: //down
									if(inBounds(tempChar.getX()+50,tempChar.getY())&& !(inQuestion)){
										tempChar.move2(3);
										}
									break;	
							case 3://right
									if(inBounds(tempChar.getX(),tempChar.getY()+50)&& !(inQuestion)){
										tempChar.move2(4);
									}
									break;
							}
						if(tempChar.getBounds().intersects(player.getBounds())){
							inQuestion = true;
							try {
								mathProblem(i);
							} catch (ScriptException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						}
					}
				
				}
				
			}
        };
        timer = new Timer(1000 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();
		
		
		
		
		
		this.addKeyListeners(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case 37://left
							if(inBounds(player.getX()-50,player.getY()) && !(inQuestion)){
								player.move2(1);
							}
							break;
					case 38://up
							if(inBounds(player.getX(),player.getY()-50)&& !(inQuestion)){
								player.move2(2);
							}
							break;
					case 39://right
							if(inBounds(player.getX()+50,player.getY())&& !(inQuestion)){
								player.move2(3);
								}
							break;	
					case 40: //down
							if(inBounds(player.getX(),player.getY()+50)&& !(inQuestion)){
								player.move2(4);
							}
							break;
				}}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		
	}
	
	public void mathProblem(int x) throws ScriptException, MalformedURLException, IOException{
		int difficulty = random.nextInt(3);
		MathProblem problem = null;
		switch(difficulty){
		case 0:problem = new EasyProblem();break;
		case 1:problem = new MediumProblem();break;
		case 2:problem = new HardProblem();break;
		}
		
		
		if(problem.getUserEvaluation()){
			this.remove(mapObjects.get(x));
			mapObjects.remove(x);
			inQuestion = false;
			if(mapObjects.size() == 1){
				blackOut(true);
			}
		}else{
			player.setLocation(0,0);
			player.setBlockX(0);
			player.setBlockY(0);
			inQuestion = false;
			this.remove(healthArr[health-1]);
			health--;
			if(health == 0){
				inQuestion = true;
				timer.stop();
				blackOut(false);
				System.out.println("game over");
				
			}
		}
		
		
	}
	
	public void update(){
		int ran = 0;
		for(int r=0; r<mazeArr.length; r++){
		    for (int c=0; c<mazeArr.length; c++){

			int R = (int) (random.nextDouble()*256);
			int G = (int)(random.nextDouble()*256);
			int B= (int)(random.nextDouble()*256);
			Color randomColor = new Color(R, G, B);
		    	grect[r][c].setFillColor(randomColor);
		    }
		}
	}
	
	public void blackOut(boolean didWin){
		for(int r=0; r<mazeArr.length; r++){
		    for (int c=0; c<mazeArr.length; c++){
		    	grect[r][c].setFillColor(Color.BLACK);
		    }
		}
		
		this.removeAll();
		File file;
		if(didWin){
			file = new File("../bin/oser_win.png");
		}else file = new File("../bin/oser_fail.png");
		String fileName = file.getPath();
		GImage sprite_still = new GImage(fileName);
		sprite_still.setSize(this.getWidth(), this.getHeight());
		this.add(sprite_still);
	}
	
	public int getRanX(){
		int result;
		int ran = random.nextInt(possibleX.size());
		result = possibleX.get(ran);

		return result;
	}
	
	public int getRanY(){
		int result;
		int ran = random.nextInt(possibleY.size());
		result = possibleY.get(ran);
	
		return result;
	}
	
	
	
	public boolean inBounds(double x, double y){
		return (y >= 0) && (y < (50 * ARRSIZE) && (x >= 0) && (x < (50 * ARRSIZE)));
	}
	

}
