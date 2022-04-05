/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.shopping.Order;
import sample.shopping.OrderDetail;
import sample.user.ProductDAO;
import sample.user.UserError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "Payment.jsp";
    private static final String SUCCESS = "OrderDetailController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            String url = ERROR;
            
            UserError userError = new UserError();
            
            try {
                ProductDAO dao = new ProductDAO();
                String userID = request.getParameter("userID").trim();
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone");
                String total = request.getParameter("total");

                boolean checkValication = true;

               
                if (address.length() > 50 || address.length() < 2) {
                    userError.setAddressError("address must be in [2,50]");
                    checkValication = false;
                }
                if (phone.length() > 15 || phone.length() < 5) {
                    userError.setPhoneNumberError("Phone number must be in [15,5]");
                    checkValication = false;
                }
                if(checkValication)
                {
                     long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    Order order = new Order(email, userID, address, phone, total, date.toString(), "1", "paid"); 
                    boolean checkInsert= dao.insertProduct(order);
                    if(checkInsert)
                    {
                        url=SUCCESS;
                    }
                }
                else
                {
                    request.setAttribute("ORDER_ERROR", userError);
                    
                }
                
            } catch (Exception e) {
            log("ERROR at Createcontroller: " + e.toString());
            
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
