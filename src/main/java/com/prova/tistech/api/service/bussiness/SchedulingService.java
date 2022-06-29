package com.prova.tistech.api.service.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prova.tistech.api.entities.Scheduling;
import com.prova.tistech.api.exception.ConsistencyFailureException;
import com.prova.tistech.api.repository.SchedulingRepository;
import com.prova.tistech.api.service.BaseService;

@Service
public class SchedulingService extends BaseService<Scheduling, SchedulingRepository>{
	
	@Override
	public void consistPersistence(Scheduling entidade) {
		super.consistPersistence(entidade);
		
		if(Optional.ofNullable(repository.findBy(entidade.getAvailability())).isPresent()) {
			throw new ConsistencyFailureException("Schedule Error because Availability is already in used");
		};
	}

	public List<Scheduling> findByTaxNumber(String taxNumber) {
		return repository.findByTaxNumber(taxNumber);
	}
}