package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <title>Home Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("        <link href=\"https://fonts.googleapis.con/css2?\n");
      out.write("              family=Poppins:wght@300;400;500;600;700&display=swap\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" \n");
      out.write("              rel=\"stylesheet\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/flickity@2/dist/flickity.min.css\">\n");
      out.write("        <script src=\"https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"container\" style=\"padding-bottom: 100px;\">\n");
      out.write("                <div class=\"navbar\">\n");
      out.write("                    <a href=\"home\"><img class=\"logo\" src=\"images2/Logo.png\" style=\"height: 100px; padding-top: 50px;\"/></a>\n");
      out.write("                    <nav>\n");
      out.write("                        <ul id = \"MenuItems\" style=\"max-height: 200px;margin-top: 25px;\">\n");
      out.write("                            ");
      dal.AccountDAO DAO = null;
      synchronized (_jspx_page_context) {
        DAO = (dal.AccountDAO) _jspx_page_context.getAttribute("DAO", PageContext.PAGE_SCOPE);
        if (DAO == null){
          DAO = new dal.AccountDAO();
          _jspx_page_context.setAttribute("DAO", DAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                            <li><i class=\"fa fa-credit-card\" aria-hidden=\"true\"></i> <i class=\"fa fa-usd\" aria-hidden=\"true\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DAO.getMoney(sessionScope.account.getID())}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                            <li><a href=\"index.html\">Welcome</a></li>\n");
      out.write("                            <li><a class=\"active\" href=\"home\">Home</a></li>\n");
      out.write("                            <li><a href=\"products\">Products</a></li>\n");
      out.write("                            <li><a href=\"discount.jsp\">Discount</a></li>\n");
      out.write("                            <li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account==null?\"account.jsp\":\"account-detail.jsp\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Account</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account==null?\"account.jsp\":\"carts\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><i style=\"font-size: 1.5em\" class=\"fa fa-shopping-cart fa-2x\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <img src=\"images/menu.png\" class=\"menu-icon\" onclick=\"menutoggle()\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-2\">\n");
      out.write("                        <h1>HYPEBEAST<br>Sneaker Store</h1>\n");
      out.write("                        <p>Life ins't perfect but your SNEAKER can be.</p>\n");
      out.write("                        <a href=\"products\" class=\"btn\">Explore Now  &#8594;</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class='col-2'>\n");
      out.write("                        <img id=\"only\" src=\"images/jordan-1-unc.png\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>  \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--slide-->\n");
      out.write("        <div class=\"categories\">\n");
      out.write("            <h2 class=\"title\">&#8610; CATEGORIES &#8611;</h2>\n");
      out.write("            <!-- Flickity HTML init -->\n");
      out.write("            <div class=\"gallery js-flickity\"\n");
      out.write("                 data-flickity-options='{ \"wrapAround\": true }'>\n");
      out.write("                <div onclick=\"location.href = 'tab?catid=1'\" \n");
      out.write("                     class=\"gallery-cell\" style=\"background-image: url('images/pic1.png'); width: 80%; height: 80vh\" ></div>\n");
      out.write("                <div onclick=\"location.href = 'tab?catid=2'\"  \n");
      out.write("                     class=\"gallery-cell\" style=\"background-image: url('images/pic2.png'); width: 80%; height: 80vh\" ></div>\n");
      out.write("                <div onclick=\"location.href = 'tab?catid=3'\" \n");
      out.write("                     class=\"gallery-cell\" style=\"background-image: url('images/pic3.png'); width: 80%; height: 80vh\" ></div>\n");
      out.write("                <div onclick=\"location.href = 'tab?catid=4'\" \n");
      out.write("                     class=\"gallery-cell\" style=\"background-image: url('images/pic4.png'); width: 80%; height: 80vh\" ></div>\n");
      out.write("                <div onclick=\"location.href = 'tab?catid=5'\" \n");
      out.write("                     class=\"gallery-cell\" style=\"background-image: url('images/pic5.png'); width: 80%; height: 80vh\" ></div>\n");
      out.write("            </div>  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--lates products-->\n");
      out.write("        <div class=\"small-container\">\n");
      out.write("            <h2 class=\"title\">Newest Products</h2>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--        Offer       -->\n");
      out.write("        <div class=\"offer\">\n");
      out.write("            <div class=\"small-container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-2\">\n");
      out.write("                        <img src=\"images/ex.png\" class=\"offer-img\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-2\">\n");
      out.write("                        <p>Exclusive available on SNKRSDASH</p>\n");
      out.write("                        <h1>Jesus Shoes</h1>\n");
      out.write("                        <small>In reference to religious symbolism and the cult appeal of \n");
      out.write("                            streetwear, digital culture studio MSCHF has created ‘jesus shoes‘. \n");
      out.write("                            the design injects 60cc of holy water into the bubble of a air max sole \n");
      out.write("                            to allow wearers to literally ‘walk on water’ with every step. realized\n");
      out.write("                            with a somewhat tongue-in-cheek attitude, the shoes utilize the classic \n");
      out.write("                            NIKE silhouette to investigate ideas of devotion in both religion and \n");
      out.write("                            commercial products.</small><br/>\n");
      out.write("                        <a href=\"details?id=17\" class=\"btn\">Buy Now &#8594;</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--        testimonial       -->\n");
      out.write("        <div class=\"testimonial\">\n");
      out.write("            <div class=\"small-container\">\n");
      out.write("                <div class=\"row onlyYou\">\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <i class=\"fa fa-quote-left\"></i>\n");
      out.write("                        <p>Love this store</p>\n");
      out.write("                        <div class=\"rating\">\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <img src=\"images/user-1.png\">\n");
      out.write("                        <h3>Emma</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <i class=\"fa fa-quote-left\"></i>\n");
      out.write("                        <p>Best store ever</p>\n");
      out.write("                        <div class=\"rating\">\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <img src=\"images/user-2.png\">\n");
      out.write("                        <h3>Kevin</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <i class=\"fa fa-quote-left\"></i>\n");
      out.write("                        <p>100% legit!</p>\n");
      out.write("                        <div class=\"rating\">\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                            <i class=\"fa fa-star\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <img src=\"images/user-3.png\">\n");
      out.write("                        <h3>Lucy</h3>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--        brands       -->\n");
      out.write("        <div class=\"brands\">\n");
      out.write("            <div class=\"small-container\">\n");
      out.write("                <div class=\"row onlyYou\">\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <img src=\"images/adidas-logo.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <img src=\"images/nike-logo.jpg\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <img src=\"images/off-white-logo.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <img src=\"images/vans-logo.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <img src=\"images/converse-logo.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${new}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("p");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div class=\"col-4 up\">\n");
          out.write("                        <div onclick=\"location.href = 'details?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("';\" class=\"onePic\" style=\"background-image: url('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getImgs().get(0).getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'); cursor:pointer;\">\n");
          out.write("\n");
          out.write("                        </div>\n");
          out.write("                        <div>\n");
          out.write("                            <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                            ");
          dal.FeedbackDAO daoStars = null;
          synchronized (_jspx_page_context) {
            daoStars = (dal.FeedbackDAO) _jspx_page_context.getAttribute("daoStars", PageContext.PAGE_SCOPE);
            if (daoStars == null){
              daoStars = new dal.FeedbackDAO();
              _jspx_page_context.setAttribute("daoStars", daoStars, PageContext.PAGE_SCOPE);
            }
          }
          out.write("\n");
          out.write("                            <div class=\"rating\">\n");
          out.write("                                <i class=\"fa ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${daoStars.getStarsByID(p.getID())<0.25?'fa-star-o':\n                                               daoStars.getStarsByID(p.getID())>=0.25 && daoStars.getStarsByID(p.getID())<0.75?'fa-star-half-o':\n                                               daoStars.getStarsByID(p.getID())>=0.75?'fa-star':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></i>\n");
          out.write("                                <i class=\"fa ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${daoStars.getStarsByID(p.getID())<1.25?'fa-star-o':\n                                               daoStars.getStarsByID(p.getID())>=1.25 && daoStars.getStarsByID(p.getID())<1.75?'fa-star-half-o':\n                                               daoStars.getStarsByID(p.getID())>=1.75?'fa-star':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></i>\n");
          out.write("                                <i class=\"fa ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${daoStars.getStarsByID(p.getID())<2.25?'fa-star-o':\n                                               daoStars.getStarsByID(p.getID())>=2.25 && daoStars.getStarsByID(p.getID())<2.75?'fa-star-half-o':\n                                               daoStars.getStarsByID(p.getID())>=2.75?'fa-star':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></i>\n");
          out.write("                                <i class=\"fa ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${daoStars.getStarsByID(p.getID())<3.25?'fa-star-o':\n                                               daoStars.getStarsByID(p.getID())>=3.25 && daoStars.getStarsByID(p.getID())<3.75?'fa-star-half-o':\n                                               daoStars.getStarsByID(p.getID())>=3.75?'fa-star':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></i>\n");
          out.write("                                <i class=\"fa ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${daoStars.getStarsByID(p.getID())<4.25?'fa-star-o':\n                                               daoStars.getStarsByID(p.getID())>=4.25 && daoStars.getStarsByID(p.getID())<4.75?'fa-star-half-o':\n                                               daoStars.getStarsByID(p.getID())>=4.75?'fa-star':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></i>\n");
          out.write("                            </div>\n");
          out.write("                            <div style=\"display: flex;justify-content: space-between; \">\n");
          out.write("                                <p>$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                <p><a href=\"shop?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getAcc().getID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getAcc().getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></p>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("\n");
          out.write("                    </div>    \n");
          out.write("                ");
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
}
