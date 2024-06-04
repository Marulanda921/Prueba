package com.Riwi.Prueba.Api.Dto.Request;

import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OptionQuestionRequest {
    private String text;
    private State state;
}
