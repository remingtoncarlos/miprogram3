/*
                                CLASE PRINCIPAL O PLANTILLA
Por: Carlos Alberto Alegria V

 */
package alquilervehiculos2;

public class AlquilerVehiculo {
	private int matricula;
	private String tipo_vehiculo, fecha;

	// CONSTRUCTOR
	public AlquilerVehiculo() {
		super();
	}

	// *********************** para polimorfimos
	public String registro() {
		return "MAtricula: " + matricula + ", Tipo vehiculo: " + tipo_vehiculo + ", Fecha: " + fecha;
	}
	// ****************************************************

	// METODOS GETT Y SETT
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
