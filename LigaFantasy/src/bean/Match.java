package bean;

/**
 * @author pablo
 *
 */
public class Match {

	private Team homeTeam;
	private Team awayTeam;
	private int homeGoals;
	private int awayGoals;

	/**
	 * @param homeTeam
	 * @param awayTeam
	 */
	public Match(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

//----------getters and setters-------------------------------------------------

	/**
	 * @return the homeTeam
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	/**
	 * @return the awayTeam
	 */
	public Team getAwayTeam() {
		return awayTeam;
	}

	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	/**
	 * @return the homeGoals
	 */
	public int getHomeGoals() {
		return homeGoals;
	}

	/**
	 * @param homeGoals the homeGoals to set
	 */
	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	/**
	 * @return the awayGoals
	 */
	public int getAwayGoals() {
		return awayGoals;
	}

	/**
	 * @param awayGoals the awayGoals to set
	 */
	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	@Override
	public String toString() {
		return "Match [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeGoals=" + homeGoals + ", awayGoals="
				+ awayGoals + "]";
	}

}
