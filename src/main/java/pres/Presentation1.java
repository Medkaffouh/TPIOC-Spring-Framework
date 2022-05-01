package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation1 {

	public static void main(String[] args) {
		/*
		 * Injection des dépendances par
		 * instanciation statique => new
		 * en utilisant un setter ou via le constructeur
		 */
		DaoImpl dao=new DaoImpl();
		MetierImpl metier=new MetierImpl(dao);
		//metier.setDao(dao);
		System.out.println("résultat = "+metier.calcul());

	}

}
