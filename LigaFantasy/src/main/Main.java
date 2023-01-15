package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.League;
import bean.Team;
import lists.HashMap;

public class Main {

	static HashMap teams = new HashMap();
	static int totalTeams = 0;

	public static void main(String[] args) {

		int numOption = 0;
		boolean finish = false;
		do {
			numOption = displayMenu();
			switch (numOption) {
			case 1:
				addTeam();
				break;
			case 2:
				League league = new League(convertTeamHashToList(teams));
				league.displayRounds(league.simulate());
				finish = true;
				break;
			case 3:
				Scanner sc = new Scanner(System.in);
				System.out.print("\n0 para par/1 para impar: ");
				autoInsertTeams(sc.nextInt());
				break;
			}
		} while (!finish);
	}

	/**
	 * Generate teams automatically
	 * 
	 * @param par a integer value for the number of teams to be generated
	 */
	private static void autoInsertTeams(int par) {
		String alphabet[] = { "FC BARCELONA", "REAL MADRID", "REAL SOCIEDAD", "VILLAREAL", "REAL ZARAGOZA",
				"REAL BETIS", "ATLETICO MADRID", "ATHLETIC CLUB", "RAYO VALLECANO", "OSASUNA CF", "MALLORCA CF",
				"GIRONA FC", "VALENCIA CF", "GETAFE CF", "ALMERIA CF", "CELTA DE VIGO", "REAL VALLADOLID", "SEVILLA CF",
				"CADIH CFOH", "ESPANYOL", "ELCHE" };

		for (int i = 0; i < (par == 0 ? alphabet.length : alphabet.length - 1); i++) {
			Team team = new Team();
			String name = alphabet[i];
			team.setName(name);
			teams.put(team);
		}

	}

	@SuppressWarnings("resource")
	/**
	 * Display a menu to simulate the league and allows to select an option.
	 * 
	 * @return the selected option as an integer.
	 */
	private static int displayMenu() {
		Scanner scInt = new Scanner(System.in);
		System.out.println("\nMENU LIGA FANTASY");
		System.out.println("1. Insertar equipo");
		System.out.println("2. Simular");
		System.out.println("3. Automatico");
		System.out.println("");
		System.out.print("Option: ");
		int option = scInt.nextInt();
		System.out.print("");
		return option;

	}

	@SuppressWarnings("resource")
	/**
	 * Add a new team to the teams collection with a unique name
	 */
	private static void addTeam() {
		// Control the maximum number of teams
		if (totalTeams >= 21) {
			System.err.println("Ya has llegado al maximo número de equipos");
			return;
		}
		Scanner scString = new Scanner(System.in);
		Team team = new Team();
		String name = null;
		do {
			if (name != null) {
				System.err.print("El equipo ya existe");
			}
			System.out.print("Insertar nombre del equipo: ");
			name = scString.nextLine();
		} while (teams.getByKey(name) != null);

		team.setName(name);
		teams.put(team);
		totalTeams++;
	}

	/**
	 * Generates a List of teams based on the teams present in the given HashMap.
	 * 
	 * @param teamsMap The HashMap containing teams to be added to the List.
	 * @return A List of teams.
	 */
	private static List<Team> convertTeamHashToList(HashMap teamsMap) {
		List<Team> teamsArray = new ArrayList<Team>();
		for (int i = 0; i < HashMap.LENGTH; i++) {
			// get team at the current position
			Team team = teamsMap.getTeamByPosition(i);
			if (team == null)
				continue;
			teamsArray.add(team);
		}
		return teamsArray;
	}

}
