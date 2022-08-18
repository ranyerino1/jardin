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

    private String usuId="", usuLogin="", usuPassword="", nombre_usuario1="", nombre_usuario2="", apellido_usuario1="", apellido_usuario2="", 
                   numDocument_usuario="", tipo_usua="", tele_usua="", direc_usua="", correo_usua="", fechanaci_usua="", estado="";

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
            nombre_usuario1 = usuVO.getNombre_usuario1();
            nombre_usuario2 = usuVO.getNombre_usuario2();
            apellido_usuario1 = usuVO.getApellido_usuario1();
            apellido_usuario2 = usuVO.getApellido_usuario2();
            numDocument_usuario = usuVO.getNumDocument_usuario();
            tipo_usua = usuVO.getTipo_usua();
            tele_usua = usuVO.getTele_usua();
            direc_usua = usuVO.getDirec_usua();
            correo_usua = usuVO.getCorreo_usua();
            fechanaci_usua = usuVO.getFechanaci_usua();
            estado = usuVO.getEstado();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {

        try {
            sql = "insert into usuario(NOM_USUARIO,CONTRASENA, ESTA_USUA) values (?,?,?)";
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
    
        public boolean completarPerfil(String nombre1, String nombre2, String apellido1, String apellido2, String numDocu, 
                                       String tipoDocu, String numTel, String direccion, String correo, String fecha, String usuId) {

        try {
            sql = "UPDATE usuario SET 1NOM_USUA=?, 2NOM_USUA=?, 1APEL_USUA=?, 2APEL_USUA=?, NUMDOCU_USUA=?, TIPO_USUA=?,"
                   + "TELE_USUA=?, DIREC_USUA=?, CORREO_USUA=?, FECHNACI_USUA=? where ID_USUA=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_usuario1);
            puente.setString(2, nombre_usuario2);
            puente.setString(3, apellido_usuario1);
            puente.setString(4, apellido_usuario2);
            puente.setString(5, numDocument_usuario);
            puente.setString(6, tipo_usua);
            puente.setString(7, tele_usua);
            puente.setString(8, direc_usua);
            puente.setString(9, correo_usua);
            puente.setString(10, fechanaci_usua);
            puente.setString(11, usuId);
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
            sql = "SELECT NOM_USUARIO, CONTRASENA FROM usuario WHERE NOM_USUARIO=? AND CONTRASENA=?";
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

              UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                                          mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10),
                                          mensajero.getString(11), mensajero.getString(12), mensajero.getString(13), mensajero.getString(14));
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
