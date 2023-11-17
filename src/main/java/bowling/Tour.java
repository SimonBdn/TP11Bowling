package bowling;

public class Tour {
	private Lancer lancer1;
	private Lancer lancer2;
	private TypeLancer typelancer;
	private int scoreTour = 0;

	public Tour() {
		lancer1 = new Lancer();
		lancer2 = new Lancer();
		typelancer = TypeLancer.NORMAL;
	}

	public int getScoreTour(Lancer l1, Lancer l2) {
		int l1Val =  Math.max(0, l1.getNbPins());
		int l2Val =  Math.max(0, l2.getNbPins());

		if (lancer1.getNbPins() == 10 ){
			this.scoreTour = lancer1.getNbPins() + l1Val + l2Val;
		}else if (lancer1.getNbPins() + lancer2.getNbPins() == 10) {
			this.scoreTour = lancer1.getNbPins() + lancer2.getNbPins() + l1Val;
		} else {
			this.scoreTour = Math.max(0, lancer1.getNbPins()) +  Math.max(0, lancer2.getNbPins());
		}
		return (this.scoreTour);
	}

	public void addScoreLancer(int nbPins) {
		if (nbPins < 0 || nbPins > 10){
			throw new IllegalArgumentException("nLe nombre de quilles doit être compris entre 0 et 10.");
		}
		if (this.getNumLancer() == 1) {
			addScoreLancer(nbPins, lancer1);
			if (nbPins == 10) {
				typelancer = TypeLancer.STRIKE;
			}
		} else if (this.getNumLancer() == 2) {
			
			/*
			if (lancer1.getNbQuille() + nbQuille >10){
				throw new IllegalArgumentException("Lancers make more than 10 quilles");
			}
			 */
			addScoreLancer(nbPins, lancer2);
			if (lancer1.getNbPins() + lancer2.getNbPins() == 10){
				typelancer = TypeLancer.SPARE;
			}
		}
	}

	public void addScoreLancer(int nbPins, Lancer lancer) {
		lancer.setNbPins(nbPins);
	}

	public int getNbQuilleTour() {
		int score = 0;
		if (lancer1.getNbPins() != -1) {
			score += lancer1.getNbPins();
		}
		if (lancer2.getNbPins() != -1) {
			score += lancer2.getNbPins();
		}
		return score;
	}

	public int getScorePinsLancer(Lancer l) {
		/*
		if (l.getNbPins() < 0) {
			return 0;
		}
		
		 */
		return l.getNbPins();
	}
	public int getScorePinsLancer1(){
		return getScorePinsLancer(lancer1);
	}

	public int getScorePinsLancer2(){
		return getScorePinsLancer(lancer2);
	}

	public int getNumLancer() {
		if (lancer1.getNbPins() == -1) {
			return 1;
		} else if (lancer2.getNbPins() == -1 && lancer1.getNbPins() != 10) {
			return 2;
		} else {
			return 0;
		}
	}

	public Lancer getLancer1() {
		return lancer1;
	}

	public Lancer getLancer2() {
		return lancer2;
	}
}