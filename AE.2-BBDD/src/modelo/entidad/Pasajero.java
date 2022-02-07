package modelo.entidad;

public class Pasajero {
	
	private int pasajeroid;
	private String nombre;
	private int edad;
	private double peso;
	private int cocheid;
	
	public Pasajero() {
		super();
	}

	public Pasajero(int pasajeroid, String nombre, int edad, double peso) {
		super();
		this.pasajeroid = pasajeroid;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public int getPasajeroid() {
		return pasajeroid;
	}

	public void setPasajeroid(int pasajeroid) {
		this.pasajeroid = pasajeroid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCocheid() {
		return cocheid;
	}

	public void setCocheid(int cocheid) {
		this.cocheid = cocheid;
	}

	@Override
	public String toString() {
		return "Pasajero [pasajeroid=" + pasajeroid + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso
				+ ", cocheid=" + cocheid + "]";
	}
	
	

	
	
	

}
