package com.Riwi.Prueba.Infraestructure.Services;


import com.Riwi.Prueba.Api.Dto.Request.SurveyRequest;
import com.Riwi.Prueba.Api.Dto.Response.BasicUserResponse;
import com.Riwi.Prueba.Api.Dto.Response.SurveyResponse;
import com.Riwi.Prueba.Domain.Entity.Survey;
import com.Riwi.Prueba.Domain.Entity.User;
import com.Riwi.Prueba.Domain.Repository.SurveyRepository;
import com.Riwi.Prueba.Domain.Repository.UserRepository;
import com.Riwi.Prueba.Infraestructure.ISurveyService;
import com.Riwi.Prueba.Utils.Exception.BadRequestException;
import com.Riwi.Prueba.Utils.Messages.ErrorMessages;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ModelMapper modelMapper;


    @Override
    public SurveyResponse create(SurveyRequest request) {
        Survey survey = requestToEntity(request);
        Survey savedSurvey = surveyRepository.save(survey);
        return entityToResponse(savedSurvey);
    }

    @Override
    public Page<SurveyResponse> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return surveyRepository.findAll(pageable)
                .map(this::entityToResponse);
    }

    @Override
    public SurveyResponse get(Integer id) {
        Survey survey = find(id);
        return entityToResponse(survey);
    }

    @Override
    public void delete(Integer id) {
        surveyRepository.deleteById(id);
    }

    @Override
    public SurveyResponse update(SurveyRequest request, Integer integer) {
        Survey survey = this.find(integer);
        modelMapper.map(request, survey);
        return this.entityToResponse(this.surveyRepository.save(survey));
    }


    public SurveyResponse entityToResponse(Survey survey) {

        BasicUserResponse userResponse = BasicUserResponse.builder()
                .email(survey.getUser().getEmail())
                .name(survey.getUser().getName())
                .state(survey.getUser().getState())
                .build();


        return SurveyResponse.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .creationDate(survey.getCreationDate())
                .state(survey.getState())
                .basicUserResponse(userResponse)
                .build();
    }

    private Survey requestToEntity(SurveyRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException("survey no encontrado"));

        return Survey.builder()
                .title(request.getTitle())
                .creationDate(request.getCreationDate())
                .state(request.getState())
                .user(user)
                .build();
    }

    private Survey find(int id){
        return this.surveyRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("survey")));
    }

}
