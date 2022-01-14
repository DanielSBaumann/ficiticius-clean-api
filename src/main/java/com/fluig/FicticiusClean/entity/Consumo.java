package com.fluig.FicticiusClean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumo {

    private BigDecimal precoGasolina;
    private double kmCidade;
    private double kmRodovia;
    private List<ConsumoPorCarro> consumosPorCarro;

}
