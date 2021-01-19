package by;

public class kino {
    private String name;
    private String genre;
    private String rating;
    private String actor;
    private String director;
    private String url;

    public kino() {
    }

    public kino(String name, String genre, String rating, String actor, String director, String url) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.actor = actor;
        this.director = director;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
