/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sena
 */
public class UsuarioVO {
    
    private String usuId, usuLogin, usuPassword, nombre_usuario1, nombre_usuario2, apellido_usuario1, apellido_usuario2, 
                   numDocument_usuario, tipo_usua, tele_usua, direc_usua, correo_usua, fechanaci_usua, estado;
    
    public UsuarioVO(String usuId, String usuLogin, String usuPassword, String nombre_usuario1, String nombre_usuario2, 
                     String apellido_usuario1, String apellido_usuario2, String numDocument_usuario, String tipo_usua, String tele_usua, 
                     String direc_usua, String correo_usua, String fechanaci_usua, String estado){
        this.usuId=usuId;
        this.usuLogin=usuLogin;
        this.usuPassword=usuPassword;
        this.nombre_usuario1=nombre_usuario1;
        this.nombre_usuario2=nombre_usuario2;
        this.apellido_usuario1=apellido_usuario1;
        this.apellido_usuario2=apellido_usuario2;
        this.numDocument_usuario=numDocument_usuario;
        this.tipo_usua=tipo_usua;
        this.tele_usua=tele_usua;
        this.direc_usua=direc_usua;
        this.correo_usua=correo_usua;
        this.fechanaci_usua=fechanaci_usua;
        this.estado=estado;
    }

    public UsuarioVO() {
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getNombre_usuario1() {
        return nombre_usuario1;
    }

    public void setNombre_usuario1(String nombre_usuario1) {
        this.nombre_usuario1 = nombre_usuario1;
    }

    public String getNombre_usuario2() {
        return nombre_usuario2;
    }

    public void setNombre_usuario2(String nombre_usuario2) {
        this.nombre_usuario2 = nombre_usuario2;
    }

    public String getApellido_usuario1() {
        return apellido_usuario1;
    }

    public void setApellido_usuario1(String apellido_usuario1) {
        this.apellido_usuario1 = apellido_usuario1;
    }

    public String getApellido_usuario2() {
        return apellido_usuario2;
    }

    public void setApellido_usuairo2(String apellido_usuario2) {
        this.apellido_usuario2 = apellido_usuario2;
    }

    public String getNumDocument_usuario() {
        return numDocument_usuario;
    }

    public void setNumDocument_usuario(String numDocument_usuario) {
        this.numDocument_usuario = numDocument_usuario;
    }

    public String getTipo_usua() {
        return tipo_usua;
    }

    public void setTipo_usua(String tipo_usua) {
        this.tipo_usua = tipo_usua;
    }

    public String getTele_usua() {
        return tele_usua;
    }

    public void setTele_usua(String tele_usua) {
        this.tele_usua = tele_usua;
    }

    public String getDirec_usua() {
        return direc_usua;
    }

    public void setDirec_usua(String direc_usua) {
        this.direc_usua = direc_usua;
    }

    public String getCorreo_usua() {
        return correo_usua;
    }

    public void setCorreo_usua(String correo_usua) {
        this.correo_usua = correo_usua;
    }

    public String getFechanaci_usua() {
        return fechanaci_usua;
    }

    public void setFechanaci_usua(String fechanaci_usua) {
        this.fechanaci_usua = fechanaci_usua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}
