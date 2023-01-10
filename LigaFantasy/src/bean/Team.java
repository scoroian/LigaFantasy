package bean;

import java.util.ArrayList;

public class Team {

	private String name;
	private int points;
	private int goalsScored; // goles a favor
	private int goalsAgainst; // goles en contra
	private ArrayList<Team> played = new ArrayList<Team>();

	/**
	 * Empty constructor
	 */
	public Team() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param name the name of the team
	 */
	public Team(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to add
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * @return the goalsScored
	 */
	public int getGoalsScored() {
		return goalsScored;
	}

	/**
	 * 
	 * @param goalsScored the goalsScored to set
	 * @return true
	 */
	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	/**
	 * @return the goalsAgainst
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	/**
	 * @param goalsAgainst the goalsAgainst to set
	 * @return true
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	/**
	 * @return the played
	 */
	public ArrayList<Team> getPlayed() {
		return played;
	}

	/**
	 * @param team the played to set
	 */
	public void setPlayed(Team team) {
		this.played.add(team);
	}

	/**
	 * Adds the goals scored to the team.
	 * 
	 * @param numGoals number of goals scored
	 * @return boolean goalsAdded
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public void addGoalsScoredToTeam(int numGoals) throws IllegalArgumentException {
		// Check parameters
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Add the goals to the team
		this.setGoalsScored(this.getGoalsScored() + numGoals);
	}

	/**
	 * Adds the goals agains to the team.
	 * 
	 * @param numGoals number of goals agains
	 * @return boolean goalsAdded
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public void addGoalsAgainstToTeam(int numGoals) throws IllegalArgumentException {
		// Check parameters
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Add the goals to the team
		this.setGoalsAgainst(this.getGoalsAgainst() + numGoals);
	}

	/**
	 * Compares two Team objects and returns true if the current Team object is
	 * greater than the provided Team object. The comparison is based on the
	 * following criteria: 
	 * 1. Points 
	 * 2. Goal difference (goals scored minus goals against) 
	 * 3. Goals scored
	 * 
	 * @param data the Team object to compare with
	 * @return true if the current Team object is greater than the provided Team
	 *         object, false otherwise.
	 */
	public boolean greaterThan(Team data) {
		if (points > data.points) {
			return true;
		} else if (points == data.points && (goalsScored - goalsAgainst) > (data.goalsScored - data.goalsAgainst)) {
			return true;
		} else if (points == data.points && (goalsScored - goalsAgainst) == (data.goalsScored - data.goalsAgainst)
				&& goalsScored > data.goalsScored) {
			return true;
		} else {
			return false;
		}
	}

}
