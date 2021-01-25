package com.alexoterof.smartable.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexoterof.smartable.dao.PersonaDao;
import com.alexoterof.smartable.dto.input.PersonaInputDto;
import com.alexoterof.smartable.dto.response.PersonaDto;
import com.alexoterof.smartable.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	private PersonaDao personaDao;
	
	
	@Override
	public Iterable<PersonaDto> findAll() {
		List<PersonaDto> personas = new ArrayList<PersonaDto>();
		personaDao.findAll().forEach(r -> personas.add(convertToDto(r)));
		return personas;
	}

	@Override
	public PersonaDto findById(Long id) {
		return convertToDto(personaDao.findById(id).get());
	}

	@Override
	public PersonaDto createOrUpdate(PersonaInputDto input) {
		Persona persona = new Persona();
		BeanUtils.copyProperties(input, persona);
		return convertToDto(personaDao.save(persona));
	}

	@Override
	public void deleteById(Long id) {
		personaDao.deleteById(id);
	}
	
	private PersonaDto convertToDto(Persona input) {
		PersonaDto output = new PersonaDto();
		output.setId(input.getId());
		output.setFullname(input.getFullname());
		output.setUsername(input.getUsername());
		output.setEmail(input.getEmail());
		output.setCargo(input.getCargo());
		output.setXhoras(input.isXhoras());
		return output;
	}

}
