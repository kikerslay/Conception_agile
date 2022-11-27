package fr.icom.info.m1.balleauprisonnier_mvn.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Projectile extends Entity{
	
	public static final double ballrayon = 15; // rayon fix de la balle 
	public final double range = 150; // porter de la balle 
	public double traveltime = 180;
	public Projectile(GraphicsContext gc, double x, double y)
	{
		graphicsContext = gc;
		posX = x;
		posY = y;
		speed = 2.5;
		Image tilesheetImage = new Image("assets/ball.png");
	    sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), null);
	    sprite.setX(posX);
	    sprite.setY(posY);
		gc.drawImage(new Image("assets/ball.png"), 0, 600-50,10,10);
		alive = true;
		collision = false;
		
	}
	
	// getter de la positionX
	public double getPositionX() {
		return posX;
	}
	
	// getter de la positionY
	public double getPositionY() {
		return posY;
	}
	
	public void SetPositionX(double x) {
		this.posX = x;
	}
	
	// getter de la positionY
	public void SetPositionY(double y) {
		this.posY = y;
	}
	
	public boolean getEtat() {
		return this.alive;
	}
	public void setEtat(boolean t){
		this.alive = t;
	}
	
	public void setCol(boolean t){
		this.collision = t;
	}

	
	// On affiche la balle 
	public void draw() {
		if(this.alive == true) {
			graphicsContext.drawImage(new Image("assets/ball.png"), this.posX/*en.posX*/,this.posY /*pos_Y*/,25,25);
		}
	
	}
	public void move(){
		double s = posX;
		//while(this.traveltime !=0) {
			s = s + speed;
			this.SetPositionX(s);
			this.collision = true;
			this.traveltime -= 2;
		//}
		System.out.println(this.posX);
		
		if(this.traveltime == 0) {
			this.speed = 0;
		}
	}
}
