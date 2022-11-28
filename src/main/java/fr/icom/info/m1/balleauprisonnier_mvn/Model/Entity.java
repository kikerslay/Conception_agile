package fr.icom.info.m1.balleauprisonnier_mvn.Model;

import java.awt.Rectangle;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity  {
	public double speed;
	public double posX;
	public double posY;
	public double witdh;
	public double height;
	public double angle;
	public Rectangle hitbox;
	public boolean collision;
	public GraphicsContext graphicsContext; 
	public Sprite sprite;
	public String side;
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
	
	public Bbox bbox() {
		return new Bbox(this.posX, this.posX +10, this.posY , this.posY +10 );
	}
	public boolean isColliding(Entity other) {
		return bbox().isColliding(other.bbox());
	}
	
}
