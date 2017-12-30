package org.demo.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
class BookingRestController {
    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping("/bookings")
    Collection<Booking> bookings() {
        return this.bookingRepository.findAll();
    }
}
