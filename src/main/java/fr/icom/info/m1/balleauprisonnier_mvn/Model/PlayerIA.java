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
    	
    	/*if (currenttime - tt >= 1000 && currenttime - tt < 2000) {
    		this.moveLeft();
    		System.out.println();
    	    tt = System.currentTimeMillis();
    	}*/
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
   		/*if( posX < 337) {
   			posX = 337;
   		}  */
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
   	    /*if( posX > w - 93) {
   		    posX = w - 93;
   		} */   
   	  }
   	 
    @Override
   	 public void moveUp()
   	  {	
   		Random randomGenerator = new Random();
        speed = randomGenerator.nextFloat();
   		spriteAnimate();  
   		posY -= speed;
   		/*if( posY < 36) {
   			posY = 36;
   		}*/
   	  }
     @Override
   	  public void moveDown(int h)
   	  {	  
   		 Random randomGenerator = new Random();
         speed = randomGenerator.nextFloat();
   		 spriteAnimate();  
   		 posY += speed;
   		 /*if( posY > h - 142) {
   			 posY = h - 142;
   		 }*/
   	  }

    
    public void isShot(Projectile balle) {
		  if(balle.collision == true) {
			
				  this.posX = 700 -50;
				  this.posY = 0;
				  
				
				  
		  }
	  }
}
