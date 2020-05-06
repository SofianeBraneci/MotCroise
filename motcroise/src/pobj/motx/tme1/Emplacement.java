package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**Classe qui définit un emplacement
 * @author Hamdad Khellaf
 * @author Braneci sofiane*/

public class Emplacement {
	/** Liste qui contient l'ensemble des case dans l'emplacement*/
    private List<Case> lettres = new ArrayList<Case>();
    
    /** 
     * index du début de l'emplacement
     * row : la ligne
     * col : colonne 
     * */
    private int row, col;

    /**
     * Création du mot contenue dans l'emplacement
     * 
     *@return String
     * */
    @Override
    public String toString() {
        String mot = "";
        for (Case temp : lettres) {
            mot += temp.getChar();
        }
        return mot;
    }
    
	/** Accèsseur de la taille de l'emplacement 
	 * @return int*/
    public int size() {
        return lettres.size();
    }

	/** Permet l'ajout d'une case à un emplacement
	 * @param e: une case
	 */
    public void ajouterCase(Case e) {
    	if (lettres.size() == 0) {
    		this.col= e.getCol();
    		this.row = e.getLig();
    	}
        lettres.add(e);
    }

	/** Accèsseur qui retourn la list des case de l'emplacement 
	 * @return List<Case>*/
    public List<Case> getList() {
        return lettres;
    }

    
	/** Accèsseur de l'attribut row
	 * @return int*/
    public int getLig() {
        return this.row;
    }
	/** Accèsseur de l'attribut col 
	 * @return int*/
    public int getCol() {
        return this.col;
    }
    
    public boolean hasCaseVide() {
    	for (Case i : this.lettres) {
    		if(i.isVide()) return  true;
    	}
    	return false;
    }

}