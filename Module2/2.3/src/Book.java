public class Book {
    private String title;
    private String author;
    private int year;
    private double rating;
    private String review;
    private int reviewCount;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setReview(String review) {
        this.review = review;
        reviewCount++;
    }

    public String getReview() {
        return review;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }


}
