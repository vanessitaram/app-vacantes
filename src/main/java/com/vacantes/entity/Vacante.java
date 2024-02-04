package com.vacantes.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//JavaBean o Pojo

@Entity
@Table(name="Vacantes")
public class Vacante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nombre;
	private String descripcion;
	private LocalDate fecha;
	private Double salario;
	private String estatus;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Vacante [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", salario="
				+ salario + ", estatus=" + estatus + "]";
	}

	

}
