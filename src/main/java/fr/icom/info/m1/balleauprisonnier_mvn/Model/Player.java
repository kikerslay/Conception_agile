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
      String side;
	  private boolean hasBall;
	  /**
	   * Constructeur du Joueur
	   * 
	   * @param gc ContextGraphic dans lequel on va afficher le joueur
	   * @param color couleur du joueur
	   * @param yInit position verticale
	   */
	   public Player(GraphicsContext gc, String color, double xInit, double yInit, String s)
	  {
	    posX = xInit;               
	    posY = yInit;
	    graphicsContext = gc;
	    playerColor=color;
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
	 public void moveLeft()
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
	public  void moveRight(int w) 
	  {
		spriteAnimate();  
		posX += speed;
	    if( posX > (w/2) -40) {
		    posX = (w/2) -40;
	    }    
	  }
	  
	 public void moveUp()
	  {	
		  
		spriteAnimate();  
		posY -= speed;
		if( posY < 36) {
			posY = 36;
		}
	  }

	 public void moveDown(int h)
	  {	  
		
		 spriteAnimate();  
		 posY += speed;
		 if( posY > h -142) {
			 posY = h - 142;
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
			    balle.setPositionX(this.posX);
		  	    balle.setPositionY(this.posY);
			   	balle.setEtat(false);
			   	balle.traveltime = 180;
			   	balle.speed = 2.5;
			   	this.hasBall =true ;
		   }
		 
	   }
	  
	  /**
	   *  Deplacement en mode boost
	   */
	
	 public void isShot(Projectile balle) {
		  if(balle.collision == true) {
			  if (balle.getPositionX() == this.posX && balle.getPositionY() == this.posY) {
				  this.posX = 0;
				  this.posY = 0;
			  }
		  }
	  }
	 public void spriteAnimate(){
	  	  //System.out.println("Animating sprite");
		  if(!sprite.isRunning) {sprite.playContinuously();}
		  sprite.setX(posX);
		  sprite.setY(posY);
	  }
	  
	  public boolean getHasBall() {
		  return hasBall;
	  }
	  
}
