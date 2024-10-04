/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capaModelo;

import java.util.List;

/**
 *
 * @author georg
 */
public interface IIMCDAO {
    void insertarIMC(IMC imc);
    void actualizarIMC(IMC imc);
    void eliminarIMC(int id);
    IMC obtenerIMC(int id);
    List<IMC> obtenerTodosLosIMC();
}
