package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return Header() + Body() +Footer();
  }


  public String HTMLStatement() {
    return HTMLHeader() + HTMLBody() +HTMLFooter();
  }

  private double totalAmount()
  {
    int amount = 0;
    for(Rental rental : rentals){
      amount += rental.amount();
    }
    return amount;

  }
  private int FrequentResultPointer()
  {
    int result = 0;
    for(Rental rental : rentals){
      result += rental.FrequentResultPointer();
    }
    return result;

  }

  private String Body(){
    String result = "";
    for (Rental rental : rentals) {

      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" +
              String.valueOf(rental.amount()) + "\n";

    }
    return result;
  }

  private String Footer(){
    String result = "";
    result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
    result += "You earned " + String.valueOf(FrequentResultPointer())
            + " frequent renter points";
    return result;
  }
  private String Header(){
    return "Rental Record for " + getName() + "\n";
  }

  private String HTMLHeader() {
    return "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";

  }
  private String HTMLBody() {
    String result = "";
    for (Rental rental : rentals) {

      //show figures for this rental
      result += rental.getMovie().getTitle() + "<br/>" +
              String.valueOf(rental.amount()) + "<br/>";

    }
    return result;
  }

  private String HTMLFooter(){
    String result = "";
    result += "Amount owed is <b>" + String.valueOf(totalAmount()) + "</b><br/>";
    result += "You earned <b>" + String.valueOf(FrequentResultPointer())
            + "</b> frequent renter points";
    return result;
  }
}

