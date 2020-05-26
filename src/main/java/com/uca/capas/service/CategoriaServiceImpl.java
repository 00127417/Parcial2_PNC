package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDao;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		return categoriaDao.findOne(code);
	}

	@Override
	public void save(Categoria c) throws DataAccessException {
		categoriaDao.save(c);
		
	}

}
