package com.Riwi.Prueba.Api.Dto.Request;

import com.Riwi.Prueba.Utils.Enums.State;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "el nombre es requerido")
    private String name;
    @NotBlank(message = "la contraseña es requerida")
    @Email(message = "el email no es valido")
    @Size(min = 5, max = 100, message = "el email debe tener entre 5 y 100 caracteres")
    private String email;
    private String password;
    @NotBlank(message = "el estado es requerido")
    private State state;
}
