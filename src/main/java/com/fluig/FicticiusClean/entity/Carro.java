package com.fluig.FicticiusClean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name = "carro")
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "datafabricacao", nullable = false)
    private LocalDate dataFabricacao;

    @Column(name = "consumoMedioCidade", nullable = false)
    private double consumoMedioCidade;

    @Column(name = "consumoMedioRodovia", nullable = false)
    private double consumoMedioRodovia;

}
