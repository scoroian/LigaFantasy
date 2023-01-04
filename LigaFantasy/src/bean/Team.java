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

	
}
