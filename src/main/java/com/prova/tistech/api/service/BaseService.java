package com.prova.tistech.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.prova.tistech.api.base.entities.BasicEntitie;

public abstract class BaseService<E extends BasicEntitie<E>, R extends JpaRepository<E, Long>> implements BaseServiceInterface<E> {

	@Autowired
	protected R repository;
	
	public void consistPersistence(E entidade){
	};
	
	@Override
	@Transactional
	public E insert(E entidade) {
		consistPersistence(entidade);
		entidade.setId(null);
		E entidadeCadastrado = repository.save(entidade);
		return entidadeCadastrado;
	}

	@Override
	@Transactional
	public E change(E entidade, Long id) {
		findById(id);
		consistPersistence(entidade);
		entidade.setId(id);
		return repository.save(entidade);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public E findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(getMessageError(),1));
	}

	protected String getMessageError() {
		return "Recurso não encontrado!";
	}
}
