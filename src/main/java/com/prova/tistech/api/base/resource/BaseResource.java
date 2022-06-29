package com.prova.tistech.api.base.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.prova.tistech.api.base.entities.BasicEntitie;
import com.prova.tistech.api.service.BaseServiceInterface;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

public abstract class BaseResource<E extends BasicEntitie<E>, S extends BaseServiceInterface<E>> {

	@Autowired
	protected S service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public E insert(@RequestBody @Valid E entidade, HttpServletResponse response){
		E entidadeCadastrado = service.insert(entidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidade.getId()).toUri();
		response.setHeader(HttpHeaders.LOCATION, uri.toString());
		return entidadeCadastrado;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public E change(@RequestBody @Valid E entidade, @PathVariable("id") Long id){
		return service.change(entidade, id);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id){
		service.deleteById(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<E> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public E findById(@PathVariable("id") Long id){
		return service.findById(id);
	}
}
