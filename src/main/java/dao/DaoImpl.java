package dao;

public class DaoImpl implements IDao {

	@Override
	public double getData() {
		/*
		 * Se connecter � la BD pour r�cup�rer la donn�e
		 */
		System.out.println("Version base de donn�es ...");
		double temp=Math.random()*40;
		return temp;
	}

}
