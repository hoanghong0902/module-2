package service;

import entity.PhoneNumber;
import entity.UserMomo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static service.UserBankService.parseCsvLine;

public class PhoneNumberService implements iTrade {
    static List<PhoneNumber> phoneNumberList = new ArrayList<>();
    static UserMomo currentUser;

    public PhoneNumberService(UserMomo userMomo) {
        currentUser = userMomo;
    }

    static {
        try (FileReader fileReader = new FileReader("src\\file\\phoneNumber.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                List phoneNumber = parseCsvLine(line);
                phoneNumberList.add(new PhoneNumber(phoneNumber.get(0).toString(),
                        Long.parseLong(phoneNumber.get(1).toString()),
                        phoneNumber.get(2).toString(),
                        Integer.parseInt(phoneNumber.get(3).toString()),
                        phoneNumber.get(4).toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewPhoneNumberList() {
        for (PhoneNumber phoneNumber : phoneNumberList) {
            System.out.println(phoneNumber.toString());
        }
    }

    public void viewPhoneNumber(String phoneNumber) {
        System.out.println(getPhoneNumber(phoneNumber).toString());
    }

    public PhoneNumber getPhoneNumber(String phoneNumber) {
        for (PhoneNumber phoneNumbers : phoneNumberList) {
            if (phoneNumbers.getPhoneNumber().equals(phoneNumber)) {
                return phoneNumbers;
            }
        }
        return null;
    }

    public boolean phoneNumberExist(String phoneNumber) {
        for (PhoneNumber phoneNumbers : phoneNumberList) {
            if (phoneNumbers.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void recharge(String phoneNumber, long money) {
        for (PhoneNumber phoneNumbers : phoneNumberList) {
            if (phoneNumbers.getPhoneNumber().equals(phoneNumber)) {
                phoneNumbers.setMoney(phoneNumbers.getMoney() + money);
            }
        }
        UserMomoService.withdrawMoney(money);
        updateFilePhoneNumber();
        writeHistoryTrade(RECHARGE_PHONE, phoneNumber, money);
    }

    public static void setData(String phoneNumber, String dataName, int data, String timeService, long money) {
        for (PhoneNumber phoneNumbers : phoneNumberList) {
            if (phoneNumbers.getPhoneNumber().equals(phoneNumber)) {
                phoneNumbers.setDataName(dataName);
                phoneNumbers.setData(data);
                phoneNumbers.setTimeService(timeService);
            }
        }
        updateFilePhoneNumber();
        UserMomoService.withdrawMoney(money);
        writeHistoryTrade(SET_DATA, phoneNumber, money);
    }

    public static void writeHistoryTrade(String trade, String phoneNumber, long money) {
        try (FileWriter fileWriter = new FileWriter("src\\file\\history.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            LocalDateTime time = LocalDateTime.now();
            bufferedWriter.write(currentUser.getUsername());
            switch (trade) {
                case RECHARGE_PHONE:
                    bufferedWriter.write(" {Giao dịch nạp tiền đến số điện thoại: ");
                    break;
                case SET_DATA:
                    bufferedWriter.write(" {Giao dịch nạp Data đến số điện thoại: ");
                    break;
            }
            bufferedWriter.write(phoneNumber);
            bufferedWriter.write("; Số tiền: " + money);
            bufferedWriter.write("; Số dư ví Momo: " + currentUser.getMoney());
            bufferedWriter.write("; Thời gian: " + time + " }\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateFilePhoneNumber() {
        try (FileWriter fileWriter = new FileWriter("src\\file\\phoneNumber.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (PhoneNumber phoneNumber : phoneNumberList) {
                bufferedWriter.write(phoneNumber.getPhoneNumber());
                bufferedWriter.write("," + phoneNumber.getMoney());
                bufferedWriter.write("," + phoneNumber.getDataName());
                bufferedWriter.write("," + phoneNumber.getData());
                bufferedWriter.write("," + phoneNumber.getTimeService() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
