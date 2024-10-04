
package capaModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialDAO implements IHistorialDAO {
    private Connection connection;

    public HistorialDAO() {
        this.connection = ConexionSingleton.obtenerInstancia().getConexion();
    }

    @Override
    public void insertarHistorial(Historial historial) {
        String sql = "INSERT INTO Historial (UsuarioID, tipoCalculo, resultado, fechaCalculo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, historial.getUsuarioId());
            ps.setString(2, historial.getTipoCalculo());
            ps.setDouble(3, historial.getResultado()); // Usa setDouble para el resultado
            ps.setDate(4, historial.getFechaCalculo()); // Usa setDate para la fecha
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Historial obtenerHistorial(int id) {
        String sql = "SELECT * FROM Historial WHERE id = ?";
        Historial historial = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("UsuarioID"),
                        rs.getString("tipoCalculo"),
                        rs.getDouble("resultado"), // Usa getDouble para el resultado
                        rs.getDate("fechaCalculo") // Usa getDate para la fecha
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historial;
    }

    @Override
    public void actualizarHistorial(Historial historial) {
        String sql = "UPDATE Historial SET UsuarioID = ?, tipoCalculo = ?, resultado = ?, fechaCalculo = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, historial.getUsuarioId());
            ps.setString(2, historial.getTipoCalculo());
            ps.setDouble(3, historial.getResultado()); // Usa setDouble para el resultado
            ps.setDate(4, historial.getFechaCalculo()); // Usa setDate para la fecha
            ps.setInt(5, historial.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarHistorial(int id) {
        String sql = "DELETE FROM Historial WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Historial> obtenerHistorialPorUsuario(int usuarioId) {
        List<Historial> historialList = new ArrayList<>();
        String sql = "SELECT * FROM Historial WHERE UsuarioID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, usuarioId); // Establece el parámetro para el usuario
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Historial historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("UsuarioID"),
                        rs.getString("tipoCalculo"),
                        rs.getDouble("resultado"),
                        rs.getDate("fechaCalculo")
                );
                historialList.add(historial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historialList;
    }
}