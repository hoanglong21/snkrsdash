/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Image;
import model.Product;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddProServlet", urlPatterns = {"/addpro"})
@MultipartConfig
public class AddProServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(FileUploadServlet.class);

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
            out.println("<title>Servlet AddProServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProServlet at " + request.getContextPath() + "</h1>");
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
        Account a = (Account) session.getAttribute("account");
        if (a==null || a.getRoleID()==2) {
            response.sendRedirect("login");
            return;
        }
        
        CategoryDAO cdb = new CategoryDAO();
        List<Category> list = cdb.getAll();
        
        int count = 1;
        if(request.getParameter("count")!=null && !request.getParameter("count").equals("")) {
            count = Integer.parseInt(request.getParameter("count"));
        }
        if (count<1 || count>9) {
            count = 1;
        }
        request.setAttribute("count", count);
        request.setAttribute("category", list);
        request.getRequestDispatcher("addpro.jsp").forward(request, response);
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
        ProductDAO pdb = new ProductDAO();
        List<Product> proList = pdb.getAll();
        int forName = proList.get(proList.size() - 1).getID();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        String name = request.getParameter("name");
        int categoryID = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        List<Image> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            if (request.getParameter("getPic" + i) != null && !request.getParameter("getPic" + i).equals("")) {
                list.add(new Image("hold/" + (forName + 1) +"-"+  request.getParameter("getPic" + i)));
            }
        }
        Product p = new Product();
        p.setImgs(list);
        p.setName(name);
        p.setCatID(categoryID);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setDescription(description);
        pdb.add(p, a);

        //add  
        for (Part part : request.getParts()) {
            logger.info(part.getName());
            InputStream is = request.getPart(part.getName()).getInputStream();
            int i = is.available();
            byte[] b = new byte[i];
            is.read(b);
            logger.info("Length : " + b.length);
            String fileName = getFileName(part);
            if(fileName==null || fileName.equals("")) {
                continue;
            }
            logger.info("File name : " + fileName);
            FileOutputStream os = new FileOutputStream("D:\\FPT\\Study\\semester 4\\2021_FA_PRJ_Java Web Application Development(PRJ301)\\project\\myown\\BigProject wDB\\web\\hold\\" + (forName + 1) +"-"+ fileName);
            os.write(b);
            is.close();
        }
        // end of add
        
        response.sendRedirect("dashboard");
    }

    private String getFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        logger.info("Part Header = " + partHeader);
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;

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
