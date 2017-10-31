import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Bomb extends Brick{
	Boolean hit;

	public Bomb(int x, int y, int width, int height) {
		super(x, y, width, height);
		state = "bomb";
		hit = false;
	}
	
	@Override 
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
	
}
