package pobj.motx.tme2;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

/**
 * Classe permetant de representer une contrainte de croisement
 * @author Hamdad Khellaf
 * @author Braneci sofiane
 * */

public class CroixContrainte implements IContrainte {
	private int m1, c1, m2, c2;

	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;

	}
	/**
	 * méthode qui permet de reduire l'ensemble des mots potentiels
	 * @param: GrillePotentiel
	 * */
	@Override
	public int reduce(GrillePotentiel grille) {

		EnsembleLettre set1, set2;
		Dictionnaire dict;

		set1 = grille.getMotsPot().get(m1).calcuEnsembleLettre(c1);
		set2 = grille.getMotsPot().get(m2).calcuEnsembleLettre(c2);
		int counter = 0;

		EnsembleLettre inter = set1.intersection(set2);
		if (set1.size() > inter.size() ) {
			dict = grille.getMotsPot().get(m1);
			counter  += dict.filtreParLettre(inter, c1);
		}
		if (set2.size() > inter.size()) {
			 
				dict = grille.getMotsPot().get(m2);
				counter  += dict.filtreParLettre(inter, c2);
			
		}
		
		return counter;

	}
	/**
	 * permet d'effectuer une deep comparaison 
	 * si l'objet passé et lui même l'objet courrant alors true
	 * sion on vois si les attributs sont les même
	 * @param: Object 
	 * */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CroixContrainte)) {
			return false;			
		}
		CroixContrainte o = (CroixContrainte) other;
		return (this.m1 == o.m1 && this.c1 == o.c1 && this.m2 == o.m2 && this.c2 == o.c2);
	}
	


}
