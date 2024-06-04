package com.Riwi.Prueba.Infraestructure.Services;

import com.Riwi.Prueba.Api.Dto.Request.UserRequest;
import com.Riwi.Prueba.Api.Dto.Response.SurveyResponse;
import com.Riwi.Prueba.Api.Dto.Response.UserResponse;
import com.Riwi.Prueba.Domain.Entity.Survey;
import com.Riwi.Prueba.Domain.Entity.User;
import com.Riwi.Prueba.Domain.Repository.SurveyRepository;
import com.Riwi.Prueba.Domain.Repository.UserRepository;
import com.Riwi.Prueba.Infraestructure.IUserService;
import com.Riwi.Prueba.Utils.Exception.BadRequestException;
import com.Riwi.Prueba.Utils.Messages.ErrorMessages;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final SurveyService surveyService;


    @Override
    public UserResponse create(UserRequest request) {
        User user = requestToEntity(request);
        User savedUser = userRepository.save(user);
        return entityToResponse(savedUser);
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> cursosPage = userRepository.findAll(pageable);
        return cursosPage.map(this::entityToResponse);
    }

    @Override
    public UserResponse get(Integer id) {
        User user = find(id);
        return entityToResponse(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(UserRequest request, Integer id) {
        User user = this.find(id);
        modelMapper.map(request, user);
        return this.entityToResponse(this.userRepository.save(user));
    }


    private UserResponse entityToResponse(User user) {
        List<SurveyResponse> surveyDto = user.getSurvey().stream()
                .map(surveyService::entityToResponse) // Llamada al método en la instancia de EstudiantesService
                .collect(Collectors.toList());

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .state(user.getState())
                .surveyResponses(surveyDto)
                .build();

    }


    private User requestToEntity(UserRequest request) {
        return modelMapper.map(request, User.class);
    }


    private User find(Integer id){
        return this.userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("user")));
    }


}
