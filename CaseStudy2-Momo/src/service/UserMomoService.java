package service;

import entity.UserMomo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static service.UserBankService.parseCsvLine;
import static service.UserBankService.updateFileUserBank;

public class UserMomoService implements iTrade {
    public static List<UserMomo> userMomoList = new ArrayList<>();
    public static UserMomo currentUser;

    static {
        try (FileReader fileReader = new FileReader("src\\file\\userMomo.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> user = parseCsvLine(line);
                userMomoList.add(new UserMomo(user.get(0), user.get(1),
                        (user.get(2)), (user.get(3)), Long.parseLong(user.get(4))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean changeUserName(String userName) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser) {
                user.setUsername(userName);
                currentUser = user;
                updateFileUserMomo();
                return true;
            }
        }
        return false;
    }

    public boolean changePassword(String password) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser) {
                user.setPassword(password);
                currentUser = user;
                updateFileUserMomo();
                return true;
            }
        }
        return false;
    }

    public boolean changeBankAccountNumber(String bankAccountNumber) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser) {
                user.setBankAccountNumber(bankAccountNumber);
                currentUser = user;
                updateFileUserMomo();
                return true;
            }
        }
        return false;
    }

    public boolean changePhoneNumber(String phoneNumber) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser) {
                user.setPhoneNumber(phoneNumber);
                currentUser = user;
                updateFileUserMomo();
                return true;
            }
        }
        return false;
    }

    public UserMomo getUserMomo(String phoneNumber) {
        for (UserMomo user : userMomoList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public boolean addNewUserMomo(UserMomo user) {
        if (!existPhoneNumber(user.getPhoneNumber())) {
            userMomoList.add(user);
            updateFileUserMomo();
            return true;
        }
        return false;
    }

    public boolean existPhoneNumber(String phoneNumber) {
        for (UserMomo user : userMomoList) {
            if (user.getPhoneNumber().equals(phoneNumber))
                return true;
        }
        return false;
    }

    public boolean login(String phoneNumber, String password) {
        for (UserMomo user : userMomoList) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public boolean recharge(long money) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser && UserBankService.checkBalance(currentUser.getBankAccountNumber(), money)) {
                user.setMoney(user.getMoney() + money);
                currentUser = user;
                updateFileUserMomo();
                UserBankService.withdrawMoney(currentUser.getBankAccountNumber(), money);
                writeHistoryTrade(RECHARGE_MOMO, money);
                return true;
            }
        }
        return false;
    }

    public static boolean withdrawMoneyToBank(long money) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser && user.getMoney() >= money) {
                user.setMoney((user.getMoney() - money));
                currentUser = user;
                updateFileUserMomo();
                UserBankService.recharge(currentUser.getBankAccountNumber(), money);
                writeHistoryTrade(WITHDRAW_MONEY_TO_BANK, money);
                return true;
            }
        }
        return false;
    }

    public static void withdrawMoney(long money) {
        for (UserMomo user : userMomoList) {
            if (user.getPhoneNumber().equals(currentUser.getPhoneNumber())) {
                user.setMoney((currentUser.getMoney() - money));
                currentUser = user;
                updateFileUserMomo();
                return;
            }
        }
    }

    public boolean transferMoneyToMomo(String phoneNumber, long money) {
        if (currentUser.getMoney() >= money) {
            currentUser.setMoney((currentUser.getMoney() - money));
            for (UserMomo user : userMomoList) {
                if (user == getUserMomo(phoneNumber)) {
                    user.setMoney((getUserMomo(phoneNumber).getMoney() + money));
                    currentUser = user;
                }
            }
            updateFileUserMomo();
            writeHistoryTrade(TRANSFER_MONEY_TO_MOMO, money);
            return true;
        }
        return false;
    }

    public boolean transferMoneyToBank(String accountBankNumber, long money) {
        for (UserMomo user : userMomoList) {
            if (user == currentUser && user.getMoney() >= money) {
                user.setMoney((user.getMoney() - money));
                currentUser = user;
                updateFileUserMomo();
                UserBankService.recharge(accountBankNumber, money);
                updateFileUserBank();
                writeHistoryTrade(TRANSFER_MONEY_TO_BANK, money);
                return true;
            }
        }
        return false;
    }

    public void viewUserMomoList() {
        for (UserMomo user : userMomoList) {
            System.out.println(user.toString());
        }
    }

    public void viewUserMomo(String phoneNumber) {
        for (UserMomo user : userMomoList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(user);
            }
        }
    }

    public static void updateFileUserMomo() {
        try (FileWriter fileWriter = new FileWriter("src\\file\\userMomo.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (UserMomo user : userMomoList) {
                bufferedWriter.write(user.getUsername());
                bufferedWriter.write("," + user.getPhoneNumber());
                bufferedWriter.write("," + user.getPassword());
                bufferedWriter.write("," + user.getBankAccountNumber());
                bufferedWriter.write("," + user.getMoney() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeHistoryTrade(String trade, long money) {
        try (FileWriter fileWriter = new FileWriter("src\\file\\history.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            LocalDateTime time = LocalDateTime.now();
            bufferedWriter.write(currentUser.getUsername());
            switch (trade) {
                case RECHARGE_MOMO:
                    bufferedWriter.write(" {Giao dịch nạp tiền từ Ngân hàng: ");
                    break;
                case WITHDRAW_MONEY_TO_BANK:
                    bufferedWriter.write(" {Giao dịch rút tiền về Ngân hàng: ");
                    break;
                case TRANSFER_MONEY_TO_MOMO:
                    bufferedWriter.write(" {Giao dịch chuyển tiền đến Ví Momo: ");
                    break;
                case TRANSFER_MONEY_TO_BANK:
                    bufferedWriter.write(" {Giao dịch chuyển tiền đến Ngân hàng: ");
                    break;
                case PAYMENT_OF_ELECTRICITY:
                    bufferedWriter.write(" {Giao dịch thanh toán hóa đơn điện: ");
                    break;
                case PAYMENT_OF_WATER_BILL:
                    bufferedWriter.write(" {Giao dịch thanh toán hóa đơn nước: ");
                    break;
                case PAYMENT_OF_POSTPAID_WALLET:
                    bufferedWriter.write(" {Giao dịch thanh toán ví trả sau: ");
                    break;
                case PAYMENT_OF_INTERNET_BILL:
                    bufferedWriter.write(" {Giao dịch thanh toán hóa đơn Internet: ");
                    break;
                case PAYMENT_OF_LOAN_BILL:
                    bufferedWriter.write(" {Giao dịch thanh toán khoản vay: ");
                    break;
            }
            bufferedWriter.write("Số tiền: " + money);
            bufferedWriter.write("; Số dư ví Momo: " + currentUser.getMoney());
            bufferedWriter.write("; Thời gian: " + time + " }\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUserMomo(UserMomo userMomo){
        for (UserMomo user : userMomoList){
            if(user == userMomo){
                userMomoList.remove(user);
                updateFileUserMomo();
                return true;
            }
        }
        return false;
    }

    public void viewHistoryTrade() {
        try (FileReader fileReader = new FileReader("src\\file\\history.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            int index = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(index++ + ". " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
