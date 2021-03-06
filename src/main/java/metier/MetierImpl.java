package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
	// Couplage Faible
	//@Autowired => c'est d'utiliser l'injection via le constructeur avec parameter
	private IDao dao;

	/*
	public MetierImpl() {
	}
	*/
	
	public MetierImpl(IDao dao3) {
		this.dao = dao3;
	}

	@Override
	public double calcul() {
		double data=dao.getData();
		double res=data*223*Math.cos(data);
		return res;
	}
	/*
	 * Pour Injecter dans la variable dao un objet
	 * d'une classe qui implémente l'interface IDao
	 */
	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
