package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lists.HashMap;

public class League {

	final static int WINNER_GOALS = 3;
	final static int DRAW_POINTS = 1;
	Random random = new Random();

	public Match[][] calcularLiga(HashMap teamsMap) {
		List<Team> teams = generateTeams(teamsMap);
		int numEquipos = teams.size();
		if (numEquipos % 2 == 0)
			return calcularLigaNumEquiposPar(teams);
//		else
//			return calcularLigaNumEquiposImpar(numEquipos);
		return null;
	}

	/**
	 * 
	 * @param teams
	 * @return
	 */
	private Match[][] calcularLigaNumEquiposPar(List<Team> teams) {
		int numEquipos = teams.size();
		int numRondas = numEquipos - 1;
		int numPartidosPorRonda = numEquipos / 2;

		Match[][] rounds = new Match[numRondas][numPartidosPorRonda];

		for (int i = 0, k = 0; i < numRondas; i++) {
			for (int j = 0; j < numPartidosPorRonda; j++) {
				rounds[i][j] = new Match();

				// generate random and set the home team
				int randomGoals = random.nextInt(8);
				rounds[i][j].setHomeGoals(randomGoals);
				rounds[i][j].setHomeTeam(teams.get(k));
				teams.get(k).addGoalsScoredToTeam(randomGoals);

				k++;

				if (k == numRondas)
					k = 0;
			}
		}

		for (int i = 0; i < numRondas; i++) {
			if (i % 2 == 0) {
				rounds[i][0].setAwayTeam(teams.get(numEquipos - 1));
			} else {
				rounds[i][0].setAwayTeam(rounds[i][0].getHomeTeam());
				rounds[i][0].setHomeTeam(teams.get(numEquipos - 1));
			}
		}

		int equipoMasAlto = numEquipos - 1;
		int equipoImparMasAlto = equipoMasAlto - 1;

		for (int i = 0, k = equipoImparMasAlto; i < numRondas; i++) {
			for (int j = 1; j < numPartidosPorRonda; j++) {
				// generate random and set the home team
				int randomGoals = random.nextInt(8);
				rounds[i][j].setAwayGoals(randomGoals);
				rounds[i][j].setAwayTeam(teams.get(k));
				teams.get(k).addGoalsScoredToTeam(randomGoals);

				k--;

				if (k == -1)
					k = equipoImparMasAlto;
			}
		}

		return rounds;
	}

//	private static Partido[][] calcularLigaNumEquiposImpar(int numEquipos) {
//		int numRondas = numEquipos;
//		int numPartidosPorRonda = numEquipos / 2;
//
//		Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];
//
//		for (int i = 0, k = 0; i < numRondas; i++) {
//			for (int j = -1; j < numPartidosPorRonda; j++) {
//				if (j >= 0) {
//					rondas[i][j] = new Partido();
//
//					rondas[i][j].local = k;
//				}
//
//				k++;
//
//				if (k == numRondas)
//					k = 0;
//			}
//		}
//
//		int equipoMasAlto = numEquipos - 1;
//
//		for (int i = 0, k = equipoMasAlto; i < numRondas; i++) {
//			for (int j = 0; j < numPartidosPorRonda; j++) {
//				rondas[i][j].visitante = k;
//
//				k--;
//
//				if (k == -1)
//					k = equipoMasAlto;
//			}
//		}
//
//		return rondas;
//	}

	/**
	 * Generates a List of teams based on the teams present in the given HashMap.
	 * 
	 * @param teamsMap The HashMap containing teams to be added to the List.
	 * @return A List of teams.
	 */
	public List<Team> generateTeams(HashMap teamsMap) {
		List<Team> teamsArray = new ArrayList<Team>();
		for (int i = 0; i < HashMap.TAMTABLA; i++) {
			// get team at the current position
			Team team = teamsMap.getTeamByPosition(i);
			if (team == null)
				continue;
			teamsArray.add(team);
		}
		return teamsArray;
	}

	public void mostrarPartidos(Match[][] rounds) {
		System.out.println("IDA");

		for (int i = 0; i < rounds.length; i++) {
			System.out.println("Ronda " + (i + 1) + ":\t");

			for (int j = 0; j < rounds[i].length; j++) {
				System.out.println((rounds[i][j].getHomeTeam().getName()) + " " + rounds[i][j].getHomeGoals() + " - "
						+ rounds[i][j].getAwayGoals() + " " + (rounds[i][j].getAwayTeam().getName()) + "\t");

				if (rounds[i][j].getHomeGoals() > rounds[i][j].getAwayGoals())
					rounds[i][j].getHomeTeam().addPoints(WINNER_GOALS);
				if (rounds[i][j].getAwayGoals() > rounds[i][j].getHomeGoals())
					rounds[i][j].getAwayTeam().addPoints(WINNER_GOALS);
				if (rounds[i][j].getHomeGoals() == rounds[i][j].getAwayGoals()) {
					rounds[i][j].getHomeTeam().addPoints(DRAW_POINTS);
					rounds[i][j].getAwayTeam().addPoints(DRAW_POINTS);
				}
			}

			System.out.println();
		}

//		System.out.println("VUELTA");
//
//		for (int i = 0; i < rondas.length; i++) {
//			System.out.print("Ronda " + (i + 1) + ": ");
//
//			for (int j = 0; j < rondas[i].length; j++) {
//
//				System.out.print("   " + (rondas[i][j].getAwayTeam().getName()) + " " + rondas[i][j].getAwayGoals()
//						+ " - " + rondas[i][j].getHomeGoals() + " " + (rondas[i][j].getHomeTeam().getName()));
//			}
//
//			System.out.println();
//		}
	}

	public void displayPoints(List<Team> list) {
		System.out.println(" ");
		System.out.println("PUNTOS POR EQUIPOS:");
		for (int i = 0; i < list.size(); i++) {
			Team team = list.get(i);
			System.out.println(team.getName() + ": " + team.getPoints() + " puntos.");
		}

	}
}
