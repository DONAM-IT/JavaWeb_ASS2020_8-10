package sample.order.daos;

import sample.book.daos.BookDAO;
import sample.book.dtos.BookDTO;
import sample.order.dtos.OrderDetailDTO;
import sample.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    public List<OrderDetailDTO> getOrderDetailList(int orderID) throws SQLException {
        OrderDetailDTO orderDetail = null;
        List<OrderDetailDTO> orderDetailList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, quantity, note FROM [OrderDetail] " +
                        "Where orderID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    int quantity = rs.getInt("quantity");
                    String note = rs.getString("note");
                    BookDAO bookDAO = new BookDAO();
                    BookDTO book = bookDAO.getBook(bookID + "");
                    orderDetail = new OrderDetailDTO(orderID, book, quantity, note);

                    orderDetailList.add(orderDetail);
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
        return orderDetailList;
    }
}
