package com.Riwi.Prueba.Api.Dto.Request;
import com.Riwi.Prueba.Utils.Enums.State;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {
    @NotBlank(message = "el titulo es requerido")
    private String title;
    private Date creationDate;
    private State state;
    private int UserId;
}