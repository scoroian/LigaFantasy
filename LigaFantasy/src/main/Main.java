package main;

import java.util.Scanner;

import bean.League;
import bean.Team;
import lists.HashMap;

public class Main {

	static HashMap teams = new HashMap();
	static int totalTeams = 0;

	public static void main(String[] args) {

		int opcionMenu;
		boolean finish = false;
		do {
			opcionMenu = menuSimulacion();
			switch (opcionMenu) {
			case 1:
				addTeam();
				break;
			case 2:
				League league = new League();
				league.mostrarPartidos(league.calcularLiga(teams));
				league.displayPoints(league.generateTeams(teams));
				finish = true;
				break;
			case 3:
				Scanner sc = new Scanner(System.in);
				System.out.println("0 para par, 1 para impar");
				generarEqupiosAutomaticos(sc.nextInt());
				break;
			}
		} while (!finish);
	}

	public static void generarEqupiosAutomaticos(int par) {
		String alfabeto[] = { "FC BARCELONA", "REAL MADRID", "REAL SOCIEDAD", "VILLAREAL", "REAL ZARAGOZA",
				"REAL BETIS", "ATLETICO MADRID", "ATHLETIC CLUB", "RAYO VALLECANO", "OSASUNA CF", "MALLORCA CF",
				"GIRONA FC", "VALENCIA CF", "GETAFE CF", "ALMERIA CF", "CELTA DE VIGO", "REAL VALLADOLID", "SEVILLA CF",
				"CADIH CFOH", "ESPANYOL", "ELCHE" };

		for (int i = 0; i < (par == 0 ? alfabeto.length - 1 : alfabeto.length); i++) {
			Team team = new Team();
			String name = alfabeto[i];
			team.setName(name);
			teams.insertar(team);
		}

	}

	@SuppressWarnings("resource")
	public static int menuSimulacion() {
		Scanner scInt = new Scanner(System.in);
		System.out.println("MENU LIGA");
		System.out.println("1. Insertar equipo");
		System.out.println("2. Simular");
		System.out.println("3. automatico");
		int option = scInt.nextInt();
		return option;

	}

	@SuppressWarnings("resource")
	public static void addTeam() {
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
			System.out.println("Insertar nombre del equipo:");
			name = scString.nextLine();
		} while (teams.buscar(name) != null);

		team.setName(name);
		teams.insertar(team);
		totalTeams++;
	}

}
