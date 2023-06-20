/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Account;
import model.Image;
import model.Product;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateProServlet", urlPatterns = {"/uppro"})
@MultipartConfig
public class UpdateProServlet extends HttpServlet {
    
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
            out.println("<title>Servlet UpdateProServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProServlet at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO pdb = new ProductDAO();
        CategoryDAO cdb = new CategoryDAO();      
        request.setAttribute("category", cdb.getAll());
        Product p = pdb.getByID(id);
        int count = p.getImgs().size();
        int raw_count;
        try{
            raw_count = Integer.parseInt(request.getParameter("count"));
        } catch (NumberFormatException e) {
            raw_count = count;
        }
        if (count < raw_count) {
            count = raw_count;
        }
        if(count<0 || count>9) {
            count = 9;
        }
        request.setAttribute("count", count);
        request.setAttribute("pro", p);
        request.getRequestDispatcher("updatepro.jsp").forward(request, response);
        
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
        int id = Integer.parseInt(request.getParameter("id"));
        int count = Integer.parseInt(request.getParameter("count"));
        
        ProductDAO pdb = new ProductDAO();
        Product p = pdb.getByID(id);
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        String name = request.getParameter("name");
        int categoryID = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        List<Image> list = new ArrayList<>();
        for (int i = p.getImgs().size(); i <= count; i++) {
            if (request.getParameter("getPic" + i) != null && !request.getParameter("getPic" + i).equals("")) {
                list.add(new Image("hold/" + (id) +"-"+  request.getParameter("getPic" + i)));
            }
        }

        p.setImgs(list);
        p.setName(name);
        p.setCatID(categoryID);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setDescription(description);
        pdb.upPro(p, list);

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
            FileOutputStream os = new FileOutputStream("D:\\FPT\\Study\\semester 4\\2021_FA_PRJ_Java Web Application Development(PRJ301)\\project\\myown\\BigProject wDB\\web\\hold\\" + (id) +"-"+ fileName);
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
