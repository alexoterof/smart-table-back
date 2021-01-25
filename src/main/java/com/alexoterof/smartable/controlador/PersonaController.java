package com.alexoterof.smartable.controlador;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexoterof.smartable.dto.input.PersonaInputDto;
import com.alexoterof.smartable.dto.response.PersonaDto;
import com.alexoterof.smartable.servicio.IPersonaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	
	@GetMapping("/")
	@ResponseBody
	public Iterable<PersonaDto> findAll(){
		System.out.println("Obteniendo all Personas...");
		return personaService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public PersonaDto getById(@PathVariable(value = "id") long id,
									HttpServletResponse response){
		System.out.println("Obteniendo by id...");
		try{
			return personaService.findById(id);
		}catch(NoSuchElementException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	//createorupdate
	@PutMapping("/")
	@ResponseBody
	public PersonaDto createOrUpdate(@RequestBody PersonaInputDto input) {
		System.out.println("Añadiendo o editando persona");
		try {
			return personaService.createOrUpdate(input);
		}catch(Exception e) { //Esto arreglarlo
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteById(@PathVariable(value = "id") long id,
								HttpServletResponse response) {
		System.out.println("Eliminando persona...");
		try{
			personaService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		}catch(NoSuchElementException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
