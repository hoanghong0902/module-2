package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static entity.CategoryList.categoryList;
import static entity.CategoryList.keyCategoryList;

public class ProductList {

//    public static Map<Integer, Category> listProduct = new HashMap<>();
//    public static Set<Integer> keyListProduct = listProduct.keySet();
    public static boolean addProduct(Integer categoryId, String name, long price){
        if(isCategoryId(categoryId)) {
            for (Integer key : keyCategoryList) {
                if(key.equals(categoryId)) {
                    categoryList.get(key).putProductToCategory(new Product(name, price, categoryList.get(key)));
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isProductId(Integer idProduct, Integer idCategory){
        Category category = CategoryList.getCategory(idCategory);
        assert category != null;
        for (Product key : category.getListProduct()){
            if((key.getProductId()).equals(idProduct)){
                return true;
            }
        }
        return false;
    }
    public Product getProduct(Integer idProduct, Integer idCategory) {
        Category category = CategoryList.getCategory(idCategory);
        assert category != null;
        for (Product key : category.getListProduct()){
            if((key.getProductId()).equals(idProduct)){
                return key;
            }
        }
        return null;
    }
    public static boolean isCategoryId(Integer categoryId){
        for (Integer key : keyCategoryList){
            if(key.equals(categoryId)){
                return true;
            }
        }
        return false;
    }
    public static void productListInCategoryId10Available(){
        addProduct(10,"Áo Thun Nam", 200000);
        addProduct(10,"Áo Gió", 250000);
        addProduct(10,"Quần Tây", 150000);
    }
    public static void productListInCategoryId11Available(){
        addProduct(11,"Áo Thun Nữ", 210000);
        addProduct(11,"Áo Khoác Nữ", 300000);
        addProduct(11,"Quần Đùi", 100000);
    }
    public static void productListInCategoryId12Available(){
        addProduct(12,"Iphone 14 Pro Max 128GB", 27490000);
        addProduct(12,"Ốp lưng Ip14", 57000);
        addProduct(12,"Vivo V27e", 8490000);
    }
    public static void productListInCategoryId13Available(){
        addProduct(13,"Tai nghe Bluetooth", 570000);
        addProduct(13,"Đồng Hồ Thông Minh", 1500000);
        addProduct(13,"Sạc Dự Phòng", 560000);
    }
    public static void productListInCategoryId14Available(){
        addProduct(14,"Giá Đỡ LapTop", 77000);
        addProduct(14,"Chuột Không Dây", 200000);
        addProduct(14,"Chuột Có Dây", 140000);
    }
    public static void productListInCategoryId15Available(){
        addProduct(15,"Giày Sneaker Nam", 600000);
        addProduct(15,"Dép Quai Ngang", 150000);
        addProduct(15,"Dép Nhựa", 120000);
    }
    public static void productListInCategoryId16Available(){
        addProduct(16,"Giày Sneaker Nữ", 700000);
        addProduct(16,"Sandal Nữ", 170000);
        addProduct(16,"Giày Búp Bê", 300000);
    }
    public void viewProductList(Integer categoryId){
        int count = 0;
        for (Integer key : keyCategoryList){
            if(key.equals(categoryId)) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Product List in Category " + categoryList.get(key).getName() + " id = " + categoryId);
                categoryList.get(key).getProductList();
                count++;
            }
        }
        if (count == 0){
            System.out.println("Category Id is False. Please enter Category Id again!");
        }
    }
}
