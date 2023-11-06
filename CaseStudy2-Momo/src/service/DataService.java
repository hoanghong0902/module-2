package service;

import entity.Data;
import entity.UserMomo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static service.UserBankService.parseCsvLine;

public class DataService implements iData {
    static ArrayList<Data> data3GList = new ArrayList<>();
    static ArrayList<Data> data4GList = new ArrayList<>();
    static ArrayList<Data> data5GList = new ArrayList<>();
    static ArrayList<String> dataName = new ArrayList<>();
    static UserMomo currentUser = UserMomoService.currentUser;

    static {
        try (FileReader fileName = new FileReader("src\\file\\data\\dataName.csv");
             FileReader fileData3G = new FileReader("src\\file\\data\\data3G.csv");
             FileReader fileData4G = new FileReader("src\\file\\data\\data4G.csv");
             FileReader fileData5G = new FileReader("src\\file\\data\\data5G.csv");
             BufferedReader bufferName = new BufferedReader(fileName);
             BufferedReader bufferData3G = new BufferedReader(fileData3G);
             BufferedReader bufferData4G = new BufferedReader(fileData4G);
             BufferedReader bufferData5G = new BufferedReader(fileData5G)) {

            String line1, line2, line3, line4;
            while ((line1 = bufferName.readLine()) != null) {
                dataName.add(line1);
            }
            while ((line2 = bufferData3G.readLine()) != null) {
                ArrayList<String> data3G = parseCsvLine(line2);
                data3GList.add(new Data(data3G.get(0), Integer.parseInt(data3G.get(1)),
                        data3G.get(2), Long.parseLong(data3G.get(3))));
            }
            while ((line3 = bufferData4G.readLine()) != null) {
                ArrayList<String> data4G = parseCsvLine(line3);
                data4GList.add(new Data(data4G.get(0), Integer.parseInt(data4G.get(1)),
                        data4G.get(2), Long.parseLong(data4G.get(3))));
            }
            while ((line4 = bufferData5G.readLine()) != null) {
                ArrayList<String> data5G = parseCsvLine(line4);
                data5GList.add(new Data(data5G.get(0), Integer.parseInt(data5G.get(1)),
                        data5G.get(2), Long.parseLong(data5G.get(3))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewListDataName() {
        int index = 1;
        for (String data : dataName) {
            System.out.println(index++ + ". " + data);
        }
    }

    public String getDataName(int index) {
        return dataName.get(index);
    }

    public void viewListData3G() {
        int index = 1;
        for (Data data : data3GList) {
            System.out.println(index++ + ". " + data.toString());
        }
    }

    public Data getData3G(int index) {
        return data3GList.get(index);
    }

    public void viewListData4G() {
        int index = 1;
        for (Data data : data4GList) {
            System.out.println(index++ + ". " + data.toString());
        }
    }

    public Data getData4G(int index) {
        return data4GList.get(index);
    }

    public void viewListData5G() {
        int index = 1;
        for (Data data : data5GList) {
            System.out.println(index++ + ". " + data.toString());
        }
    }

    public Data getData5G(int index) {
        return data5GList.get(index);
    }

    public boolean buyData(Data data, String phoneNumber, UserMomo userMomo) {
        currentUser = userMomo;
        if (currentUser.getMoney() >= data.getPrice()) {
            PhoneNumberService.setData(phoneNumber, data.getName(), data.getData(), data.getTimeService(), data.getPrice());
            return true;
        }
        return false;
    }
}
