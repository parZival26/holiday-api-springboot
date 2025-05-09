package com.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class UpdateTipoDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String tipo;

}
