package pobj.motx.tme2;

import java.util.ArrayList;

import java.util.List;

/**
 * Permet de representer un ensemble de lettre
 * @author Hamdad Khellaf
 * @author Braneci sofiane
 * */
public class EnsembleLettre {
	private List<Character> list;

	public EnsembleLettre() {
		list = new ArrayList<Character>();
	}
	
	/**permet d'ajouter une lettre à l'ensemble*/

	public void add(char c) {
		if (!list.contains(c)) {
			list.add(c);
		}
	}
	/**@return rend la taille de l'ensemble
	 * */
	public int size() {
		return list.size();
	}
	/**
	 * Accesseur de l'ensemble des lettres
	 * @return: copie de l'ensemble
	 * */
	public List<Character> getLetters(){
		return getCopy(list);
	}
	
	/***
	 * @param c: caractère
	 * @return: true si c est dans l'ensemble
	 **/
	public boolean contains(char c) {
		return list.contains(c);
	}
	
	/**
	 *@param l: list de caractère
	 *@return: une copie de l
	 **/
	private List<Character> getCopy(List<Character> l) {
		List<Character> copy = new ArrayList<Character>(l);
		return copy;
	}
	
	/**pour manipuler que des ensmeble de lettres
	 * @param l: list de caractère*/
	private EnsembleLettre(List<Character> l) {
		list = l;
	}
	/**permet de calculer l'intersection entre deux ensemble de lettre
	 * @param set: ensemble de lettre
	 * @return: l'intersection des deux ensembles*/
	public EnsembleLettre intersection(EnsembleLettre set) {
		List<Character> copy = getCopy(list);
		copy.retainAll(set.list);
		return new EnsembleLettre(copy);

	}
}