package fr.icom.info.m1.balleauprisonnier_mvn.Model;




import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


/**
 * Classe gerant le terrain de jeu.
 * 
 */
public class Field extends Canvas {
	
	private static Field fObject;
	/** Joueurs */
	 private Player [] equipe1 = new Player[3];
	 private PlayerIA [] equipe2 = new PlayerIA[3];
	/** Couleurs possibles */
	private Projectile balle;
	String[] colorMap = new String[] {"blue", "green", "orange", "purple", "yellow"};
	/** Tableau traçant les evenements */
   // ArrayList<String> input = new ArrayList<String>();
    
    /** Balle **/
    
    final GraphicsContext gc;
    final int width;
    final int height;
    //Controller controller = new Controller()
   
    /**
     * Canvas dans lequel on va dessiner le jeu.
     * 
     * @param scene Scene principale du jeu a laquelle on va ajouter notre Canvas
     * @param w largeur du canvas
     * @param h hauteur du canvas
     */
	private Field( int w, int h) 
	{
		super(w, h); 
		width = w;
		height = h;
		
		/** permet de capturer le focus et donc les evenements clavier et souris */
		this.setFocusTraversable(true);
		
        gc = this.getGraphicsContext2D();
        
        balle = new Projectile(gc,(w/2)-10,(h/2)-20);
        //balle[0].draw();
        /** On initialise le terrain de jeu */
    	equipe1[0] = new Player(gc, colorMap[0], 175, 100, "left"); // 1er joueur gauche 
    	//equipe1[0].display();

		equipe1[1] = new Player(gc, colorMap[0], 175, 200, "left"); // bas gauche 0 h-50
    	//equipe1[1].display();

		equipe1[2] = new Player(gc, colorMap[0], 175, h-200, "left"); //  bas droite w h-50
    	//equipe1[2].display();

    	equipe2[0] = new PlayerIA(gc, colorMap[1], w-230, 100, "right"); // milieu 
    	//equipe2[0].display();

		equipe2[1] = new PlayerIA(gc, colorMap[1], w-230, 200, "right"); // haut a  gauche 0 20
    	//equipe2[1].display();

		equipe2[2] = new PlayerIA(gc, colorMap[1], w-230, h-200, "right"); // haut a droite  w-50 20
    	//equipe2[2].display();
    	

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est pressee on la rajoute a la liste d'input
	     *   
	     */
	    /*this.setOnKeyPressed( // Controller
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

	    /* 
	     * Event Listener du clavier 
	     * quand une touche est relachee on l'enleve de la liste d'input
	     *   
	     */
	   /* this.setOnKeyReleased( // controller
	    	    new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            input.remove( code );
	    	        }
	    	    });
	    
	    /** 
	     * 
	     * Boucle principale du jeu
	     * 
	     * handle() est appelee a chaque rafraichissement de frame
	     * soit environ 60 fois par seconde.
	     * 
	     */
	    /*new AnimationTimer() 
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
	        		equipe1[0].moves(input,width,height);
	        		equipe2[i].isShot(balle);
	        		//equipe1[i].display();
	        		//equipe2[i].display();
	        		equipe1[0].shoot(balle);
	    	    }
	       
	        	equipe2[0].setPositionX(10);
	        	equipe2[0].setPositionY(10);
	        	System.out.println(equipe1[0].getPositionX());
	        	System.out.println(equipe1[0].getPositionY());
	        	//if(balle.getPositionX() > 200) {
	        	//equipe1[0] = null;
	        		System.out.println(equipe2[0]);
	        	//}
	        		
	    	}
	     }.start(); // On lance la boucle de rafraichissement 
	     */
	}
	 //methode pour singleton pattern
	public static Field getInstance(int w, int h) {
	      if(fObject == null) {
	         fObject = new Field(w,  h); 
	      }

	       // returns the singleton object
	       return fObject;
	}

	public Player[] getEquipe1() {
		return equipe1;
	}

	public PlayerIA[] getEquipe2() {
		return equipe2;
	}
	public Projectile getProjectile() {
		return this.balle;
	}
	
	public GraphicsContext getGraphics() {
		return gc;
	}
	
}
