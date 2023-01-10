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
		List<Team> teams = generateTeams(teamsMap);
		int totalRounds = teams.size() - 1;
		int i = 0;
		do {
			Team team1 = null;
			Team team2 = null;
//			if (i == teams.size()-1) {
//				team1 = teams.get(i);
//				
//			}
			boolean correct = false;
			do {
				
				int r = random.nextInt((teams.size()) + 1);
				team1 = teams.get(0);
				team2 = teams.get(r);
				if (!team1.getPlayed().contains(team2)) correct = true;
			} while (!correct);
			
			Match match = new Match(team1, team2);
			team1.setPlayed(team2);
			team2.setPlayed(team1);
			
			teams.remove(team1);
			teams.remove(team2);
			
			matches.add(match);
			i++;
		} while (i != totalRounds);
		
		round.add(matches);
		matches = new ArrayList<>();
	}
	
	public List<Team> generateTeams(HashMap teamsMap) {
		List<Team> teamsArray = new ArrayList<Team>();
		for (int i = 0; i < HashMap.TAMTABLA; i++) {
			Team team = teamsMap.getTeamForPosition(i);
			if (team == null) continue;
			teamsArray.add(team);
		}
		return teamsArray;
	}
	
//	public void showSimulate() {
//		String homeTeam = "";
//		int i = 1;
//		for (Match match : matches) {
//			if (!homeTeam.equals(match.getHomeTeam().getName())) {
//				homeTeam = match.getHomeTeam().getName();
//				System.out.println("###### Jornadas " + i++ + " ######");
//			}
//			System.out.println(homeTeam + " " + match.getHomeGoals() + " - " + match.getAwayGoals() + " " + match.getAwayTeam().getName());
//		}
//	}
	
	/**
	 * Method for check to see if team 1 and team 2 have already played 
	 * @param team1
	 * @param team2
	 * @return
	 */
//	private boolean checkMatch(Match actualMatch) {
//		return matches.contains(actualMatch);
//	}
}
