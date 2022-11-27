package fr.icom.info.m1.balleauprisonnier_mvn.Controlleur;

import fr.icom.info.m1.balleauprisonnier_mvn.Model.Field;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.Player;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.PlayerIA;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.Projectile;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.GraphicsContext;

public class Controller {
	
	public ArrayList<String> input = new ArrayList<String>();
    
	GraphicsContext gc ;
	public Controller() {
		 
		
		 Field field =  Field.getInstance(700, 500);
		/* Projectile balle = field.getProjectile();
		 Player [] equipe1 = field.getEquipe1();
		 PlayerIA [] equipe2 = field.getEquipe2();	*/
		 gc = field.getGraphics();
		 
		
		 
	}
	public void runController(Field field, Player[] equipe1,PlayerIA [] equipe2,Projectile balle) {
		
		
		field.setOnKeyPressed( // Controller
	    		new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            // only add once... prevent duplicates
	    	            if ( !input.contains(code) )
	    	                input.add( code );
	    	        }
	    	    });
		field.setOnKeyReleased( // controller
	    	    new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            input.remove( code );
	    	        }
	    	    });
	  new AnimationTimer() 
	    {
		     	
		
	        public void handle(long currentNanoTime)
	        {	 
	            // On nettoie le canvas a chaque frame
	            //gc.setFill( Color.WHITE);
	            //gc.fillRect(0, 0, width, height);
	            //gc.lineTo(w, h/2);
	        	gc.drawImage(new Image("assets/terrain.png"), 0,0,700,500);
	        
	        	//balle[0].draw();
	        	  balle.draw();
	        	
	        	  //balle.move();
	            //balle[0] = new Projectile(gc, w/2, h-5);
	            // Deplacement et affichage des joueurs
	        	for (int i = 0; i < equipe1.length; i++) 
	    	    {
	        		equipe1[0].moves(input,700,500);
	        		equipe2[i].moveIA();
	        		equipe2[i].isShot(balle);
	        		//equipe1[i].display();
	        		//equipe2[i].display();
	        		equipe1[0].shoot(balle);
	    	    }
	        	
	        	equipe1[0].setPositionX(10);
	        	equipe1[0].setPositionY(10);
	        	System.out.println(equipe1[0].getPositionX());
	        	System.out.println(equipe1[0].getPositionY());
	        	//if(balle.getPositionX() > 200) {
	        	//equipe1[0] = null;
	        	System.out.println("Q");
	        		//System.out.println(input.get(0));
	        	//}
	        		
	    	}
	     }.start(); // On lance la boucle de rafraichissement 
	     
	}
	
}
