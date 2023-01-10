package lists;

import algoritmes.SortAlgoritmes;
import bean.Team;

public class HashMap {
	// 21 teams / 0.8 = 26.25, the next prime number is 27
	public static final int TAMTABLA = 27;
	private int numElementos;
	private double factorCarga;
	private Team[] tabla;

	public HashMap() {
		// se inicializa la tabla y sus elementos a NULL
		tabla = new Team[TAMTABLA];
		for (int i = 0; i < TAMTABLA; i++) {
			tabla[i] = null;
		}
		// se inicializan los atributos a 0
		numElementos = 0;
		factorCarga = 0;
	}

	/**
	 * Returns the team object stored at a given position.
	 * 
	 * @param position the position of the team in the table
	 * @return a Team object or null if the position is invalid or unoccupied
	 */
	public Team getTeamByPosition(int position) {
		if (position < 0 || position > 27)
			return null;
		return tabla[position];
	}

	/**
	 * Returns the position in the table for a given key. If the key already exists
	 * in the table, it returns the position of the key. If the key doesn't exist in
	 * the table, it returns the next available position.
	 * 
	 * @param clave the key to be hashed
	 * @return an integer representing the position in the table
	 */
	public int hash(String clave) {
		int i = 0, p;
		long d;
		// como la clave de dispersion es de tipo cadena, primero se convierte a un
		// valor entero
		d = transformaCadena(clave);

		// aplica aritmetica modular para obtener la dirección base

		p = (int) (d % TAMTABLA);

		// bucle de exploración cuadratica

		while (tabla[p] != null && !tabla[p].getName().equals(clave)) {
			i++;
			p = p + i * i;
			p = p % TAMTABLA;// considera el array como circular
		}
		return p;
	}

	/**
	 * Transforms a string key into an integer value.
	 * 
	 * @param clave the key to be transformed
	 * @return a long integer representing the transformed key
	 */
	private long transformaCadena(String clave) {
		// método de multiplicación para realizar la transformación.
		// detalles de cómo se obtiene, queda fuera del ámbito del tema
		long d = 0;
		for (int j = 0; j < Math.min(10, clave.length()); j++) {
			d = d * 29 + (int) clave.charAt(j);
		}

		if (d < 0)
			d = -d;
		return d;
	}

	/**
	 * Inserts a team object into the table.
	 * 
	 * @param r the team object to be inserted
	 */
	public void insertar(Team r) {
		int posicion = hash(r.getName());
		tabla[posicion] = r;
		numElementos++;
		factorCarga = (double) (numElementos) / TAMTABLA;
		if (factorCarga > 0.8)
			System.out.println("\n#### EL FACTOR DE CARGA SUPERA EL 80%, conviene aumentar el tamaño");

	}

	/**
	 * Finds and returns the team object with a given name.
	 * 
	 * @param clave the name of the team to be searched
	 * @return a Team object or null if the team was not found
	 */
	public Team buscar(String clave) {

		int posicion = hash(clave);
		Team pr = tabla[posicion];

		return pr;
	}

	/**
	 * Prints the sorted list of teams and their scores
	 * 
	 * @param param the HashMap object from which the teams will be displayed
	 */
	public static void displayScores(HashMap param) {
		param.tabla = SortAlgoritmes.shellSort(param.tabla);
		System.out.println("EQUIPOS			PTS		DG");
		int tab = 0;
		for (int i = 0; param.tabla[i] != null; i++) {
			tab = param.numElementos / 5;
			switch (tab) {
			case 0:
				System.out.println(param.tabla[i] + "			" + 20 + "		" + 3);
				break;
			case 1:
				System.out.println(param.tabla[i] + "			" + 20 + "		" + 3);
				break;
			case 2:
				System.out.println(param.tabla[i] + "		" + 20 + "		" + 3);
				break;
			case 3:
				System.out.println(param.tabla[i] + "	" + 20 + "		" + 3);
				break;
			}
		}
	}

}
