/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JavaMail.PropiedadesCorreo;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alrod
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 1. Recibir datos de las vistas
        String usuId = request.getParameter("textId");
        String usuLogin = request.getParameter("textLogin");
        String usuPassword = request.getParameter("textPassword");
        String nombre_usuario1 = request.getParameter("nombre1");
        String nombre_usuario2 = request.getParameter("nombre2");
        String apellido_usuario1 = request.getParameter("apellido1");
        String apellido_usuario2 = request.getParameter("apellido2");
        String numDocument_usuario = request.getParameter("numDocu");
        String tipo_usua = request.getParameter("tipoDocu");
        String tele_usua = request.getParameter("numTel");
        String direc_usua = request.getParameter("direcUsua");
        String correo_usua = request.getParameter("correo");
        String fechanaci_usua = request.getParameter("fecha");
        String Estado = "Activo";
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quién tiene los datos d forma segura? VO
        UsuarioVO usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, nombre_usuario1, nombre_usuario2, apellido_usuario1,
                apellido_usuario2, numDocument_usuario, tipo_usua, tele_usua, direc_usua,
                correo_usua, fechanaci_usua, Estado);

        //3. ¿Quién hace las operaciones? DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        ServletContext context = getServletContext();

        String host = context.getInitParameter("host");
        String puerto = context.getInitParameter("puerto");
        String usuarioCorreo = context.getInitParameter("usuarioCorreo");
        String password = context.getInitParameter("password");
        String resultadoMensaje = "";

        //4. dministrar Operaciones
        switch (opcion) {
            case 1: //Agregar Registro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "el usuario se registro correctamente");
                    String receptor = request.getParameter("textLogin");
                    String asunto = "Correo de Registro";
                    String contenido = "Bienvenido, su registro se realizo con exito su usuario es " + receptor;

                    try {

                        PropiedadesCorreo.envioCorreo(host, puerto, usuarioCorreo, password, receptor, asunto, contenido);
                        resultadoMensaje = "El mensaje se envio de forma correcta";
                    } catch (Exception e) {
                        e.printStackTrace();
                        resultadoMensaje = "Error al enviar el mensaje " + e.getMessage();
                    }

                } else {
                    request.setAttribute("mensajeError", "el usuario NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
            case 5://completar perfil 
                if (usuDAO.completarPerfil(nombre_usuario1, nombre_usuario2, apellido_usuario1, apellido_usuario2,
                        numDocument_usuario, tipo_usua, tele_usua, direc_usua, correo_usua, fechanaci_usua, usuId)) {

                    request.setAttribute("mensajeExito", "completaste tu perfil de manera exitosa");
                } else {
                    request.setAttribute("mensajeError", "lo sentimos revisa los campon nuevamente");
                }
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
                break;
            case 2: //actualizar Registro
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "el usuario se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "el usuario NO se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;
            case 3: //eliminar Registro
                if (usuDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "el usuario se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "el usuario NO se elimino correctamente");
                }
                request.getRequestDispatcher("eliminarRegistro.jsp").forward(request, response);
                break;
            case 4:
                if (usuDAO.inicioSesion(usuLogin, usuPassword)) {
                    HttpSession misesion = request.getSession(true);

                    usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, nombre_usuario1, nombre_usuario2, apellido_usuario1,
                            apellido_usuario1, numDocument_usuario, tipo_usua, tele_usua, direc_usua,
                            correo_usua, fechanaci_usua, Estado);

                    RolDAO rolDAO = new RolDAO();
                    RolVO rolVO = new RolVO();

                    ArrayList<RolVO> listaRol = rolDAO.listar(usuLogin);
                    for (int i = 0; i < listaRol.size(); i++) {
                        rolVO = listaRol.get(i);
                    }
                    String usuid = rolVO.getRolId();
                    String roltipo = rolVO.getRolTiPo();

                    misesion.setAttribute("datosUsuario", usuVO);

                    if (listaRol.size() > 1) {
                        request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    }

                    if (roltipo.equals("admin")) {
                        request.getRequestDispatcher("admin.jsp").forward(request, response);
                    } else if (roltipo.equals("director")) {
                        request.getRequestDispatcher("director.jsp").forward(request, response);
                    } else if (roltipo.equals("profesor")) {
                        request.getRequestDispatcher("profesor.jsp").forward(request, response);
                    } else if (roltipo.equals("alumno")) {
                        request.getRequestDispatcher("alumno.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensajeError", "¡Por favor, verifique sus datos de acceso!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
