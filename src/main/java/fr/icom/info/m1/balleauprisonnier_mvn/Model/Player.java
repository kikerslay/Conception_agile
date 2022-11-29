package fr.icom.info.m1.balleauprisonnier_mvn.Model;


import java.util.ArrayList;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * 
 * Classe gerant un joueur
 *
 */
public class Player extends Entity
{
	
	  String playerColor;
	  ImageView PlayerDirectionArrow;
      String side;
	  public boolean hasBall;
	  /**
	   * Constructeur du Joueur
	   * 
	   * @param gc ContextGraphic dans lequel on va afficher le joueur
	   * @param color couleur du joueur
	   * @param yInit position verticale
	   */
	  Player(GraphicsContext gc, String color, double xInit, double yInit, String s)
	  {
	    posX = xInit;               
	    posY = yInit;
	    graphicsContext = gc;
	    playerColor=color;
	    angle = 0;
	    alive = true;
	    collision = true;
	    hasBall = false;
	    side = s;
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
	 public void moves(ArrayList<String> input, Projectile balle,int w, int h) {
		 
		 if (input.contains("D")) { this.moveRight(w);}
		 if (input.contains("Q")) { this.moveLeft();}
		 if (input.contains("T")) { this.shoot(balle); balle.setMove(true);}
		 if (input.contains("Z")) { this.moveUp();}
		 if (input.contains("S")) { this.moveDown(h);}
		 
	 }
	  void moveLeft()
	  {	
		spriteAnimate();  
	    posX -= speed;
		if( posX < 30) {
			posX = 30;
		}  
	  }

	  /**
	   *  Deplacement du joueur vers la droite
	   */
	  void moveRight(int w) 
	  {
		spriteAnimate();  
		posX += speed;
	    if( posX > (w/2) -40) {
		    posX = (w/2) -40;
	    }    
	  }
	  
	  void moveUp()
	  {	
		  
		spriteAnimate();  
		posY -= speed;
		if( posY < 36) {
			posY = 36;
		}
	  }

	  void moveDown(int h)
	  {	  
		
		 spriteAnimate();  
		 posY += speed;
		 if( posY > h -142) {
			 posY = h - 142;
		 }
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
	  	
	  	if(hasBall == true) {
	  		sprite.playShoot();
	  		balle.move();
	  		balle.setEtat(true);
	  		this.hasBall = false;
	  	}
	  }
	   
	   public void getBalle(Projectile balle) {
		   if ((balle.collision == false) && (balle.moving == false) ) {
			   System.out.println("GetBalle");
			    balle.SetPositionX(this.posX);
		  	    balle.SetPositionY(this.posY);
			   	balle.setEtat(false);
			   	balle.traveltime = 180;
			   	balle.speed = 2.5;
			   	this.hasBall =true ;
		   }
		 
	   }
	  
	  /**
	   *  Deplacement en mode boost
	   */
	  void boost() 
	  {
	      posX += speed*2;
		  spriteAnimate();
	  }
	  void isShot(Projectile balle) {
		  if(balle.collision == true) {
			  if (balle.getPositionX() == this.posX && balle.getPositionY() == this.posY) {
				  this.posX = 0;
				  this.posY = 0;
			  }
		  }
	  }
	  void spriteAnimate(){
	  	  //System.out.println("Animating sprite");
		  if(!sprite.isRunning) {sprite.playContinuously();}
		  sprite.setX(posX);
		  sprite.setY(posY);
	  }
	  
}
