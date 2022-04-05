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
import javax.servlet.http.HttpSession;
import sample.shopping.Book;
import sample.shopping.Cart;
import sample.shopping.OrderDetail;
import sample.user.ProductDAO;
import sample.user.ProductDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "OrderDetailController", urlPatterns = {"/OrderDetailController"})
public class OrderDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        private static final String ERROR="viewCart.jsp";
        private static final String SUCCESS="shopping.jsp";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url=ERROR;
        try {
            String userID=request.getParameter("userID");
            
            String total=request.getParameter("total");
            ProductDAO dao=new ProductDAO();
            String orderID=dao.getOrderID();
            HttpSession session=request.getSession();
            Cart cart=(Cart)session.getAttribute("CART");
            for(Book pro: cart.getCart().values())
            {
                String orderDetailID=pro.getProductID().trim() + String.valueOf(orderID);
                String productID=pro.getProductID();
                int quantity=pro.getQuantityCART();
                double price=pro.getPrice();
                String statusID="1";
                OrderDetail OD=new OrderDetail(orderID, orderDetailID, productID, quantity, price, statusID);
                boolean check=dao.writeDetail(OD);
                if(check)
                {
                    ProductDTO dto=dao.getProductByID(pro.getProductID());
                    dao.updateQuantity(dto.getQuantity()-pro.getQuantityCART(), productID);
                }
            }
            session.setAttribute("CART", null);
            url=SUCCESS;
            
        } catch (Exception e) {
            log("Error at OrderDetailController: " + e.toString());
        }finally
        {
            response.sendRedirect(url);
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
