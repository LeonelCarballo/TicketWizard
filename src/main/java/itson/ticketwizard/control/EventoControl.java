/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.persistencia.EventoDAO;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class EventoControl {

    private EventoDAO eventoDAO;
    private BoletoDAO boletoDAO;

    public EventoControl(EventoDAO eventoDAO, BoletoDAO boletoDAO) {
        this.eventoDAO = eventoDAO;
        this.boletoDAO = boletoDAO;
    }


    public List<Evento> obtenerEventos() {
        return eventoDAO.obtenerEventos();
    }

    
    public List<Boleto> consultarBoletosDisponibles(Integer idEventoFiltro) {
        return boletoDAO.consultarBoletosDisponibles(idEventoFiltro);
    }


    public List<Evento> seleccionarEvento(int idEvento) {

        return eventoDAO.obtenerEventos();
    }

    public List<Boleto> seleccionarBoleto(int numSerie) {
        return boletoDAO.consultarBoletosNumSerie(numSerie);
    }
}
