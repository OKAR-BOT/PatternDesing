
package capaVista;

import capaModelo.*;
import CapaControl.ControlFacade;
import java.sql.Date;
import java.util.Calendar;


public class GOProyectoDP {

    public static void main(String[] args) {
 ConexionSingleton conexion = ConexionSingleton.obtenerInstancia();

  // Instancia de ControlFacade
        ControlFacade controlFacade = new ControlFacade();
        
        // Eliminar todos los usuarios y resetear el ID
        IUsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario(0, "Ana Gomez", 25, 'F', new Date(Calendar.getInstance().getTimeInMillis()));

        // Registrar el usuario
        controlFacade.registrarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente.");

        // Hacer la consulta para obtener el usuario por ID
        Usuario usuarioObtenido = controlFacade.obtenerUsuario(1);
        if (usuarioObtenido != null) {
            System.out.println(usuarioObtenido);  // Imprime usando toString() si ya lo tienes
        } else {
            System.out.println("No se encontró el usuario.");
        }
        
        ConexionSingleton.obtenerInstancia().cerrarConexion();

    }
}
