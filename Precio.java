/*
                         CLASE HIJA
 */
package alquilervehiculos2;

public class Precio extends AlquilerVehiculo {
	private int toneladas;
	private double dias;
	private double precio;
	
	public Precio() {
		super();
	}
/*
	public void  finalizar() {
		System.out.println("Finalizar");
	}
	*/
	public int getToneladas() {
		return toneladas;
	}

	public void setToneladas(int toneladas) {
		this.toneladas = toneladas;
	}

	public double getDias() {
		return dias;
	}

	public void setDias(double dias) {
		this.dias = dias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String  registro() {
		return "Matricula: "+getMatricula()+", Tipo vehiculo: "+getTipo_vehiculo()+", Fecha: "+getFecha()+"Precio"+precio;
	}
	
}