package omw.model;

import java.util.ArrayList;

public class DatChampion {
	
	private Champion champion;
	
	private ArrayList<Ability> listAbilities = new ArrayList<Ability>();
	
	private ArrayList<Skin> listSkins = new ArrayList<Skin>();
	
	public DatChampion(Champion champion){
		
		this.champion=champion;		
	}
	
	public void addAbility(Ability ability){
		if(ability != null){
			listAbilities.add(ability);			
		}
		else{
			System.out.println("Ability null");
		}
	}
	
	public void addSkin(Skin skin){
		if(skin != null){
			listSkins.add(skin);
		}
		else{
			System.out.println("Skin null");
		}
	}

	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
	}

	public ArrayList<Ability> getListAbilities() {
		return listAbilities;
	}

	public void setListAbilities(ArrayList<Ability> listAbilities) {
		this.listAbilities = listAbilities;
	}

	public ArrayList<Skin> getListSkins() {
		return listSkins;
	}

	public void setListSkins(ArrayList<Skin> listSkins) {
		this.listSkins = listSkins;
	}
	
	

}
