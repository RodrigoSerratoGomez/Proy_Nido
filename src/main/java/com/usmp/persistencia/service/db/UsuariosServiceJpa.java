package com.usmp.persistencia.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.usmp.persistencia.models.Usuario;
import com.usmp.persistencia.repository.UsuariosRepository;
import com.usmp.persistencia.service.IUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService{

	@Autowired
	private UsuariosRepository usuariosRepo;

	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodas() {
		return usuariosRepo.findAll();
	}

	@Override
	public Usuario buscarPorId(Long idUsuario) {
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Long idUsuario) {
		usuariosRepo.deleteById(idUsuario);	
	}
}
