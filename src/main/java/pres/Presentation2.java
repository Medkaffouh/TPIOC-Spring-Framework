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
		
		System.out.println("R�sultats = "+metier.calcul());
		
	}// les framework qui fait �a pas vous, ce code just pour comprendre comment �a marche

}


/*
 * Si vous voulez cr�e une application ferm�e � la modification et ouvert � l'extension
 * 1 => il faut utiliser le couplage faible (les interfaces).
 * 2 => il faut faire l'injection de dependance en utilisant l'instanciation dynamique.
 */
