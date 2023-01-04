package bean;

public class Team {

	private String name;
	private int points;
	private int goalF;// goles a favor
	private int goalC;// goles en contra

	public Team() {}

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
	 * @param points the points to add
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * @return the goalF
	 */
	public int getGoalF() {
		return goalF;
	}

	/**
	 * @param goalF the goalF to add
	 */
	public void addGoalF(int goalF) {
		this.goalF += goalF;
	}

	/**
	 * @return the goalC
	 */
	public int getGoalC() {
		return goalC;
	}

	/**
	 * @param goalC the goalC to add
	 */
	public void addGoalC(int goalC) {
		this.goalC += goalC;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", points=" + points + ", goalF=" + goalF + ", goalC=" + goalC + "]";
	}

}
