package com.company.chatterbook.model;
import java.util.List;

public class User {
    // String that holds the user name
    String name;
    // List of chatterPosts for a single user
    List<ChatterPost> chatterPosts;

    // Constructs a new user
    public User(String name){
        this.name = name;
    }

    // Setter for the chatterPosts list
    public void setChatterPosts(List<ChatterPost> posts){
        chatterPosts = posts;
    }
    // Getter for the username
    public String getName(){
        return name;
    }

    // getter for the list of chatterPosts
    public List<ChatterPost> getChatterPosts(){
        return chatterPosts;
    }
}
