package fr.icom.info.m1.balleauprisonnier_mvn.Controlleur;

import fr.icom.info.m1.balleauprisonnier_mvn.Model.Field;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.Player;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.PlayerIA;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.Projectile;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.canvas.GraphicsContext;

public class Controller {
	
	/** Tableau traçant les evenements */
	public ArrayList<String> input = new ArrayList<String>();
	long lastTurn = System.currentTimeMillis();
	public int score;
	GraphicsContext gc ;
	String Newligne=System.getProperty("line.separator");
	public Controller() {
		 
		
		 Field field =  Field.getInstance(700, 500);
		 gc = field.getGraphics();
		 score = 0;
		
		 
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
	            
	        	gc.drawImage(new Image("assets/terrain.png"), 0,0,700,500);
	     
	        	balle.draw();
	            // Deplacement et affichage des joueurs
	        	for (int i = 0; i < equipe1.length; i++) 
	    	    {
	        			if(balle.getMove() == true){
	        				
	        				balle.move();
	        				lastTurn = System.currentTimeMillis();
	        			}
	        			if(balle.getPositionX() > 310 && System.currentTimeMillis() - lastTurn >=1000 )
	    	        	{
	    	        		balle.setPositionX((700/2)-10);
	    	        		balle.setPositionY((500/2) -20);
	    	        		
	    	        	}
	        			if(equipe1[0].isColliding(balle) == true || equipe1[0].getHasBall()== true){
	        				
	        				equipe1[0].getBalle(balle);
	        			} 
	        			if(equipe2[i].isColliding(balle) == true) {
	        				
	        				score = equipe2[i].isShot(balle,score);
	        				
	        			}
	        			
	        		equipe1[0].moves(input,balle,700,500);
	        		equipe2[i].moveIA(System.currentTimeMillis(),lastTurn);
	        		gc.strokeText("Score : "+ score , 310, 20);	
	        		gc.strokeText("Z = Deplacement Haut"+Newligne+"Q = Deplacment Gauche D = Deplacement Gauche"
	        						+Newligne+"S = Deplacement Bas"+Newligne+"T = Tirer",50,440);
	    	    }
	        	
	        	
	        		
	    	}
	       
	     }.start(); // On lance la boucle de rafraichissement 
	    
	}
	
	
}
