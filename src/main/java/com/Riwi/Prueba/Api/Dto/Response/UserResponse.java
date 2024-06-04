package com.Riwi.Prueba.Api.Dto.Response;
import com.Riwi.Prueba.Utils.Enums.State;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String name;
    private String email;
    private State state;
    private List<SurveyResponse> surveyResponses;
}