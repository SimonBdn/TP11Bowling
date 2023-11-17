package bowling;

public class DernierTour extends Tour {
	Lancer lancer3;

	public DernierTour() {
		lancer3 = new Lancer();
	}

	@Override
	public int getScoreTour(Lancer l1, Lancer l2) {

		return Math.max(0, getLancer1().getNbPins()) + Math.max(0, getLancer2().getNbPins()) + Math.max(0, lancer3.getNbPins());
	}

	public void addScoreLancer(int nbPins) {
		if (this.getNumLancer() == 3) {
			super.addScoreLancer(nbPins, lancer3);
		} else {
			super.addScoreLancer(nbPins);
		}
	}

	public int getNbPinsTour() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}

	@Override
	public int getNumLancer() {
		if (this.getLancer1().getNbPins() == -1) {
			return 1;
		} else if (this.getLancer2().getNbPins() == -1 ) {
			return 2;
		} else if (this.lancer3.getNbPins() == -1 && (this.getLancer1().getNbPins() + this.getLancer2().getNbPins()) >=10 ) {
			return 3;
		} else {
			return 0;
		}
	}

	public int getScorePinsLancer3(){
		return super.getScorePinsLancer(lancer3);
	}
}