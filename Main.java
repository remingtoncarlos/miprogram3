/*             PARA INGENIERRIA DL SOFTWARE 2
                           TAREA UNIDAD 2
                           Por:  CARLOS ALBERTO ALEGRIA V
                           Docente: iNG. YURY MONTOYA
                           Fecha: 08/082022
                           PopayÁn
 */

package miprogram3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// char salir='s';
		int x = 0;
		int vr = 0;

		// Scanner entrar=new Scanner(System.in);

		Metodos m = new Metodos();
		System.out.print("BIENVENIDO A ALQUIATUOS S.A.S\n");

		do {
			vr = m.menu(x);
			// System.out.println("Vr: "+vr+"\n");

		} while (vr != 4); // salir=='s');
	}// fin main

}// fin clase
