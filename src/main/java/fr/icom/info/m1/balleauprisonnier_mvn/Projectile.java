package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Projectile extends Entity{
	
	public static final double ballrayon = 15; // rayon fix de la balle 

	public Projectile(GraphicsContext gc, double x, double y)
	{
		graphicsContext = gc;
		posX = x;
		posY = y;
		speed = 1.5;
		Image tilesheetImage = new Image("assets/ball.png");
	    sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), null);
	    sprite.setX(posX);
	    sprite.setY(posY);
		gc.drawImage(new Image("assets/ball.png"), 0, 600-50,10,10);
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
	
	// On affiche la balle 
	public void draw(Entity e) {
		//graphicsContext.fillOval(ballspeedX, ballspeedY, ballrayon, ballrayon);
		//double pos_Y = posY;
		graphicsContext.drawImage(new Image("assets/ball.png"), this.posX/*en.posX*/,this.posY /*pos_Y*/,25,25);
		//System.out.println(posY);
		double cpt = posX;
		cpt = cpt + speed;
		this.SetPositionX(cpt);
		System.out.println(cpt);
		if(cpt >= (700-e.posX)) {
		this.SetPositionX(700-e.posX);	
		}
		/*if (cpt > 700 - posX) {
			this.SetPositionX(cpt);
		}*/
	}
	
}
