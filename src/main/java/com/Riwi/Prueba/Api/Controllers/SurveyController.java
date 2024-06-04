package com.Riwi.Prueba.Api.Controllers;


import com.Riwi.Prueba.Api.Dto.Request.SurveyRequest;
import com.Riwi.Prueba.Api.Dto.Response.QuestionResponse;
import com.Riwi.Prueba.Api.Dto.Response.SurveyResponse;
import com.Riwi.Prueba.Api.Dto.Response.UserResponse;
import com.Riwi.Prueba.Infraestructure.ISurveyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping
    public ResponseEntity<Page<SurveyResponse>> getAllCursos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<SurveyResponse> cursosPage = surveyService.getAll(page, size);
        return ResponseEntity.ok(cursosPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponse> get(@PathVariable Integer id) {
        SurveyResponse responseDTO = surveyService.get(id);
        return ResponseEntity.ok(responseDTO);
    }




}
