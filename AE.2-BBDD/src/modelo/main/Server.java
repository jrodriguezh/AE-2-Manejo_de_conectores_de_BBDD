package modelo.main;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.DaoPasajeroMySQL;
import modelo.persistencia.interfaz.DaoCoche;
import modelo.persistencia.interfaz.DaoPasajero;

public class Server {
	static DaoCoche dc = new DaoCocheMySQL();         // Implementamos nuestras interfaces para poder ejecutar sus m�todos.
	static DaoPasajero dp = new DaoPasajeroMySQL();

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			
			boolean continuar = true; // Boolean para controlar la salida del programa.

			do {

				escribirMenu(); // Escribimos el men� para que el usuario pueda elegir una opci�n

				int opcion = sc.nextInt(); // Lee la respuesta de usuario para utilizarlo en el switch

				switch (opcion) {

				// ------- DAR DE ALTA COCHE -------

				case 1:
					System.out.println("Introduce los datos del coche:");
					Coche cocheAlta = new Coche(); // Creamos un objeto coche donde introduciremos los datos del usuario
					sc.nextLine();
					System.out.println("Matricula:");
					String matricula = sc.nextLine();
					cocheAlta.setMatricula(matricula);

					System.out.println("Marca:");
					String marca = sc.nextLine();
					cocheAlta.setMarca(marca);

					System.out.println("Modelo:");
					String modelo = sc.nextLine();
					cocheAlta.setModelo(modelo);

					System.out.println("Color:");
					String color = sc.nextLine();
					cocheAlta.setColor(color);

					boolean alta = dc.alta(cocheAlta); // Realizamos el alta del coche en la BBDD con un boolean, para
														// saber
														// si se ha realizado correctamente o no

					if (alta) {
						System.out.println("El coche se ha dado de alta");
					} else {
						System.out.println("El coche NO se ha dado de alta");
					}

					break;

				// ------- DAR DE BAJA COCHE POR ID-------

				case 2:
					System.out.println("Introduce el ID del coche a dar de baja:");
					int idBaja = sc.nextInt();
					boolean baja = dc.baja(idBaja);

					if (baja) {
						System.out.println("El coche se ha dado de baja");
					} else {
						System.out.println("El coche NO se ha dado de baja");
					}

					break;

				// ------- CONSULTAR COCHE POR ID -------

				case 3:
					System.out.println("Introduce el ID del coche a consultar:");
					int idConsulta = sc.nextInt();
					Coche cocheConsulta = dc.obtener(idConsulta); // Creamos un objeto coche para poder darle los datos
																	// del coche obtenido de la BBDD

					System.out.println(cocheConsulta);

					break;

				// ------- MODIFICAR COCHE POR ID -------

				case 4:
					System.out.println("Introduce el ID del coche a modificar:");
					Coche cocheModificar = new Coche(); // Creamos un objeto coche donde introduciremos los datos del
														// usuario
					int idModificar = sc.nextInt();
					cocheModificar.setId(idModificar);
					sc.nextLine();

					System.out.println("Introduce los nuevos datos del coche:");

					System.out.println("Matricula:");
					String matriculaMod = sc.nextLine();
					cocheModificar.setMatricula(matriculaMod);

					System.out.println("Marca:");
					String marcaMod = sc.nextLine();
					cocheModificar.setMarca(marcaMod);

					System.out.println("Modelo:");
					String modeloMod = sc.nextLine();
					cocheModificar.setModelo(modeloMod);

					System.out.println("Color:");
					String colorMod = sc.nextLine();
					cocheModificar.setColor(colorMod);

					boolean modificar = dc.modificar(cocheModificar);

					if (modificar) {
						System.out.println("El coche se ha modificado");
					} else {
						System.out.println("El coche NO se ha modificado");
					}

					break;

				// ------- LISTAR COCHES -------

				case 5:
					System.out.println("Listando todos los coches: \n" + "--------------------------");
					listarCoches();
					System.out.println("--------------------------");
					break;

				// ------- GESTION DE PASAJEROS -------
					
				case 6:
					boolean continuar2 = true;
					System.out.println("Bienvenido al gestor de pasajeros");
					do {
						escribirSubMenu();
						int opcion2 = sc.nextInt(); // Lee la respuesta de usuario para utilizarlo en el switch

						switch (opcion2) {
						
						// ------- DAR DE ALTA PASAJERO -------
						
						case 1:
							System.out.println("Introduce los datos del pasajero:");
							Pasajero pasajeroAlta = new Pasajero(); // Creamos un objeto pasajero donde introduciremos los datos del usuario
							sc.nextLine();
							System.out.println("Nombre:");
							String nombre = sc.nextLine();
							pasajeroAlta.setNombre(nombre);

							System.out.println("Edad:");
							int edad = sc.nextInt();
							pasajeroAlta.setEdad(edad);

							System.out.println("Peso:");
							double peso = sc.nextDouble();
							pasajeroAlta.setPeso(peso);
				
							boolean altaPasajero = dp.alta(pasajeroAlta); // Realizamos el alta del pasajero en la BBDD con un boolean, para
																// saber si se ha realizado correctamente o no

							if (altaPasajero) {
								System.out.println("El pasajero se ha dado de alta");
							} else {
								System.out.println("El pasajero NO se ha dado de alta");
							}
							break;
						
						// ------- DAR DE BAJA PASAJERO POR ID -------
							
						case 2:
							System.out.println("Introduce el ID del pasajero a dar de baja:");
							int idBajaPasajero = sc.nextInt();
							boolean bajaPasajero = dp.baja(idBajaPasajero);

							if (bajaPasajero) {
								System.out.println("El pasajero se ha dado de baja");
							} else {
								System.out.println("El pasajero NO se ha dado de baja");
							}

							
							break;
							
						// ------- CONSULTAR PASAJERO POR ID -------	
							
						case 3:
							System.out.println("Introduce el ID del pasajero a consultar:");
							int idConsultaPasajero = sc.nextInt();
							Pasajero pasajeroConsulta = dp.obtener(idConsultaPasajero); // Creamos un objeto pasajero para poder darle los datos
																			// del pasajero obtenido de la BBDD

							System.out.println(pasajeroConsulta);
							
							break;
							
						// ------- LISTAR PASAJEROS -------
							
						case 4:
							
							System.out.println("Listando todos los pasajeros: \n" + "--------------------------");
							listarPasajeros();
							System.out.println("--------------------------");
							break;
							
						// ------- ANADIR PASAJERO A UN COCHE -------	
							
						case 5:
							System.out.println("Estos son todos los coches disponibles:");
							listarCoches();
							System.out.println("Introduce el ID del COCHE donde quieras a�adir un pasajero:");
							Pasajero pasajeroAnadir = new Pasajero(); // Creamos un objeto pasajero donde introduciremos los datos del
																// usuario
							int idModificarP = sc.nextInt();
							pasajeroAnadir.setCocheid(idModificarP);							
							System.out.println("Estos son todos los pasajeros:");
							listarPasajeros();
							System.out.println("Introduce el ID del pasajero que quieras anadir al coche:");

							int pasajeroid = sc.nextInt();
							pasajeroAnadir.setPasajeroid(pasajeroid);
							
							
							boolean anadirPasajero = dp.anadirACoche(pasajeroAnadir);

							if (anadirPasajero) {
								System.out.println("El pasajero se ha anadido");
							} else {
								System.out.println("El pasajero NO se ha anadido");
							}
							
							
							break;
							
						// ------- ELIMINAR PASAJERO DE UN COCHE -------	
							
						case 6:
							System.out.println("Estos son los coches disponibles:");
							listarCoches();
							System.out.println("De que coche deseas eliminar un pasajero: (ID)");
							int idCoche=sc.nextInt();
							System.out.println("Estos son los pasajeros de ese coche:");
							listarPasajeros(idCoche);
							System.out.println("Que pasajero deseas eliminar: (ID)");
							int idPasajero=sc.nextInt();
							Pasajero pasajeroEliminar = new Pasajero();
							pasajeroEliminar.setPasajeroid(idPasajero);
							boolean borrarPasajero = dp.eliminarDeCoche(pasajeroEliminar);

							if (borrarPasajero) {
								System.out.println("El pasajero se ha eliminado");
							} else {
								System.out.println("El pasajero NO se ha eliminado");
							}
							
							
							
							break;
							
						// ------- LISTAR PASAJEROS DE UN COCHE -------	
							
						case 7:
							System.out.println("Introduce el ID del coche:");
							int idCocheListar=sc.nextInt(); 
							listarPasajeros(idCocheListar);
							
							
							break;
							
						// ------- SALIR DEL PROGRAMA -------
							
						case 8:
							continuar2 = false;
							System.out.println("Saliendo del gestor de pasajaros...");
							break;
						default:
							System.out.println("Elija una de las opciones...");
							
						}
						
					} while (continuar2);
					
					break;

				// ------- SALIR DEL PROGRAMA -------

				case 7:
					continuar = false;
					System.out.println("Fin del programa. Gracias por su tiempo.");
					break;
				default:
					System.out.println("Elija una de las 6 opciones...");
				}

			} while (continuar);

			// Captura las posibles excepciones del programa
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}

	}

	private static void escribirMenu() {
		System.out.println("Elija una de las siguientes opciones:");
		System.out.println("1. Anadir nuevo coche");
		System.out.println("2. Borrar coche por ID");
		System.out.println("3. Consulta coche por ID");
		System.out.println("4. Modificar coche por ID");
		System.out.println("5. Listado de coches");
		System.out.println("6. Acceder al gestor de pasajeros");
		System.out.println("7. Terminar el programa");

	}
	
	private static void escribirSubMenu() {
		System.out.println("Elija una de las siguientes opciones:");
		System.out.println("1. Anadir nuevo pasajero");
		System.out.println("2. Borrar pasajero por ID");
		System.out.println("3. Consulta pasajero por ID");
		System.out.println("4. Listar todos los pasajeros");	
		System.out.println("5. Anadir pasajero a un coche por ID");
		System.out.println("6. Eliminar pasajero de un coche por ID");
		System.out.println("7. Listar todos los pasajeros de un coche por ID");
		System.out.println("8. Volver al gestor de coches");

	}
	
	private static void listarCoches() {
		
		List<Coche> listaCoches = dc.Listar();
		for (Coche c : listaCoches) {
			System.out.println(c);
		}
		
	}
	
	private static void listarPasajeros() {
		List<Pasajero> listaPasajeros = dp.Listar();
		for (Pasajero p: listaPasajeros) {
			System.out.println(p);
		}
	}
	
	private static void listarPasajeros(int id) {
		List<Pasajero> listaPasajeros = dp.ListarPasajeros(id);
		for (Pasajero p: listaPasajeros) {
			System.out.println(p);
		}
	}

}
