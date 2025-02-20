/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.TransaccionDTO;
import itson.ticketwizard.entidades.Transaccion;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.persistencia.TransaccionDAO;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


    public class TransaccionControl {
        private TransaccionDAO transaccionDAO;

        public TransaccionControl() {
            this.transaccionDAO = new TransaccionDAO();
        }

        public boolean registrarTransaccion(TransaccionDTO transaccionDTO) {
            return transaccionDAO.registrarTransaccion(transaccionDTO);
        }

        public List<Transaccion> obtenerTransaccionesPorUsuario(int idUsuario) {
            return transaccionDAO.consultarTransaccionesPorUsuario(idUsuario);
        }

        public boolean actualizarSaldoUsuario(int idUsuario, float nuevoSaldo) {
            return transaccionDAO.actualizarSaldo(idUsuario, nuevoSaldo);
        }
    }

