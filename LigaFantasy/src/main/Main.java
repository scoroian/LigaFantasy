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
				league.simulate(teams);
				finish = true;
				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			case 5:
//				break;
//			case 6:
//				finish = true;
			}
		} while (!finish);
	}

//	public static int menu() {
//		System.out.println("MENU LIGA FANTASY");
//		System.out.println("1. Insertar equipo");
//		System.out.println("2. Añadir puntos a equipo");
//		System.out.println("3. Añadir goles a favor a equipo");
//		System.out.println("4. Añadir goles en contra a equipo");
//		System.out.println("5. Ver puntuacion");
//		System.out.println("6. Salir");
//		return scInt.nextInt();
//	}

	public static int menuSimulacion() {
		try (Scanner scInt = new Scanner(System.in)) {
			System.out.println("MENU LIGA SIMULACION");
			System.out.println("1. Insertar equipo");
			System.out.println("2. Simular");
			int option = scInt.nextInt();
			return option;
		} catch (Exception e) {
			System.err.println("Opcion no valida");
		}
		return 0;

	}

	public static void addTeam() {
		// Control the maximum number of teams
		if (totalTeams >= 21) {
			System.err.println("Ya has llegado al maximo número de equipos");
			return;
		}
		try (Scanner scString = new Scanner(System.in)) {
			Team team = new Team();
			String name = null;
			do {
				if (name != null) {
					System.err.println("El equipo ya existe");
				}
				System.out.println("Insertar nombre del equipo:");
				name = scString.next();
			} while (teams.buscar(name) != null);

			team.setName(name);
			teams.insertar(team);
		}
		totalTeams++;
	}

}
