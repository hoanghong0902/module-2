package entity;

import java.util.*;

public class Category {
    public final Integer categoryId;
    private String name;

    private final List<Product> productList = new ArrayList<>();

    public Category(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Integer getId() {
        return categoryId;
    }

    public void getProductList() {
        int index = 1;
        for (Product product : productList) {
            System.out.println(index++ + ". " + product.toString());
        }
    }

    public List<Product> getListProduct(){
        return productList;
    }
    public void putProductToCategory(Product product) {
        productList.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }

}
