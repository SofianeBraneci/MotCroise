package pobj.motx.tme2;

/**
 * Interface qui modifie la gille potentiel 
 * passé en argument en definissant la méthode reduce
 * @author Hamdad Khellaf
 * @author Braneci sofiane
 * */
public interface IContrainte {
	/**permetera de modifier la gille 
	 * @param grille: GrillePotentiel */
	public int reduce(GrillePotentiel grille);

}
