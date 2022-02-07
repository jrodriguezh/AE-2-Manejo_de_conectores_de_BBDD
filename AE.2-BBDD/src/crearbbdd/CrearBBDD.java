package crearbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearBBDD {


	public static void main(String[] args) throws SQLException {
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = ""; 
		Connection con;
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexion con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexion con la Base de datos");
			
		try {

			con.setAutoCommit(false);

			String sql = "CREATE SCHEMA ALMACEN_COCHES";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			System.out.println("Creado esquema Almacen_Coches");
			String sql2 = "USE ALMACEN_COCHES";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.execute();
			System.out.println("Creando tablas en Almacen coches...");
			String sql3 = "CREATE TABLE coches (cocheID int(11) NOT NULL AUTO_INCREMENT, matricula varchar(45) DEFAULT NULL, marca varchar(45) DEFAULT NULL, modelo varchar(45) DEFAULT NULL, color varchar(45) DEFAULT NULL, PRIMARY KEY (cocheID))";
			PreparedStatement ps3 = con.prepareStatement(sql3);
			ps3.execute();
			System.out.println("Creada la tabla: coches, con los atributos: ID, matricula, marca, modelo y color");
			String sql4 = "CREATE TABLE pasajeros ( pasajeroID int(11) NOT NULL AUTO_INCREMENT, nombre varchar(45) DEFAULT NULL, edad int(3) DEFAULT NULL, peso double DEFAULT NULL, cocheID  int(11), PRIMARY KEY (pasajeroID), FOREIGN KEY (cocheID) REFERENCES coches(cocheID))";
			PreparedStatement ps4 = con.prepareStatement(sql4);
			ps4.execute();
			System.out.println(
					"Creada la tabla: pasajeros, con los atributos: ID, Nombre, Edad, peso y su relación con la tabla coches a través del CocheID.");

			con.commit();
			
			System.out.println("Todos los datos han sido cargados en la BBDD de forma satisfactoria");

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al ejecutar la transaccion");
			System.out.println(e.getMessage()); 
			con.rollback();
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexion con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");
	}
	
}