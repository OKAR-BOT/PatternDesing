package capaModelo;

import java.sql.Date;

/**
 *
 * @author georg
 */
public class IMC {
    private int id;
    private int medicionId; // ID de la medición relacionada
    private double imc;
    private Date fechaCalculo;

    // Constructor
    public IMC(int id, int medicionId, double imc, Date fechaCalculo) {
        this.id = id;
        this.medicionId = medicionId;
        this.imc = imc;
        this.fechaCalculo = fechaCalculo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicionId() {
        return medicionId;
    }

    public void setMedicionId(int medicionId) {
        this.medicionId = medicionId;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    @Override
    public String toString() {
        return "IMC{" +
                "id=" + getId() +
                ", medicionId=" + getMedicionId() +
                ", imc=" + getImc() +
                ", fechaCalculo=" + getFechaCalculo() +
                '}';
    }
}
