package entity;

public class PayTheBill{
    private final String phoneNumber;
    private long electricBill;
    private long waterBill;
    private long internetBill;
    private long postpaidWallet;
    private long loanBill;

    public PayTheBill(String phoneNumber, long electricBill, long waterBill, long internetBill, long postpaidWallet, long loanBill) {
        this.phoneNumber = phoneNumber;
        this.electricBill = electricBill;
        this.waterBill = waterBill;
        this.internetBill = internetBill;
        this.postpaidWallet = postpaidWallet;
        this.loanBill = loanBill;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getPostpaidWallet() {
        return postpaidWallet;
    }

    public void setPostpaidWallet(long postpaidWallet) {
        this.postpaidWallet = postpaidWallet;
    }

    public long getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(long electricBill) {
        this.electricBill = electricBill;
    }

    public long getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(long waterBill) {
        this.waterBill = waterBill;
    }

    public long getInternetBill() {
        return internetBill;
    }

    public void setInternetBill(long internetBill) {
        this.internetBill = internetBill;
    }

    public long getLoanBill() {
        return loanBill;
    }

    public void setLoanBill(long loanBill) {
        this.loanBill = loanBill;
    }

    @Override
    public String toString() {
        return "PayTheBill{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", electricBill=" + electricBill +
                ", waterBill=" + waterBill +
                ", internetBill=" + internetBill +
                ", postpaidWallet=" + postpaidWallet +
                ", loanBill=" + loanBill +
                '}';
    }
}
