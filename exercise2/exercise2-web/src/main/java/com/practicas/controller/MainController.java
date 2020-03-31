package com.practicas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.services.CarFiltro;
import com.practicas.services.CarService;

public class MainController {

	public void MainAction(HttpServletRequest request, HttpServletResponse response) {
		CarService carservice = new CarService();
		List<Car> cars = carservice.getCars(0, 10);
		long contador = carservice.totalCar;
		
		request.setAttribute("total", contador);
		request.setAttribute("cars", cars);
		
	}

	public void paginacion(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 *10-10)*10;
			end = begin + 10;
		}
		CarService carservice = new CarService();
		
		long contador = carservice.totalCar;
		long ultima = contador/10;
		int r = (int)contador%10;
		if(Long.valueOf(request.getParameter("page"))==ultima) {
			end = begin + r;
		}
		
		request.setAttribute("total", contador);
		List<Car> cars = CarService.getCars(begin, end);
		// long count = CarService.totalCar;
		// request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		request.setAttribute("page", page);
	}

	public void filtrar(HttpServletRequest request, HttpServletResponse response) {

		String annoFiltro = (String) request.getParameter("year");
		String makeFiltro = (String) request.getParameter("make");
		CarService service = new CarService();
		CarFiltro filtro = new CarFiltro();
		List<Predicate<Car>> p = new ArrayList<Predicate<Car>>();
		if (!annoFiltro.equals("null")) { 
			p.add(filtro.anno(Integer.parseInt(annoFiltro)));

		}
		if (!annoFiltro.equals("null")) { 
			p.add(filtro.make(makeFiltro));
		}
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		long contador = service.getCarsCount(p);
		long ultima = contador / 10;
		int r = (int) contador % 10;
		if (Long.valueOf(request.getParameter("page")) == ultima) {
			end = begin + r;
		}

		List<Car> cars = service.getCars(begin, end, p);
		request.setAttribute("cars", cars);
		request.setAttribute("make", makeFiltro);
		request.setAttribute("year", annoFiltro);
		request.setAttribute("total", contador);
		request.setAttribute("page", page);
		request.setAttribute("ultima", ultima);

	}
	
	public void detalles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarService carservice = new CarService();
		String pk = request.getParameter("pk");
		if(pk == null) {
			throw new Exception("Coche no encontrado");
		}
		String redirect = request.getParameter("redirect");
		Optional<Car> car = CarService.getCarByPk(Integer.valueOf(pk));
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car.get());
		request.setAttribute("drivelines", carservice.getCarsDrivelines());
		request.setAttribute("classifications", carservice.getCarsClassifications());
		request.setAttribute("years", carservice.getCarsAnnos());
		request.setAttribute("fueltypes", carservice.getCarsFuelTypes());

	}

}
