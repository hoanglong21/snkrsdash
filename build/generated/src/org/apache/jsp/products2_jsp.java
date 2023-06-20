package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class products2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width-device-width, initial-scale=1.0\">\n");
      out.write("        <title>Products Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/backstyle.css\"/>\n");
      out.write("        <link href=\"https://fonts.googleapis.con/css2?\n");
      out.write("              family=Poppins:wght@300;400;500;600;700&display=swap\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"navbar\">\n");
      out.write("                <a href=\"home\"><img class=\"logo\" src=\"images2/Logo.png\" style=\"height: 100px; padding-top: 50px;\"/></a>\n");
      out.write("                <nav>\n");
      out.write("                    <ul id = \"MenuItems\" style=\"max-height: 200px;margin-top: 25px;\">\n");
      out.write("                        ");
      dal.AccountDAO DAO = null;
      synchronized (_jspx_page_context) {
        DAO = (dal.AccountDAO) _jspx_page_context.getAttribute("DAO", PageContext.PAGE_SCOPE);
        if (DAO == null){
          DAO = new dal.AccountDAO();
          _jspx_page_context.setAttribute("DAO", DAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                        <li><i class=\"fa fa-credit-card\" aria-hidden=\"true\"></i> <i class=\"fa fa-usd\" aria-hidden=\"true\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DAO.getMoney(sessionScope.account.getID())}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                        <li><a href=\"index.html\">Welcome</a></li>\n");
      out.write("                        <li><a href=\"home\">Home</a></li>\n");
      out.write("                        <li><a class=\"active\" href=\"products\">Products</a></li>\n");
      out.write("                        <li><a href=\"discount.jsp\">Discount</a></li>\n");
      out.write("                        <li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account==null?\"account.jsp\":\"account-detail.jsp\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Account</a></li>\n");
      out.write("                        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account==null?\"account.jsp\":\"carts\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><i style=\"font-size: 1.5em\" class=\"fa fa-shopping-cart fa-2x\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <img src=\"images/menu.png\" class=\"menu-icon\" onclick=\"menutoggle()\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"display: flex; min-height: 1000px;\">\n");
      out.write("            <div class=\"left\" style=\"width: 15%;margin-left: 5%; transform: translateY(30%); position: absolute;\">\n");
      out.write("                <form action=\"price\">\n");
      out.write("                    <h3 style=\"text-align: center;background-color: #ecbac3;padding: 3%;border-radius: 15px;margin-bottom: 10px;\">Filters</h3>\n");
      out.write("                    <p>Condition</p>\n");
      out.write("                    <input style=\"width: inherit;height: inherit; margin-left: 5%;\" type=\"radio\" name=\"condition\" value=\"1\"> Available <br>\n");
      out.write("                    <input style=\"width: inherit;height: inherit; margin-left: 5%;\" type=\"radio\" name=\"condition\" value=\"0\"> Sold out <br>\n");
      out.write("                    <p>Categories</p>\n");
      out.write("                    ");
      dal.CategoryDAO cDAO = null;
      synchronized (_jspx_page_context) {
        cDAO = (dal.CategoryDAO) _jspx_page_context.getAttribute("cDAO", PageContext.PAGE_SCOPE);
        if (cDAO == null){
          cDAO = new dal.CategoryDAO();
          _jspx_page_context.setAttribute("cDAO", cDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <p>Avg. Customer Review</p>\n");
      out.write("                    <fieldset class=\"stars\" style=\"border: none; margin-top: 5%;\">\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star1\" value=\"5\"/>\n");
      out.write("                        <label style=\"font-size: inherit; float: right;width: inherit; transform: translateX(-700%);\" class=\"fa fa-star\" for=\"star1\"></label>\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star2\" value=\"4\"/>\n");
      out.write("                        <label style=\"font-size: inherit; float: right;width: inherit; transform: translateX(-700%);\" class=\"fa fa-star\" for=\"star2\"></label>\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star3\" value=\"3\"/>\n");
      out.write("                        <label style=\"font-size: inherit; float: right;width: inherit; transform: translateX(-700%);\" class=\"fa fa-star\" for=\"star3\"></label>\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star4\" value=\"2\"/>\n");
      out.write("                        <label style=\"font-size: inherit; float: right;width: inherit; transform: translateX(-700%);\" class=\"fa fa-star\" for=\"star4\"></label>\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star5\" value=\"1\"/>\n");
      out.write("                        <label style=\"font-size: inherit; float: right;width: inherit; transform: translateX(-700%);\" class=\"fa fa-star\" for=\"star5\"></label>\n");
      out.write("                        <input type=\"radio\" name=\"stars\" id=\"star-reset\"/> <p style=\"transform: translateX(45%);font-size: 1em;\">& UP</p>\n");
      out.write("                        <label style=\"padding: 7px 7px; float: left;width: inherit;font-size: 0.7em;transform: translate(60%,-160%);\" style=\"transform: translate(100%,-100%);\" class=\"reset\" for=\"star-reset\">reset</label>\n");
      out.write("                    </fieldset>\n");
      out.write("                    <p>Price</p>\n");
      out.write("                    <div style=\"display: flex; align-content: space-between;\">\n");
      out.write("                        <input style=\"width: 40%;\" type=\"number\" name=\"from\" min=\"0\" placeholder=\"$ Min\">\n");
      out.write("                        <p style=\"width: 20%;font-size: 2.5em;text-align: center;\">-</p> \n");
      out.write("                        <input style=\"width: 40%;\" type=\"number\" name=\"to\" min=\"0\" placeholder=\"$ Max\">\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <p>Name</p>\n");
      out.write("                    <input type=\"text\" placeholder=\"Search...\" name=\"key\"/>\n");
      out.write("                    <p>Sort</p>\n");
      out.write("                    <select style=\"width: 100%;\">\n");
      out.write("                        <option>Default shorting</option>\n");
      out.write("                        <option>Short by price</option>\n");
      out.write("                        <option>Short by popularity</option>\n");
      out.write("                        <option>Short by rating</option>\n");
      out.write("                        <option>Short by sale</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"submit\" class=\"btn\" value=\"Apply\"/>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"small-container\" style=\"margin-top: 0; margin-left: 50%;\">\n");
      out.write("                <div class=\"row row-2\">\n");
      out.write("                    <h2>All Products</h2>\n");
      out.write("                </div>\n");
      out.write("                ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"page-btn\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--        footer       -->\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"footer-col-1\">\n");
      out.write("                        <h3>Download Our App</h3>\n");
      out.write("                        <p>Download App for Android and ios mobile phone.</p>\n");
      out.write("                        <div class=\"app-logo\">\n");
      out.write("                            <img src=\"images/play-store.png\">\n");
      out.write("                            <img src=\"images/app-store.png\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer-col-2\">\n");
      out.write("                        <img src=\"images/lol.png\" style=\"filter: invert(0.8);\">\n");
      out.write("                        <p>Our Purpose Is To Sustainably Make the Pleasure and\n");
      out.write("                            Benefits of Sports Accessible to the Many.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer-col-3\">\n");
      out.write("                        <h3>Useful Links</h3>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>Coupons</li>\n");
      out.write("                            <li>Blog Post</li>\n");
      out.write("                            <li>Return Policy</li>\n");
      out.write("                            <li>Join Affiliate</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer-col-4\">\n");
      out.write("                        <h3>Follow us</h3>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>Facebook</li>\n");
      out.write("                            <li>Twitter</li>\n");
      out.write("                            <li>Instagram</li>\n");
      out.write("                            <li>Youtube</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <p class=\"copyright\">Copyright 2021 - HoangLong21</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cDAO.all}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("c");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <input style=\"width: inherit;height: inherit; margin-left: 5%;\" type=\"checkbox\" name=\"cat\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("<br>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("page");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.page}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${data}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("p");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"col-4 up\">\n");
          out.write("                            <div onclick=\"location.href = 'details?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("';\" class=\"onePic\" style=\"background-image: url('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getImgs().get(0).getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'); cursor:pointer;\">\n");
          out.write("\n");
          out.write("                            </div>\n");
          out.write("                            <div>\n");
          out.write("                                <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                                <div class=\"rating\">\n");
          out.write("                                    <i class=\"fa fa-star\"></i>\n");
          out.write("                                    <i class=\"fa fa-star\"></i>\n");
          out.write("                                    <i class=\"fa fa-star\"></i>\n");
          out.write("                                    <i class=\"fa fa-star\"></i>\n");
          out.write("                                    <i class=\"fa fa-star\"></i>\n");
          out.write("                                </div>\n");
          out.write("                                <div style=\"display: flex;justify-content: space-between; \">\n");
          out.write("                                    <p>$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                    <p><a href=\"shop?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getAcc().getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getAcc().getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></p>\n");
          out.write("                                </div>\n");
          out.write("                            </div>\n");
          out.write("\n");
          out.write("                        </div>    \n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${1}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_2.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.num}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_2.setVar("i");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <span onclick=\"location.href = 'products?page=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
