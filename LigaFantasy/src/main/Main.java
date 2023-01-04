package main;

import java.util.Scanner;

import bean.Team;
import lists.HashMap;

public class Main {

	static Scanner scInt = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);

	static HashMap teams = new HashMap();
	static int totalTeams = 0;

	public static void main(String[] args) {

		int opcionMenu;
		do {
			opcionMenu = menuSimulacion();
			switch (opcionMenu) {
			case 1:
				addTeam();
				break;
			case 2:
				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			case 5:
//				break;
//			case 6:
//				System.exit(0);
//				break;
			default:
				throw new IllegalArgumentException("Opción no valida: " + opcionMenu);
			}
		} while (opcionMenu < 1 || opcionMenu > 2);
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
		System.out.println("MENU LIGA SIMULACION");
		System.out.println("1. Leer archivo");
		System.out.println("2. Siular");
		return scInt.nextInt();
	}

	public static void addTeam() {
		if (totalTeams >= 21) {
			System.out.println("");
		}
		Team team = new Team();
		System.out.println("Insertar nombre del equipo:");
		String name = null;

		while (teams.buscar(name) != null) {
			if (name != null) {
				System.out.println("El equipo ya existe");
			}
			name = scString.next();
		}
		
		team.setName(name);
		teams.insertar(team);
	}

}
