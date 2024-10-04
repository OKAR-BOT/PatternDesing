
package capaModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    
    private Connection conexion;

    public UsuarioDAO() {
        this.conexion = ConexionSingleton.obtenerInstancia().getConexion();
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        String sql = "{call GestionarUsuario('Insertar', NULL, ?, ?, ?, ?)}";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setString(3, String.valueOf(usuario.getSexo()));
            ps.setDate(4, usuario.getFechaRegistro());
            ps.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        String sql = "{call GestionarUsuario('Obtener', ?, NULL, NULL, NULL, NULL)}";
        Usuario usuario = null;
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getInt("Edad"),
                    rs.getString("Sexo").charAt(0),
                    rs.getDate("FechaRegistro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void eliminarUsuario(int id) {
        String sql = "{call GestionarUsuario('Eliminar', ?, NULL, NULL, NULL, NULL)}";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String query = "EXEC GestionarUsuario 'Actualizar', ?, ?, ?, ?, ?";
    try (PreparedStatement ps = conexion.prepareStatement(query)) {
        ps.setInt(1, usuario.getId());  // Asigna el ID del usuario a actualizar
        ps.setString(2, usuario.getNombre());
        ps.setInt(3, usuario.getEdad());
        ps.setString(4, String.valueOf(usuario.getSexo())); // Convertimos el char en String
        ps.setDate(5, usuario.getFechaRegistro());
        ps.executeUpdate();
        System.out.println("Usuario actualizado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
       String query = "EXEC GestionarUsuario 'ObtenerTodos'";
    List<Usuario> usuarios = new ArrayList<>();
    try (PreparedStatement ps = conexion.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt("id"),
                rs.getString("Nombre"),
                rs.getInt("edad"),
                rs.getString("sexo").charAt(0),  // Convertir a char el valor del sexo
                rs.getDate("fechaRegistro")
            );
            usuarios.add(usuario);
        }
        System.out.println("Usuarios obtenidos exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return usuarios;    
    }
}
