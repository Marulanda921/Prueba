package com.Riwi.Prueba.Api.Controllers;


import com.Riwi.Prueba.Api.Dto.Request.SurveyRequest;
import com.Riwi.Prueba.Api.Dto.Response.SurveyResponse;
import com.Riwi.Prueba.Infraestructure.ISurveyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("survey")
@AllArgsConstructor
public class SurveyController {

    private final ISurveyService surveyService;



    @PostMapping
    public ResponseEntity<SurveyResponse> createSurvey(@Valid @RequestBody SurveyRequest requestDTO) {
        SurveyResponse responseDTO = surveyService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
