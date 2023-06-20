package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Landing Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style3.css\">\n");
      out.write("        <style>\n");
      out.write("                    .contact--lockup{max-width:90%}\n");
      out.write("                    .contact--lockup{-webkit-box-pack:center; \n");
      out.write("                            -webkit-justify-content:center; \n");
      out.write("                            -ms-flex-pack:center; \n");
      out.write("                            justify-content:center}\n");
      out.write("                    .contact--lockup .modal{padding:45px 45px; \n");
      out.write("                    text-align:center; \n");
      out.write("                    background-color:#0c0c0c; \n");
      out.write("                    box-shadow:0 0 30px 0 rgba(0,0,0,0.75)}.contact--lockup .modal--information p,.contact--lockup .modal--information a{display:block; \n");
      out.write("                    margin:14px 0; \n");
      out.write("                    text-decoration:none; \n");
      out.write("                    color:#fff; \n");
      out.write("                    font-weight:700}.contact--lockup .modal--information p{margin-top:0}.contact--lockup .modal--options{margin:0; \n");
      out.write("                    padding:0; \n");
      out.write("                    list-style:none}.contact--lockup .modal--options>li{width:130px; \n");
      out.write("                    margin:0 auto 25px auto}.contact--lockup .modal--options li:nth-child(1){background-color:#1769ff}.contact--lockup .modal--options li:nth-child(2){background-color:#ea4c89}.contact--lockup .modal--options li:nth-child(3){margin-bottom:0; \n");
      out.write("                    background-color:#0f33ff; \n");
      out.write("                    text-transform:uppercase}.contact--lockup .modal--options a{display:block; \n");
      out.write("                    width:100%; \n");
      out.write("                    padding:8px 0; \n");
      out.write("                    text-decoration:none; \n");
      out.write("                    color:#fff; \n");
      out.write("                    font-weight:700\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <a href=\"home\"><img class=\"logo\" src=\"images2/Logo.png\" style=\"height: 50px;filter: invert(1);\"/></a>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\" class=\"active\">Contact</a></li>\n");
      out.write("                <li><a href=\"home\">Home</a></li>\n");
      out.write("                <li><a href=\"#\">News</a></li>\n");
      out.write("                <li><a href=\"products\">Products</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <img src=\"images/vn.png\">\n");
      out.write("            <div class=\"contact\" style=\"transform: translateX(-40%);\" >\n");
      out.write("              <div class=\"contact--lockup\">\n");
      out.write("                <div class=\"modal\">\n");
      out.write("                  <div class=\"modal--information\">\n");
      out.write("                    <p>Vietnam</p>\n");
      out.write("                    <a style=\"transform: translateX(-15px);\" href=\"\">snkrsdashhype@gmail.com</a>\n");
      out.write("                  </div>\n");
      out.write("                  <ul class=\"modal--options\">\n");
      out.write("                    <li><a href=\"https://www.facebook.com/LongBee.ne\">Facebook</a></li>\n");
      out.write("                    <li><a href=\"https://www.instagram.com/hoang.longz/\">Instagram</a></li>\n");
      out.write("                    <li><a href=\"https://gmail.com\">Contact Us</a></li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>");
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
