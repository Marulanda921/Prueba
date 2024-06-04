package com.Riwi.Prueba.Api.Controllers;


import com.Riwi.Prueba.Api.Dto.Request.OptionQuestionRequest;
import com.Riwi.Prueba.Api.Dto.Response.OptionQuestionResponse;
import com.Riwi.Prueba.Infraestructure.IoptionQuestion;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/optionQuestions")
@AllArgsConstructor
public class OptionQuestionController {

    @Autowired
    private final IoptionQuestion ioptionQuestion;

    @PostMapping
    public ResponseEntity<OptionQuestionResponse> createCurso(@Valid @RequestBody OptionQuestionRequest requestDTO) {
        OptionQuestionResponse responseDTO = ioptionQuestion.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
