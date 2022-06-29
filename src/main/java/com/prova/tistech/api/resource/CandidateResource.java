package com.prova.tistech.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.base.resource.BaseResource;
import com.prova.tistech.api.entities.Candidate;
import com.prova.tistech.api.service.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateResource extends BaseResource<Candidate, CandidateService>{

}
