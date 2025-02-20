
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class BoletoDAO {

    private ManejadorConexiones manejadorConexiones;

    public BoletoDAO() {
        this.manejadorConexiones = new  ManejadorConexiones();
    }

    public List<Boleto> consultarBoletosDisponibles(Integer idEventoFiltro) {
        String codigoSQL = """
                            SELECT
                            	numSerie,
                            	idUsuario,
                            	idEvento,
                            	precio,
                            	disponibilidad,
                            	numAsiento,
                            	fila,
                            	numControl
                            FROM 
                            	Boletos 
                            WHERE
                            	(disponibilidad = "Disponible" OR desponibilidad = "Reventa") AND idEvento = ?
                            ;
                           """;
        List<Boleto> listaBoletos = new LinkedList<>();

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setInt(1, idEventoFiltro);

            ResultSet resultadosConsulta = comando.executeQuery();

            // nos movemos a cada una de las filas devueltas
            while (resultadosConsulta.next()) {
                // estamos dentro de una fila
                Integer numSerie = resultadosConsulta.getInt("numSerie");
                Integer idUsuario = resultadosConsulta.getInt("idUsuario");
                Integer idEvento = resultadosConsulta.getInt("idEvento");
                float precio = resultadosConsulta.getFloat("precio");
                String disponibilidad = resultadosConsulta.getString("disponibilidad");
                Integer numeroAsiento = resultadosConsulta.getInt("numeroAsiento");
                String fila = resultadosConsulta.getString("fila");
                Integer numControl = resultadosConsulta.getInt("numControl");

                // paquete donde empaquetaras los datos
                Boleto boletos = new Boleto(numSerie, precio, numControl, disponibilidad, numeroAsiento, fila, idEvento, idUsuario);
                listaBoletos.add(boletos);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar los boletos: " + ex.getMessage());
        }
        return listaBoletos;
    }
//    OBETENER BOLETO POR NUMERO DE SERIE Y ACTUALIZAR ESTADO 

    public List<Boleto> consultarBoletosNumSerie(Integer numSerieFiltro) {
        String codigoSQL = """
                            SELECT
                            	numSerie,
                            	idUsuario,
                            	idEvento,
                            	precio,
                            	disponibilidad,
                            	numAsiento,
                            	fila,
                            	numControl
                            FROM 
                            	Boletos 
                            WHERE
                            	numSerie = ?
                            ;
                           """;
        List<Boleto> listaBoletos = new LinkedList<>();

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, numSerieFiltro);
            
            ResultSet resultadosConsulta = comando.executeQuery();
            
            // nos movemos a cada una de las filas devueltas

            while (resultadosConsulta.next()) {
                // estamos dentro de una fila
                Integer numSerie = resultadosConsulta.getInt("numSerie");
                Integer idUsuario = resultadosConsulta.getInt("idUsuario");
                Integer idEvento = resultadosConsulta.getInt("idEvento");
                float precio = resultadosConsulta.getFloat("precio");
                String disponibilidad = resultadosConsulta.getString("disponibilidad");
                Integer numAsiento = resultadosConsulta.getInt("numAsiento");
                String fila = resultadosConsulta.getString("fila");
                Integer numControl = resultadosConsulta.getInt("numControl");

                // paquete donde empaquetaras los datos
                Boleto boletos = new Boleto(numSerie, precio, numControl, disponibilidad, numAsiento, fila, idEvento, idUsuario);
                listaBoletos.add(boletos);
            }

        } catch (SQLException ex) {
            System.err.println("Erros la consultar los boletos: " + ex.getMessage());
        }
        return listaBoletos;
    }

    public boolean actualizarEstadoBoleto(Integer numSerie, String nuevoEstado) {
        String codigoSQL = """
                        UPDATE Boletos
                        SET disponibilidad = ?
                        WHERE numSerie = ?
                       """;
        try {

            Connection conexion = this.manejadorConexiones.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setString(1, nuevoEstado);
            comando.setInt(2, numSerie);

            int filasAfectadas = comando.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException ex) {
            System.err.println("Error al actualizar el estado del boleto: " + ex.getMessage());
            return false;
        }
    }
    
}