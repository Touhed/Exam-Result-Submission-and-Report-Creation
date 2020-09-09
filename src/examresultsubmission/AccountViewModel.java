package examresultsubmission;

/**
 *
 * @author Touhedur Rahman
 */
public class AccountViewModel 
{
    private int UserId;
    private String UserName;
    private String Email;
    private String Password;
    private String UserType;

    public AccountViewModel(int UserId, String UserName, String Email, String Password,String UserType) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.UserType = UserType;
    }

    public AccountViewModel() {
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    
    @Override
    public String toString()
    {
        return "ViewAccount{" + "UserName=" + UserName + ", UserId=" + UserId + ", Email=" + Email + ", Password=" + Password + ",+ UserType = "+UserType+'}';
    }
}
