package com.Riwi.Prueba.Api.Dto.Response;

import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SurveyToQuestionResp {
    private int id;
    private String title;
    private Date creationDate;
    private State state;
    private List<QuestionResponse> questionResponses;
}
