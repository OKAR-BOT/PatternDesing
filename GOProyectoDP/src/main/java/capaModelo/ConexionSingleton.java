
package capaModelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {

    // Variables para la conexión
    private String usuario = "usersql";
    private String contrasenia = "root";
    private String bd = "BDProyecto";
    private String ip = "localhost";
    private String puerto = "1433";

    // La única instancia de la clase
    private static ConexionSingleton instancia;
    private Connection conexion;

    // Constructor privado para evitar la instanciación directa
    private ConexionSingleton() {
        String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd;

        try {
            // Establece la conexión usando DriverManager
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
            System.out.println("Conexión establecida con SQL Server");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos SQL Server");
            e.printStackTrace();
        }
    }

    // Método público y estático para obtener la única instancia de la clase
    public static ConexionSingleton obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionSingleton();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
