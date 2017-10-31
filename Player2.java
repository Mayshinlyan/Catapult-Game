import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Player2 extends JComponent{
	
	private int v;
	private double A;
	private Wall wall;
	private int ballx, bally;
	private int score;
	private int rowIndex, colIndex;
	private boolean explode;
	private boolean enemyhit;
	
	public Player2(Wall wall){
		this.wall = wall;
		this.score = 0;
		this.explode = false;
		this.enemyhit = false;
	}
	
	//checking if the whole row is destroyed or not. 
	public void checkRow(){
		int temp=0;
		for(int i=0; i<5;i++){
			if(wall.getBricks()[rowIndex][i].getState().equals("destroyed")){
				temp++;
			}
		}
		
		if(temp==5){
			for(int j=0; j<5; j++){
				wall.getBricks()[rowIndex][j].setState(wall.getBricks()[rowIndex+1][j].getState());
			}
		}
	}
	public void draw(Graphics g){
		
		ballx=1100;
		boolean over = false;
		while (over==false){
			bally = (int)(((ballx-1100)*Math.tan((A)))-((9.8*Math.pow(ballx-1100, 2))/(2*Math.pow((v*Math.cos(A)),2))));
			System.out.println(bally);
			//drawing trajectory
			g.setColor(Color.black);
			g.drawLine(ballx, 700-bally, ballx, 700-bally);
			System.out.println(ballx);
			ballx--;
			
		 if (ballx<=725){
				//the ball escapes gravity
				if (bally<0){
					score-=10;
					over = true;
				//the ball hits the ground
				} else if (bally>750){
					score-=10;
					over = true;
				} else if (ballx>=410){
					//finding the row the ball hit
					rowIndex = (bally/50)+1;
					//finding the column the ball hit
					colIndex = ((ballx-410)/65);
					
					//the first hit is just cracked 
					if(wall.getBricks()[rowIndex][colIndex].getState().equals("normal")){
						wall.getBricks()[rowIndex][colIndex].setState("cracked");
						score+=10;
						over = true;
						
					//the second hit destroyed the brick and give 10 points
					} else if (wall.getBricks()[rowIndex][colIndex].getState().equals("cracked")){
						wall.getBricks()[rowIndex][colIndex].setState("destroyed");
						checkRow();
						score+=10;
						over = true;
						
					//if the ball hit the destroyed brick, the trajectory continues
					} else if (wall.getBricks()[rowIndex][colIndex].getState().equals("destroyed")){
						checkRow();
						over = false;
					
					//if the ball hit the bomb the two rows above and below the bomb and including the bomb row got destroyed
					} else if (wall.getBricks()[rowIndex][colIndex].getState().equals("bomb")){
						for(int i= rowIndex-2; i<=rowIndex+2; i++){
							for (int j=0; j<5;j++){
								wall.getBricks()[i][j].setState("destroyed");
							}
						}
						
						score+=200;
						explode = true;
						over = true;
						
					}
					
				} else if (ballx<410){
					// the ball hits the enemy
					if (ballx<=100 && ballx>0 && bally>=700 && bally<=750){
						enemyhit = true;
						//the bomb hasn't exploded
						if(explode == false){
						score += 500;
						//the bomb has already exploded
						} else if (explode == true) {
						score += 150;
						}
					
					//off the screen
					} else if (ballx < 0){
						score -= 10;
					}
				}
				
			}
		}
		
		
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public double getA() {
		return A;
	}

	public void setA(double a2) {
		A = a2;
	}

	public int getScore() {

		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isExplode() {
		return explode;
	}

	public void setExplode(boolean explode) {
		this.explode = explode;
	}

	public boolean isEnemyhit() {
		return enemyhit;
	}

	public void setEnemyhit(boolean enemyhit) {
		this.enemyhit = enemyhit;
	}
	
	
}
