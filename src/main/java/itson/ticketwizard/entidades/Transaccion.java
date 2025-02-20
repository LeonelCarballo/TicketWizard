/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Dana Chavez
 */
public class Transaccion {
    
    private Integer idTransaccion;
    private Date fechaHora;
    private Float monto;
    private Float comision;
    private Integer idApartado;
    private Integer idVendedor;
    private Integer idComprador;
    
    public Transaccion() {
    }

    public Transaccion(Date fechaHora, Float monto, Float comision, Integer idApartado, Integer idVendedor, Integer idComprador) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.comision = comision;
        this.idApartado = idApartado;
        this.idVendedor = idVendedor;
        this.idComprador = idComprador;
    }

    public Transaccion(Integer idTransaccion, Date fechaHora, Float monto, Float comision, Integer idApartado, Integer idVendedor, Integer idComprador) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.comision = comision;
        this.idApartado = idApartado;
        this.idVendedor = idVendedor;
        this.idComprador = idComprador;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Integer getIdApartado() {
        return idApartado;
    }

    public void setIdApartado(Integer idApartado) {
        this.idApartado = idApartado;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idTransaccion);
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.idTransaccion, other.idTransaccion);
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", comision=" + comision + ", idApartado=" + idApartado + ", idVendedor=" + idVendedor + ", idComprador=" + idComprador + '}';
    }
    
}
