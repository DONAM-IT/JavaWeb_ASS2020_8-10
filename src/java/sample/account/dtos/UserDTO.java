package sample.account.dtos;

public class UserDTO {
    private String id, password, fullName, roleID, gender, phone, address;
    private boolean status;

    public UserDTO(String id, String password, String fullName, String roleID, String gender, String phone, String address) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.roleID = roleID;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.status = true;
    }

    public UserDTO(String id, String password, String fullName, String roleID, String gender, String phone, String address, boolean status) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.roleID = roleID;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
