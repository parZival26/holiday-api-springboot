package com.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateTipoDTO {
    @Getter @Setter
    @NotBlank
    private String tipo;
}
