package com.proyecto.servlet.controller;

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

import com.proyecto.dao.CarDao;
import com.proyecto.dao.CarDaoImpl;
import com.proyecto.dao.ClassificationDao;
import com.proyecto.dao.EngineDao;
import com.proyecto.dao.MakeDao;
import com.proyecto.model.Car;
import com.proyecto.model.CarImage;
import com.proyecto.model.Engine;
import com.proyecto.services.CarService;
import com.proyecto.services.UtilsService;

@Controller("mainController")
public class MainController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UtilsService utilsService;
	
	@Autowired
	private MakeDao makeDao;
	
	@Autowired
	private EngineDao engineDao;
	
	@Autowired
	private ClassificationDao classificationDao;
	
	@Autowired
	private CarDao carDao;
	

	public void MainAction(HttpServletRequest request, HttpServletResponse response) {

		List<Car> cars = carService.getCars(10, 0);
		long contador = carService.totalCar();

		request.setAttribute("total", contador);
		request.setAttribute("cars", cars);

	}

	public void paginacion(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		request.setAttribute("total", 50);
		List<Car> cars = carService.getCars(10, Integer.valueOf(page));
		// long count = CarService.totalCar;
		// request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		request.setAttribute("page", page);
	}

	public void filtrar(HttpServletRequest request, HttpServletResponse response) {

		String annoFiltro = (String) request.getParameter("year");
		String makeFiltro = (String) request.getParameter("make");
		String hybridFiltro = (String) request.getParameter("hybrid");
		
	
		List<Car> cars = new ArrayList<>();
		
		if (!annoFiltro.equals("null") && !annoFiltro.equals("0") ) {
			int annoFiltroInt = Integer.parseInt(annoFiltro);
			cars = carDao.findYearByName(annoFiltroInt); /////////// PASARLO POR CARSERVICE Y PASARLE BOOLEAN E INTEGER EN CARDAOIMPL Y HACER 15, 25, 50 en PAGINATION
		
		}
		if (!makeFiltro.equals("null") && !makeFiltro.equals("0") && !makeFiltro.equals("")) {
	
			cars = carDao.findMakeByName(makeFiltro);
		}
		else if (!hybridFiltro.equals("null") && !hybridFiltro.equals("0") && !hybridFiltro.equals("")) {
			boolean hybridFiltroBoolean = Boolean.parseBoolean(hybridFiltro); 
			cars = carDao.findHybridByName(hybridFiltroBoolean);
		}
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		

		
		request.setAttribute("cars", cars);
		request.setAttribute("make", makeFiltro);
		request.setAttribute("year", annoFiltro);
		request.setAttribute("hybrid", hybridFiltro);
	
		request.setAttribute("page", page);


	}

	

	public void detalles(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pk = request.getParameter("pk");
		if (pk == null) {
			throw new Exception("Coche no encontrado");
		}
		String redirect = request.getParameter("redirect");
		Car car = carService.getCarByPk(Integer.valueOf(pk));
		CarImage carImage = carService.getCarImageByCarPk(Integer.valueOf(pk));
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car);
		request.setAttribute("carImage", carImage);
		request.setAttribute("make", utilsService.getCarsMakes());
		request.setAttribute("drivelines", utilsService.getCarsDriveLines());
		request.setAttribute("classifications", utilsService.getCarsClassificationsTabla());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("fueltypes", utilsService.getCarsFuelTypes());
		request.setAttribute("transmissions", utilsService.getCarsTransmissions());

	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pk = request.getParameter("pk");
		if (pk == null) {
			throw new Exception("Coche no encontrado");
		}
		String redirect = request.getParameter("redirect");
		Car car = carService.getCarByPk(Integer.valueOf(pk));
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car);
		request.setAttribute("make", utilsService.getCarsMakes());
		request.setAttribute("drivelines", utilsService.getCarsDriveLines());
		request.setAttribute("classifications", utilsService.getCarsClassificationsTabla());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("fueltypes", utilsService.getCarsFuelTypes());
		request.setAttribute("transmissions", utilsService.getCarsTransmissions());

	}
	
	public void insertar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pk = request.getParameter("pk");
		if (pk == null) {
			throw new Exception("Coche no encontrado");
		}
		String redirect = request.getParameter("redirect");
		Car car = carService.getCarByPk(Integer.valueOf(pk));
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car);
		request.setAttribute("make", utilsService.getCarsMakes());
		request.setAttribute("drivelines", utilsService.getCarsDriveLines());
		request.setAttribute("classifications", utilsService.getCarsClassificationsTabla());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("fueltypes", utilsService.getCarsFuelTypes());
		request.setAttribute("transmissions", utilsService.getCarsTransmissions());

	}
	
	public void insertarUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String redirect = request.getParameter("redirect");
		request.setAttribute("redirect", redirect);
	

	}
	
	public void booking(HttpServletRequest request, HttpServletResponse response) throws Exception {

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