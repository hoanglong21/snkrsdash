package controller;

import dal.AccountDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Account;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = "/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(FileUploadServlet.class);

    public FileUploadServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        for (Part part : request.getParts()) {
            logger.info(part.getName());
            InputStream is = request.getPart(part.getName()).getInputStream();
            int i = is.available();
            byte[] b = new byte[i];
            is.read(b);
            logger.info("Length : " + b.length);
            String fileName = getFileName(part);
            logger.info("File name : " + fileName);
            FileOutputStream os = new FileOutputStream("D:\\FPT\\Study\\semester 4\\2021_FA_PRJ_Java Web Application Development(PRJ301)\\project\\myown\\BigProject wDB\\web\\hold\\" + fileName);
            os.write(b);
            is.close();
        }

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

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        //add
        AccountDAO adb = new AccountDAO();

        Account a;
        if (request.getParameter("accID") != null && !request.getParameter("accID").equals("")) {
            int id = Integer.parseInt(request.getParameter("accID"));
            a = adb.getAccountById(id);
        } else {
            HttpSession session = request.getSession();
            a = (Account) session.getAttribute("account");
        }

        //end of add
        String ctx = "D:/FPT/Study/semester 4/2021_FA_PRJ_Java Web Application Development(PRJ301)/project/myown/BigProject wDB/web/hold/";
        String filename = a.getUsername();
        new File(ctx + filename + ".jpg").delete();
        new File(ctx + filename + ".png").delete();
        new File(ctx + filename + ".gif").delete();

        for (Part part : request.getParts()) {
            logger.info(part.getName());
            InputStream is = request.getPart(part.getName()).getInputStream();
            int i = is.available();
            byte[] b = new byte[i];
            is.read(b);
            logger.info("Length : " + b.length);
            String fileName = getFileName(part);
            logger.info("File name : " + fileName);
            String extension = "";

            try {
                extension = fileName.substring(fileName.length() - 3);
                FileOutputStream os = new FileOutputStream("D:\\FPT\\Study\\semester 4\\2021_FA_PRJ_Java Web Application Development(PRJ301)\\project\\myown\\BigProject wDB\\web\\hold\\" + a.getUsername() + "." + extension);
                adb.updateImg(a, "hold/" + a.getUsername() + "." + extension);
                os.write(b);
                is.close();
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }

        response.sendRedirect("account-detail.jsp");
    }

}
