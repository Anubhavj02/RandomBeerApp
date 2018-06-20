package com.beer.app.service;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.beer.app.config.AppConfig;
import com.beer.app.dao.BeerDao;
import com.beer.app.model.Beer;

/**
 * Test class to test BeerServiceClass
 * 
 * @author anubhavjain
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@SuppressWarnings("deprecation")
public class BeerServiceTest {

	@Autowired
	private BeerService beerService;
	@Autowired
	private BeerDao beerDao;

	private Beer beer;

	/**
	 * Setup before the test suit, creating object and mocks
	 */
	@Before
	public void setup() {
		beer = new Beer();
		beer.setName("Test");
		beer.setDescription("Test");
		beer.setBreweryLocation("Test");
		beer.setImageUrl("Test");

		List<Beer> beersList = new ArrayList<Beer>();
		beersList.add(beer);

		// Mockito methods and returns
		Mockito.when(beerDao.get(1)).thenReturn(beer);

		Mockito.when(beerDao.save(beer)).thenReturn((long) 1);

		Mockito.when(beerDao.list()).thenReturn(beersList);

		Mockito.when(beerDao.update(1, beer)).thenReturn((long) 1);

		Mockito.when(beerDao.delete(1)).thenReturn(true);
	}

	/**
	 * After test suit method
	 */
	@After
	public void tearDown() {
		beer = null;
	}

	/**
	 * Function to test save method
	 */
	@Test
	public void testSave() {

		assertTrue(beerService.save(beer) == 1);
	}

	/**
	 * Function to test find by id method
	 */
	@Test
	public void testFindById() {
		Beer beer = beerService.get(1);
		assertEquals("Test", beer.getName());
	}

	/**
	 * Function to test get all method
	 */
	@Test
	public void testGetAll() {
		List<Beer> beer = beerService.list();
		assertTrue(beer.size() > 0);
	}

	/**
	 * Function to test update method
	 */
	@Test
	public void testUpdate() {
		beerService.update(1, beer);
		Beer beer = beerService.get(1);
		assertEquals("Test", beer.getName());
	}

	/**
	 * Function to test delete method
	 */
	@Test
	public void testDelete() {
		;
		assertTrue(beerService.delete(1));

	}

	@Configuration
	static class BeerServiceTestContextConfiguration {

		@Bean
		public BeerService beerService() {
			return new BeerServiceImpl();
		}

		// Mocking BeerDao class using mockito
		@Bean
		public BeerDao beerDao() {
			return Mockito.mock(BeerDao.class);
		}
	}

}
