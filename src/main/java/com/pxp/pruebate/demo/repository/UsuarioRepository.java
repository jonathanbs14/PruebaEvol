package com.pxp.pruebate.demo.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.pxp.pruebate.demo.entity.UsuarioEntity;

import java.util.List;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioEntity, Integer> {

    public boolean existsByEmail(String email);

    public List<UsuarioEntity> findByEmail(String email);

}
