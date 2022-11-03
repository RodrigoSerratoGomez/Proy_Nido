package com.usmp.persistencia.service;

import java.util.List;

import com.usmp.persistencia.models.Usuario;

public interface IUsuariosService {
	void guardar (Usuario usuario);
	List<Usuario>buscarTodas();
	Usuario buscarPorId(Long idUsuario);
	void eliminar(Long idUsuario);
}
