package bowling;

public class Lancer {
	private int nbPins;
	
	public Lancer(int nbPins){
		if(nbPins > 10 || nbPins <0){
			throw new IllegalArgumentException("Le nombre de quilles est incorecte.");
		}
		else {this.nbPins = nbPins;}
	}
	
	public int getNbPins(){
		return this.nbPins;
	}

	
}
