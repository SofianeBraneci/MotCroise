package pobj.motx.tme1;

/**
 * Classe permetant la representation d'une Case
 * @author Hamdad Khellaf
 * @author Braneci sofiane
 * */

public class Case {
	/* ligne de la case*/
	private int lig;
	/* colonne de la case*/
	private int col;
	/* lettre contenue dans la case*/
	private char c;
	
	
	/**
	 * Constructeur de la classe
	 * qui permet l'instantiation d'une case
	 * @param lig: ligne de la case
	 * @param col: colonne de la case
	 * @param c: caractère à stocker dans la case
	 * 
	 * */
	public Case(int lig, int col, char c) {
		
		this.lig =lig;
		this.col = col;
		this.c = c;
	}
	
	/** Accèsseur de l'attribut lig
	 * 
	 * @return la ligne de la case*/
	public int getLig() {
		return this.lig;
	}
	
	/** Accèsseur de l'attribut col
	 * 
	 * @return la col de la case*/
	
	public int getCol() {
		return this.col;
	}
	
	/** Accèsseur de l'attribut c
	 * 
	 * @return la lettre / valeur de la case*/
	public char getChar() {
		return this.c;
	}
	/** Mutateur de l'attribut lig*/
	public void setChar(char c) {
		this.c = c;
	}
	
	/** Test si une case est vide
	 * @return un boolean */
	public boolean isVide() {
		return this.c == ' ';
	}
	
	/** Test si une case est pleine
	 * @return un boolean */
	public boolean isPleine() {
		return this.c == '*';
	}
	
	/** Permet de retourner une copie de la case 
	 * @return Case */
	public Case clone() {
		return new Case(this.lig, this.col, this.c );
	}
	

}
