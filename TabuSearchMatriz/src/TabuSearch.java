import java.util.ArrayList;
import java.util.List;

import ts.entity.courseunit.CourseUnit;
import ts.entity.courseunit.CourseUnitRepository;
import ts.entity.infra.DataLoader;
import ts.entity.schedule.Schedule;
import ts.entity.schedule.ScheduleIdentity;
import ts.optimizer.matrix.Value;

public class TabuSearch {

	public static int[][] getBestNeighbour(TabuList tabuList,
			TSPEnvironment tspEnviromnet, int[][] currSolution) {

		int[][] bestSol = new int[currSolution.length][currSolution[0].length]; // this
																				// is
																				// the
																				// best
																				// Solution
																				// So
																				// Far
		arraycopy(currSolution, bestSol);
		int bestCost = tspEnviromnet.getObjectiveFunctionValue(bestSol);
		int diaDaSemana = 0;
		int duracaoAula = 0;

		boolean firstNeighbor = true;

		for (int i = 0; i < bestSol.length; i++) {
			for (int j = 0; j < bestSol[0].length; j++) {
				if (i == j) {
					continue;
				}

				int[][] newBestSol = new int[bestSol.length][bestSol[0].length]; // this
																					// is
																					// the
																					// best
																					// Solution
																					// So
																					// Far
				arraycopy(bestSol, newBestSol);

				newBestSol = swapOperator(i, j, bestSol); // Try swapping
															// cities i and
															// j
				// printSolution(newBestSol);

				// , maybe we get a bettersolution
				int newBestCost = tspEnviromnet
						.getObjectiveFunctionValue(newBestSol);

				if ((newBestCost < bestCost || firstNeighbor)
						&& tabuList.tabuList[i][j] == 0) { // if better move
															// found, store it
					firstNeighbor = false;
					diaDaSemana = i;
					duracaoAula = j;
					arraycopy(newBestSol, bestSol);
					bestCost = newBestCost;
				}

			}
		}

		tabuList.decrementTabu();
		tabuList.tabuMove(diaDaSemana, duracaoAula);

		return bestSol;

	}

	// swaps two cities
	public static int[][] swapOperator(int duracaoAula, int diaDaSemana,
			int[][] currSolution) {
		// int temp = currSolution[duracaoAula][diaDaSemana];
		// currSolution[duracaoAula][diaDaSemana] =
		// currSolution[diaDaSemana][duracaoAula];
		// currSolution[diaDaSemana][duracaoAula] = temp;
		// return currSolution;
		int selectedrow = (int) (Math.random() * 14);
		int maximiumrow = (int) (Math.random() * 14);
		int selectedcol = (int) (Math.random() * 5);
		int maximiumcol = (int) (Math.random() * 5);
		//
		int[] tempcol = new int[14];
		for (int i = 0; i < 14; i++) {
			// ler as linhas da coluna selectedcol
			tempcol[i] = currSolution[i][selectedcol];
		}
		for (int i = 0; i < maximiumrow; i++) {
			// adicionar o valor da coluna diadasemana
			currSolution[i][selectedcol] = currSolution[i][diaDaSemana];
			currSolution[i][diaDaSemana] = tempcol[i];
		}
		//
		int[] temprow = new int[5];
		for (int i = 0; i < 5; i++) {
			// ler as colunas da linha selectedrow
			temprow[i] = currSolution[selectedrow][i];
		}
		for (int i = 0; i < maximiumcol; i++) {
			// adicionar o valor da coluna diadasemana
			currSolution[selectedrow][i] = currSolution[duracaoAula][i];
			currSolution[duracaoAula][i] = temprow[i];
		}
		//
		return currSolution;
	}

	public static void main(String[] args) {

		TSPEnvironment tspEnvironment = new TSPEnvironment();

		// tspEnvironment.distances = // Distance matrix, 5x5, used to represent
		// distances
		// new int[][] { { 0, 1, 3, 4, 5 }, { 1, 0, 1, 4, 8 }, { 3, 1, 0, 5, 1
		// },
		// { 4, 4, 5, 0, 2 }, { 5, 8, 1, 2, 0 } };
		// Between cities. 0,1 represents distance between cities 0 and 1, and
		// so on.
		String filename = "csv/data-test.csv";

		DataLoader.load(filename);

		CourseUnitRepository courseUnitRepository = DataLoader
				.getCourseUnitRepository();
		List<CourseUnit> units = courseUnitRepository.listAll();
		//
		List<Schedule> schedules = new ArrayList<Schedule>();
		for (CourseUnit unit : units) {
			ScheduleIdentity identity = new ScheduleIdentity(unit, 2014, 2, 1);
			schedules.add(new Schedule(identity));
		}
		//
		Schedule[] sas = new Schedule[schedules.size()];
		schedules.toArray(sas);
		//
		Schedule sa = sas[0];
		//
		int[][] currSolution = new int[sa.getMatrix().getRowMax()][sa
				.getMatrix().getColMax()];
		for (int i = 0; i < sa.getMatrix().getRowMax(); i++) {
			for (int j = 0; j < sa.getMatrix().getColMax(); j++) {
				if (sa.getMatrix().getMatrixValue(i, j) == Value._0) {
					currSolution[i][j] = 0;
				} else {
					currSolution[i][j] = 1;
				}
			}
		}

		// int[][] currSolution = new int[][] { { 1, 0, 1, 0, 0 },
		// { 1, 0, 1, 0, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0 } }; // initial solution
		// city numbers start from 0
		// the first and last cities' positions do not change

		int numberOfIterations = 10000;
		//int tabuLength = 10;
		TabuList tabuList = new TabuList(14, 5);

		int[][] bestSol = new int[currSolution.length][currSolution[0].length]; // this
																				// is
																				// the
																				// best
																				// Solution
																				// So
																				// Far
		arraycopy(currSolution, bestSol);
		int bestCost = tspEnvironment.getObjectiveFunctionValue(bestSol);

		for (int i = 0; i < numberOfIterations; i++) { // perform iterations
														// here

			currSolution = TabuSearch.getBestNeighbour(tabuList,
					tspEnvironment, currSolution);
			printSolution(currSolution);
			//
			int currCost = tspEnvironment
					.getObjectiveFunctionValue(currSolution);
			//
			System.out.println("Current best cost = " + currCost);
			//
			if (currCost < bestCost) {
				arraycopy(currSolution, bestSol);
				bestCost = currCost;
			}
		}

		System.out.println("Search done! \nBest Solution cost found = "
				+ bestCost + "\nBest Solution :");

		printSolution(bestSol);

	}

	public static void printSolution(int[][] currSolution) {
		for (int i = 0; i < currSolution.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < currSolution[0].length; j++) {
				System.out.print(currSolution[i][j] + "     ");
			}
		}
		System.out.println();
	}

	public static void arraycopy(int[][] src, int[][] dest) {
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[0].length; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
}
