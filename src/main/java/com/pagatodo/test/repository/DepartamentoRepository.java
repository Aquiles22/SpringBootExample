package com.pagatodo.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagatodo.test.dao.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    /*@SuppressWarnings("unchecked")
    @Transactional
    Departamento save(Departamento entity);

    @Transactional
    void deleteById(Long id);

    @Transactional
    Optional<Departamento> findById(Long id);

    @Transactional
    List<Departamento> findAll();*/
}
