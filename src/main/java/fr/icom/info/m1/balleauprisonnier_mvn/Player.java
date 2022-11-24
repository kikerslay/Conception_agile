package fr.icom.info.m1.balleauprisonnier_mvn;


import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 
 * Classe gerant un joueur
 *
 */
public class Player extends Entity
{
	
	  String playerColor;
	  // On une image globale du joueur 
	  //Image directionArrow;
	  //Sprite sprite;
	  ImageView PlayerDirectionArrow;
	  
	  /**
	   * Constructeur du Joueur
	   * 
	   * @param gc ContextGraphic dans lequel on va afficher le joueur
	   * @param color couleur du joueur
	   * @param yInit position verticale
	   */
	  Player(GraphicsContext gc, String color, int xInit, int yInit, String side)
	  {
		// Tous les joueurs commencent au centre du canvas, 
	    posX = xInit;               
	    posY = yInit;
	    graphicsContext = gc;
	    playerColor=color;
	    angle = 0;
	    alive = true;
	    //hitbox = new Rectangle();

	    // On charge la representation du joueur
        /**if(side=="top"){
        	directionArrow = new Image("assets/PlayerArrowDown.png");
		}
		else{
			directionArrow = new Image("assets/PlayerArrowUp.png");
		}
        
        PlayerDirectionArrow = new ImageView();
        PlayerDirectionArrow.setImage(directionArrow);
        PlayerDirectionArrow.setFitWidth(10);
        PlayerDirectionArrow.setPreserveRatio(true);
        PlayerDirectionArrow.setSmooth(true);
        PlayerDirectionArrow.setCache(true);**/
	    if(playerColor == "blue") {
	        Image tilesheetImage = new Image("assets/PlayerBlue.png");
	        sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), side);
	        sprite.setX(posX);
	        sprite.setY(posY);
	    }else {
	    Image tilesheetImage = new Image("assets/PlayerRed.png");
	    sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), side);
        sprite.setX(posX);
        sprite.setY(posY);
	    }
     
        //directionArrow = sprite.getClip().;

	    // Tous les joueurs ont une vitesse aleatoire entre 0.0 et 1.0
        //Random randomGenerator = new Random();
        //speed = randomGenerator.nextFloat();
	     speed = 0.6;
	  }

	  /**
	   *  Affichage du joueur
	   */
	  void display()
	  {
		  graphicsContext.save(); // saves the current state on stack, including the current transform
	      //rotate(graphicsContext, angle, posX + directionArrow.getWidth() / 2, posY + directionArrow.getHeight() / 2);
		  //graphicsContext.drawImage(directionArrow, posX, posY);
		  graphicsContext.restore(); // back to original state (before rotation)
	  }

	 /**private void rotate(GraphicsContext gc, double angle, double px, double py) {
		  Rotate r = new Rotate(angle, px, py);
		  gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	  }
	  
	  /**
	   *  Deplacement du joueur vers la gauche, on cantonne le joueur sur le plateau de jeu
	   */
	 public void moves(ArrayList<String> input,int w, int h) {
		 
		 if (input.contains("D")) { this.moveRight(w);}
		 if (input.contains("Q")) { this.moveLeft();}
		 if (input.contains("Z")) { this.moveUp();}
		 if (input.contains("S")) { this.moveDown(h);}
		 
	 }
	  void moveLeft() // online width
	  {	
		spriteAnimate();  
	    posX -= speed;
		if( posX < 0) {
			posX = 0;
		}  
	  }

	  /**
	   *  Deplacement du joueur vers la droite
	   */
	  void moveRight(int w) 
	  {
		spriteAnimate();  
		posX += speed;
	    if( posX > (w/2) -50) {
		    posX = (w/2) -50;
		}    
	  }
	  
	  void moveUp()
	  {	
		  
		spriteAnimate();  
		posY -= speed;
		if( posY < 0) {
			posY = 0;
		}
	  }

	  void moveDown(int h)
	  {	  
		
		 spriteAnimate();  
		 posY += speed;
		 if( posY > h -50) {
			 posY = h - 50;
		 }
		 /**
	    if (posY > 1 &&  posY < 600/2) 
	    {
			spriteAnimate();
		    posY += speed;
	    }else
	    {
	    	posY-= speed;
	    }**/
	  }
	  /**
	   *  Rotation du joueur vers la gauche
	   */
	  void turnLeft() 
	  {
	    if (angle > 0 && angle < 180) 
	    {
	    	angle += 1;
	    }
	    else {
	    	angle += 1;
	    }

	  }
	  
	  /**
	   *  Rotation du joueur vers la droite
	   */
	  void turnRight() 
	  {
	    if (angle > 0 && angle < 180) 
	    {
	    	angle -=1;
	    }
	    else {
	    	angle -= 1;
	    }
	  }

	   public void shoot(Projectile balle){
	  	sprite.playShoot();
	  	if(balle.alive == false) {
	  		balle.SetPositionX(this.posX);
	  		balle.SetPositionY(this.posY);
	  		balle.setEtat(true);
	  	}
	  	else{
	  		balle.move();
	  	}
	  	/*if(balle.alive == false) {
	  		balle.move();
	  	}*/
	  }
	   
	   public void getBalle(Projectile balle) {
		   
	   }
	  
	  /**
	   *  Deplacement en mode boost
	   */
	  void boost() 
	  {
	      posX += speed*2;
		  spriteAnimate();
	  }

	  void spriteAnimate(){
	  	  //System.out.println("Animating sprite");
		  if(!sprite.isRunning) {sprite.playContinuously();}
		  sprite.setX(posX);
		  sprite.setY(posY);
	  }
	  
}
