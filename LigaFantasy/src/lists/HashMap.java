package lists;

import bean.Team;

public class HashMap {
	// 21 teams / 0.8 = 26.25, the next prime number is 27
	static final int TAMTABLA = 27;
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

	// devuelve la posición o índice de la tabla libre para insertar
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

	public void insertar(Team r) {
		int posicion = hash(r.getName());
		tabla[posicion] = r;
		numElementos++;
		factorCarga = (double) (numElementos) / TAMTABLA;
		if (factorCarga > 0.8)
			System.out.println("\n#### EL FACTOR DE CARGA SUPERA EL 80%, conviene aumentar el tamaño");

	}

	//devuelve una referencia a un elemento di lo encuentra en la tabla y devuelve NULL si no lo encuentra o fue dado de baja
	public Team buscar(String clave)
	{
		
		int posicion=hash(clave);
		Team pr=tabla[posicion];
//		if(pr!=null)
//			if(!pr.esAlta) pr=null;
		
		return pr;
	}
//	
//	//para dar de baja se siguen los mismos pasos que para buscar y se pone a false el atributo esAlta
//	public void eliminar(String clave)
//	{
//		int posicion=hash(clave);
//		if(tabla[posicion]!=null)
//			tabla[posicion].esAlta=false;
//		
//	}

}
