/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

/**
 *
 * @author Dana Chavez
 */
public class Boleto {
    
    private int numSerie;
    private float precio;
    private int numControl;
    private String disponibilidad;
    private int numAsiento;
    private String fila;
    private int idEvento;
    private int idUsuario;

    public Boleto(int numSerie, float precio, int numControl, String disponibilidad, int numAsiento, String fila, int idEvento, int idUsuario) {
        this.numSerie = numSerie;
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public Boleto(float precio, int numControl, String disponibilidad, int numAsiento, String fila, int idEvento, int idUsuario) {
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public Boleto() {
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.numSerie;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boleto other = (Boleto) obj;
        return this.numSerie == other.numSerie;
    }

    @Override
    public String toString() {
        return "Boleto{" + "numSerie=" + numSerie + ", precio=" + precio + ", numControl=" + numControl + ", disponibilidad=" + disponibilidad + ", numAsiento=" + numAsiento + ", fila=" + fila + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario + '}';
    }
    
    
    
}
