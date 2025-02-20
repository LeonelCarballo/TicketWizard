/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.sql.Date;

/**
 *
 * @author Dana Chavez
 */
public class Evento {
    
    private Integer idEvento;
    private String nombre;
    private String nombreLocal;
    private String descripcion;
    private Date fechaHora;
    private String ciudad;
    private String calle;
    private String colonia;
    private String codigoPostal;
    
    public Evento() {
    }

    public Evento(String nombre, String nombreLocal, String descripcion, Date fechaHora, String ciudad, String calle, String colonia, String codigoPostal) {
        this.nombre = nombre;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }
      
    public Evento(Integer idEvento, String nombre, String nombreLocal, String descripcion, Date fechaHora, String ciudad, String calle, String colonia, String codigoPostal) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idEvento;
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
        final Evento other = (Evento) obj;
        return this.idEvento == other.idEvento;
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaHora=" + fechaHora + ", ciudad=" + ciudad + ", calle=" + calle + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
    
    
    
}
