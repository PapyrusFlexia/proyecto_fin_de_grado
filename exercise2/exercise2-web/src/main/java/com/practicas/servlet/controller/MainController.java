package com.practicas.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practicas.dao.CarDaoImpl;
import com.practicas.model.Car;
import com.practicas.services.CarFiltro;
import com.practicas.services.CarService;
import com.practicas.services.UtilsService;

@Controller("mainController")
public class MainController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UtilsService utilsService;
	


	public void MainAction(HttpServletRequest request, HttpServletResponse response) {

		List<Car> cars = carService.getCars(0, 10);
		long contador = carService.totalCar();

		request.setAttribute("total", contador);
		request.setAttribute("cars", cars);

	}

	public void paginacion(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		long contador = carService.totalCar();
		long ultima = contador / 10;
		int r = (int) contador % 10;
		if (Long.valueOf(request.getParameter("page")) == ultima) {
			end = begin + r;
		}

		request.setAttribute("total", contador);
		List<Car> cars = carService.getCars(begin, end);
		// long count = CarService.totalCar;
		// request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		request.setAttribute("page", page);
	}

	public void filtrar(HttpServletRequest request, HttpServletResponse response) {

		String annoFiltro = (String) request.getParameter("year");
		String makeFiltro = (String) request.getParameter("make");
		String hybridFiltro = (String) request.getParameter("hybrid");
		String classificationFiltro = (String) request.getParameter("classification");
		CarFiltro filtro = new CarFiltro();
		List<Predicate<Car>> p = new ArrayList<Predicate<Car>>();
		if (!annoFiltro.equals("null") && !annoFiltro.equals("0")) {
			p.add(filtro.anno(Integer.parseInt(annoFiltro)));

		}
		if (!makeFiltro.equals("null")) {
			p.add(filtro.make(makeFiltro));
		}
		if (!hybridFiltro.equals("null")) {
			p.add(filtro.hibrido(Boolean.valueOf(hybridFiltro)));
		}
		if (!classificationFiltro.equals("null")) {
			p.add(filtro.clasificacion(classificationFiltro));
		}
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		long contador = carService.getCarsCount(p);
		long ultima = contador / 10;
		int r = (int) contador % 10;
		if (Long.valueOf(request.getParameter("page")) == ultima) {
			end = begin + r;
		}

		List<Car> cars = carService.getCars(begin, end, p);
		request.setAttribute("cars", cars);
		request.setAttribute("make", makeFiltro);
		request.setAttribute("year", annoFiltro);
		request.setAttribute("hybrid", hybridFiltro);
		request.setAttribute("classification", classificationFiltro);
		request.setAttribute("total", contador);
		request.setAttribute("page", page);
		request.setAttribute("ultima", ultima);

	}

	/*
	 * public void ordenar(HttpServletRequest request, HttpServletResponse response)
	 * { String pkOrden = (String) request.getParameter("pk"); String modeloOrden =
	 * (String) request.getParameter("id"); String makeOrden = (String)
	 * request.getParameter("make"); String annoOrden = (String)
	 * request.getParameter("year");
	 * 
	 * 
	 * CarService service = new CarService(); CarFiltro filtro = new CarFiltro();
	 * List<Predicate<Car>> p = new ArrayList<Predicate<Car>>(); if
	 * (!annoFiltro.equals("null")) {
	 * p.add(filtro.anno(Integer.parseInt(annoFiltro)));
	 * 
	 * } if (!annoFiltro.equals("null")) { p.add(filtro.make(makeFiltro)); } String
	 * page = request.getParameter("page"); int begin = 0; int end = 10; if (page !=
	 * null) { begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10; end = begin + 10;
	 * }
	 * 
	 * long contador = service.getCarsCount(p); long ultima = contador / 10; int r =
	 * (int) contador % 10; if (Long.valueOf(request.getParameter("page")) ==
	 * ultima) { end = begin + r; }
	 * 
	 * List<Car> cars = service.getCars(begin, end, p); request.setAttribute("cars",
	 * cars); request.setAttribute("make", makeFiltro); request.setAttribute("year",
	 * annoFiltro); request.setAttribute("total", contador);
	 * request.setAttribute("page", page); request.setAttribute("ultima", ultima);
	 * 
	 * }
	 */

	public void detalles(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pk = request.getParameter("pk");
		if (pk == null) {
			throw new Exception("Coche no encontrado");
		}
		String redirect = request.getParameter("redirect");
		Car car = carService.getCarByPk(Integer.valueOf(pk));
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car);
		request.setAttribute("drivelines", utilsService.getCarsDriveLines());
		request.setAttribute("classifications", utilsService.getCarsClassificationsTabla());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("fueltypes", utilsService.getCarsFuelTypes());
		request.setAttribute("transmissions", utilsService.getCarsTransmissions());

	}

	/*
	 * public Comparator<Car> CarComparator() { Comparator<Car> compareByMake = new
	 * Comparator<Car>() {
	 * 
	 * @Override public int compare(Car o1, Car o2) {
	 * 
	 * int multiplicador = 1; return multiplicador *
	 * (o1.getIdentification().getMake().compareTo(o2.getIdentification().getMake())
	 * ); } }; return compareByMake;
	 * 
	 * }
	 */

	/*
	 * public <CarComparator> void ordenarMake(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { int
	 * begin = 0; int end = 63; List<Predicate<Car>> ps = new
	 * ArrayList<Predicate<Car>>(); CarService carservice = new CarService();
	 * CarComparator makecomparator = (CarComparator) CarComparator(); List<Car>
	 * cars = carservice.getCarsSortMake(begin, end, ps,
	 * (com.practicas.model.comparators.CarComparator) makecomparator);
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String un = request.getParameter("username");
		String pw = request.getParameter("password");

		if (un.equals("admin") && pw.equals("admin")) {
			response.sendRedirect("success.html");
			return;
		} else {
			response.sendRedirect("error.jsp");
			return;
		}
	}

}
