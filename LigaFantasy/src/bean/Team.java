package bean;

public class Team {

	private String name;
	private int points;
	private int goalF;// goles a favor
	private int goalC;// goles en contra

	public Team() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGoalF() {
		return goalF;
	}

	public void setGoalF(int goalF) {
		this.goalF = goalF;
	}

	public int getGoalC() {
		return goalC;
	}

	public void setGoalC(int goalC) {
		this.goalC = goalC;
	}

}
