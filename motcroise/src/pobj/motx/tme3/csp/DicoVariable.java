package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable {

	private int index;
	private GrillePotentiel gp;
	private List<String> domain;
	
	public DicoVariable(int index, GrillePotentiel gp) {
		this.index = index;
		this.gp = gp;
		this.domain = new ArrayList<String>();
		this.domain = gp.getMotsPot().get(index).getElements();
	}
	
	
	
	@Override
	public List<String> getDomain() {
		// TODO Auto-generated method stub
		return this.domain;
	}

	public int getIndex() {
		return this.index;
	}
	
	public String toString() {
		return "\n Grille PLACES : \n" + this.gp.getGrillePlaces().toString() +
				"\n on cherche l'index : " + this.index + "\n" + this.domain.toString();
	}
}
