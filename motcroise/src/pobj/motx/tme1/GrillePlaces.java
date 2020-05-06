package pobj.motx.tme1;

import java.util.List;



import java.util.ArrayList;

/**Classe qui definit une Gille de Places
 * @author Hamdad Khellaf
 * @author Braneci sofiane
 * 
 * */


public class GrillePlaces {
	/** Objet qui manipule une grille */ 
    private Grille grille;
    /**List des place*/
    private List<Emplacement> places;
    /**nombre de place horizontale*/
    private int nbHorizontal;
    
    
    /**
     * Constructeur de la classe
     * qui prend en @param une grille
     * à partire de cette grille on cherche 
     * tout les emplacement horizontaux et verticaux 
     * possible qui sont stocker dans places
     * @param grille: Gille
     * */
    
    public GrillePlaces(Grille grille) {
        this.grille = grille;
        places = new ArrayList<Emplacement>();
        for(int i=0 ; i < this.grille.nbLig() ; i++) {
        	this.chercherPlaces(this.getLig(i));
        }
        nbHorizontal =this.places.size();
        for(int j=0 ; j < this.grille.nbCol() ; j++) {
        	this.chercherPlaces(this.getCol(j));
        }
        System.out.println(places);
    }
    
	/** Getteur de l'attribut place
	 * @return places: list d'emplacements */

    public List<Emplacement> getPlaces() {
        return places;
    }
	/** Accèsseur  de l'attribut nbHorizontal 
	 * @return: nbHorizontal*/
    public int getNbHorizontal() {
        return nbHorizontal;
    }
    
	/** permet de construire une chaine de caractères à partire des emplacements
	 * @return String*/
    public String toString() {
        StringBuilder emp = new StringBuilder("");
        int i = 0;
        for (Emplacement emplacement : places) {
            int row, col, size;
            row = emplacement.getLig();
            col = emplacement.getCol();
            size = emplacement.size();
            String str = "Emplacement " + (i + 1) + " début: (" + row + "," + col + "), longeur: " + size + ")\n";

            emp.append(str);
        }

        return grille.toString()+""+emp.toString();
    }

	/** permet de retourner une list de case contenu dans une ligne
	 * @param lig: ligne designé
	 * @return: List<Case>*/
    private List<Case> getLig(int lig) {
        List<Case> temp = new ArrayList<Case>();
        for (int j=0; j < this.grille.nbCol() ; j++) {
        	temp.add(this.grille.getCase(lig,j));
        }
        return temp;
    }
	/** permet de retourner une list de case contenu dans une colonne
	 * @param col: colonne designé
	 * @return: List<Case>*/
    private List<Case> getCol(int col) {
        List<Case> temp = new ArrayList<Case>();
        for (int i=0; i < this.grille.nbLig() ; i++) {
        	temp.add(this.grille.getCase(i,col));
        }
        return temp;
    }

	/** permet d'ajouter à places des emplacement valide 
	 * à partire une liste de case
	 * @param cases: lise de case
	 * */
	public void chercherPlaces(List<Case> cases) {
    	int i=0;
    	while(i < cases.size()) {
    		Emplacement tmp =new Emplacement();
    		boolean con = true;
    		do {
				Case c = cases.get(i);
				i++;
				if (!(c.isPleine())) {
					tmp.ajouterCase(c);
				}else {
					con = false;
				}
			}while(con && i < cases.size());		
			if (tmp.size()>1) {
				this.places.add(tmp);
			}
    	}
  
	}
	
/**rend une nouvelle GrillePotentiel où les cases constituant l’emplacement
de mot d’indice m,  ont pour contenu les lettres de soluce
	@param m: index
	@param soluce: chaine de caracètres
	@return: nouvelle GrillePlaces
*/
	public GrillePlaces fixer(int m, String soluce) {
		Grille copyGrille = grille.copy();
		Emplacement emp = places.get(m);
		for(int i = 0; i < soluce.length(); i++) {
			Case e = emp.getList().get(i);
			copyGrille.getCase(e.getLig(), e.getCol()).setChar(soluce.charAt(i));
		}
		return new GrillePlaces(copyGrille);
	}
	
}