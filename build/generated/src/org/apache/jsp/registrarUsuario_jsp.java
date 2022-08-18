package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.RolVO;
import ModeloDAO.RolDAO;

public final class registrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"menu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"index.css\">\n");
      out.write("        <title>Registrar</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>   \n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"\">Inicio</a></li>\n");
      out.write("                <li><a href=\"\">Registrar usuario</a></li>\n");
      out.write("                <form method=\"post\" action=\"Sesiones\">\n");
      out.write("                    <input type=\"submit\" value=\"Cerrar Sesion\" >\n");
      out.write("                </form>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"login-box\">\n");
      out.write("            <h2>Registrar Usuario</h2>\n");
      out.write("            <form method=\"post\" action=\"Usuario\">\n");
      out.write("                <div class=\"user-box\">\n");
      out.write("                    <input type=\"text\" name=\"textLogin\" required=\"\">\n");
      out.write("                    <label>Usuario</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"user-box\">\n");
      out.write("                    <input type=\"password\" name=\"textPassword\" required=\"\">\n");
      out.write("                    <label>Contraseña</label>\n");
      out.write("                </div>\n");
      out.write("                <button>Registrar</button> <br>\n");
      out.write("                <input type=\"hidden\" value=\"1\" name=\"opcion\"><br>\n");
      out.write("                <a href=\"index.jsp\">Ingresar</a>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");

            if (request.getAttribute("mensajeError") != null) { 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("        \n");
      out.write("            ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
