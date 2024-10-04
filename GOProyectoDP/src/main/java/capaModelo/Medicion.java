package capaModelo;

import java.sql.Date;

/**
 *
 * @author georg
 */
public class Medicion {
    private int id;
    private int userId; // ID del usuario relacionado
    private double peso;
    private double talla;

    // Constructor
    public Medicion(int id, int userId, double peso, double talla) {
        this.id = id;
        this.userId = userId;
        this.peso = peso;
        this.talla = talla;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                "id=" + getId() +
                ", userId=" + getUserId() +
                ", peso=" + getPeso() +
                ", talla=" + getTalla() +
                '}';
    }
}
