package sample.account.dtos;

public class UserErrorDTO {
    private String userIDError;
    private String passwordError;
    private String fullNameError;
    private String passwordRepeatError;
    private String phoneError;
    private String addressError;

    public UserErrorDTO() {
        this.userIDError = "";
        this.passwordError = "";
        this.fullNameError = "";
        this.passwordRepeatError = "";
        this.phoneError = "";
        this.addressError = "";
    }

    public UserErrorDTO(String userIDError, String passwordError, String fullNameError, String passwordRepeatError, String phoneError, String addressError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.fullNameError = fullNameError;
        this.passwordRepeatError = passwordRepeatError;
        this.phoneError = phoneError;
        this.addressError = addressError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordRepeatError() {
        return passwordRepeatError;
    }

    public void setPasswordRepeatError(String passwordRepeatError) {
        this.passwordRepeatError = passwordRepeatError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }
}
