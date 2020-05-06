package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * 
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * 
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}

	/**
	 * Accès au i-eme mot du dictionnaire.
	 * 
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * 
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy() {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de
	 * filtrer pour ne pas perdre d'information.
	 * 
	 * @param len la longueur voulue
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	/**
	 * Permet de charger un dictionnaire à partir du chemin passé
	 */

	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dict = new Dictionnaire();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/frgut.txt"))) {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				dict.add(line.replace("\n", ""));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dict;

	}
	/**
	 * Rend la liste des mot du dictionniare
	 * */
	public List<String> getElements() {
		return mots;

	}
	
	/**
	 * Permet de filtrer l'ensemble des mots
	 * en gardant uniquement ceux qui contiennent le caractère à la position i
	 * @param c: caractère
	 * @param i: index
	 * @return: nombre de mot filtré
	 * */
	public int filtreParLettre(char c, int i) {
		List<String> cible = new ArrayList<String>();
		int cpt = 0;

		for (String mot : mots) {
			if (mot.charAt(i) == c) {
				cible.add(mot);

			} else {
				cpt++;
			}
		}
		
		mots = cible;
		return cpt;
	}
	/**
	 * Permet de filtrer l'ensemble des mots
	 * en gardant uniquement ceux qui contiennent le caractère à la position i tel que 
	 * le caractère est dans l'ensemble des lettres 
	 * @param set: ensemble de lettre potentielles
	 * @param i: index
	 * @return: nombre de mot filtré
	 * */
	public int filtreParLettre(EnsembleLettre set, int i) {
		List<String> cible = new ArrayList<String>();
		int cpt = 0;

		for (String mot : mots) {
			if (set.getLetters().contains(mot.charAt(i))) {
				cible.add(mot);
				
			}
			else {
				cpt++;
			}
		}

		mots = cible;
		return cpt;
	}
	
	/**
	 * Permet de calculé toute les lettres potientielles dans à position i
	 *@param index: index dans la chaine de caractère
	 *@return: nombre de mot filtré
	 * */
	public EnsembleLettre calcuEnsembleLettre(int index) {
		EnsembleLettre set = new EnsembleLettre();
		
		for (String mot: mots) {
			set.add(mot.charAt(index));
		}
		
		return set;
		
		
		
		
		
	}

}
