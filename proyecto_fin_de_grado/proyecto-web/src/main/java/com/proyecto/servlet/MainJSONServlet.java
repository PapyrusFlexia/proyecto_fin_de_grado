
package com.proyecto.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.proyecto.model.Car;
import com.proyecto.model.Engine;
import com.proyecto.model.PaginaCompleta;
import com.proyecto.model.comparators.CarComparator;
import com.proyecto.services.CarMakeComparator;
import com.proyecto.services.CarPkComparator;
import com.proyecto.services.CarPredicate;
import com.proyecto.services.CarService;
import com.proyecto.services.CarYearComparator;

@WebServlet(name = "MainJSONServlet", 
	urlPatterns = { "/carsJSON" }, 
	initParams = @WebInitParam(name = "location", value = "Hola"),
	loadOnStartup = 1)
public class MainJSONServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaginaCompleta pagina = new PaginaCompleta();
		
	     response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        
       
        /** SERVER SIDE
        
        long total = carService.totalCar();
        int draw = Integer.parseInt(request.getParameter("draw"));
        
        pagina.setiTotalRecords(carService.totalCar());          /////////////////////
        pagina.setiTotalDisplayRecords(carService.totalCar());
        pagina.setAaData(carService.getCars());
        
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        int end = start + length;
        
        CarPredicate p = new CarPredicate();
        List<Predicate<Car>> plist = new ArrayList<Predicate<Car>>();
        
        String make = (String) request.getParameter("columns[2][search][value]");
        String year = (String) request.getParameter("columns[3][search][value]");
        String classification = (String) request.getParameter("columns[4][search][value]");
        String fueltype = (String) request.getParameter("columns[5][search][value]");
        String hybrid = (String) request.getParameter("columns[6][search][value]");
        String search = (String) request.getParameter("[search][value]");
        
        if(make != null && !make.equals("")) {
        	make = make.substring(1,make.length() - 1);
        	plist.add(p.porMarca(make));
        }
        if(year != null && !year.equals("")) {
        	year = year.substring(1,year.length() - 1);
        	plist.add(p.porAnno(Integer.parseInt(year)));
        }
        if(classification != null && !classification.equals("")) {
        	classification = classification.substring(1,classification.length() - 1);
        	plist.add(p.tipoClasificacion(classification));
        }
        if(fueltype != null && !fueltype.equals("")) {
        	fueltype = fueltype.substring(1,fueltype.length() - 1);
        	plist.add(p.tipoFuel(fueltype));
        }
        if(hybrid != null && !hybrid.equals("")) {
        	hybrid = hybrid.substring(1,hybrid.length() - 1);
        	plist.add(p.esHibrido(Boolean.parseBoolean(hybrid)));
        }
        if(search != null && !search.equals("")) { ////////////////
        	plist.add(p.incluyeEnMarca(search));
        }
        
        long count = 0;
        if(plist.size() > 0) {
        	count = carService.getCarsCount(plist);
        	pagina.setiTotalDisplayRecords(count); /////////////////////
        }
        
        String ordercol = request.getParameter("order[0][column]");
        String orderdir = request.getParameter("order[0][dir]");
        boolean orderUsage = orderdir.equals("asc")?true:false;

        
        CarComparator carComparator = null;
        CarMakeComparator carMakeComparator = null;
        CarPkComparator carPkComparator = null;
        CarYearComparator carYearComparator = null;  
        
        
    /** COMPARATORS    if(ordercol != null && !ordercol.equals("")) {
        	order = true;
        	if(ordercol.equals("0")) {
        		if(orderdir.equals("asc")) {
        			carcomparator = new CarComparator(false);
        		}
        	}
        } 
        
        int r = 0;
        if (count > 0) {
        	r = (int) count % 10;
        	
        	if (Long.valueOf(request.getParameter("start")) > count-length) {
        		end = start + r;
        		
        	}
        	
        	switch (ordercol==null?"":ordercol) {
            case "0":
                carPkComparator = new CarPkComparator(orderUsage);
                break;
                
            case "1":
                
                break;
            case "2":
                carMakeComparator = new CarMakeComparator(orderUsage);
                
                break;
            case "3":
                carYearComparator = new CarYearComparator(orderUsage);
                break;
            default:
                break;
            }
            
            pagina.setCars(carService.getCarsCompare(start, end, plist, carComparator)); /// getCarsCompare no creado
        } 
        
        Map<String, List<?>> filters = new HashMap<String, List<?>>();
		
		filters.put("makes", utilsService.getCarsMakes());
		filters.put("years", utilsService.getCarsYears());
		filters.put("classifications", carService.getCarsClassifications());
		filters.put("fueltypes", carService.getCarsFuelTypes());
		pagina.setFilters(filters);
		pagina.setCars(carService.getCars());
 
        
        Gson gson = new Gson();
        out.print(gson.toJson(pagina));
        out.flush(); 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		super.doPost(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse 
			 response)
			        throws ServletException, IOException { **/
	} 
	

	}
 