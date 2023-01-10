package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lists.HashMap;

public class League {

	final static int winnerPoints = 3;
	final static int drawPoints = 1;

	List<List<Match>> round = new ArrayList<List<Match>>();
	Random random = new Random();

	/**
	 * Simulates a tournament using a given HashMap of teams. The simulation
	 * generates matches, assigns goals to teams, and updates team statistics such
	 * as points and goals scored/conceded.
	 * 
	 * @param teamsMap HashMap containing teams participating in the tournament.
	 */
	public void simulate(HashMap teamsMap) {
		List<Match> matches = new ArrayList<Match>();
		// boolean to finish all rounds
		boolean finish = false;
		do {
			matches = new ArrayList<Match>();
			// get teams array
			List<Team> teams = generateTeams(teamsMap);
			int totalRounds = teams.size() - 1;
			int totalMatches = teams.size() / 2;
			int i = 0;
			do {
				Team team1 = null;
				Team team2 = null;
				// check if teams is empty to finish loop
				if (teams.size() == 0) {
					break;
				} else {
					boolean correct = false;
					do {
						int r = random.nextInt((teams.size()));
						if (r == 0)
							r++;
						team1 = teams.get(0);
						team2 = teams.get(r);
						if (!team1.getPlayed().contains(team2))
							correct = true;
					} while (!correct);
				}

				// create match between team1 and team2
				Match match = new Match(team1, team2);
				// add teams to each other's list of played teams
				team1.setPlayed(team2);
				team2.setPlayed(team1);
				// remove teams from list of available teams
				teams.remove(team1);
				teams.remove(team2);
				// generate random goals for each team
				int team1Goals = random.nextInt(8);
				int team2Goals = random.nextInt(8);
				// set teams goals in the match
				match.setHomeGoals(team1Goals);
				match.setAwayGoals(team2Goals);
				// add team1 goals to team1's statistics
				team1.addGoalsScoredToTeam(team1Goals);
				team2.addGoalsScoredToTeam(team2Goals);
				// add team1 goals against to team1's statistics
				team1.addGoalsAgainstToTeam(team2Goals);
				team2.addGoalsAgainstToTeam(team1Goals);

				if (team1Goals > team2Goals)
					team1.addPoints(winnerPoints);
				if (team2Goals > team1Goals)
					team2.addPoints(winnerPoints);
				if (team1Goals == team2Goals) {
					team1.addPoints(drawPoints);
					team2.addPoints(drawPoints);
				}
				// add match to list of matches
				matches.add(match);
				i++;
			} while (i != totalMatches);
			// add round of matches to the tournament
			round.add(matches);
			// check if all rounds have been completed
			if (round.size() >= totalRounds)
				finish = true;
		} while (!finish);

		displaySimulation();

	}

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

	/**
	 * Displays the simulation by iterating through the rounds and matches and
	 * printing the match details in the format:
	 * 
	 * homeTeamName homeGoals - awayGoals awayTeamName
	 */
	public void displaySimulation() {
		int i = 1;
		// iterate through the rounds
		for (List<Match> matches : round) {
			System.out.println("###### Jornadas " + i++ + " ######");
			// iterate through the matches of the round
			for (Match match : matches) {
				// print the match details
				System.out.println(match.getHomeTeam().getName() + " " + match.getHomeGoals() + " - "
						+ match.getAwayGoals() + " " + match.getAwayTeam().getName());
			}
		}
	}
}
