package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDao;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDao libroDao;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDao.findAll();
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		return libroDao.findOne(code);
	}

	@Override
	public void save(Libro l) throws DataAccessException {
		libroDao.save(l);
		
	}
	
	

}
