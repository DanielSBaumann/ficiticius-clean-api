package com.fluig.FicticiusClean.controller;

import com.fluig.FicticiusClean.dto.CarroDTO;
import com.fluig.FicticiusClean.entity.Carro;
import com.fluig.FicticiusClean.entity.Consumo;
import com.fluig.FicticiusClean.response.Response;
import com.fluig.FicticiusClean.service.CarroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "*")
public class CarrosController {

    @Autowired
    private CarroService carroService;

    @ApiOperation(value = "Salva um novo carro")
    @PostMapping("/salvar")
    public ResponseEntity<Response<CarroDTO>> salvar(
            @Valid @RequestBody CarroDTO carroDTO,
            BindingResult result) {

        Response<CarroDTO> response = new Response<CarroDTO>();

        if (result.hasErrors()) {

            result.getAllErrors()
                    .forEach(error ->
                            response.getErrors()
                                    .add(error.getDefaultMessage()));

            return badRequest().body(response);
        }

        Carro carro = carroService.persist(converterDtoParaCarro(carroDTO));

        response.setData(converterCarroParaDto(carro));

        return ok(response);
    }

    public Carro converterDtoParaCarro(CarroDTO carroDTO) {

        LocalDate data = LocalDate.parse(carroDTO.getDataFabricacao(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return Carro
                .builder()
                .nome(carroDTO.getNome())
                .marca(carroDTO.getMarca())
                .modelo(carroDTO.getModelo())
                .consumoMedioCidade(carroDTO.getConsumoMedioCidade())
                .consumoMedioRodovia(carroDTO.getConsumoMedioRodovia())
                .dataFabricacao(data)
                .build();
    }

    public CarroDTO converterCarroParaDto(Carro carro) {

        String data = carro
                .getDataFabricacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return CarroDTO
                .builder()
                .nome(carro.getNome())
                .marca(carro.getMarca())
                .modelo(carro.getModelo())
                .consumoMedioCidade(carro.getConsumoMedioCidade())
                .consumoMedioRodovia(carro.getConsumoMedioRodovia())
                .dataFabricacao(data)
                .build();
    }

    @ApiOperation(value = "Retorna consumos rankeados pela kilometragem")
    @GetMapping("/consumosPorCarro/precoGasolina/{precoGasolina}/kmCidade/{kmCidade}/kmRodovia/{kmRodovia}")
    public ResponseEntity<Consumo> consumoPorCarro(
            @PathVariable BigDecimal precoGasolina,
            @PathVariable double kmCidade,
            @PathVariable double kmRodovia) {

        Optional<Consumo> consumo = carroService
                .consumo(precoGasolina, kmCidade, kmRodovia);

        return consumo
                .map(ResponseEntity::ok)
                .orElseGet(() -> badRequest().body(consumo.get()));
    }

}
