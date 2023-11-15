package bowling;

import java.util.ArrayList;

public class Tour {
	
	private ArrayList<Lancer> lancer;
	
	private TypeLancer typeLancer;
	
	
	public Tour(ArrayList<Lancer> lancer, TypeLancer typeLancer){
		this.lancer = new ArrayList<>();
		this.typeLancer = typeLancer;
	}
	public Tour(ArrayList<Lancer> lancer){
		this.lancer = new ArrayList<>();
		this.typeLancer = TypeLancer.NORMAL;
	}
	
}
