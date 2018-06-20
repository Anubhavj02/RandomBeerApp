package com.beer.app.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.beer.app.config.AppConfig;
import com.beer.app.model.Beer;

/**
 * Test class to test BeerDao
 * 
 * @author anubhavjain
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@SuppressWarnings("deprecation")
public class BeerDaoTest {

	@Autowired
	private BeerDao beerDaoTest;

	private Beer beer;

	private long id;

	@Before
	public void setupData() {

	}

	@After
	public void tearDown() {
	}

	/**
	 * Function to test save method
	 */
	@Test
	public void testSave() {
		long id = saveBeer();
		Beer beer = beerDaoTest.get(id);
		assertTrue(beer != null);
		beerDaoTest.delete(id);
	}

	/**
	 * Function to test find by beer id method
	 */
	@Test
	public void testFindById() {
		long id = saveBeer();
		Beer beer = beerDaoTest.get(id);
		assertEquals("Test", beer.getName());
		beerDaoTest.delete(id);
	}

	/**
	 * Function to test get beer list method
	 */
	@Test
	public void testGetAll() {
		long id = saveBeer();
		List<Beer> beer = beerDaoTest.list();
		assertTrue(beer.size() > 0);
		beerDaoTest.delete(id);
	}

	/**
	 * Function to test uddate method
	 */
	@Test
	public void testUpdate() {
		long id = saveBeer();
		beer.setName("TestUpdated");
		beerDaoTest.update(id, beer);
		Beer beer = beerDaoTest.get(id);
		assertEquals("TestUpdated", beer.getName());
		beerDaoTest.delete(id);
	}

	/**
	 * Function to save a beer
	 * 
	 * @return id of saved beer
	 */
	public long saveBeer() {
		beer = new Beer();
		beer.setName("Test");
		beer.setDescription("Test");
		beer.setBreweryLocation("Test");
		beer.setImageUrl("Test");
		id = beerDaoTest.save(beer);
		return id;
	}

	/**
	 * Function to test delete method
	 */
	@Test
	public void testDelete() {
		long id = saveBeer();
		beerDaoTest.delete(id);
		Beer beer = beerDaoTest.get(id);
		assertTrue(beer == null);

	}

	/**
	 * Function to delete the beer
	 * 
	 * @param id
	 */
	public void deleteBeer(long id) {
		beerDaoTest.delete(id);
	}

	@Configuration
	static class BeerDaoTestContextConfiguration {

		@Bean
		public BeerDao beerDaoTest() {
			return new BeerDaoImpl();
		}

	}

}