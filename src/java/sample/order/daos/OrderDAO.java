package sample.order.daos;

import sample.order.dtos.OrderDTO;
import sample.order.dtos.OrderDetailDTO;
import sample.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    public List<OrderDTO> getNotReturnedOrderList(String userID) throws SQLException {
        OrderDTO order = null;
        List<OrderDTO> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id, borrowDate, returnDate FROM [Order] " +
                        "Where userID=? AND returned=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setInt(2, 0);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    Date borrowDate = rs.getDate("borrowDate");
                    Date returnDate = rs.getDate("returnDate");

                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    List<OrderDetailDTO> orderDetailList = orderDetailDAO.getOrderDetailList(id);
                    order = new OrderDTO(id, userID, borrowDate, returnDate, false, orderDetailList);

                    orderList.add(order);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return orderList;
    }

    public List<OrderDTO> getNotReturnedOrderList() throws SQLException {
        OrderDTO order = null;
        List<OrderDTO> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id, userID, borrowDate, returnDate FROM [Order] " +
                        "Where returned=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, 0);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String userID = rs.getString("userID");
                    Date borrowDate = rs.getDate("borrowDate");
                    Date returnDate = rs.getDate("returnDate");

                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    List<OrderDetailDTO> orderDetailList = orderDetailDAO.getOrderDetailList(id);
                    order = new OrderDTO(id, userID, borrowDate, returnDate, false, orderDetailList);

                    orderList.add(order);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return orderList;
    }

    public boolean returnOrder(int orderID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        PreparedStatement bookStm = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);

            if (conn != null) {
                Date today = new Date();

                String sql = "UPDATE [Order] " +
                        "SET returned=1 , returnDate=? " +
                        "WHERE id = ?";
                stm = conn.prepareStatement(sql);
                java.sql.Date sqlToday = new java.sql.Date(today.getTime());
                stm.setDate(1, sqlToday);
                stm.setInt(2, orderID);
                stm.execute();

                OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                List<OrderDetailDTO> orderDetailDTOList = orderDetailDAO.getOrderDetailList(orderID);

                for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
                    String sql2 = "UPDATE Book " +
                            "SET available = available + ? " +
                            "WHERE id=?";
                    bookStm = conn.prepareStatement(sql2);
                    bookStm.setInt(1, orderDetailDTO.getQuantity());
                    bookStm.setInt(2, orderDetailDTO.getBook().getId());
                    bookStm.execute();
                }
            }

            conn.commit();
            result = true;
        } catch (Exception e) {
            conn.rollback();
        } finally {
            try {
                if (bookStm != null) bookStm.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {

            }
        }
        return result;
    }

    public boolean isReturned(int orderID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT returned FROM [Order] " +
                        "WHERE id = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    result = rs.getBoolean("returned");
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) stm.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {

            }
        }
        return result;
    }

    public List<OrderDTO> getReturnedOrderList(String userID) throws SQLException {
        OrderDTO order = null;
        List<OrderDTO> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id, borrowDate, returnDate FROM [Order] " +
                        "Where userID=? AND returned=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setInt(2, 1);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    Date borrowDate = rs.getDate("borrowDate");
                    Date returnDate = rs.getDate("returnDate");

                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    List<OrderDetailDTO> orderDetailList = orderDetailDAO.getOrderDetailList(id);
                    order = new OrderDTO(id, userID, borrowDate, returnDate, false, orderDetailList);

                    orderList.add(order);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return orderList;
    }
}
