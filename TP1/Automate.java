import java.util.ArrayList;

public class Automate {

	static final int NB_TRANSITIONS = 256;

	private int start = -1;
	private int end = -1;
	private int nbStates = 0;
	private int nbTransitions = 0;

	private int[][] autom;
	private int[][] epsilon;

	private ArrayList<Tuple> etoile = new ArrayList<>();

	public Automate(int s, int e, int nbS, int nbT) {
		start = s;
		end = e;
		nbStates = nbS;
		nbTransitions = nbT;

		autom = new int[nbStates][NB_TRANSITIONS];

		for (int i = 0; i < nbStates; i++) {
			for (int j = 0; j < NB_TRANSITIONS; j++) {
				autom[i][j] = -1;
			}
		}

		epsilon = new int[nbStates][nbStates];

		for (int i = 0; i < nbStates; i++) {
			for (int j = 0; j < nbStates; j++) {
				epsilon[i][j] = 0;
			}
		}

	}

	public void modifEps(int i, int j) {
		epsilon[i][j] = 0;
	}

	public void addTransition(int a, int b, int t) {
		autom[a][t] = b;
	}

	public void addEpsilon(int a, int b) {
		epsilon[a][b] = 1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getNbStates() {
		return nbStates;
	}

	public void setNbStates(int nbStates) {
		this.nbStates = nbStates;
	}

	public int getNbTransitions() {
		return nbTransitions;
	}

	public void setNbTransitions(int nbTransitions) {
		this.nbTransitions = nbTransitions;
	}

	public int[][] getAutom() {
		return autom;
	}

	public void setAutom(int[][] autom) {
		this.autom = autom;
	}

	public int[][] getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(int[][] epsilon) {
		this.epsilon = epsilon;
	}
	
	public ArrayList<Tuple> getEtoile() {
		return etoile;
	}

	public void setEtoile(ArrayList<Tuple> etoile) {
		this.etoile = etoile;
	}

	public void affiche() {
		System.out.println("transitions :");
		for (int i = 0; i < nbStates; i++) {
			for (int j = 0; j < NB_TRANSITIONS; j++) {
				if (autom[i][j] != -1) {
					System.out.print(i + " ");
					System.out.print(j + " ");
					System.out.println(autom[i][j]);
				}
			}
		}
	}

	public void afficheEpsilon() {
		System.out.println("transitions epislon :");
		for (int i = 0; i < nbStates; i++) {
			for (int j = 0; j < nbStates; j++) {
				if (epsilon[i][j] != 0) {
					System.out.print(i + " ");
					System.out.print(j + " ");
					System.out.println(epsilon[i][j]);
				}
			}
		}
	}
}
