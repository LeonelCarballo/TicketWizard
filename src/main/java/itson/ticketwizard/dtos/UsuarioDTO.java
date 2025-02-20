/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dtos;

import java.sql.Date;

/**
 *
 * @author Dana Chavez
 */

public class UsuarioDTO {
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private String calle;
    private Integer numeroCasa;
    private String colonia;
    private Date fechaNac;
    private String numTelefono;
    private String correoElectronico;
    private String contrasena;
    private Float saldo;

    public UsuarioDTO(String nombres, String apellidoP, String apellidoM, String calle, int numeroCasa, String colonia, Date fechaNac, String numTelefono, String correoElectronico, String contrasena, Float saldo) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.calle = calle;
        this.numeroCasa = numeroCasa;
        this.colonia = colonia;
        this.fechaNac = fechaNac;
        this.numTelefono = numTelefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
         
}
