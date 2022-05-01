package pres;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

public class Presentation2 {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(new File("config.txt"));
		String daoClassName=scanner.nextLine();
		Class cDao=Class.forName(daoClassName);
		IDao dao=(IDao) cDao.getDeclaredConstructor().newInstance();

		String metierClassName=scanner.nextLine();
		Class cMetier=Class.forName(metierClassName);
		IMetier metier=(IMetier) cMetier.getDeclaredConstructor().newInstance();
		
		Method method=cMetier.getMethod("setDao", IDao.class);
		// metier.setDao(dao); => statique
		method.invoke(metier, dao); // => instanciation dynamique
		
		System.out.println("Résultats = "+metier.calcul());
		
	}// les framework qui fait ça pas vous, ce code just pour comprendre comment ça marche

}


/*
 * Si vous voulez crée une application fermée à la modification et ouvert à l'extension
 * 1 => il faut utiliser le couplage faible (les interfaces).
 * 2 => il faut faire l'injection de dependance en utilisant l'instanciation dynamique.
 */
