/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        UserDAO dao=new UserDAO();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            
            boolean checkValication = true;
            
            if (userID.length() > 10 || userID.length() < 2) {
                userError.setUserIDError("UserID must be in [2,10]");
                checkValication = false;
                
            }
            
            if (fullName.length() > 50 || fullName.length() < 5) {
                userError.setFullNameError("fullName must be in [50,10]");
                checkValication = false;
            }
            
            if (address.length() > 50 || address.length() < 2) {
                userError.setAddressError("Address must be in [50,2]");
                checkValication = false;
            }
            if (phoneNumber.length() > 15 || phoneNumber.length() < 5) {
                userError.setPhoneNumberError("Phone number must be in [15,5]");
                checkValication = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmPasswordError("2 password khong giong nhau");
                checkValication = false;
            }
            if (checkValication) {
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                UserDTO user= new UserDTO(userID, fullName, "2", password, phoneNumber, address, "1", date.toString());
                boolean checkInsert= dao.insertUser(user);
                if(checkInsert)
                {
                        url=SUCCESS;
                }
                else
                {
                    userError.setMessageError("Can not create user ! unknow error");
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("ERROR at Createcontroller: " + e.toString());
            if(e.toString().contains("duplicate"))
            {
                userError.setUserIDError("Trung userID roi kia");
                request.setAttribute("USER_ERROR", userError);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
