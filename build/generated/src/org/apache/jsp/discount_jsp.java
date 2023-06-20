package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class discount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n");
      out.write("        <title>Welcome</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style2.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n");
      out.write("        <link href=\"http://fonts.cdnfonts.com/css/alphacentauri\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"logo\"><a href=\"home\"><img src = \"images/lol.png\" style=\"height: 100px;filter: invert(1);margin-top: 30px;\"\"/></div></a>\n");
      out.write("            <div class=\"nav-links\">\n");
      out.write("                <form action=\"coupon\">\n");
      out.write("                    <P style=\"color: white;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess==null?\"Type code here, no space\":mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</P><input type=\"text\" href=\"home\" placeholder=\"Check coupon code\" name=\"cou\"</input>\n");
      out.write("                    <input type=\"submit\" value=\"Check\"/> \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <section id=\"sectionone\" class=\"screen\">\n");
      out.write("            <div id=\"scene\">\n");
      out.write("                <div data-depth=\"0.1\" class=\"bg\">\n");
      out.write("                    <img src=\"images2/background.png\" alt=\"\" />\n");
      out.write("                </div>\n");
      out.write("                <div data-depth=\"0.2\" class=\"rock1\">\n");
      out.write("                    <img src=\"images2/rock.png\" alt=\"\" />\n");
      out.write("                </div>\n");
      out.write("                <div style=\"z-index: 5;\" data-depth=\"1.2\" class=\"earth\">\n");
      out.write("                    <img src=\"images2/earth.png\" alt=\"\" />\n");
      out.write("                </div>\n");
      out.write("                <div style=\"z-index: 4;\" data-depth=\"0.1\" class=\"text\">\n");
      out.write("                    <h1 style=\" transform: translateY(-15vh); font-size: 2.5em;\">Welcome_To</h1>\n");
      out.write("                    <h1 style=\" transform: translateY(-10vh);\">SNKRSDASH</h1>\n");
      out.write("                </div>\n");
      out.write("                <div data-depth=\"0.4\" class=\"mid\">\n");
      out.write("                    <img src=\"images2/mid.png\" alt=\"\" />\n");
      out.write("                </div>\n");
      out.write("                <div data-depth=\"0.1\" class=\"fore\">\n");
      out.write("                    <img src=\"images2/foreground.png\" alt=\"\" />\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/parallax/3.1.0/parallax.min.js\"></script>\n");
      out.write("        <script src=\"js/script.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
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
