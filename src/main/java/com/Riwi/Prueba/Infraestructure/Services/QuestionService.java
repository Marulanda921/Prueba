package com.Riwi.Prueba.Infraestructure.Services;

import com.Riwi.Prueba.Api.Dto.Request.QuestionRequest;
import com.Riwi.Prueba.Api.Dto.Response.QuestionResponse;
import com.Riwi.Prueba.Domain.Entity.Question;
import com.Riwi.Prueba.Domain.Entity.Survey;
import com.Riwi.Prueba.Domain.Repository.QuestionRepository;
import com.Riwi.Prueba.Domain.Repository.SurveyRepository;
import com.Riwi.Prueba.Infraestructure.IQuestionService;
import com.Riwi.Prueba.Utils.Exception.BadRequestException;
import com.Riwi.Prueba.Utils.Messages.ErrorMessages;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final SurveyService surveyService;

    @Autowired
    private final SurveyRepository surveyRepository;



    @Override
    public QuestionResponse create(QuestionRequest request) {
        Question question = requestToEntity(request);
        Question savedQuestion = questionRepository.save(question);
        return entityToResponse(savedQuestion);
    }

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return questionRepository.findAll(pageable)
                .map(this::entityToResponse);
    }

    @Override
    public QuestionResponse get(Integer id) {
        Question question = find(id);
        return entityToResponse(question);
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionResponse update(QuestionRequest request, Integer integer) {
        Question question = this.find(integer);
        modelMapper.map(request, question);
        return this.entityToResponse(this.questionRepository.save(question));
    }

    public QuestionResponse entityToResponse(Question question) {
        /*
        List<QuestionResponse> questionResponses = question.getQuestionList().stream()
                .map(questions -> estudiantesService.entityToResponse(estudiante)) // Llamada al método en la instancia de EstudiantesService
                .collect(Collectors.toList());
*/

        return QuestionResponse.builder()
                .id(question.getId())
                .text(question.getText())
                .type(question.getType())
                .OpcionesRespuesta(question.getOpciones1())
                .opciones(question.getOpciones())
                .build();
    }

    private Question requestToEntity(QuestionRequest request) {
        return Question.builder()
                .text(request.getText())
                .type(request.getType())
                .opciones(request.getOpciones())
                .build();
    }

    private Question find(Integer id){
        return this.questionRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("question")));
    }

}
