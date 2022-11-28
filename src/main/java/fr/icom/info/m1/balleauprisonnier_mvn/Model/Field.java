package fr.icom.info.m1.balleauprisonnier_mvn.Model;




import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


/**
 * Classe gerant le terrain de jeu.
 * 
 */
public class Field extends Canvas {
	
	private static Field fObject;

	private Player [] equipe1 = new Player[3];
	private PlayerIA [] equipe2 = new PlayerIA[3];

	private Projectile balle;
	String[] colorMap = new String[] {"blue", "green", "orange", "purple", "yellow"};


    
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
        
        //balle = new Projectile(gc,(w/2)-10,(h/2)-20);
        balle = new Projectile(gc,(w/2)-100,(h/2)-20);
        
        /** On initialise le terrain de jeu */
    	equipe1[0] = new Player(gc, colorMap[0], 175, 100, "left"); // 1er joueur gauche 
    

		//equipe1[1] = new Player(gc, colorMap[0], 175, 200, "left"); // bas gauche 0 h-50
    	

		//equipe1[2] = new Player(gc, colorMap[0], 175, h-200, "left"); //  bas droite w h-50
    

    	equipe2[0] = new PlayerIA(gc, colorMap[1], w-230, 100, "right"); // milieu 
    	

		equipe2[1] = new PlayerIA(gc, colorMap[1], w-230, 200, "right"); // haut a  gauche 0 20
    

		equipe2[2] = new PlayerIA(gc, colorMap[1], w-230, h-200, "right"); // haut a droite  w-50 20
    	
    	

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
