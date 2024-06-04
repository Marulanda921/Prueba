package com.Riwi.Prueba.Api.Dto.Response;

import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionQuestionResponse {
    private int id;
    private String text;
    private State state;
}
