/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.TransaccionDTO;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.persistencia.TransaccionDAO;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Dana Chavez
 */
public class TransaccionControl {
    
    private final TransaccionDAO transaccionDAO;
    private final BoletoDAO boletoDAO;
    
    public TransaccionControl() {
        this.transaccionDAO = new TransaccionDAO();
        this.boletoDAO = new BoletoDAO();
    }
    
    public boolean comprarBoleto(int idComprador, int numSerieBoleto) {
        // Obtener el boleto desde la base de datos
        BoletoDTO boleto = boletoDAO.obtenerBoletoPorNumSerie(numSerieBoleto);
        if (boleto == null || !boleto.getDisponibilidad().equals("Disponible") && !boleto.getDisponibilidad().equals("Reventa")) {
            System.out.println("El boleto no está disponible para la venta.");
            return false;
        }
        
        // Calcular el monto y la comisión
        float precioBase = boleto.getPrecio();
        float comision = boleto.getDisponibilidad().equals("Reventa") ? (float) (precioBase * 0.03) : 0;
        float montoTotal = precioBase + comision;
        
        LocalDate fechaHoy = LocalDate.now();
        Date fechaSQL = Date.valueOf(fechaHoy);

        // Registrar la transacción
        TransaccionDTO transaccion = new TransaccionDTO(
            
            fechaSQL,
            montoTotal,
            comision,
            0,
            boleto.getIdUsuario(), 
            idComprador
        );
        
        boolean transaccionExitosa = transaccionDAO.registrarTransaccion(transaccion);

        if (transaccionExitosa) {
                boletoDAO.actualizarEstadoBoleto(numSerieBoleto, "Reservado");

                transaccionDAO.actualizarSaldo(idComprador, -montoTotal); 

                transaccionDAO.actualizarSaldo(boleto.getIdUsuario(), precioBase); 

                return true;
            }

            return false;
        }
    
    }

