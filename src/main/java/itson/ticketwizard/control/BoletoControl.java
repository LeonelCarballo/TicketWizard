
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.persistencia.BoletoDAO;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class BoletoControl {
    private BoletoDAO boletoDAO;

    public BoletoControl() {
        this.boletoDAO = new BoletoDAO();
    }

    public List<Boleto> obtenerBoletosDisponibles(int idEvento) {
        return boletoDAO.consultarBoletosDisponibles(idEvento);
    }

    public Boleto obtenerBoletoPorNumSerie(int numSerie) {
        List<Boleto> boletos = boletoDAO.consultarBoletosNumSerie(numSerie);
        return boletos.isEmpty() ? null : boletos.get(0);
    }

    public boolean cambiarEstadoBoleto(int numSerie, String nuevoEstado) {
        return boletoDAO.actualizarEstadoBoleto(numSerie, nuevoEstado);
    }
}