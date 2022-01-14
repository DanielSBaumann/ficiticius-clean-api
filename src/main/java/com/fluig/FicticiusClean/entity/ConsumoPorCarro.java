package com.fluig.FicticiusClean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoPorCarro {

    private Carro carro;
    private BigDecimal valorConsumoCidade;
    private BigDecimal valorConsumoRodovia;

}
