import java.awt.Graphics;
import java.util.*;
import java.awt.Color;
import javax.swing.JComponent;

public class Brick{
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	private Color color;
	protected String state;


	public Brick(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state = "normal";
		//this.color = color.red;
	}
	
	

	public void draw(Graphics g){
		if (state.equals("normal")){
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		} else if (state.equals("cracked")){
		g.setColor(Color.magenta);
		g.fillRect(x, y, width, height);
		} else if (state.equals("destroyed")){
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
		}
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);

	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}








}
