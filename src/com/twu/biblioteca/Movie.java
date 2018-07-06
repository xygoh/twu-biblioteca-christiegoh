package com.twu.biblioteca;

public class Movie {
    private String title;
    private int year;
    private Director director;
    private Rating rating;
    private User user=null;
    private boolean available;

    // extend this class from Library Item , book as well
    public Movie(String title, int year, boolean available, Director director, Rating rating) {
        this.title = title;
        this.year = year;
        this.available = available;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director.firstName + " " + director.lastName;
    }

    public void getDetails(String format){
        System.out.printf(format,title,director,year);
    }

    public void checkOut(User u){
        available = false;
        user = u;
    }

    public void checkIn(){
        available = true;
        user = null;
    }
}
