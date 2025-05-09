package com.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nombre;
}
