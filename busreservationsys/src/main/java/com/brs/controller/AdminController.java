 package com.brs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Admin;
import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.Route;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.service.IAdminService;
import com.brs.service.IBusService;
import com.brs.service.IReservationService;
import com.brs.service.IRouteService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {
	
	@Autowired
	private IAdminService adminservice;
	
	@Autowired
	private IReservationService reservationservice;
	
	@Autowired
	private IRouteService routeservice;

	@Autowired
	private IBusService busService;
	
	//Admin Login
	@GetMapping("/login/{Adminusername}/{Adminpassword}")
	public ResponseEntity<Admin> signIn(@PathVariable String adminUsername, @PathVariable String adminPassword){
		Admin temp = adminservice.signIn(adminUsername,adminPassword);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	
	//Admin logout
	@GetMapping("/logout")
	public ResponseEntity<String> signOut(){
		String temp = adminservice.signOut();
		return new ResponseEntity<String>(temp,HttpStatus.OK);
	}

	//Updating admin details
	@PutMapping("/update/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable String id,@RequestBody Admin admin) throws AdminNotFoundException
	{
		Admin updatedAdmin = adminservice.updateAdmin(Integer.parseInt(id),admin);
	    return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);
    }
	
	//Getting all reservations done
	@GetMapping("/getAllreservations")
	public List<Reservation> getAllBookings() throws ReservationNotFoundException {
		return reservationservice.viewAllReservation();
	}
	
	
	
	//Getting all the routes available
	@GetMapping("getAllRoutes")
	public List<Route> getAllRoutes() throws RouteNotFoundException {
		return routeservice.viewAllRoute();
	}
	
	//addingRouteDetails
	@PostMapping("/addroute/{id}")
	public ResponseEntity<Route> addRouteDetails(@PathVariable("id") String hotel_id,@RequestBody Route route) throws RouteNotFoundException {
			
		return new ResponseEntity<Route>(routeservice.addRoute(route),HttpStatus.OK);
	}
		
	//updateRouteDetails
	@PutMapping("/updateroute/{id}")
	public ResponseEntity<Route> updateRouteDetails(@PathVariable("id") String id,@RequestBody Route route) throws RouteNotFoundException {
			
		return new ResponseEntity<Route>(routeservice.updateRoute(route),HttpStatus.OK);
	}
		
	//removeRouteDetails
	@DeleteMapping("/removeRoute/{id}")
	public ResponseEntity<Route> removeRouteDetails(@PathVariable("id") long routeId) throws RouteNotFoundException, ReservationNotFoundException {		
			return new ResponseEntity<Route>(routeservice.deleteRoute(routeId), HttpStatus.OK);
	}
	
	
	//GetBusDetails
	@GetMapping("/showBus/{id}")
	public ResponseEntity<Bus> showRoomDetails(@PathVariable("id") int busId) throws BusNotFoundException {
		
		return new ResponseEntity<Bus>(busService.getBus(busId),HttpStatus.OK);
	}
		
	//Add Bus Details
	@PostMapping("addBus")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) throws BusNotFoundException {
		return new ResponseEntity<>(busService.addBus(bus), HttpStatus.OK);
	}

	//update bus details
	@PutMapping("updatebus")
	public ResponseEntity<Bus> updatebus(@Valid @RequestBody Bus bus) throws BusNotFoundException {
		return new ResponseEntity<>(busService.updateBus(bus), HttpStatus.OK);
	}

	//Delete bus details
	@DeleteMapping("deletebus/{busid}")
	public ResponseEntity<Bus> deleteBus(@PathVariable("busid") int busId) throws BusNotFoundException {
		
		return new ResponseEntity<>(busService.deleteBus(busId), HttpStatus.OK);

	}
     //view Bus By Id
	@GetMapping("view/{busid}")
	public ResponseEntity<Bus> getBusById(@PathVariable("busid") int busId) throws BusNotFoundException {
		return new ResponseEntity<>(busService.getBus(busId), HttpStatus.OK);
	}

	//View AllBuses
	@GetMapping("allbus")
	public ResponseEntity<List<Bus>> getAllBus() {
		
		return new ResponseEntity<List<Bus>>(busService.viewAllBus(), HttpStatus.OK);
	}
		
}
