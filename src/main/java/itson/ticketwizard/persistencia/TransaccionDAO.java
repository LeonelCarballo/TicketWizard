
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.TransaccionDTO;
import itson.ticketwizard.entidades.Transaccion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class TransaccionDAO {
    
    private final ManejadorConexiones manejadorConexiones;

    public TransaccionDAO() {
        this.manejadorConexiones = new ManejadorConexiones();
    }
    
    public boolean registrarTransaccion(TransaccionDTO transaccionDTO) {
        String codigoSQL = """
                           INSERT INTO Transacciones(
                           fechaHora,
                           monto,
                           comision,
                           idApartado,
                           idVendedor,
                           idComprador
                           )
                           VALUES(?,?,?,?,?,?);                       
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion(); 
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setDate(1,transaccionDTO.getFechahora());
            comando.setFloat(2, transaccionDTO.getMonto());
            comando.setFloat(3,transaccionDTO.getComision());
            
            int filasAfectadas = comando.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException ex){
            System.err.println("Error al registrar la transaccion: " + ex.getMessage());
            return false;
        }
        
    }
    
    public List <Transaccion> consultarTransaccionesPorUsuario(Integer idUsuario){
        String codigoSQL = """
                            SELECT
                                idTransaccion,
                                fechaHora,
                                monto,
                                comision,
                                idApartado,
                                idVendedor,
                                idComprador
                           FROM Transacciones WHERE idComprador = ? OR idVendedor = ?;
                           """;
                            List <Transaccion> listaTransacciones = new LinkedList<>();
                           try{
                               Connection conexion = this.manejadorConexiones.crearConexion();
                               PreparedStatement comando = conexion.prepareStatement(codigoSQL);
                               ResultSet resultadosConsulta = comando.executeQuery();
                               
                                comando.setInt(1, idUsuario);
                                comando.setInt(2, idUsuario);
                               
                               // Nos movemos a cada una de las filas devueltas
                               while(resultadosConsulta.next()){
                                   // Estamos dentro de una fila
                                   Integer idTransaccion = resultadosConsulta.getInt("idTransaccion");
                                   Date fechaHora = resultadosConsulta.getDate("fechaHora");
                                   Float monto = resultadosConsulta.getFloat("monto");
                                   Float comision = resultadosConsulta.getFloat("comision");
                                   Integer idApartado = resultadosConsulta.getInt("idApartado");
                                   Integer idVendedor = resultadosConsulta.getInt("idVendedor");
                                   Integer idComprador = resultadosConsulta.getInt("idComprador");
                                   
                                   // Paquete donde empaquetaras los datos
                                   Transaccion transaccion = new Transaccion(idTransaccion, fechaHora, monto, comision, idApartado, idVendedor, idComprador);
                                   listaTransacciones.add(transaccion);
                               }
                               
                           } catch (SQLException ex){
                               System.err.println("Error al consultar las transacciones: " + ex.getMessage());
                           }    
                            return listaTransacciones;
    }
    
    public boolean actualizarSaldo(int idUsuario, float nuevoSaldo) {
        String codigoSQL = "UPDATE Usuarios SET saldo = ? WHERE idUsuario = ?";
        try (Connection conexion = manejadorConexiones.crearConexion();
             PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {

            comando.setFloat(1, nuevoSaldo);
            comando.setInt(2, idUsuario);

            int filasAfectadas = comando.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            System.err.println("Error al actualizar el saldo: " + ex.getMessage());
            return false;
        }
    }
    
}
