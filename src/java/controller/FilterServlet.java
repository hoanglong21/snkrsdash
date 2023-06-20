/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FilterServlet", urlPatterns = {"/filter"})
public class FilterServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }
//        System.out.println((String) session.getAttribute("condition"));
        int available = 1;
        if (session.getAttribute("condition") != null) {
            available = (int) session.getAttribute("condition");
        }
        if (request.getParameter("condition") != null) {
            available = Integer.parseInt(request.getParameter("condition"));
        }

        int stars = 0;
        Double from = null, to = null;
        if (session.getAttribute("stars") != null) {
            try {
                stars = (int) session.getAttribute("stars");
            } catch (NumberFormatException e) {
                stars = 0;
            }
        }
        if (request.getParameter("stars") != null) {
            try {
                stars = Integer.parseInt((String) request.getParameter("stars"));
            } catch (NumberFormatException e) {
                stars = 0;
            }
        }
        if (session.getAttribute("from") != null) {
            try {
                from = (Double) session.getAttribute("from");
            } catch (NumberFormatException e) {
                from = 0.0;
            }
        }
        if (request.getParameter("from") != null) {
            try {
                from = Double.parseDouble((String) request.getParameter("from"));
            } catch (NumberFormatException e) {
                from = 0.0;
            }
        }
        if (session.getAttribute("to") != null) {
            try {
                to = (Double) session.getAttribute("to");
            } catch (NumberFormatException e) {
                to = 0.0;
            }
        }
        if (request.getParameter("to") != null) {
            try {
                to = Double.parseDouble((String) request.getParameter("to"));
            } catch (NumberFormatException e) {
                to = 0.0;
            }
        }
        String[] raw_cat = null;
        List<Integer> raw_catInt = null;
        if (session.getAttribute("forNext") != null) {
            raw_catInt = (List<Integer>) session.getAttribute("forNext");
        }
        if (request.getParameterValues("cat") != null) {
            raw_cat = request.getParameterValues("cat");
        }

        int[] catID = null;
        List<Integer> forNext = new ArrayList<>();
        if (raw_catInt != null) {
            catID = new int[raw_catInt.size()];
            for (int i = 0; i < raw_catInt.size(); i++) {
                catID[i] = raw_catInt.get(i);
                forNext.add(catID[i]);

            }
        }

        if (raw_cat != null) {
            forNext.clear();
            catID = new int[raw_cat.length];
            for (int i = 0; i < raw_cat.length; i++) {
                catID[i] = Integer.parseInt(raw_cat[i]);
                forNext.add(catID[i]);
            }
        }

        String sort = (String) session.getAttribute("sort");
        if (request.getParameter("sort") != null) {
            sort = request.getParameter("sort");
        }

        ProductDAO p = new ProductDAO();
        if (name == null) {
            name = "";
        }

        List<Product> list = null;
        list = p.filter(available, catID, stars, from, to, name, sort);

        int page, numperpage = 8;
        int num = (list.size() % numperpage == 0 ? (list.size() / numperpage) : ((list.size() / numperpage) + 1));
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        int size = list.size();
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> list1 = p.getListByPage(list, start, end);

        request.setAttribute("data", list1);
        request.setAttribute("page", page);
        request.setAttribute("num", num);

        //a lot
        session.setAttribute("name", name);
        session.setAttribute("condition", available);
        session.setAttribute("stars", stars);
        session.setAttribute("from", from);
        session.setAttribute("to", to);
        session.setAttribute("sort", sort);
        session.setAttribute("forNext", forNext);
        //a lot
        request.getRequestDispatcher("products.jsp").forward(request, response);
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
//        processRequest(request, response);
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }
//        System.out.println((String) session.getAttribute("condition"));
        int available = 1;
        if (session.getAttribute("condition") != null) {
            available = (int) session.getAttribute("condition");
        }
        if (request.getParameter("condition") != null) {
            available = Integer.parseInt(request.getParameter("condition"));
        }

        int stars = 0;
        Double from = null, to = null;
        if (session.getAttribute("stars") != null) {
            try {
                stars = (int) session.getAttribute("stars");
            } catch (NumberFormatException e) {
                stars = 0;
            }
        }
        if (request.getParameter("stars") != null) {
            try {
                stars = Integer.parseInt((String) request.getParameter("stars"));
            } catch (NumberFormatException e) {
                stars = 0;
            }
        }
        if (session.getAttribute("from") != null) {
            try {
                from = (Double) session.getAttribute("from");
            } catch (NumberFormatException e) {
                from = 0.0;
            }
        }
        if (request.getParameter("from") != null) {
            try {
                from = Double.parseDouble((String) request.getParameter("from"));
            } catch (NumberFormatException e) {
                from = 0.0;
            }
        }
        if (session.getAttribute("to") != null) {
            try {
                to = (Double) session.getAttribute("to");
            } catch (NumberFormatException e) {
                to = 0.0;
            }
        }
        if (request.getParameter("to") != null) {
            try {
                to = Double.parseDouble((String) request.getParameter("to"));
            } catch (NumberFormatException e) {
                to = 0.0;
            }
        }
        String[] raw_cat = null;
        if (session.getAttribute("cat") != null) {
            raw_cat = (String[]) session.getAttribute("cat");
        }
        if (request.getParameterValues("cat") != null) {
            raw_cat = request.getParameterValues("cat");
        }

        int[] catID = null;
        List<Integer> forNext = new ArrayList<>();
        if (raw_cat != null) {
            catID = new int[raw_cat.length];
            for (int i = 0; i < raw_cat.length; i++) {
                catID[i] = Integer.parseInt(raw_cat[i]);
                forNext.add(catID[i]);
            }
        }
        String sort = (String) session.getAttribute("sort");
        if (request.getParameter("sort") != null) {
            sort = request.getParameter("sort");
        }
        ProductDAO p = new ProductDAO();
        List<Product> list = p.filter(available, catID, stars, from, to, name, sort);

        int page, numperpage = 8;
        int num = (list.size() % numperpage == 0 ? (list.size() / numperpage) : ((list.size() / numperpage) + 1));
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        int size = list.size();
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> list1 = p.getListByPage(list, start, end);

        request.setAttribute("data", list1);
        request.setAttribute("page", page);
        request.setAttribute("num", num);

        //a lot
        session.setAttribute("name", name);
        session.setAttribute("condition", available);
        session.setAttribute("stars", stars);
        session.setAttribute("from", from);
        session.setAttribute("to", to);
        session.setAttribute("sort", sort);
        session.setAttribute("forNext", forNext);
        //a lot
        request.getRequestDispatcher("products.jsp").forward(request, response);
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
