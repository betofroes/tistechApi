package com.prova.tistech.api.service;

import java.util.List;

import com.prova.tistech.api.base.entities.BasicEntitie;

public interface BaseServiceInterface<E extends BasicEntitie<E>> {

	public E insert(E entidade);
	public E change(E entidade, Long id);
	public void deleteById(Long id);
	public List<E> findAll();
	public E findById(Long id);
}