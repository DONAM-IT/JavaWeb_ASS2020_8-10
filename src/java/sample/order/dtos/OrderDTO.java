package sample.order.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private int id;
    private String userID;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;
    private List<OrderDetailDTO> orderDetailList = null;

    public OrderDTO() {
    }

    public OrderDTO(int id, String userID, Date borrowDate, Date returnDate, boolean isReturned) {
        this.id = id;
        this.userID = userID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.orderDetailList = new ArrayList<>();
    }

    public OrderDTO(int id, String userID, Date borrowDate, Date returnDate, boolean isReturned, List<OrderDetailDTO> orderDetailList) {
        this.id = id;
        this.userID = userID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.orderDetailList = orderDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public List<OrderDetailDTO> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailDTO> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
