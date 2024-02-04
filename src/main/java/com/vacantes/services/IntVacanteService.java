package com.vacantes.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vacantes.entity.Vacante;

public interface IntVacanteService {

	public List<Vacante> listaVacantes();
	public void guardar(Vacante vacante);
	public Vacante buscar(Integer idVacante);
	public void eliminar(Integer idVacante);
	public int totalRegistros();
	public Page<Vacante> buscarTodas(Pageable page);


}
