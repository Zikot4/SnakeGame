package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import javax.swing.JPanel;

import object.Food;
import object.Point;
import object.Poison;
import object.Snake;
import static object.IDirection.START_DIRECTION;
import static object.IFrameParameters.*;

public class JPanelSnake extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
    private boolean gameOver = false;
    Random random = new Random();
    
    Snake snake;
    Food food;
    Poison poison;
    
    public JPanelSnake(){
    	
    }
    
    @Override
	public void paint(Graphics g){
    	super.paint(g);
    	snake.paint(g);
    	food.paint(g);
    	poison.paint(g);
        if (gameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG))/2, (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY)/2);
        }

    }
    
    void addCanvas(Frame frame){
    	setBackground(Color.WHITE);
    	frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX,FIELD_HEIGHT *POINT_RADIUS + FIELD_DY );
    	
    	food = new Food(random.nextInt(FIELD_WIDTH),random.nextInt(FIELD_HEIGHT));
    	snake = new Snake(START_SNAKE_X,START_SNAKE_Y,START_SNAKE_SIZE,START_DIRECTION);
    	poison = new Poison(random.nextInt(FIELD_WIDTH),random.nextInt(FIELD_HEIGHT));
    	frame.setTitle(TITLE_OF_PROGRAM + " : "+snake.getLenght());
    	
    	frame.addKeyListener(new KeyAdapter(){
    		public void keyPressed(KeyEvent e){
    			snake.setDirection(e.getKeyCode());
    			if(e.getKeyCode() == 10){
    				;//TODO 
    			}
    				
    			
    		}
    	});

    	run(frame);
    }

    void createNextPoint(Point point){
    	int x,y;
    	do{
    		x = random.nextInt(FIELD_WIDTH);
    		y = random.nextInt(FIELD_HEIGHT);	
    	}while(snake.isInsideSnake(x,y));
	point.setXY(x, y);
    }


    void run(Frame frame){
    	while(!gameOver){

    		gameOver = snake.move(food);
    		
    		if(snake.isFood(food)){
    			frame.setTitle(TITLE_OF_PROGRAM + " : "+snake.getLenght());
    			createNextPoint(food);
    			createNextPoint(poison);
    		}
    		if(snake.isFood(poison))
    			gameOver = true;
    		
    		
    		this.repaint();
    		try{
    			Thread.sleep(SHOW_DELAY);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
}




