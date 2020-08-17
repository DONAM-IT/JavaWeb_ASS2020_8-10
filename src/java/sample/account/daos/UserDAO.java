/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account.daos;

import sample.account.dtos.UserDTO;
import sample.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID, gender, phone, address FROM [User] "
                        + "WHERE id=? AND password=? AND status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    result = new UserDTO(userID, "", fullName, roleID, gender, phone, address);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public UserDTO getUser(String userID) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID, gender, phone, address FROM [User] "
                        + "WHERE id=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    result = new UserDTO(userID, "", fullName, roleID, gender, phone, address);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<UserDTO> getListUser(String roleID) {
        List<UserDTO> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id, fullName, gender, phone, address FROM [User] " +
                        "Where roleID=? AND status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, roleID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
//                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");

                    UserDTO user = new UserDTO(id, "*****", fullName, roleID, gender, phone, address);
                    userList.add(user);
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
        return userList;
    }

    public List<String> getListUserID(String roleID) {
        List<String> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id FROM [User] " +
                        "Where roleID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, roleID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    userList.add(id);
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
        return userList;
    }

//    public void updateAccount(UserDTO user) throws SQLException{
//        Connection conn = null;
//        PreparedStatement stm = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null){
//                String sql = "UPDATE [User] " +
//                                "SET fullName=?, gender =?, phone =?, address =? " +
//                                "WHERE id = ?";
//                stm = conn.prepareStatement(sql);
////                stm.setString(1, user.getPassword());
//                stm.setString(1, user.getFullName());
//                stm.setString(2, user.getGender());
//                stm.setString(3, user.getPhone());
//                stm.setString(4, user.getAddress());
//                stm.setString(5, user.getId());
//
//                stm.executeUpdate();
//            }
//        } catch (Exception e){
//
//        } finally {
//            try {
//                if (stm != null) stm.close();
//                if (conn != null) conn.close();
//            } catch (Exception e){
//
//            }
//        }
//    }

    public void updateProfile(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [User] " +
                        "SET fullName=?, gender =?, phone =?, address =? " +
                        "WHERE id = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getGender());
                stm.setString(3, user.getPhone());
                stm.setString(4, user.getAddress());
                stm.setString(5, user.getId());

                stm.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {

            }
        }
    }

    public boolean changePassword(String userID, String oldPassword, String newPassword) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        PreparedStatement updateStm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT '' FROM [User] "
                        + "WHERE id=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, oldPassword);
                rs = stm.executeQuery();
                if (rs.next()) {
                    sql = "UPDATE [User] " +
                            "SET password = ? " +
                            "WHERE id=?";
                    updateStm = conn.prepareStatement(sql);
                    updateStm.setString(1, newPassword);
                    updateStm.setString(2, userID);
                    if (updateStm.executeUpdate() > 0) {
                        result = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (updateStm != null) {
                updateStm.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean isExitsUserID(String id) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT '' FROM [User] " +
                        "WHERE id=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    result = true;
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
        return result;
    }

    public void creatUser(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null && user != null) {
                String sql = "INSERT INTO [User](id, password, fullName, gender, phone, address, roleID) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getId());
                stm.setString(2, user.getPassword());
                stm.setString(3, user.getFullName());
                stm.setString(4, user.getGender());
                stm.setString(5, user.getPhone());
                stm.setString(6, user.getAddress());
                stm.setString(7, user.getRoleID());

                stm.executeUpdate();

            }
        } catch (Exception e) {

        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {

            }
        }
    }

    public void deleteUser(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [User] " +
                        "SET status = 0 " +
                        "WHERE id=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                stm.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {

            }
        }
    }
}
