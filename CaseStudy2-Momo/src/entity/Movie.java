package entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private String name;
    private String cinemaName;
    private String day;
    private ArrayList<String> time;
    private ArrayList<Integer> seat;
    private long movieTicketPrice;

    public Movie(String name, String cinemaName, String day, ArrayList<String> time, ArrayList<Integer> seat, long movieTicketPrice) {
        this.name = name;
        this.cinemaName = cinemaName;
        this.day = day;
        this.time = time;
        this.seat = seat;
        this.movieTicketPrice = movieTicketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Integer> getSeat() {
        return seat;
    }

    public void setSeat(ArrayList<Integer> seat) {
        this.seat = seat;
    }

    public long getMovieTicketPrice() {
        return movieTicketPrice;
    }

    public void setMovieTicketPrice(long movieTicketPrice) {
        this.movieTicketPrice = movieTicketPrice;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", day='" + day + '\'' +
                ", time=" + time +
                ", seat=" + seat +
                ", movieTicketPrice=" + movieTicketPrice +
                '}';
    }
}
