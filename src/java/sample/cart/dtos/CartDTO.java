package sample.cart.dtos;

import sample.account.dtos.UserDTO;
import sample.book.dtos.BookDTO;
import sample.order.dtos.OrderDetailDTO;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private UserDTO user;
    private Map<Integer, OrderDetailDTO> cart;

    public CartDTO(UserDTO user, Map<Integer, OrderDetailDTO> cart) {
        this.user = user;
        this.cart = cart;
    }

    public CartDTO() {
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Map<Integer, OrderDetailDTO> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, OrderDetailDTO> cart) {
        this.cart = cart;
    }

    public int getQuantity(String bookID) {
        int result = 0;
        try {
            if (this.cart.containsKey(Integer.parseInt(bookID))) {
                result = cart.get(Integer.parseInt(bookID)).getQuantity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public void add(BookDTO book) {
        if (this.cart == null) {
            this.cart = new HashMap<Integer, OrderDetailDTO>();
        }
        if (this.cart.containsKey(book.getId())) {
            int quantity = this.cart.get(book.getId()).getQuantity();
            this.cart.get(book.getId()).setQuantity(quantity + 1);
        } else {
            OrderDetailDTO orderDetail = new OrderDetailDTO(0, book, 1, "");
            cart.put(book.getId(), orderDetail);
        }
    }

    public boolean delete(String bookID) {
        if (cart == null) {
            return false;
        }
        if (this.cart.containsKey(Integer.parseInt(bookID))) {
            cart.remove(Integer.parseInt(bookID));
            return true;
        }
        return false;
    }

    public boolean update(String bookID, int quantity, String note) {
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(Integer.parseInt(bookID))) {
                    this.cart.get(Integer.parseInt(bookID)).setQuantity(quantity);
                    this.cart.get(Integer.parseInt(bookID)).setNote(note);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
