package com.uca.capas.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria",new Categoria());
		mav.setViewName("categoria");
		return mav;
	}
	
	
	@RequestMapping("/categorias")
	public ModelAndView formCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("categoria");
		}
		else {
			categoriaService.save(categoria);
			mav.addObject("resultado",1);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> list = categoriaService.findAll();
		mav.addObject("listCat",list);
		mav.addObject("libro",new Libro());
		mav.setViewName("libro");
		return mav;
	}
	
	
	@RequestMapping("/libros")
	public ModelAndView formLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Categoria> list = categoriaService.findAll();
			mav.addObject("listCat",list);
			mav.setViewName("libro");
		}
		else {
			long millis=System.currentTimeMillis();  
			Timestamp date=new java.sql.Timestamp(millis);
			libro.setF_ingreso(date);
			libroService.save(libro);
			mav.addObject("libro",new Libro());
			mav.addObject("resultado",2);
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> lista = libroService.findAll();
		mav.addObject("listaL",lista);
		mav.setViewName("listado");
		return mav;
	}
	
}
