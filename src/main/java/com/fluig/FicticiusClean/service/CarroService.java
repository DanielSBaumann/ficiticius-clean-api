package com.fluig.FicticiusClean.service;

import com.fluig.FicticiusClean.entity.Carro;
import com.fluig.FicticiusClean.entity.Consumo;

import java.math.BigDecimal;
import java.util.Optional;

public interface CarroService {

    Carro persist(Carro carro);

    Optional<Consumo> consumo(BigDecimal precoGasolina, double kmCidadedouble, double kmRodovia);

}
