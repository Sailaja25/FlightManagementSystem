package com.cg.controller;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bean.Booking;
import com.cg.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController 
{

	@Autowired
	BookingService bookingService;
	
	/*
	 * 
	 URI : http://localhost:9001/booking/showAllBookings
	 METHOD : GET
	 */
	@GetMapping("/showAllBookings")
	public List<Booking> showAllBookings()
	{
		return bookingService.viewBooking();
	}
	
	/*
	 URI : http://localhost:9001/booking/addBooking
	 METHOD : POST
	 */
	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking newBooking)
	{
		bookingService.validateBooking(newBooking);
		return bookingService.addBooking(newBooking);
	}
	
	/* 
	 URI : http://localhost:9001/booking/showById/1000
	 METHOD : GET
	 */
	@GetMapping("/showById/{bookingId}")
	public Booking showById(@PathVariable BigInteger bookingId)
	{
		return bookingService.viewBooking(bookingId);
	}
	
	/*
	 URI : http://localhost:9001/booking/modifyBooking
	 METHOD : PUT
	 */
	@PutMapping("/modifyBooking")
	public Booking updateBooking(@RequestBody Booking updateBooking)
	{
		bookingService.validateBooking(updateBooking);
		return bookingService.modifyBooking(updateBooking);
	}
	
	/*
	 URI : http://localhost:9001/booking/deleteBooking/1000
	 METHOD : DELETE
	 */
	@DeleteMapping("/deleteBooking/{bookingId}")
	public void deleteBooking(@PathVariable BigInteger bookingId)
	{
		bookingService.deleteBooking(bookingId);
	}
	
}





