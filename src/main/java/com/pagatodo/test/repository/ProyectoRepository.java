package com.pagatodo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagatodo.test.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}