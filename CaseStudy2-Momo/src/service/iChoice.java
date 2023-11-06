package service;

public interface iChoice {

    int EXIT = 0;
    int REGISTER = 1;
    int LOGIN = 2;

    int YES = 1;
    int NO = 2;

    int RECHARGE_MOMO = 1;
    int TRANSFER_MONEY_MOMO = 2;
    int WITHDRAW_MONEY_MOMO = 3;
    int RECHARGE_PHONE_NUMBER = 4;
    int RECHARGE_DATA = 5;
    int PAY_THE_BILL_MOMO = 6;
    int GET_TICKET_MOVIE = 7;
    int VIEW_HISTORY_TRADE = 8;
    int VIEW_MOMO_INFORMATION = 9;
    int CHANGE_INFORMATION_MOMO = 10;
    int DELETE_ACCOUNT_MOMO = 11;
    int LOGOUT = 12;

    int TRANSFER_MONEY_TO_MOMO = 1;
    int TRANSFER_MONEY_TO_BANK = 2;

    int CHANGE_USERNAME = 1;
    int CHANGE_PASSWORD = 2;
    int CHANGE_PHONE_NUMBER = 3;
    int CHANGE_BANK_ACCOUNT_NUMBER = 4;

    int AEON_CINEMA = 1;
    int GALAXY_CINEMA = 2;

    int PAYMENT_OF_ELECTRICITY = 1;
    int PAYMENT_OF_WATER_BILL = 2;
    int PAYMENT_OF_INTERNET_BILL = 3;
    int PAYMENT_OF_POSTPAID_WALLET = 4;
    int PAYMENT_OF_LOAN_BILL = 5;
}
