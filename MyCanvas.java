import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyCanvas extends JPanel {
	private Player1 player1;
	private Player2 player2;
	private Wall wall;
	private Catapult C1;
	private Catapult C2;
	private int width = 1200;
	private int height = 800;
	
		
	public MyCanvas (){
	
		
		//creating new wall
		wall = new Wall(15, 5, width/3);
		add(wall);
		//creating catapult one
		C1 = new Catapult(0, height-100, 100, 50);
		add(C1);
		//creating catapult two 
		C2 = new Catapult(width-100, height-100, 100,50);
		add(C2);
		//creating player one
		player1 = new Player1(wall);
		add(player1);
		//creating player two
		player2 = new Player2(wall);
		add(player2);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
		C1.draw(g, Color.black);
		C2.draw(g, Color.gray);
		wall.draw(g);
		g.setColor(Color.darkGray);
		g.fillRect(0, height-50, width, 50);
		
		player1.draw(g);
		player2.draw(g);
		
	
	}
	

	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}


	public Player1 getPlayer1() {
		return player1;
	}


	public void setPlayer1(Player1 player1) {
		this.player1 = player1;
	}


	public Player2 getPlayer2() {
		return player2;
	}


	public void setPlayer2(Player2 player2) {
		this.player2 = player2;
	}
	
	

		
	
	}
