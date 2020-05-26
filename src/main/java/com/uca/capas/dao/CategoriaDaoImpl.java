package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;


@Repository
public class CategoriaDaoImpl implements CategoriaDao{
	
	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT * FROM public.cat_categoria");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		
		List<Categoria> res = query.getResultList();
		return res;
	}

	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		Categoria c = entityManager.find(Categoria.class, code);
		return c;
	}

	@Override
	@Transactional
	public void save(Categoria c) throws DataAccessException {
		if(c.getC_categoria() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c);
		}
		
	}

	
}
