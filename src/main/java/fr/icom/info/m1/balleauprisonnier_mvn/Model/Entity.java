package fr.icom.info.m1.balleauprisonnier_mvn.Model;

import java.awt.Rectangle;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity  {
	public double speed;
	public double posX;
	public double posY;
	public double angle;
	public Rectangle hitbox;
	public boolean collision;
	public GraphicsContext graphicsContext; 
	public Sprite sprite;
	public boolean alive;
	
	public double getPositionX() {
		return this.posX;
	}
	
	public double getPositionY() {
		return this.posY;
	}
	
	public void setPositionX(double x) {
		 this.posX = x;
	}
	
	public void setPositionY(double y) {
		 this.posY = y;
	}
}
