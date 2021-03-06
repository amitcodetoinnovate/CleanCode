package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int daysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  double amount() {
    double amount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (daysRented() > 2)
          amount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (daysRented > 3)
          amount += (daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }
  public double FrequentResultPointer()
  {
    return isNewReleaseApplicable()?2:1;
  }
  private boolean isNewReleaseApplicable(){
    return this.movie.isNewMovieRelease() && daysRented >1;
  }

}