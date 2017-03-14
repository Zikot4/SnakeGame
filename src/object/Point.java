package object;

import java.awt.Color;
import java.awt.Graphics;


public class Point {
	
    final int POINT_RADIUS = 20;
    
    private boolean isEaten = false;
	private int x,y;
	private Color color = Color.black;
	
	public Point(int x,int y){
		this.setXY(x,y);
	}
	
	public void paint(Graphics g){
			
		g.setColor(color);
		g.fillRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
	}
	
	public void paintBorder(Graphics g){
		g.setColor(color);
		g.drawRect(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void eat() {
        isEaten = true;
    }
	
	public boolean isEaten() {
    	return isEaten;
    }
	
	public void setColor(Color color){
		this.color = color;
	}
	
    public int getX() { return x; }
    public int getY() { return y; }
}
