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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    
    private static final String ERROR="update.jsp";
    private static final String SUCCESS="SearchController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String userID=request.getParameter("userID").trim();
            String fullName=request.getParameter("fullName").trim();
            String roleID=request.getParameter("roleID").trim();
            String phoneNumber=request.getParameter("phoneNumber").trim();
            String address=request.getParameter("address").trim();
            String statusID=request.getParameter("statusID").trim();
            boolean check=true;
            UserError userError=new UserError();
            if(fullName.length()>50||fullName.length()<2)
            {
                userError.setFullNameError("Full Name [2,50] !");
                check=false;
            }
            if(roleID.length()!=1)
            {
                userError.setRoleIDError("role ID have only 1number !");
                check=false;
            }
            if(phoneNumber.length()>15||phoneNumber.length()<2)
            {
                userError.setPhoneNumberError("phoneNumber [2,15] !");
                check=false;
            }if(address.length()>50||address.length()<2)
            {
                userError.setAddressError("address [2,50] !");
                check=false;
            }
            if(statusID.length()!=1)
            {
                userError.setStatusIDError("statusID have only 1number");
                check=false;
            }
            if(check)
            {
                UserDAO dao=new UserDAO();
                UserDTO user=new UserDTO(userID, fullName, roleID, "", phoneNumber, address, statusID, "");
                boolean checkUpdate=dao.updateUser(user);
                if(checkUpdate)
                {
                    url=SUCCESS;    
                }
            }
            else
            {
                request.setAttribute("USER_ERROR", userError);
            }
            
        } catch (Exception e) {
            log("ERROR at updateCOntroller: "+ e.toString());
        }
        finally
        {
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
