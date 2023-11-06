package service;

public class User {
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.id = (int) (Math.random()*(9999-1000+1)+ 1000);
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
