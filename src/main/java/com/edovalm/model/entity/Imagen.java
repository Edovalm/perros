package com.edovalm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_imagen;
    private String archivo_imagen;
	public Integer getId_imagen() {
		return id_imagen;
	}
	public void setId_imagen(Integer id_imagen) {
		this.id_imagen = id_imagen;
	}
	public String getArchivo_imagen() {
		return archivo_imagen;
	}
	public void setArchivo_imagen(String archivo_imagen) {
		this.archivo_imagen = archivo_imagen;
	}
	public Imagen(Integer id_imagen, String archivo_imagen) {
		super();
		this.id_imagen = id_imagen;
		this.archivo_imagen = archivo_imagen;
	}
	public Imagen() {
		super();
	}
	private static final long serialVersionUID = 1L;
}
