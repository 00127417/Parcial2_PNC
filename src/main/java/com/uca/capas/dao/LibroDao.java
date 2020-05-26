package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroDao {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public Libro findOne(Integer code) throws DataAccessException;
	
	public void save(Libro l) throws DataAccessException; 
}
