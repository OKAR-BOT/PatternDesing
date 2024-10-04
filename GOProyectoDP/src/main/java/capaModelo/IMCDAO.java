
package capaModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IMCDAO implements IIMCDAO {
    private Connection connection;

     public IMCDAO() {
        this.connection = ConexionSingleton.obtenerInstancia().getConexion();
    }

    @Override
    public void insertarIMC(IMC imc) {
        String sql = "INSERT INTO IMC (MedicionID, imc, fechaCalculo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, imc.getMedicionId());
            ps.setDouble(2, imc.getImc()); // Asegúrate de usar setDouble
            ps.setDate(3, imc.getFechaCalculo()); // Asegúrate de usar setDate
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IMC obtenerIMC(int id) {
        String sql = "SELECT * FROM IMC WHERE id = ?";
        IMC imc = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                imc = new IMC(
                        rs.getInt("id"),
                        rs.getInt("MedicionID"),
                        rs.getDouble("imc"), // Usa getDouble aquí
                        rs.getDate("fechaCalculo") // Usa getDate aquí
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imc;
    }

    @Override
    public void actualizarIMC(IMC imc) {
        String sql = "UPDATE IMC SET MedicionID = ?, imc = ?, fechaCalculo = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, imc.getMedicionId());
            ps.setDouble(2, imc.getImc()); // Asegúrate de usar setDouble
            ps.setDate(3, imc.getFechaCalculo()); // Asegúrate de usar setDate
            ps.setInt(4, imc.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarIMC(int id) {
        String sql = "DELETE FROM IMC WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<IMC> obtenerTodosLosIMC() {
        List<IMC> imcs = new ArrayList<>();
        String sql = "SELECT * FROM IMC";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IMC imc = new IMC(
                        rs.getInt("id"),
                        rs.getInt("MedicionID"),
                        rs.getDouble("imc"), // Usa getDouble aquí
                        rs.getDate("fechaCalculo") // Usa getDate aquí
                );
                imcs.add(imc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imcs;
    }
}