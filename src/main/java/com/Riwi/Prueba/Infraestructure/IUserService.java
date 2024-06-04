package com.Riwi.Prueba.Infraestructure;

import com.Riwi.Prueba.Api.Dto.Request.UserRequest;
import com.Riwi.Prueba.Api.Dto.Response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Integer>{
}


