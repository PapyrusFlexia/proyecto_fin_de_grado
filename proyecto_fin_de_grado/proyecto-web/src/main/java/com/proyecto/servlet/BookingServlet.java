package com.proyecto.servlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.proyecto.model.Booking;
import com.proyecto.model.CarImage;
import com.proyecto.model.Rating;
import com.proyecto.services.CarService;
import com.proyecto.services.data.DatabaseJson;

@WebServlet(name = "BookingServlet", urlPatterns = { "/booking" })
public class BookingServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mainController.booking(request, response);
		request.setAttribute("names", utilsService.getCarsNames());
		request.getRequestDispatcher("./booking.jsp").forward(request, response);
		;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Booking booking = new Booking();
		String dispatcher = "./booking.jsp";
		String numberofusers = request.getParameter("numberofusers");
		String place = request.getParameter("place");
		String startdate = request.getParameter("startdate");
		SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date start;
		try {
		
			start = startDateFormat.parse(startdate);
			booking.setStartdate(start);
		//	booking = carService.saveBooking(booking);
		} catch (ParseException e2) {
	
			e2.printStackTrace();
		}
		
		String finishdate = request.getParameter("finishdate");
		SimpleDateFormat finishDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date finish;
		try {
			
			finish = finishDateFormat.parse(finishdate);
			booking.setFinishdate(finish);
		//	booking = carService.saveBooking(booking);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
	
		String reserved = request.getParameter("reserved");
		String carname = request.getParameter("carname");
		/*String rating = request.getParameter("valorar");
		
		Rating ratingStars = new Rating();
		Booking bookingId = new Booking();

		ratingStars.setRating(Integer.valueOf(rating));
		ratingStars.setBookingid(bookingId.getId());
		ratingStars = carService.saveRating(ratingStars);*/
		
		
		// Validator
		if (numberofusers != null && Integer.valueOf(numberofusers) > 0 && place != null && !place.equals("")
				&& startdate != null && !startdate.equals("") && finishdate != null
				&& !finishdate.equals("") && finishdate != null
				&& !finishdate.equals("") && reserved != null
				&& carname != null && !carname.equals("")) {
			try {
				
				
				booking.setNumberofusers(Integer.valueOf(numberofusers));
				booking.setPlace(place);
				booking.setReserved(Boolean.valueOf(reserved));
				booking.setCarname(carname);
				booking = carService.saveBooking(booking);
		
			
			} catch (Exception e) {
				request.setAttribute("executed", "ok");
				request.getRequestDispatcher("./booked.jsp").forward(request, response);
				try {
					mainController.booking(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispatcher = "./booking.jsp";
			}
			request.getRequestDispatcher("/booked.jsp").forward(request, response);
			

		}
	}

}