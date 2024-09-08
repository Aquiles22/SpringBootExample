package com.pagatodo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagatodo.test.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
