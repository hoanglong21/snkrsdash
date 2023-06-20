package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class account_002ddetail_002dcus_0020_002d_0020not_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width-device-width, initial-scale=1.0\">\n");
      out.write("        <title>Account Customer</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("        <link href=\"https://fonts.googleapis.con/css2?\n");
      out.write("              family=Poppins:wght@300;400;500;600;700&display=swap\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"all\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"home\"><img src=\"images/lol.png\" width=\"150px\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <nav>\n");
      out.write("                        <ul id = \"MenuItems\" style=\"max-height: 200px;margin-top: 25px;\">\n");
      out.write("                            <li><a href=\"index.html\">Welcome</a></li>\n");
      out.write("                            <li><a href=\"home\">Home</a></li>\n");
      out.write("                            <li><a href=\"products\">Products</a></li>\n");
      out.write("                            <li><a href=\"discount.jsp\">Discount</a></li>\n");
      out.write("                            <li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("                            <li><a class=\"active\" href=\"account.jsp\">Account</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"card.jsp\"><img src=\"images/cart.png\" width=\"30px\" height=\"30px\"></a>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <img src=\"images/menu.png\" class=\"menu-icon\" onclick=\"menutoggle()\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--account page-->\n");
      out.write("            <div class=\"account-page\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-2\">\n");
      out.write("                            <img id=\"only\" src=\"images/2.png\" width=\"100%\">\n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"text\" placeholder=\"New image?\" \n");
      out.write("                                       style=\"transform: translate(30px,-30px);width: 96%;height: inherit;margin: inherit;border: inherit;\">\n");
      out.write("                                <input type=\"submit\" value=\"OK\" \n");
      out.write("                                       style=\"transform: translate(30px,-30px);width: inherit;height: inherit;margin: inherit;border: inherit;\">\n");
      out.write("                            </form>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-2\">\n");
      out.write("                            <div class=\"form-container\">\n");
      out.write("                                <div class=\"form-btn\">\n");
      out.write("                                    <span>Account</span>\n");
      out.write("                                    <hr id=\"Indicator\" style='transform: translateX(0);'>\n");
      out.write("                                </div>\n");
      out.write("                                <form id=\"LoginForm\" style='left: 0; transform: translateY(-50px);'>\n");
      out.write("                                    <p style=\"text-align: left; margin-left: 5px;\">Role:</p>\n");
      out.write("                                    <input style=\"padding-left: 5px;\" type=\"text\" readonly=\"true\" value=\"Customer\">\n");
      out.write("                                    <p style=\"text-align: left; margin-left: 5px;\">Username:</p>         \n");
      out.write("                                    <input style=\"padding-left: 5px;\" type =\"text\" readonly=\"true\" value=\"HoangLong\">\n");
      out.write("                                    <p style=\"text-align: left; margin-left: 5px;\">Password:</p>\n");
      out.write("                                    <input style=\"padding-left: 5px;\" type=\"password\" placeholder=\"Password\" value=\"123\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn\">Change</button>\n");
      out.write("                                    <a href=\"\">Become Seller &#8594;</a>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--        footer       -->\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"footer-col-1\">\n");
      out.write("                            <h3>Download Our App</h3>\n");
      out.write("                            <p>Download App for Android and ios mobile phone.</p>\n");
      out.write("                            <div class=\"app-logo\">\n");
      out.write("                                <img src=\"images/play-store.png\">\n");
      out.write("                                <img src=\"images/app-store.png\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"footer-col-2\">\n");
      out.write("                            <img src=\"images/lol.png\" style=\"filter: invert(0.8);\">\n");
      out.write("                            <p>Our Purpose Is To Sustainably Make the Pleasure and\n");
      out.write("                                Benefits of Sports Accessible to the Many.</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"footer-col-3\">\n");
      out.write("                            <h3>Useful Links</h3>\n");
      out.write("                            <ul>\n");
      out.write("                                <li>Coupons</li>\n");
      out.write("                                <li>Blog Post</li>\n");
      out.write("                                <li>Return Policy</li>\n");
      out.write("                                <li>Join Affiliate</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"footer-col-4\">\n");
      out.write("                            <h3>Follow us</h3>\n");
      out.write("                            <ul>\n");
      out.write("                                <li>Facebook</li>\n");
      out.write("                                <li>Twitter</li>\n");
      out.write("                                <li>Instagram</li>\n");
      out.write("                                <li>Youtube</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <hr>\n");
      out.write("                    <p class=\"copyright\">Copyright 2021 - HoangLong21</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--js for toggle menu-->\n");
      out.write("        <script>\n");
      out.write("            var MenuItems = document.getElementById(\"MenuItems\");\n");
      out.write("\n");
      out.write("            MenuItems.style.maxHeight = \"0px\";\n");
      out.write("\n");
      out.write("            function menutoggle() {\n");
      out.write("                if (MenuItems.style.maxHeight === \"0px\") {\n");
      out.write("                    MenuItems.style.maxHeight = \"200px\";\n");
      out.write("                } else {\n");
      out.write("                    MenuItems.style.maxHeight = \"0px\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("      \n");
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
