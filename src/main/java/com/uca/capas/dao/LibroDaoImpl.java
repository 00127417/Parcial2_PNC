package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.capas.domain.Libro;

@Repository
public class LibroDaoImpl implements LibroDao{

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT * FROM public.cat_libro");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		
		List<Libro> res = query.getResultList();
		return res;
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		Libro l = entityManager.find(Libro.class, code);
		return l;
	}

	@Override
	@Transactional
	public void save(Libro l) throws DataAccessException {
		if(l.getC_libro() == null) { 
			entityManager.persist(l); 
		}
		else { 
			entityManager.merge(l);
		}
		
	}
		

}
