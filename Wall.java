import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Wall extends JComponent{
	private Brick[][] bricks;
	private int x,y;


	public Wall(int rows, int cols, int framex){
		//initializing the bricks
		bricks = new Brick[rows][cols];
		x=framex;
		y = 700;
		//building the wall
		buildWall(rows,cols,framex);

	}

	public void buildWall(int rows, int cols, int framex){
		for(int i=0; i<rows;i++){
			x=framex;
			for (int j=0; j<cols; j++){
				if (i==rows/2&&j==cols/2){
					bricks[i][j]= new Bomb(x,y,65,50); 
				} else {
					bricks[i][j] = new Brick(x,y,65,50);
				}
				x+=65;
			}
			y-=50;
		}
	}


	public void draw (Graphics g){
		for(int i=0; i<bricks.length; i++){
			for (int j=0; j<bricks[i].length; j++){
				if (i==bricks.length/2&&j==bricks[i].length/2){
					Brick bomb = bricks[i][j];
					bomb.draw(g);
				} else {
					Brick brick = bricks[i][j];
					brick.draw(g);
				}
			}
		}
	}
	

	
	public Brick[][] getBricks() {
		return bricks;
	}
	

	public void setBricks(Brick[][] bricks) {
		this.bricks = bricks;
	}


	public Brick getBrick (int i, int j){
		return bricks[i][j];
	}
	


}
