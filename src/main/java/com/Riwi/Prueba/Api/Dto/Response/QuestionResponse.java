package com.Riwi.Prueba.Api.Dto.Response;

import com.Riwi.Prueba.Utils.Enums.Options;
import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private int id;
    private String text;
    private String type;
    private Options opciones;
    private String[] OpcionesRespuesta = {"APROBADO", "DESMENTIDO"};
    private List<OptionQuestionResponse> optionQuestionResponses;
}
