import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MyGame extends JFrame implements ActionListener{
	private MyCanvas canvas;
	private JPanel panel;
	private JPanel panel2;
	private JLabel label;
	private JLabel label5;
	private JLabel label3;
	private JLabel label4;
	private JTextField speed;
	private JTextField angle;
	private JButton launch;
	private JButton start;

	private JLabel p2label;
	private JLabel p2label2;
	private JLabel p2label3;
	private JLabel p2label4;
	private JTextField p2speed;
	private JTextField p2angle;
	private JButton p2launch;
	
	// player 1 and 2 velocity and angles.
	private int v1,v2; 
	private double A1, A2;
	
	// counter for the number of times each player shoot
	private int launchTime1;
	private int launchTime2;

	
	public MyGame(){
	
		setSize(new Dimension(1225, 900));
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		

		launchTime1 = 0;
		launchTime2 = 0;
		
		canvas = new MyCanvas();
		add(canvas, BorderLayout.CENTER);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout());

		//label for player1
		label4 = new JLabel("PLAYER 1", JLabel.CENTER);
		panel.add(label4);

		label3 = new JLabel("Score:");
		panel.add(label3);
		//information to enter the speed
		label = new JLabel ("Speed:");
		panel.add(label);
		speed = new JTextField ();
		speed.addActionListener(this);
		speed.setPreferredSize(new Dimension (100,20));
		panel.add(speed);

		//information to enter the angle
		label5 = new JLabel ("Angle:");      
		panel.add(label5, BorderLayout.WEST);
		angle = new JTextField ();
		angle.addActionListener(this);
		angle.setPreferredSize(new Dimension (100,20));
		panel.add(angle);

		//launch button
		launch = new JButton ("Launch!");
		launch.addActionListener(this);
		panel.add(launch);

		//---------------------------------------------------//

		//label for player2
		p2label4 = new JLabel("PLAYER 2", JLabel.CENTER);
		panel.add(p2label4);

		p2label3 = new JLabel("Score:");
		panel.add(p2label3);

		//information to enter the speed
		p2label = new JLabel ("Speed:");
		panel.add(p2label);
		p2speed = new JTextField ();
		p2speed.addActionListener(this);
		p2speed.setPreferredSize(new Dimension (100,20));
		panel.add(p2speed);

		//information to enter the angle
		p2label2 = new JLabel ("Angle: ");
		panel.add(p2label2);
		p2angle = new JTextField ();
		p2angle.addActionListener(this);
		p2angle.setPreferredSize(new Dimension (100,20));
		panel.add(p2angle);

		//launch button
		p2launch = new JButton ("Launch!");
		p2launch.addActionListener(this);
		panel.add(p2launch);
		
	
	}


	public static void main(String[] args){
		MyGame game = new MyGame();
		game.setVisible(true);
		
		
		

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();
		if(e.getSource().equals(speed)){
			canvas.getPlayer1().setV(Integer.parseInt(speed.getText()));
	
			} else if (e.getSource().equals(angle)){
			A1 =  Math.toRadians((Integer.parseInt(angle.getText())));
			canvas.getPlayer1().setA(A1);
	
			} else if (e.getSource().equals(p2speed)){
			canvas.getPlayer2().setV(Integer.parseInt(p2speed.getText()));
			
			} else if (e.getSource().equals(p2angle)){
			A2 =  Math.toRadians((180-Integer.parseInt(p2angle.getText())));
			canvas.getPlayer2().setA(A2);
			
			} else if (e.getSource().equals(launch)){
			launchTime1++;
			System.out.println(launchTime1);
			label3.setText("Score: " + canvas.getPlayer1().getScore());
			canvas.getPlayer1().draw(g);
			repaint();
			gameover();
			} else if (e.getSource().equals(p2launch)){
			launchTime2++;	
			System.out.println(launchTime2);
			canvas.getPlayer2().draw(g);
			p2label3.setText("Score: " + canvas.getPlayer2().getScore());
			gameover();
			repaint();
			}
		
	}

	// method to say game over when the launch number reaches 50 times.
	public void gameover(){
		if (launchTime1 == 50 || launchTime2 == 50){
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.drawRect(100, 100, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Game Over!", 125, 125);
		}
	}
	
	
	public double getA1() {
		return A1;
	}


	public void setA1(double a1) {
		A1 = a1;
	}


	public int getV2() {
		return v2;
	}


	public void setV2(int v2) {
		this.v2 = v2;
	}


	public double getA2() {
		return A2;
	}


	public void setA2(int a2) {
		A2 = a2;
	}

	public int getV1(){
		return this.v1;
	}
}




	