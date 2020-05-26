package com.uca.capas.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_libro")
	private Integer c_libro;
	
	@Column(name = "s_titulo")
	@NotEmpty(message = "Este campo no debe estar vacio")
	@Size(max = 500, message = "El campo no debe de tener mas de 500 caracteres")
	private String s_titulo;
	
	@Column(name = "s_autor")
	@NotEmpty(message = "Este campo no debe estar vacio")
	@Size(max = 150, message = "El campo no debe de tener mas de 150 caracteres")
	private String s_autor;
	
	@Column(name = "c_categoria")
	@NotNull(message = "Este campo no debe estar vacio")
	private Integer c_categoria;
	
	@Column(name = "f_ingreso")
	private Timestamp f_ingreso;
	
	@Column(name = "b_estado")
	@NotNull(message = "Este campo no debe estar vacio")
	private Boolean b_estado;
	
	@Column(name = "s_isbn")
	@NotEmpty(message = "Este campo no debe estar vacio")
	@Size(max = 10, message = "El campo no debe de tener mas de 10 caracteres")
	private String s_isbn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria",unique=true,insertable = false, updatable = false)
	private Categoria categoria;

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Timestamp getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Timestamp f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getBestadoDelegate(){
		if(this.b_estado == null){
			return "";
		}
		else{
			if(this.b_estado) return "ACTIVO";
			else return "INACTIVO";
		}
	}
	
	public String getFechaDelegate(){
		if(this.f_ingreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			String shortdate = sdf.format(this.f_ingreso.getTime());
			return shortdate;
		}
	}

}
