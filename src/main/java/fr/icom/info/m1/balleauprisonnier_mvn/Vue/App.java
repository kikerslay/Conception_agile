package fr.icom.info.m1.balleauprisonnier_mvn.Vue;

import fr.icom.info.m1.balleauprisonnier_mvn.Controlleur.Controller;
import fr.icom.info.m1.balleauprisonnier_mvn.Model.Field;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale de l'application 
 * s'appuie sur javafx pour le rendu
 */
public class App extends Application 
{
	
	/**
	 * En javafx start() lance l'application
	 *
	 * On cree le SceneGraph de l'application ici
	 * @see http://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm
	 * 
	 */
	@Override
	public void start(Stage stage) throws Exception 
	{
		// Nom de la fenetre
        stage.setTitle("Balle Au Prisonnier");
       
        Group root = new Group();
        Scene scene = new Scene( root );
        Controller controleur = new Controller();
        // On cree le terrain de jeu et on l'ajoute a la racine de la scene
        Field gameField =  Field.getInstance(700,800);
        controleur.runController(gameField,gameField.getEquipe1(),gameField.getEquipe2(),gameField.getProjectile());
        root.getChildren().add( gameField );
        for (int i = 0; i < 3 ;i++) {
        	
        	root.getChildren().add(gameField.getEquipe2()[i].sprite);
        }
        root.getChildren().add(gameField.getEquipe1()[0].sprite);

        // On ajoute la scene a la fenetre et on affiche
        stage.setScene( scene );
        stage.show();
	}
	
    public static void main(String[] args) 
    {
    
    	Application.launch(args);
    }
}
