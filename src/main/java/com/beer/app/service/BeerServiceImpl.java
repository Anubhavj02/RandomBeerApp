package com.beer.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beer.app.dao.BeerDao;
import com.beer.app.model.Beer;

/**
 * Service to layer to interact with the Dao Layer
 * 
 * @author anubhavjain
 *
 */
@Service
@Transactional(readOnly = true)
public class BeerServiceImpl implements BeerService {

	@Autowired
	private BeerDao beerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#save(com.beer.app.model.Beer)
	 */
	@Transactional
	public long save(Beer beer) {
		return beerDao.save(beer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#get(long)
	 */
	public Beer get(long id) {
		return beerDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#random()
	 */
	public Beer random() {
		return beerDao.random();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#list()
	 */
	public List<Beer> list() {
		return beerDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#update(long, com.beer.app.model.Beer)
	 */
	@Transactional
	public long update(long id, Beer beer) {
		beerDao.update(id, beer);
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beer.app.service.BeerService#delete(long)
	 */
	@Transactional
	public boolean delete(long id) {
		beerDao.delete(id);
		return true;
	}

}
