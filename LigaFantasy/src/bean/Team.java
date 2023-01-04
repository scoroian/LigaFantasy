package bean;

public class Team {

	private String name;
	private int points;
	private int goalF;// goles a favor
	private int goalC;// goles en contra

	/**
	 * 
	 */
	public Team() {
		goalF = 0;
		goalC = 0;
		points = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
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
	 * @return the goalF
	 */
	public int getGoalF() {
		return goalF;
	}

	/**
	 * @param goalF the goalF to set
	 */
	public void setGoalF(int goalF) {
		this.goalF = goalF;
	}

	/**
	 * @return the goalC
	 */
	public int getGoalC() {
		return goalC;
	}

	/**
	 * @param goalC the goalC to set
	 */
	public void setGoalC(int goalC) {
		this.goalC = goalC;
	}

	/**
	 * Adds the goals in favor to the indicated team.
	 * 
	 * @param teamId
	 * @param numGoals number of goals in favor
	 * @return boolean Goals added
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public boolean addGoalsFToTeamById(int teamId, int numGoals) throws IllegalArgumentException {
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Check if the team with the given ID exists
		boolean teamExists = checkIfTeamExists(teamId);
		if (!teamExists) {
			return false;
		}

		// Add the goals to the team with the given ID
		// TODO buscas en la lista de equipos donde sea (en jornada supongo) y le seteas
		// los goles
//        teams[teamId].setGoalF(teams[teamId].getGoalF() + goals);
		return true;
	}

	/**
	 * Adds the goals agains the indicated team.
	 * 
	 * @param teamId
	 * @param numGoals number of goals agains
	 * @return boolean Goals added
	 * @throws IllegalArgumentException if the number of goals is not between 0-7
	 */
	public boolean addGoalsCToTeamById(int teamId, int numGoals) throws IllegalArgumentException {
		if (numGoals < 0 || numGoals > 7) {
			throw new IllegalArgumentException("Number of goals must be between 0 and 7");
		}

		// Check if the team with the given ID exists
		boolean teamExists = checkIfTeamExists(teamId);
		if (!teamExists) {
			return false;
		}

		// Add the goals to the team with the given ID
		// TODO buscas en la lista de equipos donde sea (en jornada supongo) y le seteas
		// los goles
//        teams[teamId].setGoalC(teams[teamId].getGoalC() + goals);
		return true;
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
