/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dtos;

/**
 *
 * @author Dana Chavez
 */
public class BoletoDTO {
    
    private float precio;
    private Integer numControl;
    private String disponibilidad;
    private Integer numAsiento;
    private String fila;
   
    public BoletoDTO(float precio, int numControl, String disponibilidad, int numAsiento, String fila) {
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        
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

    public void setNumControl(Integer numControl) {
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

 }