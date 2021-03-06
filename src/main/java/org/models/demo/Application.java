package org.models.demo;

import org.models.demo.Booking.Booking;
import org.models.demo.Booking.BookingRepository;
import org.models.demo.bookmarks.Account;
import org.models.demo.bookmarks.AccountRepository;
import org.models.demo.bookmarks.Bookmark;
import org.models.demo.bookmarks.BookmarkRepository;
import org.models.demo.person.Person;
import org.models.demo.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository) {
        return (evt) -> {
            Arrays.asList(
                    "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                    .forEach(
                            a -> {
                                Account account = accountRepository.save(new Account(a,
                                        "password"));
                                bookmarkRepository.save(new Bookmark(account,
                                        "http://bookmark.com/1/" + a, "A description"));
                                bookmarkRepository.save(new Bookmark(account,
                                        "http://bookmark.com/2/" + a, "A description"));
                            });

        };
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
