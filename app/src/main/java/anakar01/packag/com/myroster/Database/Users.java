package anakar01.packag.com.myroster.Database;

public class Users {

    private String userFullName;
    private String userEmail;
    private int userMobileNo;
    private String userPassword;


    public Users(String fullName, String email, int mobileNo, String password ){
        setUserFullName(fullName);
        setUserEmail(email);
        setUserMobileNo(mobileNo);
        setUserPassword(password);

    }

    public String getUserFullName(){
        return userFullName;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public int getUserMobileNo(){
        return userMobileNo;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserFullName(String fullName){
        this.userFullName = fullName;
    }

    public void setUserEmail(String email){
        this.userEmail = email;
    }

    public void setUserMobileNo(int userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
