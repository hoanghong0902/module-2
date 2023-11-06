package entity;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class CategoryList {
    public static Map<Integer, Category> categoryList = new HashMap<>();
    public static Set<Integer> keyCategoryList = categoryList.keySet();
    public static void categoryAvailable(){
        categoryList.put(10, new Category(10,"Thời Trang Nam"));
        categoryList.put(11, new Category(11,"Thời Trang Nữ"));
        categoryList.put(12, new Category(12,"Điện Thoại & Phụ Kiện"));
        categoryList.put(13, new Category(13,"Thiết Bị Điện Tử"));
        categoryList.put(14, new Category(14,"Máy Tính & Laptop"));
        categoryList.put(15, new Category(15,"Giày Dép Nam"));
        categoryList.put(16, new Category(16,"Giày Dép Nữ"));
    }
    public static boolean addCategory(Integer categoryId, String name){
        if(categoryList.size() == 0){
            categoryList.put(categoryId, new Category(categoryId, name));
            return true;
        } else {
            for(Integer key : keyCategoryList){
                if(key.equals(categoryId) || (categoryList.get(key).getName()).equals(name)){
                    return false;
                }
            }
        }
        categoryList.put(categoryId, new Category(categoryId, name));
        return true;
    }
    public static Category getCategory(Integer categoryId){
        for(Integer key : keyCategoryList){
            if(key.equals(categoryId)){
                return categoryList.get(key);
            }
        }
        return null;
    }
    public void viewCategoryList(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Category List:");
        for (Integer key : keyCategoryList){
            System.out.println(categoryList.get(key).toString());
        }
    }
    public boolean isCategoryId(Integer categoryId){
        for (Integer key : keyCategoryList){
            if(key.equals(categoryId)){
                return true;
            }
        }
        return false;
    }
}
