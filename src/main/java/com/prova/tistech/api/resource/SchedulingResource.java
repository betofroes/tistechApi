package com.prova.tistech.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.base.resource.BaseResource;
import com.prova.tistech.api.entities.Scheduling;
import com.prova.tistech.api.service.bussiness.SchedulingService;

@RestController
@RequestMapping("/schedules")
public class SchedulingResource extends BaseResource<Scheduling, SchedulingService>{

	@GetMapping("/{taxNumber}")
	@ResponseStatus(HttpStatus.OK)
	public List<Scheduling> findById(@PathVariable("taxNumber") String taxNumber){
		return service.findByTaxNumber(taxNumber);
	}
}
