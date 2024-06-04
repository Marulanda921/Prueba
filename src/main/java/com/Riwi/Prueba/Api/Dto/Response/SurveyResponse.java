package com.Riwi.Prueba.Api.Dto.Response;

import com.Riwi.Prueba.Utils.Enums.State;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse {
    private int id;
    private String title;
    private Date creationDate;
    private State state;
    private BasicUserResponse basicUserResponse;
}