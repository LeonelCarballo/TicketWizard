
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author payde
 */
public class UsuarioDAO {
    
    private ManejadorConexiones manejadorConexiones;

    public UsuarioDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
    
    public UsuarioDTO obtenerUsuarioId(Integer idUsuario) throws SQLException{
        String codigoSQL = """
                           SELECT 
                                nombres,
                                apellidoP,
                                apellidoM,
                                calle,
                                numeroCasa,
                                colonia,
                                fechaNacimiento,
                                numTelefono,
                                correoElectronico,
                                contrasena,
                                saldo
                           FROM Usuarios WHERE idUsuario = ?;
                           """;
                            try{
                                Connection conexion = this.manejadorConexiones.crearConexion();
                                PreparedStatement comando = conexion.prepareStatement(codigoSQL);
                            
                               
                                comando.setInt(1, idUsuario);
                                ResultSet resultadosConsulta = comando.executeQuery();
                                
                                if(resultadosConsulta.next()){
                                    return new UsuarioDTO(
                                        resultadosConsulta.getString("nombres"),
                                        resultadosConsulta.getString("apellidoP"),
                                        resultadosConsulta.getString("apellidoM"),
                                        resultadosConsulta.getString("calle"),
                                        resultadosConsulta.getInt("numeroCasa"),
                                        resultadosConsulta.getString("colonia"),
                                        resultadosConsulta.getDate("fechaNacimiento"),
                                        resultadosConsulta.getString("numTelefono"),
                                        resultadosConsulta.getString("correoElectronico"),
                                        resultadosConsulta.getString("contrasena"),
                                        resultadosConsulta.getFloat("saldo")
                                    );
                                }
                            }   catch (SQLException ex){
                                    System.err.println("Error al consultar los usuarios: " + ex.getMessage());
                                }
                                
                                return null;
        }
    
        public boolean actualizarSaldo(Integer idUsuario, float monto){
            
            String codigoSQL = "UPDATE Usuario SET saldo = saldo + ? WHERE idUsuario = ?";
            try{
                Connection conexion = this.manejadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);
                
                comando.setFloat(1,monto);
                comando.setInt(2, idUsuario);
                
                return comando.executeUpdate() > 0;
                
            } catch (SQLException ex){
                System.err.println("Error al consultar las transacciones: " + ex.getMessage());
            }
            return false;

        }
    }


                                                           