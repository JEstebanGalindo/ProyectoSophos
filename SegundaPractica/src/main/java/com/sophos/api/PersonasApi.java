package com.sophos.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.repositorio.PersonasEntity;
import com.sophos.repositorio.PersonasRepository;

@RestController
@RequestMapping("/personas")
public class PersonasApi {

	@Autowired
	private PersonasRepository service;

	@GetMapping("/traerPersonas")
	public List<?> getPersonas() {
		return Arrays.asList(service.findAll());
	}

	@PostMapping("/guardar")
	public String guardarAutor(@RequestBody PersonasEntity persona) {
		service.save(persona);
		return ("Creado correctamente");
	}

	@PutMapping("/editar")
	public String editarAutor(@RequestBody PersonasEntity persona) {
		service.save(persona);
		return ("Persona editada correctamente");
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminarAutorLibros(@PathVariable int id) {
		service.deleteById(id);
		return ("Persona eliminada correctamente");
	}

}
