package service;

import entity.PayTheBill;
import entity.UserMomo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static service.UserBankService.parseCsvLine;
import static service.UserMomoService.currentUser;
import static service.UserMomoService.withdrawMoney;

public class PayTheBillService implements iTrade {
    static List<PayTheBill> payTheBillList = new ArrayList<>();

    static {
        try (FileReader fileReader = new FileReader("src\\file\\payTheBill.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> bill = parseCsvLine(line);
                payTheBillList.add(new PayTheBill(bill.get(0),
                        Long.parseLong(bill.get(1)),
                        Long.parseLong(bill.get(2)),
                        Long.parseLong(bill.get(3)),
                        Long.parseLong(bill.get(4)),
                        Long.parseLong(bill.get(5))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getElectricBill(UserMomo userMomo) {
        long bill = 0;
        for (PayTheBill payTheBill : payTheBillList) {
            if (payTheBill.getPhoneNumber().equals(userMomo.getPhoneNumber())) {
                bill = payTheBill.getElectricBill();
            }
        }
        return bill;
    }

    public long getWaterBill(UserMomo userMomo) {
        long bill = 0;
        for (PayTheBill payTheBill : payTheBillList) {
            if (payTheBill.getPhoneNumber().equals(userMomo.getPhoneNumber())) {
                bill = payTheBill.getWaterBill();
            }
        }
        return bill;
    }

    public long getInternetBill(UserMomo userMomo) {
        long bill = 0;
        for (PayTheBill payTheBill : payTheBillList) {
            if (payTheBill.getPhoneNumber().equals(userMomo.getPhoneNumber())) {
                bill = payTheBill.getInternetBill();
            }
        }
        return bill;
    }

    public long getPostpaidWalletBill(UserMomo userMomo) {
        long bill = 0;
        for (PayTheBill payTheBill : payTheBillList) {
            if (payTheBill.getPhoneNumber().equals(userMomo.getPhoneNumber())) {
                bill = payTheBill.getPostpaidWallet();
            }
        }
        return bill;
    }

    public long getLoanBill(UserMomo userMomo) {
        long bill = 0;
        for (PayTheBill payTheBill : payTheBillList) {
            if (payTheBill.getPhoneNumber().equals(userMomo.getPhoneNumber())) {
                bill = payTheBill.getLoanBill();
            }
        }
        return bill;
    }

    public boolean paymentOfElectricity(UserMomo userMomo) {
        for (PayTheBill bill : payTheBillList) {
            if (bill.getPhoneNumber().equals(userMomo.getPhoneNumber()) && bill.getElectricBill() <= userMomo.getMoney()) {
                UserMomoService.withdrawMoney(bill.getElectricBill());
                UserMomoService.writeHistoryTrade(PAYMENT_OF_ELECTRICITY, bill.getElectricBill());
                bill.setElectricBill(0);
                updateFilePayTheBill();
                return true;
            }
        }
        return false;
    }

    public boolean paymentOfWaterBill(UserMomo userMomo) {
        for (PayTheBill bill : payTheBillList) {
            if (bill.getPhoneNumber().equals(userMomo.getPhoneNumber()) && bill.getWaterBill() <= userMomo.getMoney()) {
                UserMomoService.withdrawMoney(bill.getWaterBill());
                UserMomoService.writeHistoryTrade(PAYMENT_OF_WATER_BILL, bill.getWaterBill());
                bill.setWaterBill(0);
                updateFilePayTheBill();
                return true;
            }
        }
        return false;
    }

    public boolean paymentOfPostpaidWallet(UserMomo userMomo) {
        for (PayTheBill bill : payTheBillList) {
            if (bill.getPhoneNumber().equals(userMomo.getPhoneNumber()) && bill.getPostpaidWallet() <= userMomo.getMoney()) {
                UserMomoService.withdrawMoney(bill.getPostpaidWallet());
                UserMomoService.writeHistoryTrade(PAYMENT_OF_POSTPAID_WALLET, bill.getPostpaidWallet());
                bill.setPostpaidWallet(0);
                updateFilePayTheBill();
                return true;
            }
        }
        return false;
    }

    public boolean paymentOfInternetBill(UserMomo userMomo) {
        for (PayTheBill bill : payTheBillList) {
            if (bill.getPhoneNumber().equals(userMomo.getPhoneNumber()) && bill.getInternetBill() <= userMomo.getMoney()) {
                UserMomoService.withdrawMoney(bill.getInternetBill());
                UserMomoService.writeHistoryTrade(PAYMENT_OF_INTERNET_BILL, bill.getInternetBill());
                bill.setInternetBill(0);
                updateFilePayTheBill();
                return true;
            }
        }
        return false;
    }

    public boolean paymentOfLoanBill(UserMomo userMomo) {
        for (PayTheBill bill : payTheBillList) {
            if (bill.getPhoneNumber().equals(userMomo.getPhoneNumber()) && bill.getLoanBill() <= userMomo.getMoney()) {
                UserMomoService.withdrawMoney(bill.getLoanBill());
                UserMomoService.writeHistoryTrade(PAYMENT_OF_LOAN_BILL, bill.getLoanBill());
                bill.setLoanBill(0);
                updateFilePayTheBill();
                return true;
            }
        }
        return false;
    }

    public void updateFilePayTheBill() {
        try (FileWriter fileWriter = new FileWriter("src\\file\\payTheBill.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (PayTheBill bill : payTheBillList) {
                bufferedWriter.write(bill.getPhoneNumber());
                bufferedWriter.write("," + bill.getPostpaidWallet());
                bufferedWriter.write("," + bill.getElectricBill());
                bufferedWriter.write("," + bill.getWaterBill());
                bufferedWriter.write("," + bill.getInternetBill());
                bufferedWriter.write("," + bill.getLoanBill() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
