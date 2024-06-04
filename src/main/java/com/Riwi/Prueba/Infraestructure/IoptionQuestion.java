package com.Riwi.Prueba.Infraestructure;

import com.Riwi.Prueba.Api.Dto.Request.OptionQuestionRequest;
import com.Riwi.Prueba.Api.Dto.Response.OptionQuestionResponse;
import com.Riwi.Prueba.Infraestructure.CrudService;

public interface IoptionQuestion extends CrudService<OptionQuestionRequest, OptionQuestionResponse, Integer> {
}
