
package capaModelo;

import java.util.List;

/**
 *
 * @author georg
 */
public interface IHistorialDAO {
    void insertarHistorial(Historial historial);
    void actualizarHistorial(Historial historial);
    void eliminarHistorial(int id);
    Historial obtenerHistorial(int id);
    List<Historial> obtenerHistorialPorUsuario(int usuarioId);
}
