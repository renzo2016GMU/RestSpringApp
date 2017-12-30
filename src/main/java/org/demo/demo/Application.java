package org.demo.demo;

import org.demo.demo.Booking.Booking;
import org.demo.demo.Booking.BookingRepository;
import org.demo.demo.person.Person;
import org.demo.demo.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}

@Component
class BookingCommandLineRunner implements CommandLineRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(String... strings) throws Exception {
        for (Booking b :
                this.bookingRepository.findAll()) {
            System.out.println(b);
        }
    }
}

@Component
class PersonCommandLineRunner implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... strings) throws Exception {
        for (Person b :
                this.personRepository.findAll()) {
            System.out.println(b);
        }
    }
}

