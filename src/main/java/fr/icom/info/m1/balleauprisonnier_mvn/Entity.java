package fr.icom.info.m1.balleauprisonnier_mvn;

import java.awt.Rectangle;

import javafx.scene.canvas.GraphicsContext;

public class Entity {
	public double speed;
	public double posX;
	public double posY;
	public double angle;
	public Rectangle hitbox;
	public boolean collision = false;
	public GraphicsContext graphicsContext; 
	public Sprite sprite;
	
}
