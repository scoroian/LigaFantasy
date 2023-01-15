package bean;

import java.util.List;
import java.util.Random;

public class League {

	final static int WINNER_GOALS = 3;
	final static int DRAW_POINTS = 1;
	Random random = new Random();

	List<Team> teams = null;

	/**
	 * @return the teams
	 */
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @param teams
	 */
	public League(List<Team> teams) {
		this.teams = teams;
	}

	/**
	 * Simulates the league matches.
	 * 
	 * @return A 2D array of matches containing the results of the simulated league.
	 */
	public Match[][] simulate() {
		int numEquipos = teams.size();
		if (numEquipos % 2 == 0) {
			return calculateLeagueOddTeams();
		} else {
			return simulateEvenTeams();
		}
	}

	/**
	 * The method is used to simulate a league with an even number of teams.
	 * 
	 * The method takes in a list of teams and returns a 2D array of matches.
	 * 
	 * @param teams A list of teams participating in the league.
	 * @return A 2D array of matches, representing the rounds of the league.
	 */
	private Match[][] simulateEvenTeams() {
		int numEquipos = teams.size();
		int numRondas = numEquipos - 1;
		int numPartidosPorRonda = numEquipos / 2;

		Match[][] rounds = new Match[numRondas][numPartidosPorRonda];

		for (int i = 0, k = 0; i < numRondas; i++) {
			for (int j = 0; j < numPartidosPorRonda; j++) {
				rounds[i][j] = new Match();

				// generate random goals and set the home team
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

				// generate random goals and set the Away team
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

	/**
	 * The method is used to simulate a league with an odd number of teams.
	 * 
	 * The method takes in a list of teams and returns a 2D array of matches.
	 * 
	 * @param teams A list of teams participating in the league.
	 * @return A 2D array of matches, representing the rounds of the league.
	 */
	private Match[][] calculateLeagueOddTeams() {
		int numTeams = teams.size();
		int numRounds = numTeams;
		int numMatchByRound = numTeams / 2;

		Match[][] rounds = new Match[numRounds][numMatchByRound];

		for (int i = 0, k = 0; i < numRounds; i++) {
			for (int j = -1; j < numMatchByRound; j++) {
				if (j >= 0) {
					rounds[i][j] = new Match();

					// generate random goals and set the home team
					int randomGoals = random.nextInt(8);
					rounds[i][j].setHomeGoals(randomGoals);
					rounds[i][j].setHomeTeam(teams.get(k));
					teams.get(k).addGoalsScoredToTeam(randomGoals);
				}

				k++;

				if (k == numRounds)
					k = 0;
			}
		}

		int lastTeam = numTeams - 1;

		for (int i = 0, k = lastTeam; i < numRounds; i++) {
			for (int j = 0; j < numMatchByRound; j++) {

				// generate random goals and set the Away team
				int randomGoals = random.nextInt(8);
				rounds[i][j].setAwayGoals(randomGoals);
				rounds[i][j].setAwayTeam(teams.get(k));
				teams.get(k).addGoalsScoredToTeam(randomGoals);

				k--;

				if (k == -1)
					k = lastTeam;
			}
		}

		return rounds;
	}

	/**
	 * 
	 * Display the rounds of a match.
	 * 
	 * @param rounds The rounds of a match.
	 */
	public void displayRounds(Match[][] rounds) {
		System.out.println("\n-------------------------------------");
		System.out.println("----------------IDA------------------");
		System.out.println("-------------------------------------");

		for (int i = 0; i < rounds.length; i++) {
			System.out.println("Ronda " + (i + 1) + ":");
			System.out.println("-------------------------------------");

			for (int j = 0; j < rounds[i].length; j++) {
				System.out.println((rounds[i][j].getHomeTeam().getName()) + " " + rounds[i][j].getHomeGoals() + " - "
						+ rounds[i][j].getAwayGoals() + " " + (rounds[i][j].getAwayTeam().getName()));

				// Add points
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
// TODO: Jornada de vuelta
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

		displayPoints();
	}

	/**
	 * 
	 * Display the points of each team
	 */
	public void displayPoints() {
		System.out.println("\n-----PUNTOS POR EQUIPOS-----");
		for (Team team : teams) {
			System.out.println(team.getName() + ": " + team.getPoints() + " puntos.");
		}
	}
}
