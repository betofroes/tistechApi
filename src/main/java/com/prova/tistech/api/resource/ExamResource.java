package com.prova.tistech.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.base.resource.BaseResource;
import com.prova.tistech.api.entities.Exam;
import com.prova.tistech.api.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamResource extends BaseResource<Exam, ExamService>{

}
