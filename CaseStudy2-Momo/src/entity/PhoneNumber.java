package entity;

public class PhoneNumber {
    private String phoneNumber;
    private long money;
    private String dataName;
    private int data;
    private String timeService;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber(String phoneNumber, long money, String dataName, int data, String timeService) {
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.dataName = dataName;
        this.data = data;
        this.timeService = timeService;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getTimeService() {
        return timeService;
    }

    public void setTimeService(String timeService) {
        this.timeService = timeService;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", money=" + money +
                ", dataName='" + dataName + '\'' +
                ", data=" + data +
                ", timeService=" + timeService +
                '}';
    }
}
