package com.Riwi.Prueba.Api.Dto.Response;

import com.Riwi.Prueba.Utils.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicUserResponse {
        private String name;
        private String email;
        private State state;
}
