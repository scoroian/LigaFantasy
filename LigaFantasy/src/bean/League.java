package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lists.HashMap;

public class League {
	
	final static int winnerPoints = 3;
	final static int drawPoints = 1;
	
	List<Match> matches = new ArrayList<Match>();
	Random random = new Random();

	public void simulate(HashMap teams) {
		// get fisrt team
		team1For:
		for (int i = 0; i < teams.TAMTABLA; i++) {
			Team team1 = teams.getTeamForPosition(i);
			if (team1 == null) continue team1For;
			// get opponent
			team2For:
			for (int j = 0; j < teams.TAMTABLA; j++) {
				if (i == j) continue team2For;
				Team team2 = teams.getTeamForPosition(j);
				Match actualMatch = new Match(team1, team2);
				if (team2 == null || checkMatch(actualMatch)) continue team2For;
				// calculate the teams goals
				int team1Goals = random.nextInt(8);
				int team2Goals = random.nextInt(8);
				// set teams goals in the match
				actualMatch.setHomeGoals(team1Goals);
				actualMatch.setAwayGoals(team2Goals);
				// add team goals
				team1.addGoalsScoredToTeam(team1Goals);
				team2.addGoalsScoredToTeam(team2Goals);
				// add goals against
				team1.addGoalsAgainstToTeam(team2Goals);
				team2.addGoalsAgainstToTeam(team1Goals);
				
				if (team1Goals > team2Goals) team1.addPoints(winnerPoints);
				if (team2Goals > team1Goals) team2.addPoints(winnerPoints);
				if (team1Goals == team2Goals) {
					team1.addPoints(drawPoints);
					team2.addPoints(drawPoints);
				}
				
				matches.add(actualMatch);
			}
		}
		showSimulate();
	}
	
	public void showSimulate() {
		String homeTeam = "";
		for (Match match : matches) {
			if (!homeTeam.equals(match.getHomeTeam().getName())) {
				homeTeam = match.getHomeTeam().getName();
				System.out.println("###### Jornadas de " + homeTeam + "(" + match.getHomeTeam().getPoints() + " puntos) ######");
			}
			System.out.println(homeTeam + " " + match.getHomeGoals() + " - " + match.getAwayGoals() + " " + match.getAwayTeam().getName());
		}
	}
	
	/**
	 * Method for check to see if team 1 and team 2 have already played 
	 * @param team1
	 * @param team2
	 * @return
	 */
	private boolean checkMatch(Match actualMatch) {
		return matches.contains(actualMatch);
	}
}
