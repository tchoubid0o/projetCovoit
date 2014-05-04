package omw.metier;

import java.net.UnknownHostException;

import omw.dao.AjaxContactDao;
import omw.dao.impl.AjaxContactDaoImpl;

public class AjaxContactManager {

	private static AjaxContactManager instance;

	private AjaxContactDao ajaxContactDao = new AjaxContactDaoImpl();

	private AjaxContactManager() {
	}

	public static AjaxContactManager getInstance() {
		if (instance == null) {
			instance = new AjaxContactManager();
		}
		return instance;
	}
	
	public String addContactMessage(String email,String nom,String message) throws UnknownHostException{
		return ajaxContactDao.addContactMessage(email,nom,message);
	}
}
