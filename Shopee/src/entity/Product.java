package entity;

public class Product {
    public final Integer productId;
    private String name;
    private long price;
    private final Integer categoryId;

    public Product(String name, long price, Category category) {
        this.categoryId = category.getId();
        this.productId = (int) (Math.random() * (999 - 100 + 1) + 100);
        this.name = name;
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
