package CapaControl;

import capaModelo.DAOFactory; // Asegúrate de que esta importación esté correcta
import capaModelo.IUsuarioDAO;
import capaModelo.IMedicionDAO;
import capaModelo.IHistorialDAO;
import capaModelo.Usuario;
import capaModelo.Medicion;
import capaModelo.Historial;

public class RegistroControl {
    private static RegistroControl instancia;
    private IUsuarioDAO usuarioDAO;
    private IMedicionDAO medicionDAO;
    private IHistorialDAO historialDAO;

    // Constructor privado
    private RegistroControl() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        medicionDAO = DAOFactory.getMedicionDAO();
        historialDAO = DAOFactory.getHistorialDAO();
    }

    // Método para obtener la única instancia de RegistroControl
    public static RegistroControl obtenerInstancia() {
        if (instancia == null) {
            instancia = new RegistroControl();
        }
        return instancia;
    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.insertarUsuario(usuario);
    }

    // Método para registrar una nueva medición
    public void registrarMedicion(Medicion medicion) {
        medicionDAO.insertarMedicion(medicion);
    }

    // Método para registrar un historial
    public void registrarHistorial(Historial historial) {
        historialDAO.insertarHistorial(historial);
    }
}
