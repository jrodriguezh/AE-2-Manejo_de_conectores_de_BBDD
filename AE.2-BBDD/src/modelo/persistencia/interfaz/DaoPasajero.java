package modelo.persistencia.interfaz;

import java.util.List;

import modelo.entidad.Pasajero;

public interface DaoPasajero {

	public boolean alta (Pasajero p);
	public boolean baja (int id);
	public boolean anadirACoche(Pasajero p);
	public boolean eliminarDeCoche(Pasajero p);
	public Pasajero obtener(int id);
	public List<Pasajero> Listar();
	public List<Pasajero> ListarPasajeros(int id);
	
}
