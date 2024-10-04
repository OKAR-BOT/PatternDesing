/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAO implements IMedicionDAO {
    private Connection connection;

    public MedicionDAO() {
        this.connection = ConexionSingleton.obtenerInstancia().getConexion();;
    }



    @Override
    public void insertarMedicion(Medicion medicion) {
        String sql = "INSERT INTO Mediciones (UserID, peso, talla) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, medicion.getUserId());
            ps.setDouble(2, medicion.getPeso()); // Asegúrate de usar setDouble
            ps.setDouble(3, medicion.getTalla()); // Asegúrate de usar setDouble
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medicion obtenerMedicion(int id) {
        String sql = "SELECT * FROM Mediciones WHERE id = ?";
        Medicion medicion = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Asegúrate de usar getDouble para obtener los valores de decimal
                medicion = new Medicion(
                        rs.getInt("id"),
                        rs.getInt("UserID"),
                        rs.getDouble("peso"), // Usa getDouble aquí
                        rs.getDouble("talla")  // Usa getDouble aquí
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicion;
    }

    @Override
    public void actualizarMedicion(Medicion medicion) {
        String sql = "UPDATE Mediciones SET UserID = ?, peso = ?, talla = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, medicion.getUserId());
            ps.setDouble(2, medicion.getPeso()); // Asegúrate de usar setDouble
            ps.setDouble(3, medicion.getTalla()); // Asegúrate de usar setDouble
            ps.setInt(4, medicion.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarMedicion(int id) {
        String sql = "DELETE FROM Mediciones WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
     public List<Medicion> obtenerMedicionesPorUsuario(int userId) {
        List<Medicion> mediciones = new ArrayList<>();
        String sql = "SELECT * FROM Mediciones WHERE UserID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);  // Establecer el parámetro de usuario
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicion medicion = new Medicion(
                        rs.getInt("id"),
                        rs.getInt("UserID"),
                        rs.getDouble("peso"),
                        rs.getDouble("talla")
                );
                mediciones.add(medicion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediciones;
    }
}