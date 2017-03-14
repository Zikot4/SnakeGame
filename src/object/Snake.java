package object;

import java.awt.Graphics;
import java.util.ArrayList;

import static object.IDirection.*;
import static object.IFrameParameters.FIELD_HEIGHT;
import static object.IFrameParameters.FIELD_WIDTH;


public class Snake {
	
	private ArrayList<Point> snake = new ArrayList<Point>();
	private int direction;
	
	public Snake(int x, int y,int lenght,int direction){
		for(int i = 0; i < lenght; i++){
			Point point = new Point(x-i,y);
			snake.add(point);
		}
		this.direction = direction;
	}
	
	public void paint(Graphics g){
		for(Point point : snake){
			if((snake.get(0).getX() == point.getX()) && (snake.get(0).getY() == point.getY()) )
				point.paintBorder(g);
			else{
				point.paint(g);
				point.paintBorder(g);
			}
		}
	}
	
	public boolean isFood(Point food){
		if(snake.get(0).getX() == food.getX() && snake.get(0).getY() == food.getY()) 
			return true;
		return false;
	}
	
	public boolean move(Point food){//Crutch
		int x = snake.get(0).getX();
		int y = snake.get(0).getY();
		
		switch(direction){
			case RIGHT: { x++; break; }
			case LEFT: 	{ x--; break; }
			case UP: 	{ y--; break; }
			case DOWN: 	{ y++; break; }
		}
		
		if(FIELD_HEIGHT == y)
			y = 0;
		if(y < 0)
			y = FIELD_HEIGHT-1;
		if(FIELD_WIDTH == x)
			x = 0;
		if(x < 0)
			x = FIELD_WIDTH-1;
		
		if(isInsideSnake(x, y)){
			return true;
		}
		
		snake.add(0, new Point(x,y));
		if(isFood(food)){
            food.eat();
            
		}else{
			snake.remove(snake.size()-1);
		}
		
		return false;
	}
	
	public boolean isInsideSnake(int x, int y){
		for(Point point : snake){
			if(point.getX() == x && point.getY() == y){
				return true;
			}
		}
		return false;
	}
	
    public void setDirection(int direction) {
    		
        if ((direction >= LEFT) && (direction <= DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }
    
    public int getLenght(){
    	return snake.size();
    }
}
