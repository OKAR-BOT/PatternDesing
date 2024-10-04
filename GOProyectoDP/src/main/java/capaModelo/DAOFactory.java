/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaModelo;

/**
 *
 * @author georg
 */
public class DAOFactory {
    
     public static IUsuarioDAO getUsuarioDAO() {
       return new UsuarioDAO();
    }
     public static IMedicionDAO getMedicionDAO() {
        return new MedicionDAO();
    }

    public static IIMCDAO getIMCDAO() {
        return new IMCDAO();
    }

    public static IHistorialDAO getHistorialDAO() {
        return new HistorialDAO();
    }
}
