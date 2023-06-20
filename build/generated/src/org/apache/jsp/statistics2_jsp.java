package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class statistics2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script>\n");
      out.write("window.onload = function () {\n");
      out.write("\n");
      out.write("//Better to construct options first and then pass it as a parameter\n");
      out.write("var options = {\n");
      out.write("\ttitle: {\n");
      out.write("\t\ttext: \"Spline Chart with Export as Image\"\n");
      out.write("\t},\n");
      out.write("\tanimationEnabled: true,\n");
      out.write("\texportEnabled: true,\n");
      out.write("\tdata: [\n");
      out.write("\t{\n");
      out.write("\t\ttype: \"spline\", //change it to line, area, column, pie, etc\n");
      out.write("\t\tdataPoints: [\n");
      out.write("\t\t\t{ x: 10, y: 10 },\n");
      out.write("\t\t\t{ x: 20, y: 12 },\n");
      out.write("\t\t\t{ x: 30, y: 8 },\n");
      out.write("\t\t\t{ x: 40, y: 14 },\n");
      out.write("\t\t\t{ x: 50, y: 6 },\n");
      out.write("\t\t\t{ x: 60, y: 24 },\n");
      out.write("\t\t\t{ x: 70, y: -4 },\n");
      out.write("\t\t\t{ x: 80, y: 10 }\n");
      out.write("\t\t]\n");
      out.write("\t}\n");
      out.write("\t]\n");
      out.write("};\n");
      out.write("$(\"#chartContainer\").CanvasJSChart(options);\n");
      out.write("\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"chartContainer\" style=\"height: 370px; width: 100%;\"></div>\n");
      out.write("<script src=\"https://canvasjs.com/assets/script/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script src=\"https://canvasjs.com/assets/script/jquery.canvasjs.min.js\"></script>\n");
      out.write("</body>\n");
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
