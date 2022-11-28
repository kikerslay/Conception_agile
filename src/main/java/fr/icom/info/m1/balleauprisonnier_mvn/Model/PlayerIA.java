package fr.icom.info.m1.balleauprisonnier_mvn.Model;

import javafx.scene.canvas.GraphicsContext;
import java.util.Random;
 
public class PlayerIA extends Player{
	

    PlayerIA(GraphicsContext gc, String color, int xInit, int yInit, String side) {
        super(gc, color, xInit, yInit, side);
 
    }
   
    public void moveIA() {
    
    	this.moveLeft();
    	this.moveUp();
    	this.moveDown(500);
    	if(this.posX <= (700/2)-10) {
    		this.moveRight(700);
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
   		if( posX < 0) {
   			posX = 0;
   		}  
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
   	    if( posX > (w/2) -50) {
   		    posX = (w/2) -50;
   		}    
   	  }
   	 
    @Override
   	 public void moveUp()
   	  {	
   		Random randomGenerator = new Random();
        speed = randomGenerator.nextFloat();
   		spriteAnimate();  
   		posY -= speed;
   		if( posY < 0) {
   			posY = 0;
   		}
   	  }
     @Override
   	  public void moveDown(int h)
   	  {	  
   		 Random randomGenerator = new Random();
         speed = randomGenerator.nextFloat();
   		 spriteAnimate();  
   		 posY += speed;
   		 if( posY > h -50) {
   			 posY = h - 50;
   		 }
   	  }

    
    public void isShot(Projectile balle) {
		  if(balle.collision == true) {
			
				  this.posX = 0;
				  this.posY = 0;
				  
				
				  
		  }
	  }
}
