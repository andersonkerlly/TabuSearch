/**
 *
 * @author http://voidException.weebly.com Use this code at your own risk ;)
 */
public class TabuList {

	int[][] tabuList;

	public TabuList(int numHoras, int numDias) {
		tabuList = new int[numHoras][numDias]; // city 0 is not used here, but
												// left for simplicity
	}

	public void tabuMove(int diaDaSemana, int duracaoAula) { // tabus the swap operation
		 //tabuList[diaDaSemana][duracaoAula]+= 5;
		 //tabuList[duracaoAula][diaDaSemana]+= 5;
	}

	public void decrementTabu() {
		for (int i = 0; i < tabuList.length; i++) {
			for (int j = 0; j < tabuList[0].length; j++) {
				tabuList[i][j] -= tabuList[i][j] <= 0 ? 0 : 1;
			}
		}
	}

}
