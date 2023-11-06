package entity;

import service.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Cart{
    private Integer id = 1;
    private Integer userId;
    private long price;
    private final List<CartLine> listCart;
    public Cart(User user) {
        this.userId = user.getId();
        listCart = new ArrayList<>();
    }

    public long getPrice(){
        for (CartLine cartLine : listCart){
            price += cartLine.getTotalPrice();
        }
        return price;
    }
    public void getListCart() {
        int index = 1;
        for (CartLine cartLine : listCart){
            System.out.println(index++ + ". " + cartLine.toString());
        }
    }

    public boolean addCartLineToCart(CartLine cartLine) {
        listCart.add(cartLine);
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void viewListCart(){
        System.out.println("-----------------------------------------------------------------------");
        for (CartLine cartLine : listCart){
            System.out.println(cartLine.toString());
        }
    }
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", total price=" + price +
                '}';
    }
}
