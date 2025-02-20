
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
    
    public BoletoDAO(){
        this.manejadorConexiones = manejadorConexiones;
    }
    
    public List <Boleto> consultarArtistas(){
        String codigoSQL = """
                            SELECT
                                codigoArtista,
                                nombre,
                                nacionalidad,
                                tipo,
                                añoInicio
                           FROM artistasNuevos;
                           """;
                            List <Boleto> listaBoletos = new LinkedList<>();
                           try{
                               Connection conexion = this.manejadorConexiones.crearConexion();
                               PreparedStatement comando = conexion.prepareStatement(codigoSQL);
                               ResultSet resultadosConsulta = comando.executeQuery();
                               // nos movemos a cada una de las filas devueltas
                               while(resultadosConsulta.next()){
                                   // estamos dentro de una fila
                                   Integer numSerie = resultadosConsulta.getInt("numSerie");
                                   String nombreDueño = resultadosConsulta.getString("idUsuario");
                                   float precio = resultadosConsulta.getFloat("precio");
                                   String disponibilidad = resultadosConsulta.getString("disponibilidad");
                                   Integer numeroAsiento = resultadosConsulta.getInt("numeroAsiento");
                                   String fila = resultadosConsulta.getString("fila");
                                   Integer numControl = resultadosConsulta.getInt("numControl");
                                   
                                   // paquete donde empaquetaras los datos
                                   Boleto boletos = new Boleto(numSerie,nombreDueño,precio,disponibilidad,numeroAsiento,fila,numControl);
                                   listaBoletos.add(boletos);
                               }
                               
                           } catch (SQLException ex){
                               System.err.println("Erros la consultar los artistas: " + ex.getMessage());
                           }    
                            return listaBoletos;
    }
    
}
