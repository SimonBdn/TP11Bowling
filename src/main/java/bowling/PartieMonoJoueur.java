package bowling;

import java.util.Arrays;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {

	Tour[] tours = new Tour[10];

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		for (int i = 0; i < 9; i++) {
			tours[i] = new Tour();
		}
		tours[tours.length - 1] = new DernierTour();
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDePinsAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDePinsAbattues) {
		int currentTour = this.numeroTourCourant() - 1;
		if (this.numeroTourCourant() <= 0) {
			throw new IllegalStateException("On ne peut pas enregistrer un lancer quand la partie est finie.");
		}
		tours[this.numeroTourCourant() - 1].addScoreLancer(nombreDePinsAbattues);
		if (tours[currentTour].getNumLancer() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		Integer[] score = new Integer[10];
		Arrays.fill(score, 0);
		for (int i = 0; i <= tours.length - 2; i++) {
			if (i < 8 && tours[i + 1].getScorePinsLancer2() == -1) {
				score[i] = tours[i].getScoreTour(tours[i + 1].getLancer1(), tours[i + 2].getLancer1());
			} else {
				score[i] = tours[i].getScoreTour(tours[i + 1].getLancer1(), tours[i + 1].getLancer2());
			}
			score[tours.length - 1] = tours[tours.length - 1].getScoreTour(null, null);
		}
		int scoreTot = 0;
		for (int s : score) {
			scoreTot += s;
		}
		return scoreTot;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		boolean a = false;
		if(this.numeroTourCourant() == 0) {
			a= true;
		}
		return a;	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		for (int i = 0; i < tours.length; i++) {
			if (tours[i].getNumLancer() != 0) {
				return i + 1;
			}
		}
		return 0;	
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		return tours[numeroTourCourant() - 1].getNumLancer();	
	}

}
