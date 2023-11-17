package bowling;

public class Lancer {
	private int nbPins;
	
	public Lancer(int nbPins){
		if(nbPins > 10 || nbPins <0){
			throw new IllegalArgumentException("Le nombre de quilles est incorecte.");
		}
		this.nbPins = nbPins;
	}
	
	public int getNbPins(){
		return this.nbPins;
	}

	public void setNbPins(int nbPins) {
		if (nbPins > 10 || nbPins < 0){
			throw new IllegalArgumentException("nb quille incorrect");
		}
		this.nbPins = nbPins;
	}
	
}
