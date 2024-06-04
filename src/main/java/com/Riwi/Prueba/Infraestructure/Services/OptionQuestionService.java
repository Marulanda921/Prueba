package com.Riwi.Prueba.Infraestructure.Services;

import com.Riwi.Prueba.Api.Dto.Request.OptionQuestionRequest;
import com.Riwi.Prueba.Api.Dto.Response.OptionQuestionResponse;
import com.Riwi.Prueba.Domain.Entity.OptionQuestion;
import com.Riwi.Prueba.Domain.Repository.OptionRepository;
import com.Riwi.Prueba.Infraestructure.IoptionQuestion;
import com.Riwi.Prueba.Utils.Exception.BadRequestException;
import com.Riwi.Prueba.Utils.Messages.ErrorMessages;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OptionQuestionService implements IoptionQuestion {

    @Autowired
    private final OptionRepository optionRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public OptionQuestionResponse create(OptionQuestionRequest request) {
        OptionQuestion optionQuestion = requestToEntity(request);
        OptionQuestion savedQuestion = optionRepository.save(optionQuestion);
        return entityToResponse(savedQuestion);
    }

    @Override
    public Page<OptionQuestionResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public OptionQuestionResponse get(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public OptionQuestionResponse update(OptionQuestionRequest request, Integer integer) {
        return null;
    }

    public OptionQuestionResponse entityToResponse(OptionQuestion optionQuestion) {
        return OptionQuestionResponse.builder()
                .id(optionQuestion.getId())
                .text(optionQuestion.getText())
                .state(optionQuestion.getState())
                .build();
    }

    public OptionQuestion requestToEntity(OptionQuestionRequest request) {
        return modelMapper.map(request, OptionQuestion.class);
    }


    private OptionQuestion find(Integer id){
        return this.optionRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("optionquestion")));
    }

}
