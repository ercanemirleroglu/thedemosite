package users;

import base.MainPage;


public class User {
    public String username;
    public String password;
    public final String ercanUser = "testuser";
    public final String ercanPass = "testpass";
    private MainPage mainPage = new MainPage();

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
