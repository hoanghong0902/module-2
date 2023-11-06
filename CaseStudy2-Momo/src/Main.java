import entity.Data;
import entity.UserMomo;
import service.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main implements iCinemaPathName, iChoice, iData {
    public static final String PHONE_NUMBER = "^0+\\d{9}$";
    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";


    public static Scanner scanner = new Scanner(System.in);
    static UserBankService userBankService = new UserBankService();
    static UserMomoService userMomoService = new UserMomoService();
    static PhoneNumberService phoneNumberService;
    static PayTheBillService payTheBillService = new PayTheBillService();
    static CinemaService cinemaService = new CinemaService();
    static MovieService movieService = new MovieService();
    static DataService dataService = new DataService();
    public static UserMomo currentUser;


    public static void main(String[] args) {
        int choice;
        do {
            menuMomo();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case REGISTER:
                    register();
                    break;
                case LOGIN:
                    if (login()) {
                        service();
                    }
                    break;
                case EXIT:
                    break;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);

    }

    private static void service() {
        int choice;
        do {
            menuService();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case RECHARGE_MOMO:
                    rechargeMomo();
                    break;
                case TRANSFER_MONEY_MOMO:
                    transferMoneyMomo();
                    break;
                case WITHDRAW_MONEY_MOMO:
                    withDrawMoneyMomo();
                    break;
                case RECHARGE_PHONE_NUMBER:
                    rechargePhoneNumber();
                    break;
                case RECHARGE_DATA:
                    rechargeData();
                    break;
                case PAY_THE_BILL_MOMO:
                    payTheBillMomo();
                    break;
                case GET_TICKET_MOVIE:
                    getTicketMovie();
                    break;
                case VIEW_HISTORY_TRADE:
                    viewHistoryTrade();
                    break;
                case VIEW_MOMO_INFORMATION:
                    viewMomoInformation();
                    break;
                case CHANGE_INFORMATION_MOMO:
                    changeInformationMomo();
                    break;
                case DELETE_ACCOUNT_MOMO:
                    deleteAccount();
                    return;
                case LOGOUT:
                    logout();
                    return;
                case EXIT:
                    break;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    private static void deleteAccount() {
        int choice;
        do {
            System.out.println("Bạn có chắc muốn xóa tài khoản?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.println("Nhập lựa chọn:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == YES) {
                if (userMomoService.deleteUserMomo(currentUser)) {
                    System.out.println("Xóa tài khoản thành công");
                } else {
                    System.out.println("Xóa tài khoản thất bại");
                }
            } else if (choice > 2 || choice <= 0) {
                System.err.println("Nhập sai lựa chọn");
            }
        }while (choice > 2 || choice <= 0);
    }

    private static void viewMomoInformation() {
        UserMomo userMomo = userMomoService.getUserMomo(currentUser.getPhoneNumber());
        System.out.println(userMomo.getUsername() + ": Số dư ví Momo = " + userMomo.getMoney());
    }

    private static void changeInformationMomo() {
        int choice;
        do {
            menuChangeInformation();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case CHANGE_USERNAME:
                    changeUserName();
                    break;
                case CHANGE_PASSWORD:
                    changePassword();
                    break;
                case CHANGE_PHONE_NUMBER:
                    changePhoneNumber();
                    break;
                case CHANGE_BANK_ACCOUNT_NUMBER:
                    changeBankAccountNumber();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    private static void changeBankAccountNumber() {
        boolean success;
        String bankAccountNumber;
        do {
            System.out.println("Nhập tài khoản ngân hàng: ");
            bankAccountNumber = scanner.nextLine();
            success = userBankService.isAccountBankNumber(bankAccountNumber);
            if (!success) {
                System.err.println("Số tài khoản ngân hàng bạn nhập không đúng");
            }
        } while (!success);
        if (userMomoService.changeBankAccountNumber(bankAccountNumber)) {
            System.out.println("Chuyển đổi tài khoản ngân hàng thành công");
        } else {
            System.out.println("Chuyển đổi tài khoản ngân hàng thất bại");
        }
    }

    private static void changePhoneNumber() {
        boolean success;
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            success = validatePhoneNumber(phoneNumber);
            if (!success) {
                System.err.println("Số điện thoại bạn nhập không đúng");
            }
        } while (!success);
        if (userMomoService.changePhoneNumber(phoneNumber)) {
            System.out.println("Chuyển đổi số điện thoại thành công");
        } else {
            System.out.println("Chuyển đổi số điện thoại thất bại");
        }
    }

    private static void changePassword() {
        boolean success;
        String password;
        do {
            System.out.println("Nhập mật khẩu: ");
            password = scanner.nextLine();
            success = validatePassword(password);
            if (!success) {
                System.err.println("Mật khẩu bạn nhập không đúng");
            }
        } while (!success);
        if (userMomoService.changePassword(password)) {
            System.out.println("Chuyển đổi mật khẩu thành công");
        } else {
            System.out.println("Chuyển đổi mật khẩu thất bại");
        }
    }

    private static void changeUserName() {
        System.out.println("Nhập họ và tên: ");
        String userName = scanner.nextLine();
        if (userMomoService.changeUserName(userName)) {
            System.out.println("Chuyển đổi họ và tên thành công");
        } else {
            System.out.println("Chuyển đổi họ và tên thất bại");
        }
    }

    private static void menuChangeInformation() {
        System.out.println("**********************************************************************");
        System.out.println("*  1. Chỉnh sửa họ và tên                                            *");
        System.out.println("*  2. Chỉnh sửa mật khẩu                                             *");
        System.out.println("*  3. Chỉnh sửa số điện thoại                                        *");
        System.out.println("*  4. Chỉnh sửa tài khoản ngân hàng                                  *");
        System.out.println("*  0. Thoát Menu                                                     *");
        System.out.println("**********************************************************************");
        System.out.println("Nhập lựa chọn: ");
    }

    private static void payTheBillMomo() {
        int choice;
        do {
            menuPayTheBill();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case PAYMENT_OF_ELECTRICITY:
                    paymentOfElectricity();
                    break;
                case PAYMENT_OF_WATER_BILL:
                    paymentOfWaterBill();
                    break;
                case PAYMENT_OF_INTERNET_BILL:
                    paymentOfInternetBill();
                    break;
                case PAYMENT_OF_POSTPAID_WALLET:
                    paymentOfPostPaidWallet();
                    break;
                case PAYMENT_OF_LOAN_BILL:
                    paymentOfLoanBill();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    private static void paymentOfLoanBill() {
        int choice;
        long bill = payTheBillService.getLoanBill(currentUser);
        if (bill > 0) {
            System.out.println("Hóa đơn khoản vay của bạn là: " + bill);
            System.out.println("Bạn có muốn thanh toán hóa đơn?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case YES:
                    if (payTheBillService.paymentOfLoanBill(currentUser)) {
                        System.out.println("Thanh toán hóa đơn khoản vay thành công");
                    } else {
                        System.out.println("Thanh toán hóa đơn khoản vay thất bại: Số dư ví Momo không đủ");
                    }
                    break;
                case NO:
                    return;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } else {
            System.out.println("Bạn không có hóa đơn khoản vay");
        }
    }

    private static void paymentOfPostPaidWallet() {
        int choice;
        long bill = payTheBillService.getPostpaidWalletBill(currentUser);
        if (bill > 0) {
            System.out.println("Hóa đơn ví trả sau của bạn là: " + bill);
            System.out.println("Bạn có muốn thanh toán hóa đơn?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case YES:
                    if (payTheBillService.paymentOfPostpaidWallet(currentUser)) {
                        System.out.println("Thanh toán hóa đơn ví trả sau thành công");
                    } else {
                        System.out.println("Thanh toán hóa đơn ví trả sau thất bại: Số dư ví Momo không đủ");
                    }
                    break;
                case NO:
                    return;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } else {
            System.out.println("Bạn không có hóa đơn ví trả sau");
        }

    }

    private static void paymentOfInternetBill() {
        int choice;
        long bill = payTheBillService.getInternetBill(currentUser);
        if (bill > 0) {
            System.out.println("Hóa đơn Internet của bạn là: " + bill);
            System.out.println("Bạn có muốn thanh toán hóa đơn?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case YES:
                    if (payTheBillService.paymentOfInternetBill(currentUser)) {
                        System.out.println("Thanh toán hóa đơn Internet thành công");
                    } else {
                        System.out.println("Thanh toán hóa đơn Internet thất bại: Số dư ví Momo không đủ");
                    }
                    break;
                case NO:
                    return;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } else {
            System.out.println("Bạn không có hóa đơn Internet");
        }

    }

    private static void paymentOfWaterBill() {
        int choice;
        long bill = payTheBillService.getWaterBill(currentUser);
        if (bill > 0) {
            System.out.println("Hóa đơn tiền nước của bạn là: " + bill);
            System.out.println("Bạn có muốn thanh toán hóa đơn?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case YES:
                    if (payTheBillService.paymentOfWaterBill(currentUser)) {
                        System.out.println("Thanh toán hóa đơn nước thành công");
                    } else {
                        System.out.println("Thanh toán hóa đơn nước thất bại: Số dư ví Momo không đủ");
                    }
                    break;
                case NO:
                    return;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } else {
            System.out.println("Bạn không có hóa đơn tiền nước");
        }

    }

    private static void paymentOfElectricity() {
        int choice;
        long bill = payTheBillService.getElectricBill(currentUser);
        if (bill > 0) {
            System.out.println("Hóa đơn tiền điện của bạn là: " + bill);
            System.out.println("Bạn có muốn thanh toán hóa đơn?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case YES:
                    if (payTheBillService.paymentOfElectricity(currentUser)) {
                        System.out.println("Thanh toán hóa đơn điện thành công");
                    } else {
                        System.out.println("Thanh toán hóa đơn điện thất bại: Số dư ví Momo không đủ");
                    }
                    break;
                case NO:
                    return;
                default:
                    System.err.println("Nhập sai lựa chọn");
            }
        } else {
            System.out.println("Bạn không có hóa đơn tiền điện");
        }
    }

    private static void menuPayTheBill() {
        System.out.println("**********************************************************************");
        System.out.println("*  1. Thanh toán hóa đơn điện                                        *");
        System.out.println("*  2. Thanh toán hóa đơn nước                                        *");
        System.out.println("*  3. Thanh toán hóa đơn Intenet                                     *");
        System.out.println("*  4. Thanh toán ví trả sau                                          *");
        System.out.println("*  5. Thanh toán khoản vay                                           *");
        System.out.println("*  0. Thoát menu                                                     *");
        System.out.println("**********************************************************************");
        System.out.println("Nhập lựa chọn: ");
    }

    public static void rechargeData() {
        int choice;
        String dataName;
        boolean success;
        do {
            dataService.viewListDataName();
            System.out.println("Nhập tên gói Data bạn muốn mua: ");
            choice = Integer.parseInt(scanner.nextLine());
            success = ((choice > 0) && (choice < 4));
            if (!success) {
                System.out.println("Nhập sai lựa chọn");
            }
        } while (!success);
        dataName = dataService.getDataName((choice - 1));
        buyData(dataName);
    }

    private static void buyData(String dataName) {
        int choice;
        boolean phoneSuccess;
        String phoneNumber;
        Data data = null;
        switch (dataName) {
            case DATA_NAME_3G:
                dataService.viewListData3G();
                System.out.println("Nhập gói Data bạn muốn mua: ");
                choice = Integer.parseInt(scanner.nextLine());
                data = dataService.getData3G(choice - 1);
                break;
            case DATA_NAME_4G:
                dataService.viewListData4G();
                System.out.println("Nhập gói Data bạn muốn mua: ");
                choice = Integer.parseInt(scanner.nextLine());
                data = dataService.getData4G(choice - 1);
                break;
            case DATA_NAME_5G:
                dataService.viewListData5G();
                System.out.println("Nhập gói Data bạn muốn mua: ");
                choice = Integer.parseInt(scanner.nextLine());
                data = dataService.getData5G(choice - 1);
        }
        do {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            phoneSuccess = validatePhoneNumber(phoneNumber);
        } while (!phoneSuccess);
        assert data != null;
        if (dataService.buyData(data, phoneNumber, currentUser)) {
            System.out.println("Giao dịch nạp Data thành công");
        } else {
            System.out.println("Giao dịch nạp Data thất bại");
        }
    }

    private static void viewHistoryTrade() {
        System.out.println("Lịch sử giao dịch:");
        userMomoService.viewHistoryTrade();
    }

    private static void rechargePhoneNumber() {
        boolean phoneSuccess;
        long money;
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            phoneSuccess = validatePhoneNumber(phoneNumber);
            System.out.println("Nhập số tiền cần nạp: ");
            money = Long.parseLong(scanner.nextLine());
            if (!phoneSuccess) {
                System.out.println("Số điện thoại không hợp lệ");
            }
            if (money <= 0) {
                System.out.println("Số tiền không hợp lệ");
            }
        } while (!phoneSuccess || money <= 0);
        if (phoneNumberService.phoneNumberExist(phoneNumber)) {
            phoneNumberService.recharge(phoneNumber, money);
            System.out.println("Giao dịch nạp tiền điện thoại thành công");
        } else {
            System.out.println("Giao dịch nạp tiền thất bại: Số điện thoại không tồn tại");
        }
    }

    private static void withDrawMoneyMomo() {
        long money;
        do {
            System.out.println("Nhập số tiền cần rút");
            money = Long.parseLong(scanner.nextLine());
        } while (money <= 0);
        if (UserMomoService.withdrawMoneyToBank(money)) {
            System.out.println("Giao dịch rút tiền về Ngân hàng thành công");
        } else {
            System.out.println("Giao dịch rút tiền về Ngân hàng thất bại: Số dư ví Momo không đủ");
        }
    }

    private static void transferMoneyMomo() {
        int choice = -1;
        do {
            menuTransferMoney();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case TRANSFER_MONEY_TO_MOMO:
                    transferMoneyToMomo();
                    break;
                case TRANSFER_MONEY_TO_BANK:
                    transferMoneyToBank();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    private static void transferMoneyToBank() {
        boolean accountBankSuccess;
        long money;
        String accountBankNumber;
        do {
            System.out.println("Nhập số điện thoại người nhận: ");
            accountBankNumber = scanner.nextLine();
            accountBankSuccess = userBankService.isAccountBankNumber(accountBankNumber);
            System.out.println("Nhập số tiền cần chuyển: ");
            money = Long.parseLong(scanner.nextLine());
            if (!accountBankSuccess) {
                System.out.println("Số tài khoản ngân hàng không đúng ");
            }
            if (money <= 0) {
                System.out.println("Số tiền không hợp lệ");
            }
        } while (!accountBankSuccess || money <= 0);
        if (userMomoService.transferMoneyToBank(accountBankNumber, money)) {
            System.out.println("Giao dịch chuyển tiền đến Ngân hàng thành công");
            userBankService.viewUserBank(accountBankNumber);
        } else {
            System.out.println("Giao dịch chuyển tiền đến Ngân hàng thất bại");
        }
    }

    private static void transferMoneyToMomo() {
        boolean phoneSuccess;
        long money;
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại người nhận: ");
            phoneNumber = scanner.nextLine();
            phoneSuccess = validatePhoneNumber(phoneNumber);
            System.out.println("Nhập số tiền cần chuyển: ");
            money = Long.parseLong(scanner.nextLine());
            if (!phoneSuccess) {
                System.out.println("Số điện thoại không hợp lệ");
            }
            if (money <= 0) {
                System.out.println("Số tiền không hợp lệ");
            }
        } while (!phoneSuccess || money <= 0);
        if (phoneNumber.equals(currentUser.getPhoneNumber())) {
            System.out.println("Bạn không thể chuyển tiền đến chính mình");
        } else if (userMomoService.existPhoneNumber(phoneNumber)) {
            if (userMomoService.transferMoneyToMomo(phoneNumber, money)) {
                System.out.println("Giao dịch chuyển tiền đến ví momo thành công");
                userMomoService.viewUserMomo(phoneNumber);
            } else {
                System.out.println("Giao dịch chuyển tiền đến ví momo thất bại");
            }
        }
    }

    private static void menuTransferMoney() {
        System.out.println("**********************************************************************");
        System.out.println("*  1. Chuyển tiền đến ví Momo                                        *");
        System.out.println("*  2. Chuyển tiền đến tài khoản Ngân hàng                            *");
        System.out.println("*  0. Thoát menu                                                     *");
        System.out.println("**********************************************************************");
        System.out.println("Nhập lựa chọn: ");
    }

    private static void rechargeMomo() {
        System.out.println("Nhập số tiền bạn muốn nạp: ");
        long money = Long.parseLong(scanner.nextLine());
        if (userMomoService.recharge(money)) {
            System.out.println("Nạp tiền thành công");
        } else {
            System.out.println("Nạp tiền thất bại: Số dư tài khoản ngân hàng không đủ để thực hiện giao dịch");
        }
    }

    private static void menuService() {
        System.out.println("**********************************************************************");
        System.out.println("*  1. Nạp tiền vào Momo                                              *");
        System.out.println("*  2. Chuyển tiền                                                    *");
        System.out.println("*  3. Rút tiền về Ngân hàng                                          *");
        System.out.println("*  4. Nạp thẻ điện thoại                                             *");
        System.out.println("*  5. Nạp 3G, 4G                                                     *");
        System.out.println("*  6. Thanh toán hóa đơn                                             *");
        System.out.println("*  7. Mua vé xem phim                                                *");
        System.out.println("*  8. Xem lịch sử giao dịch                                          *");
        System.out.println("*  9. Xem số dư ví Momo                                              *");
        System.out.println("*  10. Sửa đổi thông tin                                             *");
        System.out.println("*  11. Xóa tài khoản                                                 *");
        System.out.println("*  12. Đăng xuất                                                     *");
        System.out.println("**********************************************************************");
        System.out.println("Nhập lựa chọn: ");
    }

    private static void menuMomo() {
        System.out.println("********************************MOMO**********************************");
        System.out.println("*  1. Đăng ký                                                        *");
        System.out.println("*  2. Đăng nhập                                                      *");
        System.out.println("*  0. Thoát chương trình                                             *");
        System.out.println("**********************************************************************");
        System.out.println("Nhập lựa chọn: ");
    }

    public static void getTicketMovie() {
        int choice = -1;
        do {
            System.out.println("Chọn rạp chiếu phim: ");
            cinemaService.viewCinemaListName();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case AEON_CINEMA:
                    getDayWatchMovie(CINEMA_NAME_AEON);
                    break;
                case GALAXY_CINEMA:
                    getDayWatchMovie(CINEMA_NAME_GALAXY);
                    break;
                case EXIT:
                    break;
            }
            if (choice < 0 || choice > 2) {
                System.err.println("Nhập sai lựa chọn, mời bạn nhập lại");
            }
        } while (choice < 0 || choice > 2);
    }

    public static void getDayWatchMovie(String cinemaName) {
        int choice;
        String day;
        do {
            System.out.println("Chọn ngày xem phim :");
            cinemaService.viewDayListOfCinema(cinemaName);
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 4) {
                System.err.println("Nhập sai lựa chọn, mời bạn nhập lại");
            }
        } while (choice < 0 || choice > 4);
        day = cinemaService.getDayOfCinema(cinemaName, (choice - 1));
        getMovieName(cinemaName, day);
    }

    public static void getMovieName(String cinemaName, String day) {
        int choice;
        String movieName;
        do {
            System.out.println("Chọn phim: ");
            movieService.viewMovieNameListInCinema(cinemaName, day);
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 5) {
                System.err.println("Nhập sai lựa chọn, mời bạn nhập lại");
            }
        } while (choice < 0 || choice > 5);
        movieName = movieService.getMovieNameInDay(cinemaName, day, (choice - 1));
        getTimeWatchMovie(cinemaName, movieName, day);
    }

    private static void getTimeWatchMovie(String cinemaName, String movieName, String day) {
        int choice;
        String time;
        int ticketQuantity;
        do {
            System.out.println("Chọn giờ xem phim :");
            movieService.viewTimeListOfMovie(cinemaName, movieName, day);
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 4) {
                System.err.println("Nhập sai lựa chọn, mời bạn nhập lại");
            }
        } while (choice < 0 || choice > 4);
        time = movieService.getTimeOfMovieInDay(cinemaName, movieName, day, (choice - 1));
        do {
            System.out.println("Nhập số lượng vé xem phim bạn muốn mua: ");
            ticketQuantity = Integer.parseInt(scanner.nextLine());
        } while (ticketQuantity <= 0);
        if (movieService.getTicketMovie(cinemaName, movieName, day, time, ticketQuantity, currentUser)) {
            System.out.println("Mua vé thành công");
        } else {
            System.out.println("Mua vé thất bại");
        }
    }

    private static void register() {
        boolean phoneSuccess;
        boolean passwordSuccess;
        boolean accountBankNumberSuccess;
        boolean registerSuccess;
        String phoneNumber, password,accountBankNumber;
        System.out.println("Đăng kí");
        do {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            phoneSuccess = validatePhoneNumber(phoneNumber);
            if (!phoneSuccess) {
                System.err.println("Số điện thoại không hợp lệ");
            }
        } while (!phoneSuccess);
        do {
            System.out.println("Nhập mật khẩu: ");
            password = scanner.nextLine();
            passwordSuccess = validatePassword(password);
            if (!passwordSuccess) {
                System.err.println("Mật khẩu không hợp lệ");
            }
        } while (!passwordSuccess);
        System.out.println("Nhập họ và tên: ");
        String username = scanner.nextLine();
        do {
            System.out.println("Nhập số tài khoản ngân hàng: ");
            accountBankNumber = scanner.nextLine();
            accountBankNumberSuccess = userBankService.isAccountBankNumber(accountBankNumber);
            if (!accountBankNumberSuccess) {
                System.err.println("Số tài khoản ngân hàng không hợp lệ");
            }
        }while (!accountBankNumberSuccess);
        registerSuccess = userMomoService.addNewUserMomo(new UserMomo(username, phoneNumber, password, accountBankNumber));
        if (registerSuccess) {
            System.out.println("Đăng kí thành công!");
        } else {
            System.out.println("Đăng kí thất bại!");
        }
    }

    private static boolean login() {
        boolean success;
        System.out.println("Đăng nhập:");
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        success = userMomoService.login(phoneNumber, password);
        currentUser = userMomoService.getUserMomo(phoneNumber);
        phoneNumberService = new PhoneNumberService(currentUser);
        if (success) {
            System.out.println("Đăng nhập thành công");
            return true;
        } else {
            System.out.println("Đăng nhập thất bại");
        }
        return false;
    }

    private static void logout() {
        currentUser = null;
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}