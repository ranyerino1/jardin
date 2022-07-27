/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
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
 * @author alrod
 */
public class RolDAO extends ConexionBd implements Crud {

    //1. Declarar variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String rolId = "", rolTipo = "";
    
    public RolDAO(){
    
    }

    public RolDAO(RolVO rolVO) {
        super();

        try {
            conexion = this.obtenerConexion();

            rolId = rolVO.getRolId();
            rolTipo = rolVO.getRolTiPo();
            
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into rol(rolId,rolTipo) values (?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, rolId);
            puente.setString(2, rolTipo);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public ArrayList<RolVO> listar(String usuLogin) 
    {
        ArrayList<RolVO> listaRol = new ArrayList<>();
        try 
        {
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.ID_USUA, rol.NOM_ROL FROM rol INNER JOIN rolusua ON rol.ID_ROL = rolusua.ID_ROL INNER JOIN usuario ON rolusua.ID_USUA = usuario.ID_USUA WHERE usuario.NOM_USUA=?;";  
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            mensajero = puente.executeQuery();
            while (mensajero.next()) 
            {
                RolVO rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2));
                listaRol.add(rolVO);
            }

        } 
        catch (SQLException e) 
        {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally 
        {
            try 
            {
                this.deneterConexion();
            } 
            catch (SQLException e) 
            {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRol;
    }
}
