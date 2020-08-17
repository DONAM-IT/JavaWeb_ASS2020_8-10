/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart.controllers;

import sample.account.dtos.UserDTO;
import sample.book.controllers.ViewLibraryController;
import sample.book.daos.BookDAO;
import sample.book.dtos.BookDTO;
import sample.cart.dtos.CartDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author saost
 */
public class AddToCartController extends HttpServlet {
    private static final String SUCCESS = ViewLibraryController.class.getSimpleName();
    private static final String ERROR = ViewLibraryController.class.getSimpleName();


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
        try {
            BookDAO dao = new BookDAO();
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("AUTH_USER");
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO(user, null);
            } else if (!cart.getUser().getId().equals(user.getId())) {
                cart = new CartDTO(user, null);
            }

            session.setAttribute("CART", cart);
            String id = request.getParameter("id");
            BookDTO book = dao.getBook(id);

            boolean isEnoughBook = true;
            int available = dao.getAvailable(id);
            if (cart.getQuantity(id) >= available) {
                isEnoughBook = false;
                request.setAttribute("ERROR_MESSAGE", "Not enough book: " + cart.getCart().get(Integer.parseInt(id)).getBook().getName());
            }

            if (dao.isAvailable(id) && isEnoughBook) {
                url = SUCCESS;
                cart.add(book);
                request.setAttribute("SUCCESS_MESSAGE", "Add: " + book.getName() + " successful");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Out of book: " + book.getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
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
