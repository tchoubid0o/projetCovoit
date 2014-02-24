package omw.metier;

public class CoVoiturageManager {
	
	private static CoVoiturageManager instance;
	
	private CoVoiturageManager(){
		
	}
	
	public static CoVoiturageManager getInstance() {
		if (instance == null) {
			instance = new CoVoiturageManager();
		}
		return instance;
	}

}
