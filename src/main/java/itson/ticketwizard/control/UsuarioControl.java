/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.persistencia.UsuarioDAO;
import java.sql.SQLException;



public class UsuarioControl {

    private UsuarioDAO usuarioDAO;

    public UsuarioControl() {
        this.usuarioDAO = new UsuarioDAO();
    }


    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario) throws SQLException {
        return usuarioDAO.obtenerUsuarioId(idUsuario);
    }


    public boolean actualizarSaldoUsuario(Integer idUsuario, float monto) {
        return usuarioDAO.actualizarSaldo(idUsuario, monto);
    }


    public UsuarioDTO validarCredenciales(String correoElectronico, String contrasena) throws SQLException {
        return usuarioDAO.validarCredenciales(correoElectronico, contrasena);
    }


    public boolean registrarUsuario(UsuarioDTO usuarioDTO) throws SQLException {
        return usuarioDAO.registrarUsuario(usuarioDTO);
    }
}
