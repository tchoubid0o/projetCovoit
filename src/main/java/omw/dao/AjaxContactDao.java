package omw.dao;

import java.net.UnknownHostException;

public interface AjaxContactDao {
	public String addContactMessage(String email,String nom,String message) throws UnknownHostException;
}
