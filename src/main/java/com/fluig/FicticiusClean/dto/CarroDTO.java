package com.fluig.FicticiusClean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarroDTO {

    @NotEmpty(message = "{nome.nao.vazio}")
    private String nome;

    @NotEmpty(message = "{marca.nao.vazio}")
    private String marca;

    @NotEmpty(message = "{modelo.nao.vazio}")
    private String modelo;

    @NotNull(message = "{preencha.data}")
    private String dataFabricacao;

    @Positive(message = "{consumo.nao.negativo}")
    private double consumoMedioCidade;

    @Positive(message = "{consumo.nao.negativo}")
    private double consumoMedioRodovia;

}
