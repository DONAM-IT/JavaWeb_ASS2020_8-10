/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import sample.account.controllers.*;
import sample.book.controllers.*;
import sample.cart.controllers.*;
import sample.order.controllers.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author saost
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String MANAGE_ACCOUNT = "ManageAccountController";
    private static final String UPDATE_ACCOUNT_INFO = "UpdateAccountInfoController";
    private static final String CREAT_USER_ACCOUNT = CreatUserAccountController.class.getSimpleName();
    private static final String CREAT_ADMIN_ACCOUNT = CreatAdminAccountController.class.getSimpleName();
    private static final String ADD_TO_CART = AddToCartController.class.getSimpleName();
    private static final String VIEW_LIBRARY = ViewLibraryController.class.getSimpleName();
    private static final String VIEW_CART = ViewCartController.class.getSimpleName();
    private static final String CHECK_OUT = CheckOutController.class.getSimpleName();
    private static final String VIEW_USER_NOT_RETURNED_ORDER = ViewUserNotReturnedOrderController.class.getSimpleName();
    private static final String VIEW_USER_RETURNED_ORDER = ViewUserReturnedOrderController.class.getSimpleName();
    private static final String RETURN_ORDER = ReturnOrderController.class.getSimpleName();
    private static final String VIEW_ADMIN_NOT_RETURNED_ORDER = ViewAdminNotReturnedOrderController.class.getSimpleName();
    private static final String VIEW_ADMIN_RETURNED_ORDER = ViewAdminReturnedOrderController.class.getSimpleName();
    private static final String RETURN_ORDER_ADMIN = ReturnOrderAdminController.class.getSimpleName();
    private static final String MANAGE_BOOK = ManageBookController.class.getSimpleName();
    private static final String EXPORT_BOOK = ExportBookController.class.getSimpleName();
    private static final String IMPORT_BOOK = ImportBookController.class.getSimpleName();
    private static final String UPDATE_BOOK = UpdateBookController.class.getSimpleName();
    private static final String CREAT_BOOK = CreatBookController.class.getSimpleName();
    private static final String DELETE_BOOK = DeleteBookController.class.getSimpleName();
    private static final String VIEW_PROFILE = ViewProfileController.class.getSimpleName();
    private static final String UPDATE_ADMIN_PROFILE = UpdateAdminProfileController.class.getSimpleName();
    private static final String UPDATE_USER_PROFILE = UpdateUserProfileController.class.getSimpleName();
    private static final String CHANGE_PASSWORD = ChangePasswordController.class.getSimpleName();
    private static final String DELETE_BOOK_FROM_CART = DeleteBookFromCartController.class.getSimpleName();
    private static final String UPDATE_BOOK_FROM_CART = UpdateBookFromCartController.class.getSimpleName();
    private static final String SEARCH_BOOK = SearchBookController.class.getSimpleName();
    private static final String DELETE_ACCOUNT = DeleteAccountController.class.getSimpleName();

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
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("ManageAccount")) {
                url = MANAGE_ACCOUNT;
            } else if (action.equals("Update account info")) {
                url = UPDATE_ACCOUNT_INFO;
            } else if (action.equals("Creat user account")) {
                url = CREAT_USER_ACCOUNT;
            } else if (action.equals("Creat admin account")) {
                url = CREAT_ADMIN_ACCOUNT;
            } else if (action.equals("Add to cart")) {
                url = ADD_TO_CART;
            } else if (action.equals("View library")) {
                url = VIEW_LIBRARY;
            } else if (action.equals("View cart")) {
                url = VIEW_CART;
            } else if (action.equals("Check out")) {
                url = CHECK_OUT;
            } else if (action.equals("View user not returned order")) {
                url = VIEW_USER_NOT_RETURNED_ORDER;
            } else if (action.equals("Return order")) {
                url = RETURN_ORDER;
            } else if (action.equals("View user returned order")) {
                url = VIEW_USER_RETURNED_ORDER;
            } else if (action.equals("View admin not returned order")) {
                url = VIEW_ADMIN_NOT_RETURNED_ORDER;
            } else if (action.equals("View admin returned order")) {
                url = VIEW_ADMIN_RETURNED_ORDER;
            } else if (action.equals("Return order admin")) {
                url = RETURN_ORDER_ADMIN;
            } else if (action.equals("Manage book")) {
                url = MANAGE_BOOK;
            } else if (action.equals("Export")) {
                url = EXPORT_BOOK;
            } else if (action.equals("Import")) {
                url = IMPORT_BOOK;
            } else if (action.equals("Update book")) {
                url = UPDATE_BOOK;
            } else if (action.equals("Creat book")) {
                url = CREAT_BOOK;
            } else if (action.equals("Delete book")) {
                url = DELETE_BOOK;
            } else if (action.equals("View profile")) {
                url = VIEW_PROFILE;
            } else if (action.equals("Update admin profile")) {
                url = UPDATE_ADMIN_PROFILE;
            } else if (action.equals("Update user profile")) {
                url = UPDATE_USER_PROFILE;
            } else if (action.equals("Change password")) {
                url = CHANGE_PASSWORD;
            } else if (action.equals("Delete book from cart")) {
                url = DELETE_BOOK_FROM_CART;
            } else if (action.equals("Update book from cart")) {
                url = UPDATE_BOOK_FROM_CART;
            } else if (action.equals("Search book")) {
                url = SEARCH_BOOK;
            } else if (action.equals("Delete account")) {
                url = DELETE_ACCOUNT;
            }

        } catch (Exception e) {
            log("ERROR AT MAINCONTROLLER" + e.toString());
        }

        request.getRequestDispatcher(url).forward(request, response);
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
