/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.EventoDTO;
import itson.ticketwizard.entidades.Evento;
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
public class EventoDAO {
    private ManejadorConexiones manejadorConexiones;
    
    public EventoDAO(ManejadorConexiones manejadorConexiones){
        this.manejadorConexiones = manejadorConexiones;
    }
    
    public List <Evento> obtenerEventos(){
        String codigoSQL = """
                            SELECT 
                            	nombre, 
                                nombreLocal, 
                                descripcion, 
                                fechaHora, 
                                ciudad, 
                                calle, 
                                colonia, 
                                codigoPostal 
                            FROM Eventos;
                           """;
                            List <Evento> listaEventos = new LinkedList<>();
                            
                           try{
                               Connection conexion = this.manejadorConexiones.crearConexion();
                               PreparedStatement comando = conexion.prepareStatement(codigoSQL);
                               ResultSet resultadosConsulta = comando.executeQuery();
                               
                               // Nos movemos a cada una de las filas devueltas
                               while(resultadosConsulta.next()){
                                   // Estamos dentro de una fila
                                   Integer codigo = resultadosConsulta.getInt("idEvento");
                                   String nombre = resultadosConsulta.getString("nombre");
                                   String nombreLocal = resultadosConsulta.getString("nombreLocal");
                                   String descripcion = resultadosConsulta.getString("descripcion");
                                   Date fechaHora = resultadosConsulta.getDate("fechaHora");
                                   String ciudad = resultadosConsulta.getString("ciudad");
                                   String calle = resultadosConsulta.getString("calle");
                                   String colonia = resultadosConsulta.getString("colonia");
                                   String codigoPostal = resultadosConsulta.getString("codigoPostal");
                                   
                                   
                                   // Paquete donde empaquetaras los datos
                                   Evento evento = new Evento(nombre, nombreLocal, descripcion, fechaHora, ciudad, calle, colonia, codigoPostal);
                                   listaEventos.add(evento);
                               }
                               
                           } catch (SQLException ex){
                               System.err.println("Erros la consultar los artistas: " + ex.getMessage());
                           }    
                            return listaEventos;
    }
}
