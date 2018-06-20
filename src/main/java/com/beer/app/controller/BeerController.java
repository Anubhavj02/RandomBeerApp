package com.beer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.beer.app.model.Beer;
import com.beer.app.service.BeerService;

/**
 * Controller to handle to rest request and give appropriate response
 * @author anubhavjain
 *
 */
@Controller
public class BeerController {

	@Autowired
	private BeerService beerService;

	/** 
	 * Redirect to manager beer template file
	 * @return path of managebeer.jsp file
	 */
	@RequestMapping("/manage")
	public String home() {
		return "managebeers";
	}

	/**
	 * Redirect to random beer template file
	 * @return
	 */
	@RequestMapping("/")
	public String randomHome() {
		return "randombeer";
	}

	/**
	 * Redirect to random beer template file
	 * @return
	 */
	@RequestMapping("/random")
	public String randomBeer() {
		return "randombeer";
	}

	/**
	 * Rest Get method to give details of particular beer
	 * @param id
	 * @return fetch beer entity in Json format
	 */
	@RequestMapping(value = "/beer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Beer> getBeerById(@PathVariable("id") Integer id) {
		Beer beer = beerService.get(id);
		return new ResponseEntity<Beer>(beer, HttpStatus.OK);
	}

	/**
	 * Function to get all the list of beers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/beer", method = RequestMethod.GET)
	public ResponseEntity<List<Beer>> getAllBeers() {
		List<Beer> list = beerService.list();
		return new ResponseEntity<List<Beer>>(list, HttpStatus.OK);
	}

	/**
	 * Rest get method to return random beer
	 * @return
	 */
	@RequestMapping(value = "/beerRandom", method = RequestMethod.GET)
	public ResponseEntity<Beer> getRandomBeer() {
		Beer beer = beerService.random();
		return new ResponseEntity<Beer>(beer, HttpStatus.OK);
	}

	/**
	 * Rest Post method to save the beer
	 * @param beer entity to be saved
	 * @param builder
	 * @return
	 */
	@RequestMapping(value = "/beer", method = RequestMethod.POST)
	public ResponseEntity<Void> addBeer(@RequestBody Beer beer, UriComponentsBuilder builder) {
		beerService.save(beer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/beer/{id}").buildAndExpand(beer.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Rest put method to update the beer record
	 * @param beer record to be updated
	 * @return
	 */
	@RequestMapping(value = "/beer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Beer> updateBeer(@RequestBody Beer beer) {
		beerService.update(beer.getId(), beer);
		return new ResponseEntity<Beer>(beer, HttpStatus.OK);
	}

	/**
	 * Rest delete method to delete the beer record
	 * @param id to be deleted
	 * @return
	 */
	@RequestMapping(value = "/beer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBeer(@PathVariable("id") Integer id) {
		beerService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
