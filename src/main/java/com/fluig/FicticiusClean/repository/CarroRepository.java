package com.fluig.FicticiusClean.repository;

import com.fluig.FicticiusClean.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findAll();

}
