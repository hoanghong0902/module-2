package service;

import entity.UserBank;
import entity.UserMomo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserBankService {
    public static List<UserBank> userBankList = new ArrayList<>();

    static {
        try (FileReader fileReader = new FileReader("src\\file\\userBank.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> user = parseCsvLine(line);
                userBankList.add(new UserBank(user.get(0), user.get(1),
                        user.get(2), Long.parseLong((user.get(3)))));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<String> parseCsvLine(String csvLine) {
        ArrayList<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public void viewUserBankList(){
        for (UserBank user : userBankList){
            System.out.println(user.toString());
        }
    }
    public void viewUserBank(String accountNumber){
        for (UserBank user : userBankList){
            if(user.getAccountNumber().equals(accountNumber)){
                System.out.println(user.toString());
            }
        }
    }
    public static void withdrawMoney(String accountNumber, long money){
        for (UserBank user : userBankList){
            if(user.getAccountNumber().equals(accountNumber)){
                user.setMoney(getUserBankByAccountNumber(accountNumber).getMoney() - money);
                updateFileUserBank();
            }
        }
    }

    public static void recharge(String accountNumber, long money){
        for (UserBank user : userBankList){
            if(user.getAccountNumber().equals(accountNumber)){
                user.setMoney(getUserBankByAccountNumber(accountNumber).getMoney() + money);
                updateFileUserBank();
            }
        }
    }
    public static void updateFileUserBank() {
        try (FileWriter fileWriter = new FileWriter("src\\file\\userBank.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for (UserBank user : userBankList){
                bufferedWriter.write(user.getUserName());
                bufferedWriter.write("," + user.getAccountNumber());
                bufferedWriter.write("," + user.getBankName());
                bufferedWriter.write("," + user.getMoney() + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static UserBank getUserBankByAccountNumber(String accountNumber){
        for(UserBank user : userBankList){
            if(user.getAccountNumber().equals(accountNumber)){
                return user;
            }
        }
        return null;
    }

    public boolean isAccountBankNumber(String accountBankNumber){
        for(UserBank user : userBankList){
            if(user.getAccountNumber().equals(accountBankNumber)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkBalance(String bankAccountNumber, long money){
        for (UserBank user : userBankList){
            if(user.getAccountNumber().equals(bankAccountNumber) && user.getMoney() >= money){
                return true;
            }
        }
        return false;
    }
}
