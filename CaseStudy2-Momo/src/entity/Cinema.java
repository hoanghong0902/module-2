package entity;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private ArrayList<String> day;
    private ArrayList<String> movieList;

    public Cinema(String name, ArrayList<String> day, ArrayList<String> movieList) {
        this.name = name;
        this.day = day;
        this.movieList = movieList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDay() {
        return day;
    }

    public void setDay(ArrayList<String> day) {
        this.day = day;
    }

    public ArrayList<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<String> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", day=" + day +
                ", movieList=" + movieList +
                '}';
    }
}
