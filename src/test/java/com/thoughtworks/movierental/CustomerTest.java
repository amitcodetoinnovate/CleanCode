package com.thoughtworks.movierental;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldGenerateStatement(){
        Customer customer = new Customer("Cus1");
        Movie movie1 = new Movie("movie1",Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1,5);
        customer.addRental(rental1);
        String actualStatement = customer.statement();
        //System.out.println(customer.statement());
        String statement = "Rental Record for Cus1\n" +
                "\tmovie1\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points";
        assertThat(actualStatement,is(statement));


    }

    @Test
    public void shouldGenerateHTMLStatement(){
        Customer customer = new Customer("Cus1");
        Movie movie1 = new Movie("movie1",Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1,5);
        customer.addRental(rental1);
        String actualStatement = customer.HTMLStatement();
        //System.out.println(customer.statement());
        String statement = "<h1>Rental Record for <b>Cus1</b></h1><br/>" +
                "movie1<br/>15.0<br/>" +
                "Amount owed is <b>15.0</b><br/>" +
                "You earned <b>2</b> frequent renter points";
        assertThat(actualStatement,is(statement));


    }
}