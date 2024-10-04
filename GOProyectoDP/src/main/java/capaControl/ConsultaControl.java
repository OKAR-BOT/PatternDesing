package CapaControl;

import capaModelo.*;

import java.util.List;

public class ConsultaControl {
    private static ConsultaControl instancia;
    private IUsuarioDAO usuarioDAO;
    private IMedicionDAO medicionDAO;
    private IHistorialDAO historialDAO;

    // Constructor privado
    private ConsultaControl() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        medicionDAO = DAOFactory.getMedicionDAO();
        historialDAO = DAOFactory.getHistorialDAO();
    }

    // Método para obtener la única instancia de ConsultaControl
    public static ConsultaControl obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConsultaControl();
        }
        return instancia;
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id);
    }

    // Método para obtener todas las mediciones de un usuario
    public List<Medicion> obtenerMediciones(int userId) {
        return medicionDAO.obtenerMedicionesPorUsuario(userId);
    }

    // Método para obtener el historial de un usuario
    public List<Historial> obtenerHistorial(int usuarioId) {
        return historialDAO.obtenerHistorialPorUsuario(usuarioId);
    }
}
