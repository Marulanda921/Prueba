package com.Riwi.Prueba.Infraestructure;

import com.Riwi.Prueba.Api.Dto.Request.QuestionRequest;
import com.Riwi.Prueba.Api.Dto.Response.QuestionResponse;

public interface IQuestionService extends CrudService<QuestionRequest, QuestionResponse, Integer>{
}
