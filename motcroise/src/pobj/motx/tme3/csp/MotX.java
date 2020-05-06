package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme2.GrillePotentiel;

public class MotX implements ICSP {
	
	
	List<IVariable> dv;
	GrillePotentiel gp;
	
	public MotX(GrillePotentiel gp) {
		this.dv = new ArrayList<IVariable>();
		for(int i=0;i < gp.getGrillePlaces().getPlaces().size() ; i++) {
			if (gp.getGrillePlaces().getPlaces().get(i).hasCaseVide()) {
				DicoVariable dicoVariable = new DicoVariable(i, gp);
				if(! dv.contains(dicoVariable)) dv.add(new DicoVariable(i,gp));
				
				//System.out.println("i3edada da");
			}
		}
		this.gp = gp;
	}
	
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return  dv;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub

		return !gp.isDead();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		
		if (vi instanceof DicoVariable) {
			return new MotX(gp.fixer(((DicoVariable) vi).getIndex(), val));
		}
		//System.out.println("\t c sa le null ");
		return null;
	}
	
	
}
