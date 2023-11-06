package entity;

public class UserBank{
    private final String userName;
    private final String accountNumber;
    private final String bankName;
    private long money;

    public UserBank(String userName, String accountNumber, String bankName, long money) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getMoney() {
        return money;
    }

    public String getBankName() {
        return bankName;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserBank{" +
                "accountNumber=" + accountNumber +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                '}';
    }
}
