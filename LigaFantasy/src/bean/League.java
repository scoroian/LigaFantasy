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

				Match match = new Match(team1, team2);
				team1.setPlayed(team2);
				team2.setPlayed(team1);

				teams.remove(team1);
				teams.remove(team2);
				// generate goals
				int team1Goals = random.nextInt(8);
				int team2Goals = random.nextInt(8);
				// set teams goals in the match
				match.setHomeGoals(team1Goals);
				match.setAwayGoals(team2Goals);
				// add team goals
				team1.addGoalsScoredToTeam(team1Goals);
				team2.addGoalsScoredToTeam(team2Goals);
				// add goals against
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
				matches.add(match);
				i++;
			} while (i != totalMatches);

			round.add(matches);
			if (round.size() >= totalRounds)
				finish = true;
		} while (!finish);

		showSimulate();

	}

	public List<Team> generateTeams(HashMap teamsMap) {
		List<Team> teamsArray = new ArrayList<Team>();
		for (int i = 0; i < HashMap.TAMTABLA; i++) {
			Team team = teamsMap.getTeamForPosition(i);
			if (team == null)
				continue;
			teamsArray.add(team);
		}
		return teamsArray;
	}

	public void showSimulate() {
		int i = 1;
		for (List<Match> matches : round) {
			System.out.println("###### Jornadas " + i++ + " ######");
			for (Match match : matches) {
				System.out.println(match.getHomeTeam().getName() + " " + match.getHomeGoals() + " - "
						+ match.getAwayGoals() + " " + match.getAwayTeam().getName());
			}
		}
	}
}
