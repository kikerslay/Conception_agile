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
		speed = 0.5;
		Image tilesheetImage = new Image("assets/ball.png");
	    sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), null);
	    sprite.setX(posX);
	    sprite.setY(posY);
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
	public void draw(Entity en) {
		//graphicsContext.fillOval(ballspeedX, ballspeedY, ballrayon, ballrayon);
		double pos_Y = en.posY;
		graphicsContext.drawImage(new Image("assets/ball.png"), en.posX, pos_Y);
		System.out.println(posY);
		double cpt = en.posY;
		cpt = cpt - speed;
		this.SetPositionY(cpt);
	}
	
}
