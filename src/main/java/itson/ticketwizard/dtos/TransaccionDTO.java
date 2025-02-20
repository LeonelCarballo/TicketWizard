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

    public class TransaccionDTO {
        private Date fechahora;
        private float monto;
        private float comision;

        public TransaccionDTO(Date fechahora, float monto, float comision) {
            this.fechahora = fechahora;
            this.monto = monto;
            this.comision = comision;
        }

        public Date getFechahora() {
            return fechahora;
        }

        public void setFechahora(Date fechahora) {
            this.fechahora = fechahora;
        }

        public float getMonto() {
            return monto;
        }

        public void setMonto(float monto) {
            this.monto = monto;
        }

        public float getComision() {
            return comision;
        }

        public void setComision(float comision) {
            this.comision = comision;
        }


    }
