package bean;

/**
 * @author pablo
 *
 */
public class Match {

	private String homeTeam;
	private String awayTeam;
	private int homeGoals;
	private int awayGoals;

	/**
	 * Constructor with all parameters
	 * 
	 * @param homeTeam
	 * @param awayTeam
	 * @param homeGoals
	 * @param awayGoals
	 */
	public Match(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}

//----------getters and setters-------------------------------------------------

	/**
	 * @return the homeTeam
	 */
	public String getHomeTeam() {
		return homeTeam;
	}

	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	/**
	 * @return the awayTeam
	 */
	public String getAwayTeam() {
		return awayTeam;
	}

	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(String awayTeam) {
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
