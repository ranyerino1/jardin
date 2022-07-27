/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import JavaMail.PropiedadesCorreo;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBd;

/**
 *
 * @author Sena
 */
public class UsuarioDAO extends ConexionBd implements Crud {

    //1. Declarar variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String usuId = "", usuLogin = "", usuPassword = "", estado="";

    //2. Metodo principal para recibir datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        //2.1 Conectarte
        try {
            conexion = this.obtenerConexion();

            //2.2  Traigo los datos del VO
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
            estado = usuVO.getEstado();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {

        try {
            sql = "insert into usuario(NOM_USUA,CONTR_USUA, USU_EST) values (?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, estado);
            puente.executeUpdate();
            operacion = true;
            
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set usuLogin=?,usuPassword=? where usuId=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;
            

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "delete usuario set usuLogin=?,usuPassword=? where usuId=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }
    RolVO rolVO = new RolVO();
    
    

    public boolean inicioSesion(String usuLogin, String usuPassword) {
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT NOM_USUA, CONTR_USUA FROM usuario WHERE NOM_USUA=? AND CONTR_USUA=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }
    
    public ArrayList<UsuarioVO> listar() {
        ArrayList<UsuarioVO> listarUsuarios = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

              UsuarioVO  usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
              listarUsuarios.add(usuVO);
              
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarUsuarios;
    }

    public Object agregarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
