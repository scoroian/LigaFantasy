package main;

import java.util.Scanner;

import bean.Team;

public class Main {

	static Scanner scInt = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);

	public static void main(String[] args) {

		int opcionMenu;
		do {
			opcionMenu = menu();
			switch (opcionMenu) {
			case 1:
				Team team = new Team();
				break;
			case 7:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcionMenu);
			}
		} while (opcionMenu < 1 || opcionMenu > 6);
	}

	public static int menu() {
		System.out.println("MENU LIGA FANTASY");
		System.out.println("1. Insertar equipo");
		System.out.println("2. Añadir puntos a equipo");
		System.out.println("3. Añadir goles a favor a equipo");
		System.out.println("4. Añadir goles en contra a equipo");
		System.out.println("5. Ver puntuacion");
		System.out.println("6. Salir");
		return scInt.nextInt();
	}

	public static int menuSimulacion() {
		System.out.println("MENU LIGA SIMULACION");
		System.out.println("1. Leer archivo");
		System.out.println("2. Siular");
		return scInt.nextInt();
	}

}
