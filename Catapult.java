import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Catapult extends JComponent{
	private int Ctp_x, Ctp_y, width, height;
	
	public Catapult(int Ctp_x, int Ctp_y, int width, int height){

		this.Ctp_x = Ctp_x;
		this.Ctp_y = Ctp_y;
		this.width = width;
		this.height = height;
		
	}
	
	public void draw (Graphics g, Color color){
		g.setColor(color);
		g.fillRect(Ctp_x, Ctp_y, width, height);
	}
	


	
}