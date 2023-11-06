package service;

import entity.Cinema;
import entity.Movie;
import entity.UserMomo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static service.UserBankService.parseCsvLine;

public class MovieService implements iCinemaPathName, iTrade {
    static List<Movie> movieList = new ArrayList<>();
    static List<Cinema> cinemaList = CinemaService.cinemaList;
    static UserMomo currentUser;

    static {
        try {
            for (Cinema cinema : cinemaList) {
                String cinemaName = null;
                if (cinema.getName().equals(CINEMA_NAME_AEON)) {
                    cinemaName = AEON_PATHNAME;
                } else if (cinema.getName().equals(CINEMA_NAME_GALAXY)) {
                    cinemaName = GALAXY_PATHNAME;
                }
                List<String> days = cinema.getDay();
                for (String day : days) {
                    String[] getDay = day.split("/", 0);
                    Integer getDays = Integer.parseInt(getDay[0]);
                    try (FileReader fileTime = new FileReader(CINEMA_PATHNAME + cinemaName + DAY_PATHNAME + getDays + TIME_PATHNAME);
                         FileReader fileSeat = new FileReader(CINEMA_PATHNAME + cinemaName + DAY_PATHNAME + getDays + SEAT_PATHNAME);
                         FileReader fileMovie = new FileReader(CINEMA_PATHNAME + cinemaName + DAY_PATHNAME + getDays + LIST_MOVIE_IN_DAY_PATHNAME);
                         FileReader fileMovieTicketPrice = new FileReader(CINEMA_PATHNAME + cinemaName + DAY_PATHNAME + getDays + MOVIE_TICKET_PATHNAME);
                         BufferedReader bufferedTime = new BufferedReader(fileTime);
                         BufferedReader bufferedSeat = new BufferedReader(fileSeat);
                         BufferedReader bufferedMovie = new BufferedReader(fileMovie);
                         BufferedReader bufferedMovieTicketPrice = new BufferedReader(fileMovieTicketPrice)) {

                        String line1, line2, line3, line4;
                        while ((line1 = bufferedTime.readLine()) != null
                                && (line2 = bufferedSeat.readLine()) != null
                                && (line3 = bufferedMovieTicketPrice.readLine()) != null
                                && (line4 = bufferedMovie.readLine()) != null) {
                            ArrayList<String> timeList = parseCsvLine(line1);
                            ArrayList<Integer> seatList = parseListInteger(parseCsvLine(line2));
                            long movieTicketPrice = Long.parseLong(line3);
                            movieList.add(new Movie(line4, cinema.getName(), day, timeList, seatList, movieTicketPrice));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> parseListInteger(ArrayList<String> stringArrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String str : stringArrayList) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    public static ArrayList<Long> parseListLong(ArrayList<String> stringArrayList) {
        ArrayList<Long> result = new ArrayList<>();
        for (String str : stringArrayList) {
            result.add(Long.parseLong(str));
        }
        return result;
    }


    public boolean getTicketMovie(String cinemaName, String movieName, String day, String time, int ticketQuantity, UserMomo userMomo) {
        long priceTicket = getMovieTicketPriceOfMovie(cinemaName, movieName, day, time);
        int seat = getSeatOfMovie(cinemaName, movieName, day, time);
        long totalPriceTicket = priceTicket * ticketQuantity;
        currentUser = userMomo;
        if (seat >= ticketQuantity && userMomo.getMoney() >= totalPriceTicket) {
            userMomo.setMoney(userMomo.getMoney() - totalPriceTicket);
            UserMomoService.updateFileUserMomo();
            setSeatOfMovie(cinemaName, movieName, day, time, ticketQuantity);
            updateFileSeat(cinemaName, day);
            writeHistoryTrade(GET_TICKET_MOVIE, totalPriceTicket);
            return true;
        }
        return false;
    }

    public static void writeHistoryTrade(String trade, long money) {
        try (FileWriter fileWriter = new FileWriter("src\\file\\history.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            LocalDateTime time = LocalDateTime.now();
            bufferedWriter.write(currentUser.getUsername());
            bufferedWriter.write(" {Giao dịch mua vé xem phim: ");
            bufferedWriter.write("Số tiền: " + money);
            bufferedWriter.write("; Số dư ví Momo: " + currentUser.getMoney());
            bufferedWriter.write("; Thời gian: " + time + " }\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateFileSeat(String cinemaName, String day) {
        String cinemaPathName = null;
        if (cinemaName.equals(CINEMA_NAME_AEON)) {
            cinemaPathName = AEON_PATHNAME;
        } else if (cinemaName.equals(CINEMA_NAME_GALAXY)) {
            cinemaPathName = GALAXY_PATHNAME;
        }
        String[] getDay = day.split("/", 0);
        Integer getDays = Integer.parseInt(getDay[0]);
        try (FileWriter fileWriter = new FileWriter(CINEMA_PATHNAME + cinemaPathName + DAY_PATHNAME + getDays + SEAT_PATHNAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Movie movie : movieList) {
                if (movie.getCinemaName().equals(cinemaName) && movie.getDay().equals(day)) {
                    for (int i = 0; i < movie.getSeat().size(); i++) {
                        bufferedWriter.write(movie.getSeat().get(i) + ",");
                    }
                    bufferedWriter.write("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setSeatOfMovie(String cinemaName, String movieName, String day, String time, int seatQuantity) {
        ArrayList<Integer> newSeatList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getName().equals(movieName) && movie.getDay().equals(day)) {
                for (int i = 0; i < movie.getTime().size(); i++) {
                    if (movie.getTime().get(i).equals(time)) {
                        Integer seat = movie.getSeat().get(i);
                        newSeatList.add(seat - seatQuantity);
                    } else {
                        newSeatList.add(movie.getSeat().get(i));
                    }
                }
                movie.setSeat(newSeatList);
                return;
            }
        }
    }

    private int getSeatOfMovie(String cinemaName, String movieName, String day, String time) {
        int seat = 0;
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getName().equals(movieName) && movie.getDay().equals(day)) {
                for (int i = 0; i < movie.getTime().size(); i++) {
                    if (movie.getTime().get(i).equals(time)) {
                        seat = movie.getSeat().get(i);
                    }
                }
            }
        }
        return seat;
    }

    private long getMovieTicketPriceOfMovie(String cinemaName, String movieName, String day, String time) {
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getName().equals(movieName) && movie.getDay().equals(day)) {
                for (int i = 0; i < movie.getTime().size(); i++) {
                    if (movie.getTime().get(i).equals(time)) {
                        return movie.getMovieTicketPrice();
                    }
                }
            }
        }
        return 0;
    }

    public ArrayList<String> getTimeListOfMovieInDay(String cinemaName, String movieName, String day) {
        ArrayList<String> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName) && movie.getCinemaName().equals(cinemaName) && movie.getDay().equals(day)) {
                result = movie.getTime();
            }
        }
        return result;
    }

    public String getTimeOfMovieInDay(String cinemaName, String movieName, String day, int index) {
        ArrayList<String> timeList = getTimeListOfMovieInDay(cinemaName, movieName, day);
        return timeList.get(index);
    }

    public ArrayList<String> getMovieListInDay(String cinemaName, String day) {
        ArrayList<String> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getDay().equals(day)) {
                result.add(movie.getName());
            }
        }
        return result;
    }

    public String getMovieNameInDay(String cinemaName, String day, int index) {
        ArrayList<String> movieNameList = getMovieListInDay(cinemaName, day);
        return movieNameList.get(index);
    }

    public void viewTimeListOfMovie(String cinemaName, String movieName, String day) {
        ArrayList<String> timeList = getTimeListOfMovieInDay(cinemaName, movieName, day);
        int index = 1;
        for (String time : timeList) {
            System.out.println(index++ + ". " + time);
        }
    }

    public void viewMovieList() {
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
        }
    }

    public void viewMovieListInCinema(String cinemaName) {
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName)) {
                System.out.println(movie.toString());
            }
        }
    }

    public void viewMovieNameListInCinema(String cinemaName, String day) {
        int index = 1;
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getDay().equals(day)) {
                System.out.println(index++ + ". " + movie.getName());
            }
        }
    }

    public void viewMovie(String cinemaName, String movieName) {
        for (Movie movie : movieList) {
            if (movie.getCinemaName().equals(cinemaName) && movie.getName().equals(movieName)) {
                System.out.println(movie.toString());
            }
        }
    }
}
