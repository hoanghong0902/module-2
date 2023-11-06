package entity;

import service.User;

public class CartLine extends Cart{
    private Integer cartLineId;
    private Integer productId;
    private String productName;
    private Integer cartId;
    private Integer quantity = 0;
    private long totalPrice;

    public CartLine(User user) {
        super(user);
        this.cartLineId = (int) (Math.random() * (99 - 10 + 1) + 10);
        this.cartId = user.getId();
    }

    public CartLine addProductToCartLine(entity.Product product, Integer quantity) {
        this.productId = product.getProductId();
        this.productName = product.getName();
        this.quantity = quantity;
        this.totalPrice = quantity * product.getPrice();
        return this;
    }

    public int getCartLineId() {
        return cartLineId;
    }

    public void setCartLineId(int cartLineId) {
        this.cartLineId = cartLineId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "cartLineId=" + cartLineId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", cartId=" + cartId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
