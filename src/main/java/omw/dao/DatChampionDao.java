package omw.dao;

import java.util.ArrayList;

import omw.model.DatChampion;

public interface DatChampionDao {
	
	public ArrayList<DatChampion> listerDatChampion();
	
	public void removeDatchampion(String libelle);
	
	public void addDatChampion(DatChampion datChampion);

}
