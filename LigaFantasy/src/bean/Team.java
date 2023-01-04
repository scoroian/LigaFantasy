package bean;

public class Team {

	private String name;
	private int points;
	private int goalsScored; // goles a favor
	private int goalsAgainst; // goles en contra

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
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
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
	public boolean setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
		return true;
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
	public boolean setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
		return true;
	}

	/**
	 * Adds the goals scored to the team with the id passed by parameter.
	 * 
	 * @param teamId   of the team to which the goals are to be added
	 * @param numGoals number of goals scored
	 * @return boolean goalsAdded
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public boolean addGoalsScoredToTeamById(int teamId, int numGoals) throws IllegalArgumentException {
		// Check if the team exist and parameters
		boolean teamExists = checkIfTeamExists(teamId);
		if (teamId < 0 || !teamExists) {
			throw new IllegalArgumentException("Invalid teamId provided. teamId must be greater or equal to 0.");
		}
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Add the goals to the team with the given ID
		// TODO buscas en la lista de equipos donde sea (en jornada supongo) y le seteas
		// los goles
//      return teams[teamId].setGoalF(teams[teamId].getGoalF() + goals);
		return false;
	}

	/**
	 * Adds the goals agains to the team with the id passed by parameter
	 * 
	 * @param teamId   of the team to which the goals are to be added
	 * @param numGoals number of goals agains
	 * @return boolean goalsAdded
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public boolean addGoalsAgainstToTeamById(int teamId, int numGoals) throws IllegalArgumentException {
		// Check if the team exist and parameters
		boolean teamExists = checkIfTeamExists(teamId);
		if (teamId < 0 || !teamExists) {
			throw new IllegalArgumentException("Invalid teamId provided. teamId must be greater or equal to 0.");
		}
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Add the goals to the team with the given ID
		// TODO buscas en la lista de equipos donde sea (en jornada supongo) y le seteas
		// los goles
//      return teams[teamId].setGoalC(teams[teamId].getGoalC() + goals);
		return false;
	}

	/**
	 * Checks if the team with the identifier passed by parameter exists.
	 * 
	 * @param teamId
	 * @return boolean teamExist
	 * @throws IllegalArgumentException if teamId is less than or equal to 0
	 */
	private boolean checkIfTeamExists(int teamId) {
		if (teamId < 0) {
			throw new IllegalArgumentException("Invalid teamId provided. teamId must be greater or equal to 0.");
		}
		// TODO if el equipo existe donde sea devuelve true sino false.
		return false;
	}

}
