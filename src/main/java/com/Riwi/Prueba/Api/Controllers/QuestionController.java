package com.Riwi.Prueba.Api.Controllers;


import com.Riwi.Prueba.Api.Dto.Request.QuestionRequest;
import com.Riwi.Prueba.Api.Dto.Request.UserRequest;
import com.Riwi.Prueba.Api.Dto.Response.QuestionResponse;
import com.Riwi.Prueba.Api.Dto.Response.UserResponse;
import com.Riwi.Prueba.Infraestructure.IQuestionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
@AllArgsConstructor
public class QuestionController {

    @Autowired
    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> create(@Valid @RequestBody QuestionRequest requestDTO) {
        QuestionResponse responseDTO = questionService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getCurso(@PathVariable Integer id) {
        QuestionResponse responseDTO = questionService.get(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAllCursos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<QuestionResponse> cursosPage = questionService.getAll(page, size);
        return ResponseEntity.ok(cursosPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
