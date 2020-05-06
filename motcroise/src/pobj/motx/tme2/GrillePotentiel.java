package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;


/**Classe permetant de representer une Grille potentiel
 * @author Hamdad Khellaf
 * @author Braneci sofiane*/
public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dicoComplet;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;
	/**
	 * @param grille: represente une GrillePlace
	 * @param dicoComplet: represente un Dictionnaire du langage français
	 * 
	 * */
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dicoComplet = dicoComplet;
		motsPot = new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<IContrainte>();
		List<Emplacement> emps = this.grille.getPlaces();

		for (Emplacement e : emps) {
			Dictionnaire dict = dicoComplet.copy();
			dict.filtreLongueur(e.size());
			for (int i = 0; i < e.size(); i++) {
				if (!e.getList().get(i).isVide()) {
					dict.filtreParLettre(e.getList().get(i).getChar(), i);

				}
			}
			motsPot.add(dict);
		}

		int horizontal = grille.getNbHorizontal();

		Emplacement e1, e2;

		// over kill !!!
		for (int i = 0; i < horizontal; i++) {
			e1 = emps.get(i);
			for (int j = horizontal; j < emps.size(); j++) {
				e2 = emps.get(j);
				for (Case c1 : e1.getList()) {
					for (Case c2 : e2.getList()) {
						if (c1.isVide()) {
							if (c1.getCol() == c2.getCol() && c1.getLig() == c2.getLig()) {
								contraintes.add(
										new CroixContrainte(i, e1.getList().indexOf(c1), j, e2.getList().indexOf(c2)));
							}
						}
					}
				}

			}

		}

		for (IContrainte c : contraintes) {
			c.reduce(this);
		}

		propage();
	}
	
	/**permet la propagation des contraintes*/
	public boolean propage() {
		int counter;
		while (true) {
			counter = 0;
			for (IContrainte c : contraintes) {
				counter += c.reduce(this);
			}
			if (counter == 0) {
				return true;
			}
			if (isDead()) {
				return false;
			}
		}

	}
	
	/**rend true s'il exist un dictionnaire vide
	 * @return boolean
	 **/
	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if (d.getElements().size() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return list des mot potentiel*/
	public List<Dictionnaire> getMotsPot() {
		return motsPot;

	}
	/**rend une nouvelle GrillePotentiel où les cases constituant l’emplacement
de mot d’indice m,  ont pour contenu les lettres de soluce
	@param m: index de l'emplacement
	@param soluce: chaine de carctère 
	@return: GrillePotentiel
*/
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces gPlaces = grille.fixer(m, soluce);

		return new GrillePotentiel(gPlaces, dicoComplet);
	}

	/**@return gille place*/
	public GrillePlaces getGrillePlaces() {
		return grille;
	}
	/**@return list des contraintes*/
	public List<IContrainte> getContraintes() {
		return contraintes;
	}

}
