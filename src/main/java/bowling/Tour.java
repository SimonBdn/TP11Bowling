package bowling;

public class Tour {
	private Lancer lancer1;
	private Lancer lancer2;
	private TypeLancer typelanccer;
	private int scoreTour = 0;

	public Tour() {
		lancer1 = new Lancer();
		lancer2 = new Lancer();
		typelanccer = TypeLancer.NORMAL;
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

	public void addScoreLancer(int nbQuille) {
		if (nbQuille < 0 || nbQuille > 10){
			throw new IllegalArgumentException("nbQuille must be between 0 and 10");
		}
		if (this.getNumLancer() == 1) {
			addScoreLancer(nbQuille, lancer1);
			if (nbQuille == 10) {
				typelanccer = TypeLancer.STRIKE;
			}
		} else if (this.getNumLancer() == 2) {
			//TODO : implement throw declaration with working 10th lancer
			/*
			if (lancer1.getNbQuille() + nbQuille >10){
				throw new IllegalArgumentException("Lancers make more than 10 quilles");
			}
			 */
			addScoreLancer(nbQuille, lancer2);
			if (lancer1.getNbPins() + lancer2.getNbPins() == 10){
				typelanccer = TypeLancer.SPARE;
			}
		}
	}

	public void addScoreLancer(int nbQuille, Lancer lancer) {
		lancer.setNbPins(nbQuille);
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