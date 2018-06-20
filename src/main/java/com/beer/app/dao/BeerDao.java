package com.beer.app.dao;

import java.util.List;

import com.beer.app.model.Beer;

/**
 * @author anubhavjain
 *
 */
public interface BeerDao {
	
	/**
	 * Function to save the beer object in the DB
	 * @param beer object to be saved
	 * @return id of the save of beer object
	 */
	long save(Beer beer);

	/**
	 * Function to retrieve details of particular beer model
	 * @param id unique id of beer model to be fetched
	 * @return beer model fected
	 */
	Beer get(long id);

	/**
	 * Function to fetch all the beers from the database
	 * @return list of all beers in the database
	 */
	List<Beer> list();

	/**
	 * Function to update the beer record
	 * @param id unique id of beer model to be updated
	 * @param beer model to be updated 
	 * @return id of the updated record
	 */
	long update(long id, Beer beer);

	/**
	 * Function to delete a beer record
	 * @param id to be deleted
	 * @return id deleted
	 */
	boolean delete(long id);
	
	/** Function to fetch random values from the database
	 * @return random beer model
	 */
	Beer random();

}
