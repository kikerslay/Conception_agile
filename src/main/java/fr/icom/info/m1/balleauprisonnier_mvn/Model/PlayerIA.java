package fr.icom.info.m1.balleauprisonnier_mvn.Model;

import javafx.scene.canvas.GraphicsContext;
import java.util.Random;
 
public class PlayerIA extends Player{
	
	long lastTurn = System.currentTimeMillis();
	public boolean moveLeft, moveUp;
    PlayerIA(GraphicsContext gc, String color, int xInit, int yInit, String side) {
        super(gc, color, xInit, yInit, side);
        
    }
       
    public void moveIA(long currenttime,long tt) {
    	
    	if (this.posX > 607) {
    		moveLeft = true;
    	}
    	if (this.posX < 337) {
    		moveLeft = false;
    	}
    		if(moveLeft) {
    			this.moveLeft();
    		}
    		else {
    			this.moveRight(700);
    		}
 
    	if (this.posY > 358) {
        	moveUp = true;
        }
        if (this.posY < 36) {
        	moveUp = false;
        }
        	if(moveUp) {
        		this.moveUp();
        	}
        	else {
        		this.moveDown(500);
        	}
    }
    	//
    
	@Override
    public  void moveLeft()
   	  {	
    	
    	Random randomGenerator = new Random();
        speed = randomGenerator.nextFloat();
   		spriteAnimate();  
   	    posX -= speed;
   	
   	  }

   	  /**
   	   *  Deplacement du joueur vers la droite
   	   */
	
    @Override
   	public void moveRight(int w) 
   	  {
   		Random randomGenerator = new Random();
        speed = randomGenerator.nextFloat();
   		spriteAnimate();  
   		posX += speed;
   	   
   	  }
   	 
    @Override
   	 public void moveUp()
   	  {	
   		Random randomGenerator = new Random();
        speed = randomGenerator.nextFloat();
   		spriteAnimate();  
   		posY -= speed;
   		
   	  }
     @Override
   	  public void moveDown(int h)
   	  {	  
   		 Random randomGenerator = new Random();
         speed = randomGenerator.nextFloat();
   		 spriteAnimate();  
   		 posY += speed;
   		
   	  }

    /*
     * Detection de la collision balle IA
     */
    public int isShot(Projectile balle,int score) {
		  if(balle.collision == true) {
			  	  score += 1;
				  this.posX = 700 -50;
				  this.posY = 0;
		  }
		  return score;
	  }
}
