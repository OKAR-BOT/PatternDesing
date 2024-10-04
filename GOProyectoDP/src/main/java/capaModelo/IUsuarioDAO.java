/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaModelo;

import capaModelo.Usuario;
import java.util.List;


public interface IUsuarioDAO {
    void insertarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int id);
    Usuario obtenerUsuario(int id);
    List<Usuario> obtenerTodosLosUsuarios();
}
