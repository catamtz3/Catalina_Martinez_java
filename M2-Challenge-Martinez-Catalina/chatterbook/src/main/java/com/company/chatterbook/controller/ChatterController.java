package com.company.chatterbook.controller;

import com.company.chatterbook.model.ChatterPost;
import com.company.chatterbook.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ChatterController {
    // A list that holds all ChatterPost users
    private List<User> userList;

    // Method that fills our program with pre-given ChatterPost and User data
    public ChatterController() {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    // Gets all the users and their posts
    // Returns Status 200 if successful
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> returnAllUsers(){
        return userList;
    }

    // Gets a single username and their posts by their username
    // Returns Status 200 if successful
    @RequestMapping(value = "/users/{user}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User returnUserByName(@PathVariable String user){
        User foundUser = null;
        for(User userInList: userList){
            if(userInList.getName().toLowerCase().equals(user.toLowerCase())){
                foundUser = userInList;
            }
        }
        return foundUser;
    }

    // Gets a single users posts by their username
    // Returns Status 200 if successful
    @RequestMapping(value = "/userPosts/{user}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ChatterPost> returnOneUserPosts(@PathVariable String user){
        List<ChatterPost> foundUser = null;
        for(User userInList: userList){
            if(userInList.getName().toLowerCase().equals(user.toLowerCase())){
                foundUser = userInList.getChatterPosts();
            }
        }
        return foundUser;
    }
}
