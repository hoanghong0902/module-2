import entity.Cart;
import entity.CartLine;
import entity.ProductList;
import service.User;
import service.UserService;
import service.UserServiceImpl;
import entity.CategoryList;

import java.util.Scanner;

import static service.UserServiceImpl.currentUser;
import static service.UserServiceImpl.userList;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static CategoryList categoryList = new CategoryList();
    static ProductList productList = new ProductList();
    public static Cart cart;
    static CartLine cartLine;
    public static void main(String[] args) {
        CategoryList.categoryAvailable();
        productListAvailable();
        int chose = -1;
        int chose1 = -1;
        int chose2 = -1;
        do{
            menuLogin();
            chose = scanner.nextInt();
            scanner.nextLine();
            switch (chose){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    do{
                        menuCategory();
                        chose1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (chose1){
                            case 1:
                                categoryList.viewCategoryList();
                                do{
                                    menuProduct();
                                    chose2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (chose2){
                                        case 1:
                                            menuProductInCategory();
                                            break;
                                        case 2:
                                            addNewProduct();
                                            scanner.nextLine();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("No Choice");
                                            break;
                                    }
                                }while (chose2 != 0);
                                break;
                            case 2:
                                addNewCategory();
                                scanner.nextLine();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("No Choice");
                                break;
                        }

                    }while (chose1 != 0);
                case 3:
                    userService.logout();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No Choice");
                    break;

            }

        }while (chose!=0);

    }

    private static void menuProductInCategory() {
        Integer idCategory = -1;
        int chose1 = -1;
        do {
            System.out.println("Enter Id of Category");
            idCategory = scanner.nextInt();
            scanner.nextLine();
            if(categoryList.isCategoryId(idCategory)){
                do {
                    productList.viewProductList(idCategory);
                    menuAddProductToCart();
                    chose1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (chose1){
                        case 1:
                            addProductToCart(idCategory);
                            break;
                        case 2:
                            cart.viewListCart();
                            break;
                        case 0:
                            break;
                        default:
                        System.out.println("No choice");
                    }
                }while ((chose1!=0) && (chose1!=2));
            } else if(idCategory!=0){
                System.out.println("Id Category is Fail");
            }
            scanner.nextLine();
        }while (idCategory!=0);
    }

    private static void productListAvailable(){
        ProductList.productListInCategoryId10Available();
        ProductList.productListInCategoryId11Available();
        ProductList.productListInCategoryId12Available();
        ProductList.productListInCategoryId13Available();
        ProductList.productListInCategoryId14Available();
        ProductList.productListInCategoryId15Available();
        ProductList.productListInCategoryId16Available();
    }
    private static void addProductToCart(Integer idCategory) {
        Integer idProduct;
        boolean successId;
        do {
            System.out.println("Enter Id of Product:");
            idProduct = scanner.nextInt();
            successId = productList.isProductId(idProduct,idCategory);
            if(!successId){
                System.out.println("Wrong Id, please enter again");
            }
        }while (!successId);
        System.out.println("Enter Quantity:");
        Integer quantity = scanner.nextInt();
        cartLine = new CartLine(currentUser);
        CartLine cartLines = cartLine.addProductToCartLine(productList.getProduct(idProduct, idCategory), quantity);
        cart.addCartLineToCart(cartLines);
        System.out.println("Add Product to Cart success");
    }

    private static void menuAddProductToCart() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Are you add Product to Cart?");
        System.out.println("1. Yes");
        System.out.println("2. View Cart");
        System.out.println("0. Exit");
    }

    private static void menuProduct() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1. View Product List In Category");
        System.out.println("2. Add New Product");
        System.out.println("0. Exit");
        System.out.println("Enter chose: ");
    }

    private static void menuLogin() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Welcome To Shopee");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3: Logout");
        System.out.println("0. Exit");
        System.out.println("Enter chose: ");
    }

    private static void menuCategory(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1. View Category List");
        System.out.println("2. Add New Category");
        System.out.println("0. Exit");
        System.out.println("Enter chose: ");
    }
    private static void addNewProduct() {
        System.out.println("Enter Category Id: ");
        Integer categoryId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter Price: ");
        long price = scanner.nextInt();
        boolean success = ProductList.addProduct(categoryId,productName,price);
        if(success){
            System.out.println("Add New Product Success");
        } else {
            System.out.println("Add New Product Fail");
        }
    }

    private static void addNewCategory(){
        System.out.println("Enter Category id: ");
        Integer categoryId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Category Name: ");
        String name = scanner.nextLine();
        boolean success = CategoryList.addCategory(categoryId, name);
        if(success){
            System.out.println("Add new Category success");
        } else {
            System.out.println("Add new Category fail");
        }
    }
    private static void register() {
        System.out.println("Register \nInput your username: ");
        String username = scanner.nextLine();
        System.out.println("Input your password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);
        boolean success = userService.register(user);
        if(success){
            System.out.println("Register success");
        } else {
            System.out.println("Register fail");
        }
    }
    private static void login(){
        if(userList.size()==0){
            System.out.println("Please register");
            cart = new Cart(currentUser);
            return;
        }
        boolean success = false;
        do{
            System.out.println("Login \nInput your username: ");
            String username = scanner.nextLine();
            System.out.println("Input your password: ");
            String password = scanner.nextLine();
            success = userService.login(username, password);
            if(success){
                System.out.println("Login success");
                cart = new Cart(currentUser);
            } else {
                System.out.println("Wrong pass. Please login again");
            }
        }while (!success);
    }
}