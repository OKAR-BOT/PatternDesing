package capaModelo;

import java.sql.Date;

/**
 *
 * @author georg
 */
public class Historial {
    private int id;
    private int usuarioId; // ID del usuario relacionado
    private String tipoCalculo;
    private double resultado;
    private Date fechaCalculo;

    // Constructor
    public Historial(int id, int usuarioId, String tipoCalculo, double resultado, Date fechaCalculo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipoCalculo = tipoCalculo;
        this.resultado = resultado;
        this.fechaCalculo = fechaCalculo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(String tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "id=" + getId() +
                ", usuarioId=" + getUsuarioId() +
                ", tipoCalculo='" + getTipoCalculo() + '\'' +
                ", resultado=" + getResultado() +
                ", fechaCalculo=" + getFechaCalculo() +
                '}';
    }
}
