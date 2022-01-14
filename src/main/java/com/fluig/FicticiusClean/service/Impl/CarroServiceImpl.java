package com.fluig.FicticiusClean.service.Impl;

import com.fluig.FicticiusClean.entity.Carro;
import com.fluig.FicticiusClean.entity.Consumo;
import com.fluig.FicticiusClean.entity.ConsumoPorCarro;
import com.fluig.FicticiusClean.repository.CarroRepository;
import com.fluig.FicticiusClean.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Override
    public Carro persist(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Optional<Consumo> consumo(BigDecimal precoGasolina, double kmCidade, double kmRodovia) {

        List<Carro> carros = carroRepository.findAll();

        if (carros.isEmpty())
            return Optional.empty();

        Consumo consumo = Consumo
                .builder()
                .precoGasolina(precoGasolina)
                .kmCidade(kmCidade)
                .kmRodovia(kmRodovia)
                .build();

        consumo.setConsumosPorCarro(consumosPorCarro(consumo, carros));

        return Optional.of(consumo);
    }

    public List<ConsumoPorCarro> consumosPorCarro(Consumo consumo, List<Carro> carros) {

        List<ConsumoPorCarro> consumosPorCarro = new ArrayList<>();

        carros.forEach(carro -> {

            ConsumoPorCarro consumoPorCarro = ConsumoPorCarro
                    .builder()
                    .carro(carro)
                    .valorConsumoCidade(valorConsumoCidade(consumo, carro))
                    .valorConsumoRodovia(valorConsumoRodovia(consumo, carro))
                    .build();

            consumosPorCarro.add(consumoPorCarro);
        });

        return rankearCarrosPorConsumo(consumosPorCarro);
    }

    public List<ConsumoPorCarro> rankearCarrosPorConsumo(List<ConsumoPorCarro> consumosPorCarro) {

        consumosPorCarro.sort((ConsumoPorCarro c1, ConsumoPorCarro c2)
                -> Double.compare(c1.getValorConsumoCidade().doubleValue() +
                        c1.getValorConsumoRodovia().doubleValue(),
                c2.getValorConsumoCidade().doubleValue() +
                        c2.getValorConsumoRodovia().doubleValue()));

        return consumosPorCarro;
    }

    public BigDecimal valorConsumoCidade(Consumo consumo, Carro carro) {

        double media =
                (consumo.getKmCidade() / carro.getConsumoMedioCidade())
                        * consumo.getPrecoGasolina().doubleValue();

        BigDecimal bd = new BigDecimal(media)
                .setScale(2, RoundingMode.HALF_UP);

        return bd;
    }

    public BigDecimal valorConsumoRodovia(Consumo consumo, Carro carro) {

        double media =
                (consumo.getKmRodovia() / carro.getConsumoMedioRodovia())
                        * consumo.getPrecoGasolina().doubleValue();

        BigDecimal bd = new BigDecimal(media)
                .setScale(2, RoundingMode.HALF_UP);

        return bd;
    }

}
