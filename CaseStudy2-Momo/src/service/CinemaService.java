package service;

import entity.Cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaPathName {
    public static ArrayList<Cinema> cinemaList = new ArrayList<>();

    static {
        try (FileReader fileCinema = new FileReader(CINEMA_PATHNAME + CINEMA_LIST_PATHNAME);
             FileReader fileDay = new FileReader(CINEMA_PATHNAME + DAY_LIST_PATHNAME);
             FileReader fileMovie = new FileReader(CINEMA_PATHNAME + MOVIE_LIST_PATHNAME);
             BufferedReader bufferedCinema = new BufferedReader(fileCinema);
             BufferedReader bufferedDay = new BufferedReader(fileDay);
             BufferedReader bufferedMovie = new BufferedReader(fileMovie)) {
            String line1, line2, line3;
            ArrayList<String> days = new ArrayList<>();
            while ((line2 = bufferedDay.readLine()) != null) {
                days.add(line2);
            }
            ArrayList<String> movies = new ArrayList<>();
            while ((line3 = bufferedMovie.readLine()) != null) {
                movies.add(line3);
            }
            while ((line1 = bufferedCinema.readLine()) != null) {
                cinemaList.add(new Cinema(line1, days, movies));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewCinemaList() {
        for (Cinema cinema : cinemaList) {
            System.out.println(cinema.toString());
        }
    }

    public ArrayList<String> getDayListOfCinema(String cinemaName) {
        ArrayList<String> result = new ArrayList<>();
        for (Cinema cinema : cinemaList) {
            if (cinema.getName().equals(cinemaName)) {
                result = cinema.getDay();
            }
        }
        return result;
    }

    public String getDayOfCinema(String cinemaName, int index) {
        String result = null;
        for (Cinema cinema : cinemaList) {
            if (cinema.getName().equals(cinemaName)) {
                result = cinema.getDay().get(index);
            }
        }
        return result;
    }

    public void viewDayListOfCinema(String cinemaName) {
        ArrayList<String> dayList = getDayListOfCinema(cinemaName);
        int index = 1;
        for (String day : dayList) {
            System.out.println(index++ + ". " + day);
        }
    }

    public void viewCinemaListName() {
        int index = 1;
        for (Cinema cinema : cinemaList) {
            System.out.println(index++ + ". " + cinema.getName());
        }
    }
}
