package pobj.motx.tme1;

/**Classe qui définit une Grille
 * @author Hamdad Khellaf
 * @author Braneci sofiane*/
public class Grille {
	/**Attribut permetant de manipuler la grille*/
	private Case[][] grille;
	
	/**
	 * Constructeur de la Grille
	 * qui permet d'initailiser la grille par des case vide
	 * @param hauteur: le nombre de lignes
	 * @param largeur: le nombre de colonnes
	 * 
	 * */
	public Grille( int hauteur, int largeur) {
		this.grille = new Case[hauteur][largeur];
		for(int i=0 ;i < this.grille.length;i++) {
			for (int j=0 ; j < this.grille[0].length ; j++) {
				this.grille[i][j] = new Case(i,j,' '); 
			}
		}
	}
	
	/**
	 * Accèsseur d'une case
	 * @param lig: index de la ligne
	 * @param col: index de la colonne
	 * @return Case
	 * */
	
	public Case getCase(int lig, int col) {
		return this.grille[lig][col];
	}
	
	
	/**Permet l'affichage de la grille*/
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	/** Accèsseur qui permet d'acceder à l'attribut hauteur 
	 * @return int*/
	public int nbLig() {
		return this.grille.length;
	}
	
	/** Accèsseur de l'attribut largeur 
	 * @return int */
	
	public int nbCol() {
		return this.grille[0].length;
	}
	
	/** Méthode qui permet de créer une copie de la grille
	 * @return Grille */
	public Grille copy() {
		Grille newCopy = new Grille(this.nbLig(),this.nbCol());
		for(int i=0 ;i < this.nbLig();i++) {
			for (int j=0 ; j < this.nbCol() ; j++) {
				newCopy.grille[i][j] = this.getCase(i, j).clone() ;
			}
		}
		return newCopy;
	}
	
}
