/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart.controllers;

import sample.book.daos.BookDAO;
import sample.cart.daos.CartDAO;
import sample.cart.dtos.CartDTO;
import sample.order.controllers.ViewUserNotReturnedOrderController;
import sample.order.dtos.OrderDetailDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author saost
 */
public class CheckOutController extends HttpServlet {
    private static final String SUCCESS = ViewUserNotReturnedOrderController.class.getSimpleName();
    private static final String ERROR = "cart.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        boolean isEnoughBook = true;
        try {
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            BookDAO bookDAO = new BookDAO();
            if (cart != null) {
                for (OrderDetailDTO orderDetail : cart.getCart().values()) {
                    int orderQuantity = orderDetail.getQuantity();
                    int available = bookDAO.getAvailable(orderDetail.getBook().getId() + "");
                    if (orderQuantity > available) {
                        isEnoughBook = false;
                        request.setAttribute("ERROR_MESSAGE", "Not enough book: " + orderDetail.getBook().getName());
                        break;
                    }
                }
                if (isEnoughBook) {
                    CartDAO cartDAO = new CartDAO();
                    if (cartDAO.checkOut(cart)) {
                        url = SUCCESS;
                        session.setAttribute("CART", null);
                    }
                } else {

                }
            }
        } catch (Exception e) {

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
