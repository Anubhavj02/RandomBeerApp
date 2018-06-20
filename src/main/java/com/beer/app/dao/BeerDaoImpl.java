package com.beer.app.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beer.app.model.Beer;

/**
 * @author anubhavjain
 * 
 * Dao Implementaion of Beer Model class; this class interacts with the DB
 *
 */
@Repository
public class BeerDaoImpl implements BeerDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#save(com.beer.app.model.Beer)
	 */
	public long save(Beer beer) {
		sessionFactory.getCurrentSession().save(beer);
		return beer.getId();
	}

	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#get(long)
	 */
	public Beer get(long id) {
		return sessionFactory.getCurrentSession().get(Beer.class, id);
	}
	
	
	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#random()
	 */
	public Beer random() {
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Beer.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(1);
		
		return (Beer)criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#list()
	 */
	public List<Beer> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Beer> cq = cb.createQuery(Beer.class);
		Root<Beer> root = cq.from(Beer.class);
		cq.select(root);
		Query<Beer> query = session.createQuery(cq);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#update(long, com.beer.app.model.Beer)
	 */
	public long update(long id, Beer beer) {
		Session session = sessionFactory.getCurrentSession();
		Beer beerUpdated = session.byId(Beer.class).load(id);
		beerUpdated.setName(beer.getName());
		beerUpdated.setAbv(beer.getAbv());
		beerUpdated.setDescription(beer.getDescription());
		beerUpdated.setBreweryLocation(beer.getBreweryLocation());
		beerUpdated.setImageUrl(beer.getImageUrl());
		session.flush();
		return beer.getId();
	}

	/* (non-Javadoc)
	 * @see com.beer.app.dao.BeerDao#delete(long)
	 */
	public boolean delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Beer beer = session.byId(Beer.class).load(id);
		session.delete(beer);
		return true;
	}

}
