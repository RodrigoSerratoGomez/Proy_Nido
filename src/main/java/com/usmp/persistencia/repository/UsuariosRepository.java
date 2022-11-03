package com.usmp.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmp.persistencia.models.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

}
