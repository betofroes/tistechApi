package com.prova.tistech.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.base.resource.BaseResource;
import com.prova.tistech.api.entities.Availability;
import com.prova.tistech.api.service.AvailabilityService;

@RestController
@RequestMapping("/availabilities")
public class AvailabilityResource extends BaseResource<Availability, AvailabilityService>{

}