package com.Riwi.Prueba.Api.Dto.Request;

import com.Riwi.Prueba.Utils.Enums.Options;
import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private String text;
    private String type;
    private Options opciones;
}
