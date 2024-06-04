package com.Riwi.Prueba.Api.Dto.Request;

import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicSurToQuestion{
    private String title;
    private Date creationDate;
    private State state;
}
