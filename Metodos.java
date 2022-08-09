/* ESTAN TODOS LOS METODOS DE LA APLICACIÓN  */
package alquilervehiculos2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Metodos {
	private int vr, m, n, matricula;
	String op;
	private int ton;
	private double dias, precio;
	private String tipo, fecha;
	private boolean res;
	private Precio p;

	private ArrayList<Precio> lista = new ArrayList<Precio>();
	private Scanner leer = new Scanner(System.in);

	public int menu(int x) {
		System.out.println("\n -- REGSTRO ALQUILER VEH�CULOS --"
				+ "\n 1. Registrar"
				+ "\n 2. Listar"
				+ "\n 3. Eliminar"
				+ "\n 4. Salir"
				+ "\n Opci�n: ");
		op = leer.nextLine(); // System.out.println("op: "+op+"\n");
		try {
			n = Integer.parseInt(op);
			switch (n) {
				case 1:
					registrar();
					break;
				case 2:
					listar();
					break;
				case 3:
					eliminar();
					break;
				case 4:
					salir();
					x = 4;
					break;
				case 5:
					error();
					break;
				default:
					error();
					break;
			}// fin switche
				// return x;
		} // fin try
		catch (Exception e) {
			System.out.println(" **************** Solo enteros entre 1 y 4 *********");
		}
		return x;
	}// fin MENU

	private void registrar() {
		do {
			System.out.print("\nDigite el n�mero de matricula          : (" + (lista.size()) + ") : ");
			// leer.nextLine();
			matricula = leer.nextInt(); // System.out.println("RES: "+(res));
			try {
				matricula = Integer.valueOf(matricula);
				if (matricula > 100 && matricula < 10000) {
					res = false; // System.out.print("RES for: "+(res));
					for (int i = 0; i < lista.size(); i++) {
						p = lista.get(i);
						if (matricula == p.getMatricula()) {
							// if(matricula.equalsIgnoreCase(p.getMatricula())) {
							res = true; // termina el ciclo
							System.out.print("\n ------------------------------ la matr�cula: " + matricula
									+ ", ya existe ! ----");
							break;
						} // fin if
					} // fin for
				} // fin si externo
				else if (matricula <= 100 && matricula >= 10000) {
					System.out.print("--------------------- Ingres No. matr�cula entre 100 y 9999 ! ------ \n");
					res = false;
				}
				// System.out.print("RES else: "+(res));
				// leer.nextLine();//System.out.println("\nDigite el n�mero de matricula: " );
			} catch (Exception s) {
				System.out.println(" **************** Solo N�meros enteros  *********");
			}

		} while (res);
		leer.nextLine();

		do {
			System.out.print("\n Ingrese el C�digo del tipo vehiculo \n ");
			System.out.print("1.Coche, 2.Microbus, 3.Furgoneta, 4.Cami�n:");
			vr = leer.nextInt();
			if (vr < 1 || vr > 4) {
				System.out.print("\n -**- Ingrese c�digo de vehiculos entre 1 y 4 --**--\n");
			}

		} while (vr < 1 || vr > 4);

		do {
			System.out.print("\n Ingrese los dias del alquiler hasta 365: ");
			dias = leer.nextDouble();
			if (dias > 365) {
				System.out.print("--**-- Tiempo m�ximo del contrato es de 1 a 365 d�as: --**--");
			}

		} while (dias < 1 || dias > 365);

		do {
			System.out.print("\n Ingrese las toneladas                : ");
			ton = leer.nextInt();
			if (ton < 1 || ton > 50) {
				System.out.print("--**-- El m�ximo tonelaje es de 50: --**--");
			}

		} while (ton < 1 || ton > 50);

		System.out.print("\n Ingrese fecha del alquiler (dd-mm-aaa) : ");
		fecha = leer.nextLine();
		fecha = leer.nextLine();
		System.out.print("\n");

		switch (vr) {
			case 1:
				tipo = "**Coche**";
				precio = (50 * dias) + (1.5 * dias);
				break;
			case 2:
				tipo = "*Microbus";
				precio = (50 * dias) + 2;
				break;
			case 3:
				tipo = "Furgoneta";
				precio = (50 * dias) + (20 * ton) + 40; // 40 es un cargo fijo
				break;
			case 4:
				tipo = "**Cami�n*";
				precio = (50 * dias) + (20 * ton) + 40; // 40 es un cargo fijo
				break;
		}

		p = new Precio();
		p.setMatricula(matricula);
		p.setTipo_vehiculo(tipo);
		p.setDias(dias);
		p.setToneladas(ton);
		p.setFecha(fecha);
		p.setPrecio(precio);
		lista.add(p);
		System.out.print("----------------------------------- \n");
		System.out.print("-Registro almacenado correctamente..\n");
		System.out.print("------------------------------------\n");
		// System.out.print(vr);

		p.registro();
		// menu(0);
	}// fin AGREGAR

	private void listar() {
		if (lista.isEmpty()) {
			System.out.print("\n ----------------------- No hay registros para listar!----------------\n");
		} else {
			System.out.print(
					"\n------------------------------------ REGISTROS ----------------------------------------------\n");
			System.out.print("Matricula:\t Tipo Veh�culo:\t D�as:\t Toneladas:\t Fecha:\t\t Precio\n  ");
			System.out.print(
					"-------------------------------------------------------------------------------------------\n");
			for (int i = 0; i < lista.size(); i++) {
				p = lista.get(i);
				System.out.print("\n");
				System.out.print(p.getMatricula() + "\t");
				System.out.print("\t " + p.getTipo_vehiculo() + "");
				System.out.print("\t " + p.getDias() + "");
				System.out.print("\t     " + p.getToneladas() + "\t");
				System.out.print("\t " + p.getFecha() + "");
				System.out.print("\t " + p.getPrecio() + "");
			} // fin for
		} // fin else
		System.out.print(
				"\n---------------------------------------------------------------------------------------------\n");
		// menu(0);
	}// fin listar

	private void eliminar() {
		if (lista.isEmpty()) {
			System.out.print("\n      ------------------------- No hay registros a Eliminar! -----------------\n");
		} else {
			System.out.print("\nIngrese matr�cula vehiculo a Eliminar: ");
			matricula = leer.nextInt();
			res = false;
			for (int i = 0; i < lista.size(); i++) {
				p = lista.get(i); // System.out.print("Matricula No: "+p.getMatricula());
				// if(matricula==p.getMatricula()) {
				if (matricula == p.getMatricula()) {
					res = true;
					lista.remove(i);
					System.out.print("\n ********* Registro Eliminado correctamente! *******\n\n");
					break;
				} // fin si interno
					// }//fin si externo
			} // fin FOR
		} // fin else

		// menu(0);
	}// fin ELIMINAR

	private void buscar() {
		if (lista.isEmpty()) {
			System.out
					.print("\n      ------------------------------- No hay registros para Consultar ! --------------");
		} else {
			System.out.print("\nIngrese matr�cula vehiculo a Consultar: ");
			matricula = leer.nextInt();
			res = false;
			for (int i = 0; i < lista.size(); i++) {
				p = lista.get(i); // System.out.print("Matricula No: "+p.getMatricula());
				if (matricula == p.getMatricula()) {
					System.out.print("Fecha: \t Matricula: \t Tipo Veh�culo: \t D�as: \t Toneladas:  \t  Precio: \n");
					res = true;
					System.out.print("\t" + p.getFecha());
					System.out.print("\t" + p.getMatricula());
					System.out.print("\t" + p.getTipo_vehiculo());
					System.out.print("\t" + p.getDias());
					System.out.print("\t" + p.getToneladas());
					System.out.print("\t" + p.getPrecio());
				} // fin si
			} // fin FOR

			if (res == false) {
				System.out.print("--**-- La Matr�cula:  " + matricula + ", No se encontr�! --**-- ");
			}
		} // fin else

		// menu(0);
	}

	private void salir() {
		System.out.print("\n --- Aplicaci�n cerrada ---");
	}

	private void error() {
		System.out.print("\n --- Error de opci�n ! ---");
	}

}// fin clase Metodos
