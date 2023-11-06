package entity;

public class UserMomo {
    private String username;
    private String phoneNumber;
    private String password;
    private String bankAccountNumber;
    private long money = 0;

    public UserMomo(String username, String phoneNumber, String password, String bankAccountNumber, long money) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.bankAccountNumber = bankAccountNumber;
        this.money = money;
    }

    public UserMomo(String username, String phoneNumber, String password, String bankAccountNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "UserMomo{" +
                "username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", money=" + money +
                '}';
    }
}
