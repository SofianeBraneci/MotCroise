package pobj.motx.tme3.test;

import static org.junit.Assert.*;
import org.junit.*;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;

public class MotXTest {
	@Test
	public void testSplit() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille("data/split.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(6, gr.nbLig());
		System.out.println("testSplit: ");
		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);


		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testEasy2() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille("data/easy2.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());
		System.out.println("testEasy2: ");
		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());
		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testEasy() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille("data/easy.grl");
		System.out.println("testEasy: ");
		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());
		
		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());
		
		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}	
	
	@Test
	public void testMedium() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/medium.grl");
		System.out.println("testMedium: ");
		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());
		
		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testLarge2() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large2.grl");
		System.out.println("testLarge2: ");
		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testLarge3() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large3.grl");
		System.out.println("testLarge3: ");
		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testLarge4() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large4.grl");
		System.out.println("testLarge4: ");
		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
		
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testHard() {
		Long timestamp = System.currentTimeMillis();
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");
		System.out.println("testHard: ");
		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println("Avant résolution de la grille: ");
		System.out.println(gr.toString());
		
		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		MotX varsx = new MotX(gp);

		CSPSolver csp = new CSPSolver();
		MotX v = (MotX) csp.solve(varsx);
			
		System.out.println("Après résolution de la grille: ");
		System.out.println(v.getGrille().getGrille().toString());
		System.out.println("Calculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
