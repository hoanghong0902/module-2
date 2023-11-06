package entity;

public class Data {
    private String name;
    private Integer data;
    private String timeService;
    private long price;

    public Data(String name, Integer data, String timeService, long price) {
        this.name = name;
        this.data = data;
        this.timeService = timeService;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getTimeService() {
        return timeService;
    }

    public void setTimeService(String timeService) {
        this.timeService = timeService;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", data=" + data +
                ", timeService='" + timeService + '\'' +
                ", price=" + price +
                '}';
    }
}
