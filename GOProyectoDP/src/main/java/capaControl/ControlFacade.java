package CapaControl;


import capaModelo.Medicion; 
import capaModelo.Historial; 
import capaModelo.Usuario; 




import java.util.List;

public class ControlFacade {
    private RegistroControl registroControl;
    private ConsultaControl consultaControl;

public ControlFacade() {
    registroControl = RegistroControl.obtenerInstancia(); // Usa el método obtenerInstancia()
    consultaControl = ConsultaControl.obtenerInstancia(); // Asegúrate de que esto también esté correcto
}

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        registroControl.registrarUsuario(usuario);
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuario(int id) {
        return consultaControl.obtenerUsuario(id);
    }

    // Método para registrar una nueva medición
    public void registrarMedicion(Medicion medicion) {
        registroControl.registrarMedicion(medicion);
    }

    // Método para obtener todas las mediciones de un usuario
    public List<Medicion> obtenerMediciones(int userId) {
        return consultaControl.obtenerMediciones(userId);
    }

    // Método para registrar un historial
    public void registrarHistorial(Historial historial) {
        registroControl.registrarHistorial(historial);
    }

    // Método para obtener el historial de un usuario
    public List<Historial> obtenerHistorial(int usuarioId) {
        return consultaControl.obtenerHistorial(usuarioId);
    }
}
